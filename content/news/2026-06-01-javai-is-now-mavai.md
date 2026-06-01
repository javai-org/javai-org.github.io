---
title: "Javai is now Mavai"
date: 2026-06-01
description: "The project family has been renamed from Javai to Mavai. New home, same projects — and every old address redirects, forever."
summary: "The frameworks, the websites, the GitHub org and the Maven coordinates have all moved from javai to mavai. Nothing breaks: old URLs 301-redirect, GitHub repo transfers forward automatically, and the final javai Maven artifacts carry relocation POMs. Here is what changed and what, if anything, you need to do."
keywords: ["mavai", "javai", "rename", "rebrand", "punit", "feotest", "outcome", "Maven Central", "relocation POM", "probabilistic testing"]
---

The project family that published as **Javai** is now **Mavai**. The frameworks themselves are unchanged — `punit`, `feotest`, `outcome`, and the statistical oracle keep their names and their behaviour. What moved is the family name and the addresses that name appears in: the websites, the GitHub organisation, and the Maven group.

Everything that pointed at the old name keeps working. We have kept every redirect in place and intend to keep them there indefinitely.

## What moved

| Old address                             | New home                                                                                 |
|-----------------------------------------|------------------------------------------------------------------------------------------|
| `javai.org`                             | [`mavai.org`](https://mavai.org/)                                                        |
| `javai.ch`                              | [`mavai.ch`](https://mavai.ch/)                                                          |
| `r.javai.org` (statistical oracle)      | [`r.mavai.org`](https://r.mavai.org/)                                                    |
| `github.com/javai-org/punit`            | [`github.com/mavai-org/punit`](https://github.com/mavai-org/punit)                       |
| `github.com/javai-org/punitexamples`    | [`github.com/mavai-org/punitexamples`](https://github.com/mavai-org/punitexamples)       |
| `github.com/javai-org/outcome`          | [`github.com/mavai-org/outcome`](https://github.com/mavai-org/outcome)                   |
| `github.com/javai-org/feotest`          | [`github.com/mavai-org/feotest`](https://github.com/mavai-org/feotest)                   |
| `github.com/javai-org/feotest-examples` | [`github.com/mavai-org/feotest-examples`](https://github.com/mavai-org/feotest-examples) |
| `github.com/javai-org/javai-R`          | [`github.com/mavai-org/mavai-R`](https://github.com/mavai-org/mavai-R)                   |
| Maven group `org.javai`                 | `org.mavai`                                                                              |

## If you visit the websites

Nothing to do. Typing an old `javai.org`, `javai.ch`, or `r.javai.org` address — including any deep link — lands you on the matching `mavai` page. The redirects are path- and query-preserving HTTP 301s, so bookmarks, citations, and links in old posts all continue to resolve.

## If you clone from GitHub

Nothing to do. Every repository moved by GitHub **transfer**, not re-creation, so existing clone URLs, `git remote` entries, issue links, and pull-request references all forward automatically to the `mavai-org` organisation. You can repoint your remote at your convenience:

```sh
git remote set-url origin https://github.com/mavai-org/punit.git
```

…but you do not have to.

## If you depend on punit, outcome, or the examples via Maven

The artefacts moved from the `org.javai` group to **`org.mavai`**. The artifact IDs are unchanged — only the group changed:

```kotlin
// before
implementation("org.javai:punit:…")
// now
implementation("org.mavai:punit:…")
```

Maven Central artifacts are immutable, so every release already published under `org.javai` stays exactly where it is. In addition, the final `org.javai` release of each artifact carries a **Maven relocation POM**, so a build still pinned to the old coordinates resolves automatically to the new one and prints a deprecation notice pointing at `org.mavai`. You are never stranded; updating the group ID is a cleanup you can do on your own schedule.

The Gradle plugin id likewise moves from `org.javai.punit` to **`org.mavai.punit`**.

For the current version of each artifact, see the project pages — [punit](/projects/punit/), [outcome](/projects/outcome/) — or search [Maven Central](https://central.sonatype.com/) for the `org.mavai` group.

## If you use feotest from Rust

Nothing to do. `feotest` is published on [crates.io](https://crates.io/crates/feotest), where crate names are not namespaced by organisation — the crate is still simply `feotest`, and your `Cargo.toml` is unaffected. Only the source repository moved, to `github.com/mavai-org/feotest`, and the old URL redirects.

## The projects are the same

To be clear about what did *not* change: this is a rename of the family and its addresses, not of the tools. `punit` is still `punit`, `feotest` is still `feotest`, `outcome` is still `outcome`, and the methodology, APIs, and on-disk formats are untouched by the move. If your code builds today, it builds tomorrow.

## Links

- [mavai.org](https://mavai.org/) — the project family
- [mavai-org on GitHub](https://github.com/mavai-org)
- [punit](/projects/punit/) · [outcome](/projects/outcome/)
- [r.mavai.org](https://r.mavai.org/) — the statistical oracle and conformance fixtures
