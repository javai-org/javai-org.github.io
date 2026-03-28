---
title: "javai-R"
description: "The statistical oracle for the javai project family — R-generated reference datasets that verify conformance across all framework implementations."
keywords: ["javai-R", "R statistics", "conformance testing", "Wilson score", "reference data", "statistical oracle", "probabilistic testing", "cross-language verification"]
weight: 0
---

**javai-R** is the statistical oracle for the javai project family. It uses R — the gold standard for statistical computing — to generate language-agnostic reference datasets against which all javai framework implementations verify their statistics engines.

## Why it exists

The javai family includes multiple independent implementations of the same statistical methodology: [punit](/projects/punit/) (Java), feotest (Rust), and future frameworks in other languages. Each implements Wilson score confidence intervals, threshold derivation, power analysis, feasibility checking, and verdict evaluation independently, in its own language and idiom.

javai-R provides the shared truth. If your implementation produces results that match the R-generated reference data within stated tolerances, it conforms. No need to trust a Java or Rust implementation — the expected outputs come from R's well-vetted statistical functions.

## What it covers

| Suite                | Covers                                           |
|----------------------|--------------------------------------------------|
| Wilson CI            | Two-sided Wilson score confidence intervals      |
| Wilson lower bound   | One-sided Wilson score lower bound               |
| Threshold derivation | Sample-size-first and threshold-first approaches |
| Power analysis       | Sample size calculation via power analysis       |
| Feasibility          | Verification feasibility checking                |
| Verdict evaluation   | Pass/fail determination with z-test statistics   |

Each suite is published as a JSON file containing test cases with inputs, expected outputs, and a tolerance for floating-point comparison. Framework conformance tests read these files and assert that every computation matches.

## The Statistical Companion

javai-R hosts the [Statistical Companion](https://r.javai.org/STATISTICAL-COMPANION.html) — the formal mathematical foundation for the entire javai methodology. This document provides a rigorous treatment of the hypothesis testing, confidence intervals, power analysis, and threshold derivation methods that all javai frameworks implement.

It also hosts the [Distributional Contracts](https://r.javai.org/DISTRIBUTIONAL-CONTRACTS.html) paper, which extends Bertrand Meyer's Design by Contract to stochastic systems by lifting postconditions from Boolean predicates to statistical assertions.

## Designed to grow

javai-R is structured as a proper R package, versioned and installable. Its current focus is statistics engine conformance, but it is designed to expand into design of experiments (DoE) reference data as the javai family's capabilities grow.

## Repository

Browse the source, reference datasets, and documentation on [GitHub](https://github.com/javai-org/javai-R).

The companion [javai-R site](https://r.javai.org/) hosts the rendered Statistical Companion and Distributional Contracts papers.
