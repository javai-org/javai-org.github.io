---
title: "Introducing feotest"
date: 2026-06-08
author: michael
description: "feotest brings probabilistic testing to Rust — a framework for services whose output varies by design. Version 0.1.0 is on crates.io."
summary: "punit's approach, native to Rust. A non-deterministic service is treated as a stochastic service: establish a statistical baseline, then verify the service still meets it — with confidence intervals, latency distributions, and auditable verdicts. Version 0.1.0 is on crates.io."
keywords: ["feotest", "Rust", "probabilistic testing", "stochastic services", "crates.io", "punit", "release"]
---

The first release of [`feotest`](/projects/feotest/) is on [crates.io](https://crates.io/crates/feotest): probabilistic testing, native to Rust.

## Why

[punit](/projects/punit/) brought statistical testing to the JVM — run a test many times, then apply inference to decide whether a non-deterministic system is behaving acceptably. Rust teams building the same kind of system — LLM-backed services, stochastic devices, anything whose output varies by design — had no equivalent in their own language, until now.

## What it does

A service under test is treated as a **stochastic service**: rather than a single pass/fail assertion, you establish a statistically defined baseline and then verify the service still conforms to it. That gives you:

- functional outcomes reported with confidence intervals (Wilson construction)
- latency treated as a distribution, not an average
- an overall verdict that is a conjunction of contract criteria
- covariate-aware baselines, time and cost budgets, rate pacing, and a deployable Sentinel for running checks outside the test harness

It is idiomatic Rust, not a port of punit: functional equivalence with the Java framework, expressed the way Rust developers expect.

```toml
[dev-dependencies]
feotest = "0.1"
```

## Verified against the oracle

Like punit, feotest is checked release by release against [mavai-R](https://github.com/mavai-org/mavai-R), the family's statistical oracle — so the numbers it produces match an independent reference implementation of the published methodology.

## Get started

- The framework — [feotest on crates.io](https://crates.io/crates/feotest) and [GitHub](https://github.com/mavai-org/feotest)
- Worked examples — [feotest examples](/projects/feotest-examples/)
- A runnable applied demo — [feotest diagnostic device demo](/projects/feotest-diagnostic-device-demo/)
- The methodology — [r.mavai.org](https://r.mavai.org/)

The framework is licensed Apache 2.0, developed under a DCO contributor model. Feedback and contributions are welcome on the [issue tracker](https://github.com/mavai-org/feotest/issues).
