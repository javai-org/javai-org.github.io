# Javai Website

This repository contains the source for [javai.org](https://javai.org/), a static website built with [Hugo](https://gohugo.io/). The site promotes open-source tools for testing non-deterministic systems (such as AI) and serves as the public presence for the Javai project.

## Domains

| Domain        | Purpose                                                                                                       | Repository |
|---------------|---------------------------------------------------------------------------------------------------------------|------------|
| **javai.org** | Main site — open-source projects, blog posts on AI testing, probabilistic systems, and regulatory compliance  | This repo  |
| **javai.ch**  | Swiss-specific content — FINMA regulations, Swiss enterprise and cantonal government AI concerns              | [javai-org/javai-ch](https://github.com/javai-org/javai-ch) |

## Projects featured

- **[punit](https://github.com/javai-org/punit)** — Probabilistic unit testing for Java (flagship)
- **[punit examples](https://github.com/javai-org/punitexamples)** — Worked examples and patterns for punit
- **[outcome](https://github.com/javai-org/outcome)** — Test outcome capture and trend analysis

## Prerequisites

- [Hugo](https://gohugo.io/installation/) (extended edition, v0.110+)
- Git

Install Hugo on macOS:

```sh
brew install hugo
```

## Local development

Start the development server:

```sh
hugo server --buildDrafts
```

The site will be available at `http://localhost:1313/`. Changes to content and templates are hot-reloaded automatically.

## Repository structure

```
├── hugo.toml              # Site configuration (title, menus, params)
├── content/
│   ├── _index.md          # Homepage front matter
│   ├── posts/             # Blog posts (Markdown files)
│   └── projects/          # Project pages (ordered by 'weight' in front matter)
├── layouts/
│   ├── index.html         # Homepage template
│   ├── _default/          # Default templates (baseof, single, list)
│   ├── projects/          # Projects section list template
│   └── partials/          # Shared partials (head, nav, footer)
├── assets/
│   └── css/main.css       # All styles (no external CSS frameworks)
├── static/
│   └── images/            # Static assets (favicon, logos, images)
└── .github/
    └── workflows/
        └── deploy.yml     # GitHub Actions — builds and deploys to GitHub Pages
```

## Adding a blog post

Create a new Markdown file in `content/posts/`:

```sh
hugo new content posts/2026-04-01-my-new-post.md
```

Or create the file manually with this front matter:

```markdown
---
title: "Post Title"
date: 2026-04-01
description: "A short description for SEO and social sharing."
summary: "Appears in post listings and the RSS feed."
---

Post content goes here.
```

Push to `main` and the site will rebuild and deploy automatically.

## Adding or reordering projects

Project pages live in `content/projects/`. Each has a `weight` field in its front matter that controls display order (lower weight = higher position):

```markdown
---
title: "project name"
weight: 1
---
```

## Deployment

Deployment is automated via GitHub Actions (`.github/workflows/deploy.yml`):

1. Push to the `main` branch
2. GitHub Actions builds the site with `hugo --minify`
3. The built site is deployed to GitHub Pages

No manual build or deploy step is required.

## DNS configuration (GoDaddy)

To point the domains at GitHub Pages, configure these DNS records in GoDaddy:

**javai.org:**

| Type  | Name | Value                    |
|-------|------|--------------------------|
| A     | @    | 185.199.108.153          |
| A     | @    | 185.199.109.153          |
| A     | @    | 185.199.110.153          |
| A     | @    | 185.199.111.153          |
| CNAME | www  | javai-org.github.io      |

**javai.ch** is managed in a [separate repository](https://github.com/javai-org/javai-ch).

After configuring DNS, enable "Enforce HTTPS" in the GitHub Pages settings for the repository.

## RSS feed

An RSS feed is automatically generated at `/index.xml` (site-wide) and `/posts/index.xml` (posts only). This can be used to trigger cross-posting to LinkedIn or other platforms via services like Zapier or IFTTT.

## Styling

All styles are in `assets/css/main.css`. The site uses:

- No external CSS frameworks — everything is custom
- CSS custom properties (variables) for colours and spacing
- Automatic dark/light mode via `prefers-color-scheme`
- Responsive design with a mobile breakpoint at 640px

## Content guidelines

The site targets developers and IT managers concerned with regulatory compliance for AI systems. Content should be:

- Professional and authoritative in tone
- Technically precise but accessible to non-specialists
- Focused on practical testing and compliance concerns
