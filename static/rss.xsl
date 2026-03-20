<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:atom="http://www.w3.org/2005/Atom">
  <xsl:output method="html" version="1.0" encoding="UTF-8" indent="yes"/>
  <xsl:template match="/">
    <html xmlns="http://www.w3.org/1999/xhtml" lang="en">
      <head>
        <title><xsl:value-of select="/rss/channel/title"/> — RSS Feed</title>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <style>
          :root {
            --color-bg: #ffffff;
            --color-surface: #f8f9fa;
            --color-border: #e2e6ea;
            --color-text: #1a1a2e;
            --color-text-secondary: #4a5568;
            --color-accent: #1e3a5f;
          }
          @media (prefers-color-scheme: dark) {
            :root {
              --color-bg: #0f1219;
              --color-surface: #1a1f2e;
              --color-border: #2a3040;
              --color-text: #e2e6ea;
              --color-text-secondary: #a0aec0;
              --color-accent: #5b9bd5;
            }
          }
          * { box-sizing: border-box; margin: 0; padding: 0; }
          body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            color: var(--color-text);
            background: var(--color-bg);
            line-height: 1.7;
            max-width: 720px;
            margin: 0 auto;
            padding: 3rem 2rem;
          }
          .banner {
            background: var(--color-surface);
            border: 1px solid var(--color-border);
            border-radius: 8px;
            padding: 1.5rem;
            margin-bottom: 2.5rem;
          }
          .banner h1 { font-size: 1.5rem; margin-bottom: 0.5rem; }
          .banner p { color: var(--color-text-secondary); font-size: 0.95rem; margin-bottom: 0.5rem; }
          .banner code {
            background: var(--color-bg);
            padding: 0.15em 0.4em;
            border-radius: 3px;
            font-size: 0.85em;
            word-break: break-all;
          }
          h2 { font-size: 1.25rem; margin-bottom: 1.5rem; color: var(--color-text-secondary); }
          .item {
            padding: 1.5rem 0;
            border-bottom: 1px solid var(--color-border);
          }
          .item:last-child { border-bottom: none; }
          .item time {
            font-size: 0.85rem;
            color: var(--color-text-secondary);
            text-transform: uppercase;
            letter-spacing: 0.05em;
          }
          .item h3 { margin-top: 0.25rem; margin-bottom: 0.5rem; }
          .item h3 a { color: var(--color-accent); text-decoration: none; }
          .item h3 a:hover { text-decoration: underline; }
          .item p { color: var(--color-text-secondary); }
        </style>
      </head>
      <body>
        <div class="banner">
          <h1>RSS Feed</h1>
          <p>This is an RSS feed. Subscribe by copying the URL into your feed reader.</p>
          <p><code><xsl:value-of select="/rss/channel/link"/>/index.xml</code></p>
        </div>
        <h2><xsl:value-of select="/rss/channel/title"/></h2>
        <xsl:for-each select="/rss/channel/item">
          <div class="item">
            <time><xsl:value-of select="pubDate"/></time>
            <h3><a href="{link}"><xsl:value-of select="title"/></a></h3>
            <p><xsl:value-of select="description"/></p>
          </div>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
