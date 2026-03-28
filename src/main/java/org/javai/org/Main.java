package org.javai.org;

import org.javai.newsroom.Newsroom;
import org.javai.newsroom.NewsroomConfig;
import org.javai.newsroom.feed.FeedMetadata;
import org.javai.newsroom.schedule.TierFilter;

import java.nio.file.Path;

public class Main {

    private static final FeedMetadata FEED_METADATA = new FeedMetadata(
            "javai.org \u2014 Stochastic Software Feed",
            "News on testing, validation, and engineering of probabilistic and AI systems",
            "https://javai.org/",
            "feed.xml"
    );

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            printUsage();
            System.exit(1);
        }

        var command = args[0];
        var params = parseArgs(args);

        var config = new NewsroomConfig(
                Path.of(params.configDir),
                Path.of(params.state),
                Path.of(params.output),
                FEED_METADATA
        );
        var newsroom = new Newsroom(config);

        switch (command) {
            case "fetch" -> newsroom.fetch(TierFilter.parseTiers(params.tiers));
            case "generate" -> newsroom.generate();
            default -> {
                System.err.println("Unknown command: " + command);
                printUsage();
                System.exit(1);
            }
        }
    }

    private static Params parseArgs(String[] args) {
        var params = new Params();
        for (int i = 1; i < args.length; i++) {
            var arg = args[i];
            if (arg.startsWith("--config=")) {
                params.configDir = arg.substring("--config=".length());
            } else if (arg.startsWith("--state=")) {
                params.state = arg.substring("--state=".length());
            } else if (arg.startsWith("--tiers=")) {
                params.tiers = arg.substring("--tiers=".length());
            } else if (arg.startsWith("--output=")) {
                params.output = arg.substring("--output=".length());
            }
        }
        return params;
    }

    private static void printUsage() {
        System.err.println("""
                Usage: javai <command> [options]

                Commands:
                  fetch     Fetch news from configured sources
                  generate  Generate RSS feed, JSON feed, and HTML page

                Options:
                  --config=<path>   Path to config directory (default: newsroom/config)
                  --state=<path>    Path to state.json (default: newsroom/data/state.json)
                  --tiers=<list>    Comma-separated tier numbers to fetch (default: all)
                  --output=<path>   Output directory for generated files (default: build/site)
                """);
    }

    private static class Params {
        String configDir = "newsroom/config";
        String state = "newsroom/data/state.json";
        String tiers = "";
        String output = "build/site";
    }
}
