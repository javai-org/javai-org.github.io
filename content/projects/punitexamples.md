---
title: "punit examples"
description: "A complete example application demonstrating punit — LLM shopping basket testing, payment gateway SLA verification, and all major experiment modes."
keywords: ["punit examples", "probabilistic testing examples", "LLM testing", "SLA verification", "AI testing patterns", "CI/CD AI testing"]
weight: 2
language: "Java"
---

**punit examples** is a companion repository containing a fully worked example application that demonstrates the [punit](/projects/punit/) framework across all its major capabilities.

## Two example domains

### Shopping Basket (empirical approach)
An LLM translates natural language instructions (e.g. "Add 2 apples") into structured JSON actions for a shopping basket API. Because LLM behaviour is inherently probabilistic — it may hallucinate fields, produce malformed JSON, or invent invalid actions — success rates are established empirically through measurement experiments rather than predetermined.

### Payment Gateway (SLA-driven approach)
A simulated external payment service with contractual SLA obligations (99.99% availability, sub-second latency). Tests verify compliance against these mandated thresholds with full provenance tracking.

## What's demonstrated

- **Explore experiments** — compare LLM models (GPT-4o, Claude Sonnet, Claude Haiku) and temperature settings with small sample sizes to identify the best configuration
- **Measure experiments** — establish statistical baselines with 1000+ samples, producing YAML spec files with confidence intervals and latency distributions
- **Optimize experiments** — iteratively refine temperature and prompt parameters to maximise success rates
- **Threshold approaches** — sample-size-first, confidence-first, and threshold-first configuration patterns
- **Budget management** — time budgets, token budgets, and budget exhaustion behaviours (FAIL vs. EVALUATE_PARTIAL)
- **Rate pacing** — requests-per-second and requests-per-minute limits for API cost control
- **Covariate tracking** — temporal, configuration, and infrastructure covariates with baseline matching
- **Verification vs. smoke intent** — evidential compliance testing vs. lightweight sentinel checks
- **Exception handling modes** — FAIL_SAMPLE (continue) vs. ABORT_TEST (stop immediately)

## Running the examples

The project includes a mock LLM that requires no API keys, simulating realistic behaviour including temperature-sensitive reliability. Real LLM providers (OpenAI, Anthropic) can be enabled via environment variables.

Browse the source and instructions on [GitHub](https://github.com/javai-org/punitexamples).
