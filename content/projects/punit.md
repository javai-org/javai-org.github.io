---
title: "punit"
description: "Probabilistic unit testing for Java — extend JUnit with statistical assertions."
weight: 1
---

**punit** is an open-source Java library that extends JUnit to support statistical assertions on non-deterministic systems.

## Why punit?

Traditional unit tests assume that given the same input, a function always returns the same output. But AI models, probabilistic algorithms, and stochastic simulations don't work that way. punit bridges this gap by letting you write tests that express expectations about *distributions* rather than exact values.

## Key capabilities

- **Statistical assertions** — assert that outputs follow expected distributions with configurable confidence levels
- **Regression detection** — detect when a non-deterministic system's behaviour has shifted beyond acceptable bounds
- **CI/CD integration** — runs as standard JUnit tests, compatible with Maven, Gradle, and all major build tools
- **Auditable results** — produces structured output suitable for compliance reporting

## Get started

Visit the [punit repository on GitHub](https://github.com/javai-org/punit) for installation instructions, documentation, and examples.

See [punit examples](https://github.com/javai-org/punitexamples) for worked patterns covering real-world testing scenarios.
