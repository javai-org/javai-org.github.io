# REQ-ENGAGEMENT — Reader Engagement Infrastructure for javai.org

## Purpose

Establish a lightweight, privacy-conscious infrastructure on javai.org for:

1. **Measuring readership** (who reads, from where, how deep).
2. **Routing reader feedback** to channels the site owner can manage without exposing an email address or introducing a public comment surface to moderate.
3. **Amplifying reach** via LinkedIn, where the target audience already lives.

The same apparatus is intended for re-use on **javai.ch** with clearly-bounded adjustments. The plan is designed so that no code or configuration is site-specific except where explicitly flagged as such.

## Design constraints

- **No public comment surface on javai.org itself.** All reader conversation is routed to LinkedIn, where existing moderation tools apply.
- **No email address exposed** on the site. All direct-contact routes go through LinkedIn profiles.
- **Privacy-respecting analytics.** No cookies, no personal data, EU-hosted where reasonable (Plausible). Important for credibility given javai.ch's focus on Swiss AI regulation.
- **No third-party JavaScript beyond analytics.** LinkedIn integration is zero-JS (plain hyperlinks and Open Graph meta tags).
- **Supports multiple authors.** Even on javai.org (which has one curator today), the pattern supports an author registry so javai.ch's two-curator model can adopt the same code without refactor.

## Out of scope

- Email-based contact forms (mailto, Formspree, Basin, etc.).
- Giscus / Disqus / any public comment system on javai.org.
- LinkedIn's Insight Tag (tracking pixel) — explicitly rejected on privacy grounds.
- Cookie consent banner — not required under the privacy-respecting stack chosen here.
- CMS or editorial workflow beyond what Hugo already provides.
- SEO optimisation beyond what Open Graph tags provide (no sitemap improvements, no robots.txt changes, no structured data — tracked separately if needed).

---

## Prerequisites (user actions before implementation begins)

Before any code changes:

1. **Plausible account.**
   - Create a Plausible account at https://plausible.io.
   - Add `javai.org` as a site; note the tracking script snippet (contains a `data-domain` attribute — that is the key parameter we need).
   - (Later) add `javai.ch` as a second site on the same account.
   - Estimated cost: €9/month for both sites under the "Growth" plan or similar.

Here's the plausible script snippet:
```html
<!-- Privacy-friendly analytics by Plausible -->
<script async src="https://plausible.io/js/pa-R0QJ2aTt6MLM6ZeOCNBuT.js"></script>
<script>
  window.plausible=window.plausible||function(){(plausible.q=plausible.q||[]).push(arguments)},plausible.init=plausible.init||function(i){plausible.o=i||{}};
  plausible.init()
</script>
```

2. **LinkedIn profile URLs.**
- Confirm the canonical LinkedIn profile URL for the javai.org curator (Michael Mannion)
- www.linkedin.com/in/mike-franz-mannion 
- For javai.ch: confirm canonical LinkedIn profile URLs for both curators.
- www.linkedin.com/in/mike-franz-mannion
- https://www.linkedin.com/in/helena-mannion-764348261/


3. **Default social-share image.**
   - Image placed at `static/images/og-default.png` (1200×630 px, verified).
   - `hugo.toml`'s `ogImage` reference currently points at the non-existent `images/hero.jpg`; this must be updated to `images/og-default.png` as part of Step 2.


4. **GitHub Discussions — NOT required** for this plan (we are explicitly not using Giscus). No repo settings changes needed.

---

## Architecture overview

### Content sections

The site uses three top-level content sections:

- **Projects** (existing) — open-source project pages. Section URL: `/projects/`.
- **Signals** (new) — long-form essays on software engineering in the age of LLMs. Section URL: `/signals/`. Home of the Challenger/Deming essay and anything like it in future.
- **News** (renamed from `posts`) — site announcements, release notes, and updates. Section URL: `/news/`. The existing "Introducing Javai" welcome post moves here.

### Cooperating pieces

The implementation uses five cooperating pieces:

1. **Analytics snippet** — injected into `<head>` on every page, guarded so it does not load during local development.
2. **Open Graph meta tags** — extended from the existing implementation to support per-post overrides (image, description).
3. **Author registry** — a single source of truth for author metadata (display name, LinkedIn profile URL) defined in `hugo.toml`. Posts reference an author by key via frontmatter.
4. **End-of-post engagement block** — a Hugo partial that resolves the post's author and any declared LinkedIn cross-post URL, and renders:
   - A "Join the discussion on LinkedIn" link if a `linkedinPost` URL is declared on the post.
   - A "Find me on LinkedIn" link using the author's profile URL from the registry.
   - A "Share on LinkedIn" link, which composes a LinkedIn share URL for the current page.

   The block renders on Signals and News posts; it does not render on the homepage, on project pages, or on the section index pages.
