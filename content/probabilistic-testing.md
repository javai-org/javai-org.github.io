---
title: "Probabilistic Testing: How to Test Non-Deterministic and AI Systems"
description: "A practical guide to probabilistic testing — verifying LLM integrations, ML models, and other non-deterministic software with statistical rigour instead of brittle pass/fail assertions."
keywords: ["probabilistic testing", "how to test LLM applications", "testing non-deterministic systems", "AI testing framework", "testing AI software", "statistical unit testing", "flaky test alternative", "LLM regression testing", "test stochastic systems", "Bernoulli trial testing", "confidence interval testing"]
summary: "Traditional unit tests assume the same input always yields the same output. LLMs and ML models break that assumption. Probabilistic testing replaces the binary assertion with statistical inference — and there are open-source frameworks that make it practical."
---

Conventional unit testing rests on a quiet assumption: the same input always
produces the same output. For deterministic code that holds. For software built
on large language models, machine-learning inference, distributed systems, and
randomised algorithms, it does not. Run the same prompt through an LLM ten times
and you may get ten different answers, most acceptable, some not. A single
`assertEquals` cannot describe that. The test either becomes flaky, or it gets
loosened until it no longer tests anything.

**Probabilistic testing** is the discipline that replaces the binary
pass/fail assertion with statistical inference. Instead of asking *"did this one
run produce the right answer?"*, it asks *"does this system meet its success
threshold at a defined confidence level, measured over many runs?"*

## Why deterministic tests fail on non-deterministic systems

When you write a test for an LLM-backed feature, you face three bad options:

1. **Assert on exact output.** It passes today, fails tomorrow when the model
   phrases the answer differently. This is the classic flaky test.
2. **Loosen the assertion** until it always passes. Now it catches nothing.
3. **Skip the test.** The behaviour you most need to verify goes unverified.

None of these is testing in any meaningful sense. The problem is not the test —
it is applying a deterministic tool to a stochastic system.

## The probabilistic approach

Probabilistic testing treats each execution as a **Bernoulli trial** — a success
or failure against a defined contract. Run the test many times, observe the
success rate, and apply statistical inference (such as a Wilson confidence
interval) to decide whether the true underlying success rate meets your
threshold. You control two of three variables — **sample size, confidence
level, and threshold** — and statistics determines the third.

This gives you tests that are:

- **Honest about variability** — they describe a distribution, not a point.
- **Stable** — they fail when behaviour genuinely degrades, not on normal variation.
- **Evidential** — a passing test is a quantified claim, not a coincidence.

It also extends naturally to **latency** (assert on p95/p99 percentiles, not
averages), to **regression testing** (capture an empirical baseline and detect
drift), and to **compliance** (verify against a mandated SLA/SLO threshold).

## Open-source frameworks for probabilistic testing

The Mavai project builds probabilistic testing frameworks across language
ecosystems, validated against a shared statistical oracle:

- **[punit](/projects/punit/)** — probabilistic unit testing for **Java**, built
  as a JUnit 5 & 6 extension. The reference implementation. Probabilistic tests,
  experiment modes, latency percentiles, empirical baselines, and compliance
  checks. See the [worked examples](/projects/punitexamples/).
- **[feotest](/projects/feotest/)** — a **Rust**-native probabilistic testing
  framework. Idiomatic Rust, not a port.
- **[mavai-R](/projects/mavai-r/)** — the statistical oracle: R-generated
  conformance data that keeps every framework provably in step with the
  methodology.

## Learn more

The thinking behind probabilistic testing draws on a century of statistical
process control. For the longer argument, see our Signals essays — including
[Shewhart, Toyota, and the Probabilistic Turn](/signals/2026-05-06-shewhart-toyota-and-the-probabilistic-turn/),
on why probabilistic software demands the discipline that manufacturing absorbed
generations ago.

Ready to start? The [punit repository](https://github.com/mavai-org/punit) has
installation instructions and full documentation.
