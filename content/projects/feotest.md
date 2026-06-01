---
title: "feotest"
description: "A Rust-native probabilistic testing framework — idiomatic, zero-copy, and built for the Rust ecosystem from the ground up."
keywords: ["feotest", "probabilistic testing", "Rust testing framework", "stochastic testing", "non-deterministic testing", "Rust", "statistical assertions"]
weight: 4
language: "Rust"
---

**feotest** is a probabilistic testing framework for Rust. It is designed for systems where behaviour is non-deterministic by nature — LLM integrations, ML model inference, ranking and recommendation systems, and externally influenced APIs. It brings the same statistical methodology as [punit](/projects/punit/) to the Rust ecosystem, built from the ground up as idiomatic Rust rather than a port.

## How it works

Instead of the traditional binary pass/fail model, feotest treats each invocation of a stochastic service as a Bernoulli trial with a binary outcome — success or failure, as defined by a contract. Given a sequence of such trials, it applies statistical inference to determine whether the observed pass rate meets a defined threshold at a given confidence level.

## Key capabilities

- **Probabilistic tests** (`ProbabilisticTestBuilder`) — run a service multiple times and evaluate the observed pass rate against a threshold, with configurable confidence levels, integrating with Rust's native `#[test]` harness
- **Three experiment modes** — **Explore** (compare configurations with small samples), **Optimize** (iteratively tune a configuration factor, such as temperature, against a scorer), and **Measure** (establish an empirical baseline; 1000+ samples recommended)
- **Service contracts** — define reusable success criteria as an ordered chain of postconditions; a contract violation is counted as a failed trial (data), while a panic aborts the run as a defect
- **Spec-driven baselines** — measurement experiments produce spec files capturing observed success rates, confidence intervals, latency percentiles, and covariate values, committed to version control as regression baselines
- **Latency assertions** — evaluate response times at percentile level (p50, p90, p95, p99), not averages, revealing tail behaviour that means hide
- **Covariate-aware matching** — track environmental factors (model, temperature, infrastructure) and detect baseline misalignment, surfacing an inconclusive verdict rather than a misleading one
- **Budget and pacing controls** — set warm-up, time budgets, token budgets, and rate limits; feotest paces execution and stops when resources are exhausted
- **Normative and empirical thresholds** — a threshold's provenance is explicit: a normative target (an externally agreed contract/SLA, an internal service objective, or a policy target) or an empirical reference derived from a measured baseline
- **Verification vs. smoke intent** — declare whether a test is an evidential claim (with enforced minimum sample sizes) or a lightweight early-warning check
- **The Sentinel** — a harness-free runtime engine for monitoring stochastic behaviours in deployed environments without test framework dependencies
- **Structured reporting** — console, HTML, and JUnit XML output with per-test statistical detail, confidence intervals, latency percentiles, and covariate misalignment warnings

## The parameter triangle

You control two of three variables — sample size, confidence, and threshold — and statistics determines the third. feotest supports three configuration approaches: threshold-first, sample-size-first, and confidence-first.

## Why Rust

Rust's ownership model, zero-cost abstractions, and strong type system make it a natural fit for infrastructure and safety-critical systems — exactly the kind of services where probabilistic testing matters most. feotest is designed to feel native to Rust developers, following the conventions and idioms of the Rust testing ecosystem: builders, traits, macros, and the language's native test harness.

## Relationship to punit

feotest implements the same statistical methodology as punit, verified against the same [mavai-R](/projects/mavai-r/) reference datasets. The two frameworks share a specification — what to compute — but not an implementation. Where punit uses JUnit 5 extensions and Java annotations, feotest uses Rust macros, traits, and the language's native test harness.

## Add to your project

feotest is published on [crates.io](https://crates.io/crates/feotest). Add it as a dev-dependency:

```toml
[dev-dependencies]
feotest = "0.1.0"
```

Or with Cargo:

```sh
cargo add --dev feotest
```

## Get started

Visit the [feotest repository on GitHub](https://github.com/mavai-org/feotest) for installation instructions and full documentation.

See [feotest examples](/projects/feotest-examples/) for worked service contracts demonstrating the framework's features.
