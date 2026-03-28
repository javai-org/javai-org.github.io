---
title: "feotest"
description: "A Rust-native probabilistic testing framework — idiomatic, zero-copy, and built for the Rust ecosystem from the ground up."
keywords: ["feotest", "probabilistic testing", "Rust testing framework", "stochastic testing", "non-deterministic testing", "Rust", "statistical assertions"]
weight: 2
---

**feotest** is a probabilistic testing framework for Rust. It brings the same statistical methodology as [punit](/projects/punit/) — repeated trials, confidence intervals, threshold-based verdicts — to the Rust ecosystem, built from the ground up as idiomatic Rust rather than a port.

## Coming soon

feotest is in active development and its public release is imminent. The repository will be available at [github.com/javai-org/feotest](https://github.com/javai-org/feotest) once published.

## Why Rust

Rust's ownership model, zero-cost abstractions, and strong type system make it a natural fit for infrastructure and safety-critical systems — exactly the kind of services where probabilistic testing matters most. feotest is designed to feel native to Rust developers, following the conventions and idioms of the Rust testing ecosystem.

## Relationship to punit

feotest implements the same statistical methodology as punit, verified against the same [javai-R](/projects/javai-r/) reference datasets. The two frameworks share a specification — what to compute — but not an implementation. Where punit uses JUnit 5 extensions and Java annotations, feotest uses Rust macros, traits, and the language's native test harness.
