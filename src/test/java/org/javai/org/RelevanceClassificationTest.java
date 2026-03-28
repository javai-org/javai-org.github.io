package org.javai.org;

import org.javai.newsroom.filter.RelevanceClassificationUseCase;
import org.javai.newsroom.filter.RelevanceClassificationUseCase.LabelledItem;
import org.javai.newsroom.filter.experiments.RelevanceFilterTestData;
import org.javai.punit.api.InputSource;
import org.javai.punit.api.ProbabilisticTest;
import org.javai.punit.api.UseCaseProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Probabilistic test for the javai.org relevance filter.
 *
 * <p>Verifies that the LLM + prompt combination matches human-determined
 * classifications at a statistically acceptable rate using javai.org-specific
 * configuration and test data.
 */
public class RelevanceClassificationTest {

    private static final Path CONFIG_DIR = Path.of("newsroom/config");

    @RegisterExtension
    UseCaseProvider provider = new UseCaseProvider();

    @BeforeEach
    void setUp() {
        provider.register(RelevanceClassificationUseCase.class,
                () -> new RelevanceClassificationUseCase(CONFIG_DIR));
    }

    @ProbabilisticTest(
            useCase = RelevanceClassificationUseCase.class,
            samples = 50
    )
    @InputSource("labelledItems")
    void testRelevanceClassification(
            RelevanceClassificationUseCase useCase,
            LabelledItem item
    ) {
        useCase.classify(item).assertContract();
    }

    static Stream<LabelledItem> labelledItems() {
        return RelevanceFilterTestData.labelledItems(CONFIG_DIR.resolve("relevance-test-data.yml"));
    }
}
