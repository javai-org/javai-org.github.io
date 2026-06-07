---
title: "feotest diagnostic device demo"
description: "A runnable demonstration of feotest applied to a diagnostic device treated as a stochastic service — establishing a statistically defensible performance baseline, then continuously verifying the device still meets it."
keywords: ["feotest diagnostic device demo", "medical device testing", "probabilistic testing", "stochastic service", "diagnostic device", "post-market surveillance", "Rust"]
weight: 6
language: "Rust"
---

**feotest diagnostic device demo** is a runnable demonstration of the [feotest](/projects/feotest/) framework applied to a medical context: a diagnostic instrument treated as a stochastic service. It shows how to make — and then *keep* — a statistically defensible claim about a device's performance.

The service under test is a physical diagnostic instrument behind an API: given a specimen, it returns a call (tumour or normal) with analytical noise, the occasional invalid/QC result, and a variable turnaround time. Run the same specimen twice and the call can differ — genuinely stochastic behaviour, which is exactly what feotest is for.

The instrument is a stochastic mock and the reference panel is synthetic control material. The showcase demonstrates a *methodology*, not a clinical result, and makes no claim about any specific product or vendor.

## Two operations, one loop

The lifecycle is split into two explicit operations:

- **measure** runs an experiment over the reference panel and derives the empirical baseline — sensitivity and specificity, each with a Wilson confidence floor, tagged with the device's covariate identity (software version, reagent lot). You do this once, when you validate the device.
- **verify** runs a probabilistic test for the current device against that committed baseline, and exits non-zero on failure — so it drops straight into a CI gate you re-run on every firmware build, reagent lot, or release. It refuses to run without a baseline: verification depends on validation having happened.

## The demonstration run

A single default run tells the whole story end to end, in four phases:

1. **Characterise** — the measure experiment mints the baseline (validation).
2. **Verify** a healthy device — **PASS** (verification).
3. **Drift caught** — a silently degraded instrument (same declared configuration, more measurement noise) falls below the validated sensitivity floor and **FAILs**: a regression the version number never advertised.
4. **Covariate guard** — the same device with a new reagent lot **PASSes with a covariate-mismatch warning**: the baseline was measured for a different lot, so it no longer applies as-is and should be re-measured before it is trusted.

## What it demonstrates

- **Empirical baselines** — sensitivity and specificity measured over a reference panel, each carrying a Wilson confidence floor rather than a bare point estimate
- **Covariates as baseline identity** — the baseline is tagged with the device's software version and reagent lot, so a comparison is only made between like and like
- **Drift detection** — a degradation invisible to the version number is caught as a verdict below the validated floor
- **Covariate-mismatch warning** — a changed reagent lot produces a soft warning rather than a silent, invalid pass
- **A CI-ready gate** — `verify` exits non-zero on failure, so the same check runs on every firmware build, lot change, or release
- **Reproducible, auditable verdicts** — under the fixed-seed mock, the same inputs yield the same verdict, so a probabilistic result can be reproduced and audited

## Running it

Everything runs out of the box with no external services — the instrument and reference panel are built in.

```sh
cargo run -- measure   # experiment → baseline   (validation)
cargo run -- verify    # probabilistic test      (verification)
cargo run              # the whole loop end to end, in four phases
```

Browse the source and instructions on [GitHub](https://github.com/mavai-org/feotest-showcase-medical).
