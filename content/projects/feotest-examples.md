---
title: "feotest examples"
description: "Worked examples for the feotest probabilistic testing framework — Rust implementations of the same scenarios covered by punit examples."
keywords: ["feotest examples", "Rust testing examples", "probabilistic testing", "stochastic testing", "Rust"]
weight: 5
language: "Rust"
---

**feotest examples** is a companion repository containing worked examples that demonstrate the [feotest](/projects/feotest/) framework across its major capabilities, mirroring the scenarios covered by [punit examples](/projects/punitexamples/) in idiomatic Rust.

## Two example services

### Shopping basket (empirical approach)
An LLM translates natural language instructions (e.g. "Add 2 apples") into structured JSON actions. Because the LLM is inherently non-deterministic — it may hallucinate field names, produce malformed JSON, or invent actions that do not exist — acceptable success rates are established empirically from a measured baseline rather than fixed in advance.

### Payment gateway (normative approach)
A simulated external payment service with a contractual 99.99% availability SLA. The threshold is known upfront from the contract, so no baseline is needed. The mock deliberately runs just under the SLA (~99.97% success), making occasional failures observable in larger runs.

## What's demonstrated

- **Explore experiments** — compare models and temperatures on the same inputs with small per-configuration sample sizes, to choose a configuration before committing to it
- **Measure experiments** — establish a baseline spec capturing the observed pass rate, its Wilson lower bound, and the latency distribution; a paired probabilistic test later derives its threshold from that baseline
- **Optimize experiments** — iteratively tune temperature (with the model held fixed), scoring each iteration by its observed pass rate
- **Threshold approaches** — threshold-first, sample-size-first, and confidence-first configuration patterns
- **Budget management** — wall-clock time budgets and token-cost budgets, with configurable behaviour on exhaustion (fail, or evaluate the partial result)
- **Rate pacing** — requests-per-second and requests-per-minute limits for rate-limited endpoints
- **Covariate-aware matching** — the contract declares model and temperature covariates; a verifying test resolves the baseline matching its own covariates, or completes with a misalignment warning
- **Reproducible, auditable verdicts** — under a fixed-seed mock, the same inputs yield the same verdict, so a probabilistic verdict can be reproduced and audited
- **The Sentinel** — a standalone deployable binary that carries reliability specs into a target environment (a scheduled job, health check, or post-deploy gate) and runs them outside the test harness

## Running the examples

Everything runs out of the box with no API keys — a built-in mock LLM produces realistic behaviour, including higher failure rates at higher temperatures. The example suite uses small sample sizes so it runs quickly. Real LLM providers can be enabled via environment variables (`FEOTEST_LLM_MODE=real`, `OPENAI_API_KEY=…`).

```sh
cargo test -- --nocapture
```

Browse the source and instructions on [GitHub](https://github.com/mavai-org/feotest-examples).
