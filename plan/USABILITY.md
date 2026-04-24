# Mobile usability audit — javai.org

Companion to the javai.ch audit (see `javai-ch/plan/USABILITY.md`). This
tracker records which of the three javai.ch-class defects were present
on javai.org and how they were resolved.

**Target viewport:** 390 × 844 (iPhone 14/15), with a 360 × 780 spot
check. Phones only (≤480 px wide). iPad portrait and desktop were left
alone.

**Note on language coverage.** Unlike javai.ch, javai.org is
single-language (English). The German-text overflow concern that
motivated several of javai.ch's fixes does not apply here. Measurements
below are English only.

**Method.** Headless Chrome via CDP; geometry from `getBoundingClientRect`
and `scrollHeight`/`clientHeight`. Screenshots were not used as evidence
— only as illustration. See `/tmp/chrome-audit/` for the measurement
scripts (`measure.py`, `verify_banner.py`).

## Status

| # | Item | Outcome | Notes |
|---|------|---------|-------|
| 1 | Single 768 px breakpoint covering phone + tablet | **Fixed** | Two `@media` blocks existed (640 + 768), but the substantive mobile rules all lived in 768, so the root cause applied. Added a new `@media (max-width: 480px)` block below the 768 block. |
| 2 | Navigation density on phone | **Not present** | `.site-header` measured **113 px** at 390 px — under the ~120 px threshold. Nav wrapped to two rows (logo stacked above a 2-row nav), not three. `navRows === 2`, `scrollWidth === clientWidth` everywhere. No fix applied. |
| 3 | Hero and section banners consume excessive vertical space / clip content | **Fixed** | Hero was 635 px on `/` at 390 px (75% of viewport); driven by `--space-xxl` (7rem) vertical padding rather than `min-height`. All four `.section-banner` routes were clipping — /signals/ lost 41 px of its subtitle beneath `overflow: hidden`. Both fixed in the new 480 px block. |

## Pre-fix measurements (390 × 844)

### Home (`/`)

| Element | Height | Notes |
|---|---|---|
| `.site-header` | 113 px | logo + 2 nav rows |
| `.hero` | **635 px** | min-height 400 exceeded; `.hero .container` has 112 + 112 px vertical padding |
| `.hero h1` | 166 px at 2.25rem |  |
| `.hero-sub` | 114 px at 1.05rem |  |

### Section-banner routes

| Route | `.section-banner` clientH | scrollH | Verticalclip | Subtitle h |
|---|---|---|---|---|
| `/projects/` | 180 | 194 | 14 px hidden | 54 |
| `/signals/`  | 180 | **221** | **41 px hidden** | 108 |
| `/news/`     | 180 | 194 | 14 px hidden | 54 |
| `/subscribe/`| 180 | 194 | 14 px hidden | 54 |

The 14 px loss on three routes is a single line of padding being
squeezed; the 41 px loss on `/signals/` is the second half of the
two-sentence subtitle disappearing behind `overflow: hidden`.

## Fix — new `@media (max-width: 480px)` block

Adapts javai.ch commits `54d155d` (phone breakpoint) and `78e529f`
(hero + banner trim) to javai.org's actual CSS:

- `.hero { min-height: 280px; }` (was 400 at 768).
- `.hero .container { padding-top/bottom: var(--space-md); }` (was
  `--space-xxl` = 7rem). This is the single biggest saving.
- `.hero h1` → 1.875rem, `.hero-sub` → 0.95rem.
- `.section-banner { height: auto; min-height: 120px; }`. Switching
  off the fixed height is what stops the clipping.
- `.section-banner .container` padding trimmed to `--space-md` each.
- `.section-banner h1` → 1.5rem, `.section-banner-sub` → 0.95rem.

Nav rules (item 2) were deliberately left out — measurements showed
the nav was not a defect here.

## Post-fix measurements (390 × 844)

### Hero (`/`)

| Metric | Pre-fix | Post-fix | Δ |
|---|---|---|---|
| `.hero` height | **635 px** | **386 px** | −249 px |
| share of 844 px viewport | 75 % | 46 % | — |
| `.hero h1` height | 166 | 104 | −62 |
| `.hero-sub` height | 114 | 103 | −11 |
| container vertical padding | 112 + 112 | 32 + 32 | −160 |

### Section-banner (all four routes)

| Route | Pre-fix height / clip | Post-fix height / clip |
|---|---|---|
| `/projects/`  | 180 / **14 px hidden** | **165** / 0 (scrollH === clientH) |
| `/signals/`   | 180 / **41 px hidden** | **190** / 0 (auto-expands around long subtitle) |
| `/news/`      | 180 / **14 px hidden** | **165** / 0 |
| `/subscribe/` | 180 / **14 px hidden** | **165** / 0 |

No banner has vertical overflow any more. `/signals/`, whose subtitle
is long enough to push the banner past the 180 px fixed height,
correctly expands to 190 px rather than clipping. Short-subtitle
routes contract to 165 px.

### Header (unchanged — not a defect)

`.site-header` stayed at 113 px across all routes and both viewports.
Nav still wraps to 2 rows, logo still stacks above.

### 360 × 780 spot check

| Element | Pre-fix | Post-fix |
|---|---|---|
| `.hero` (home) | 731 | 454 |
| `.section-banner` (/signals/) | 180 (clipping) | 190 |

Hero does not drop as dramatically at 360 because the narrower width
wraps `.hero h1` onto four lines instead of three, but the saving
from padding is still worth ~280 px.

## What was not chased

- **Horizontal body overflow on `/subscribe/`** briefly appeared in
  one 360 × 780 capture (`scrollW 380 vs clientW 360`). Traced to a
  CDP viewport-override timing artefact (`window.innerWidth` reported
  380 mid-navigation). No element on the page had `left < 0` or
  `right > viewport` — zero offenders. Retracted without a fix.

## References

- `javai-ch/plan/USABILITY.md` — the companion tracker.
- javai-ch commits `54d155d` (phone breakpoint + compact nav) and
  `78e529f` (hero + banner trim).
- Directive: `plan/DIRECTIVE-USABILITY.md`.
