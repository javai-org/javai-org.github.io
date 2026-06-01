---
title: "punit"
description: "A JUnit 5 & 6 extension for probabilistic testing of non-deterministic systems — explore, measure, and regression-test with statistical rigour."
keywords: ["punit", "probabilistic unit testing", "JUnit 5 extension", "JUnit 6", "AI testing framework", "stochastic testing", "non-deterministic testing", "Java testing", "AI regression testing", "statistical assertions"]
weight: 1
language: "Java"
---

**punit** is a JUnit extension framework for probabilistic testing, compatible with JUnit 5 and 6. It is designed for systems where behaviour is non-deterministic by nature — LLM integrations, ML model inference, distributed systems, and randomised algorithms.

## How it works

Instead of the traditional binary pass/fail model, punit executes a test multiple times and treats each run as a Bernoulli trial. It then applies statistical inference to determine whether the observed success rate meets a defined threshold at a given confidence level.

## Key capabilities

- **Probabilistic tests** (`@ProbabilisticTest`) — run a test method multiple times and evaluate the observed pass rate against a threshold, with configurable confidence levels
- **Three experiment modes** (`@Experiment`) — **Explore** (compare configurations with small samples), **Optimize** (iteratively tune parameters like temperature or prompts), and **Measure** (establish empirical baselines with 1000+ samples)
- **Use cases and service contracts** — define reusable success criteria with postconditions, derived checks, and duration constraints, evaluated in a fail-fast hierarchy
- **Spec-driven baselines** — measurement experiments produce YAML spec files capturing observed success rates, confidence intervals, latency percentiles, and covariate values, committed to version control as regression baselines
- **Latency assertions** — evaluate response times at percentile level (p50, p90, p95, p99), not averages, revealing tail behaviour that means hide
- **Covariate-aware matching** — track environmental factors (model, temperature, time of day, infrastructure) and automatically select the most appropriate baseline for the current conditions
- **Budget and pacing controls** — set time budgets, token budgets, and API rate limits; punit computes optimal execution pace and stops when resources are exhausted
- **Compliance and conformance testing** — verify against mandated SLA/SLO thresholds (compliance) or detect drift from empirical baselines (conformance)
- **Verification vs. smoke intent** — declare whether a test is an evidential claim (with enforced minimum sample sizes) or a lightweight early-warning check
- **The Sentinel** — a JUnit-free runtime engine for monitoring stochastic behaviours in deployed environments without test framework dependencies
- **HTML reporting** — standalone reports with per-test statistical detail, confidence intervals, z-scores, latency percentiles, and covariate mismatch warnings

## The parameter triangle

You control two of three variables — sample size, confidence, and threshold — and statistics determines the third. punit supports three configuration approaches: sample-size-first, confidence-first, and threshold-first.

## Add to your project

punit is published to Maven Central under the `org.mavai` group. Depend on `punit-core` for the testing API, and add `punit-report` to write HTML and verdict-XML reports.

**Gradle (Kotlin DSL):**

```kotlin
dependencies {
    testImplementation("org.mavai:punit-core:0.9.0")
    testImplementation("org.mavai:punit-report:0.9.0")
    testImplementation("org.junit.jupiter:junit-jupiter")
}
```

**Maven:**

```xml
<dependency>
    <groupId>org.mavai</groupId>
    <artifactId>punit-core</artifactId>
    <version>0.9.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.mavai</groupId>
    <artifactId>punit-report</artifactId>
    <version>0.9.0</version>
    <scope>test</scope>
</dependency>
```

## Get started

Visit the [punit repository on GitHub](https://github.com/mavai-org/punit) for installation instructions and full documentation.

See [punit examples](/projects/punitexamples/) for a complete worked application demonstrating all major features.