5. **Frontmatter schema** — documented keys that posts must or may declare to drive the behaviour above.

---

## Frontmatter schema (Signals and News posts)

Each Signal or News post should declare:

| Key            | Required | Purpose                                                                                               |
|----------------|----------|-------------------------------------------------------------------------------------------------------|
| `title`        | yes      | Page title; used in `<title>`, `og:title`, article heading.                                           |
| `date`         | yes      | Publication date (ISO 8601).                                                                          |
| `description`  | yes      | Short description; used in `<meta name="description">` and `og:description`.                          |
| `summary`      | optional | Listing/RSS summary. Falls back to auto-generated if omitted.                                         |
| `author`       | yes      | Author key; must match an entry in `[params.authors]` in `hugo.toml`.                                 |
| `linkedinPost` | optional | Full URL of the cross-posted LinkedIn Article or Post. If set, drives the "Join the discussion" link. |
| `image`        | optional | Path (relative to `static/`) to a per-post Open Graph image. Falls back to site default.              |
| `engagement`   | optional | Set to `false` to suppress the end-of-post engagement block for this specific post.                   |

### Rendering logic for the engagement block

```
if post.engagement == false:
    render nothing
else:
    author = resolve(post.author)
    links = []
    if post.linkedinPost is set:
        links.append("Join the discussion on LinkedIn" → post.linkedinPost)
    if author.linkedin is set:
        links.append("Find {{author.name}} on LinkedIn" → author.linkedin)
    links.append("Share on LinkedIn" → LinkedIn share URL for .Permalink)
    render block with links
```

If neither `linkedinPost` nor `author.linkedin` resolves, only the "Share on LinkedIn" link appears.

---

## Configuration schema (site-level)

Additions to `hugo.toml`:

```toml
[params.analytics]
  # Domain as registered in Plausible. Empty string disables analytics entirely.
  plausibleDomain = "javai.org"

[params.authors.michael]
  name = "Michael Mannion"
  linkedin = "https://www.linkedin.com/in/<handle>/"

# For javai.ch, add a second author block:
# [params.authors.second-curator-key]
#   name = "..."
#   linkedin = "..."

[params.engagement]
  # Enables the end-of-post engagement block. Set false to globally disable.
  enabled = true
```

The existing `[params]` block (description, tagline, ogImage, keywords) is retained; `ogImage` is updated to `images/og-default.png` during Step 2 (the existing reference to `images/hero.jpg` currently 404s).

### Navigation menu

The existing single `Posts` menu entry is replaced with two entries — `Signals` and `News`:

```toml
[[menus.main]]
  name = 'Projects'
  pageRef = '/projects'
  weight = 10
[[menus.main]]
  name = 'Signals'
  pageRef = '/signals'
  weight = 20
[[menus.main]]
  name = 'News'
  pageRef = '/news'
  weight = 30
```

---

## Implementation steps

Each step has a well-defined deliverable, a test, and an estimated effort. Steps are ordered so that the site remains deployable at the end of each step (no half-finished state).

### Step 1 — Plausible analytics

**Files touched:**
- `layouts/partials/head.html`
- `hugo.toml`

**Changes:**
- Add a `[params.analytics]` block to `hugo.toml` with `plausibleDomain`.
- At the end of `head.html`, conditionally emit the Plausible script:

```go-html-template
{{ if and .Site.Params.analytics.plausibleDomain (not hugo.IsServer) }}
<script defer data-domain="{{ .Site.Params.analytics.plausibleDomain }}" src="https://plausible.io/js/script.js"></script>
{{ end }}
```

- `hugo.IsServer` ensures the script does not load during `hugo server` (local preview).

**Test:**
1. Run `hugo server` locally. View source; confirm the Plausible script is **absent**.
2. Run `hugo` to build for production. Inspect `public/index.html`; confirm the Plausible script is **present** with the correct `data-domain`.
3. After deploy, confirm Plausible dashboard registers a pageview within ~60 seconds of visiting https://javai.org.

**Effort:** ~10 minutes.

---

### Step 2 — Extend Open Graph for per-post images

**Files touched:**
- `layouts/partials/head.html`

**Current behaviour:** `head.html` emits `og:image` using `Site.Params.ogImage` only — a single site-wide image.

**Changes:**
- Introduce fallback logic: use `.Params.image` if set on the page, otherwise `.Site.Params.ogImage`.
- Add a matching `twitter:image` tag (LinkedIn honours `og:image`, but social-share previews benefit from the Twitter card fallback).

**Test:**
1. Create a test post with `image: images/test.jpg` in frontmatter.
2. Build; confirm `og:image` points to the test image on that page.
3. Build a post without `image`; confirm `og:image` falls back to the site default.
4. Use LinkedIn Post Inspector (https://www.linkedin.com/post-inspector/) on both URLs after deploy to confirm cards render.

**Effort:** ~15 minutes.

---

### Step 3 — Author registry

**Files touched:**
- `hugo.toml`

**Changes:**
- Add `[params.authors.michael]` with `name` and `linkedin`.
- Document the convention in the config comment block for future curators.

**Test:**
- Verify Hugo parses the config without error (`hugo config`).
- No visible site change in this step; this is groundwork for Step 4 and Step 5.

**Effort:** ~5 minutes (post-data collection).

---

### Step 4 — End-of-post engagement partial

**Files touched:**
- `layouts/partials/engagement.html` (new)
- `layouts/_default/single.html`

**Changes:**

Create `layouts/partials/engagement.html` that:
1. Checks `.Site.Params.engagement.enabled` and `(ne .Params.engagement false)` — render nothing if disabled.
2. Only renders on pages in the `signals` or `news` sections (not projects, not the homepage, not the section index pages).
3. Resolves the author from `.Site.Params.authors[.Params.author]`.
4. Emits an `<aside>` or `<footer>` block containing the appropriate hyperlinks per the rendering logic defined above.
5. Uses plain `<a href="...">` tags — no JavaScript, no third-party iframes.

LinkedIn share URL format:
```
https://www.linkedin.com/sharing/share-offsite/?url={{ .Permalink | urlquery }}
```

Include the partial in `layouts/_default/single.html` after `.Content`.

**Test:**
1. Create a test post in `content/signals/` with frontmatter declaring `author: michael` and `linkedinPost: https://...`.
2. Run `hugo server`. View the post. Confirm the engagement block renders with three links (discussion / profile / share).
3. Remove `linkedinPost` from frontmatter. Confirm only two links render (profile + share).
4. Add `engagement: false` to frontmatter. Confirm no block renders.
5. Visit the homepage and a project page. Confirm no engagement block appears there.

**Effort:** ~30 minutes.

---

### Step 5 — Author byline on posts

**Files touched:**
- `layouts/_default/single.html`

**Changes:**
- In the `<header class="content-header">` block, emit the author's display name when `.Params.author` resolves to a registry entry.
- Minimal visual: `By {{ author.name }}` below the date.

**Test:**
- Existing posts without an author frontmatter key render as before (no byline).
- The test post with `author: michael` shows "By Michael Mannion".

**Effort:** ~10 minutes.

---

### Step 6 — CSS for the engagement block

**Files touched:**
- `assets/css/main.css`

**Changes:**
- Minimal styling for the engagement block: horizontal rule separator, subdued label, link style consistent with the rest of the site.
- Responsive-friendly (stacks on mobile).
- Respects the site's existing light/dark mode custom-property system.

**Test:**
- Visual inspection at desktop and mobile breakpoints (640px).
- Dark-mode preview via OS setting toggle.

**Effort:** ~15 minutes.

---

### Step 7 — Content sections, navigation, and essay migration

This step has three parts: restructure the content sections, update the menu, and migrate the Challenger/Deming essay.

**Files touched:**
- `content/posts/` renamed to `content/news/` (`git mv`).
- `content/news/_index.md` (updated title and description).
- `content/signals/_index.md` (new section index).
- `hugo.toml` — replace the existing `Posts` menu entry with `Signals` and `News` entries (per the navigation schema above).
- Move `docs/essay-senior-developers-not-enough.md` → `content/signals/2026-04-19-challenger-deming-and-the-ai-watershed.md` (filename uses ISO 8601 date + slug).
- Add Hugo frontmatter block to the migrated essay (`title`, `date`, `description`, `author`, `linkedinPost`, `image` if applicable).

**Frontmatter example:**
```yaml
---
title: "Challenger, Deming, and the Watershed Moment of AI"
date: 2026-04-19
description: "Why the real AI risk to software organisations sits with upper management — and what Deming and Challenger still have to teach them."
author: michael
linkedinPost: ""   # filled in after publishing the LinkedIn cross-post
summary: "A watershed-moment essay for IT heads and upper management on why AI amplifies, rather than creates, software quality — and why the responsibility rests with those who own the system."
---
```

Note: `linkedinPost` can start empty and be filled in after Step 8 completes.

**Test:**
1. Run `hugo server`; confirm the essay renders at `/signals/2026-04-19-challenger-deming-and-the-ai-watershed/`.
2. Confirm the welcome post renders at `/news/2026-03-20-welcome/`.
3. Confirm the navigation bar shows `Projects · Signals · News` in that order.
4. Confirm OG tags, byline, and engagement block all render correctly on the essay.
5. Confirm existing inline hyperlinks and the Sources table render as expected.

**Effort:** ~15 minutes.

---

### Step 8 — Deploy and verify

**Actions:**
1. Commit changes in a single branch (e.g. `feature/engagement`).
2. Open a PR or merge to `main`.
3. On merge, the existing GitHub Actions workflow builds and deploys.
4. After deploy:
   - Verify Plausible is recording pageviews.
   - Verify the essay URL is live.
   - Run LinkedIn Post Inspector on the essay URL to confirm OG card renders correctly.
5. **Publish the LinkedIn Article/Post cross-post.** Copy the content from the essay; add the "Originally published at javai.org/..." line at the top.
6. Capture the LinkedIn post URL.
7. Add the LinkedIn post URL to the essay's frontmatter as `linkedinPost` and re-deploy.

**Effort:** ~20 minutes including LinkedIn cross-post composition.

---

## Per-site adjustments for javai.ch

When the above apparatus is mirrored to javai.ch, the following — and only the following — should need to change:

1. **`hugo.toml`**
   - `baseURL` (set to the javai.ch domain).
   - `title`, `description`, `tagline`, `keywords` — site-specific content.
   - `[params.analytics] plausibleDomain` — set to `javai.ch`.
   - `[params.authors.*]` — add a block per curator (two curators for javai.ch). Each block carries the curator's `name` and `linkedin`.
   - `ogImage` — javai.ch-specific default image.

2. **Default OG image** — `static/images/hero.jpg` replaced with javai.ch-appropriate imagery.

3. **Plausible site** — add javai.ch as a second site on the same Plausible account.

4. **Content frontmatter convention** — each javai.ch post declares `author: <curator-key>` in its frontmatter. The partial resolves the correct LinkedIn URLs per author automatically.

5. **Content sections** — create `content/signals/` and `content/news/` with their own `_index.md` files if the javai.ch repo does not already have these sections. Menu entries in `hugo.toml` mirror the javai.org structure.

**Expected mirror effort:** ~30–60 minutes, provided the directory structure and Hugo theme already match. Most of the time will be spent on content decisions (default image, site copy) rather than infrastructure code.

**What stays identical (copied verbatim):**
- `layouts/partials/head.html` (once the OG extension from Step 2 is in place)
- `layouts/partials/engagement.html`
- The `[params.authors.*]` and `[params.analytics]` schemas in `hugo.toml` (values differ; structure is the same)
- CSS additions for the engagement block
- Frontmatter schema for Signals and News posts
- Content-section structure and naming (Projects / Signals / News)

---

## Rollback

Each step is reversible. Plausible can be disabled by blanking `plausibleDomain`. The engagement block can be disabled globally via `[params.engagement] enabled = false`, or per-post via frontmatter `engagement: false`. Reverting the layout changes is a git revert.

## Success criteria

When the plan is fully executed:

1. Plausible dashboard shows live pageview data for javai.org.
2. Sharing a javai.org post URL to LinkedIn produces a rich preview card (title, description, image).
3. Each post on javai.org carries a byline and an end-of-post engagement block with correctly resolved LinkedIn links.
4. No email address appears anywhere on the site.
5. No third-party JavaScript loads beyond Plausible.
6. No public comments are accepted on the site itself.
7. The same mechanism is ready to be copied to javai.ch by populating the author registry and swapping the Plausible domain.

## Review log

| Date       | Reviewer        | Outcome               |
|------------|-----------------|-----------------------|
| 2026-04-19 | Michael Mannion | Approved.             |
