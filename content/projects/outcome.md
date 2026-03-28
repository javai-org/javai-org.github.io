---
title: "outcome"
description: "A Java framework for handling non-deterministic operations with type-safe results, structured failure classification, and policy-driven retries."
keywords: ["outcome", "Java error handling", "type-safe results", "failure classification", "retry policy", "operational resilience", "boundary pattern"]
weight: 3
language: "Java"
---

**outcome** is a Java framework that provides a formal boundary between deterministic application code and fallible, non-deterministic operations such as network calls, database queries, and external API requests.

## The problem

Java's exception model conflates three fundamentally different failure categories: operational failures (network timeouts, service unavailability), defects (null pointers, logic errors), and terminal errors (out of memory). This leads to inconsistent error handling, ad-hoc retry loops, and swallowed exceptions across codebases.

## How it works

Outcome replaces try/catch with a sealed `Outcome<T>` type — either `Ok` (success with a value) or `Fail` (a structured failure). This enables exhaustive handling via Java's pattern matching:

```java
return switch (outcome) {
    case Outcome.Ok(var user, var _) -> "Hello, " + user.name();
    case Outcome.Fail(var failure, var _) -> "Error: " + failure.message();
};
```

## Key capabilities

- **Explicit boundaries** — the `Boundary` class marks the crossing point between deterministic code and fallible operations, catching checked exceptions and classifying them into structured failures
- **Structured failure data** — each `Failure` carries a namespaced ID, type (TRANSIENT, PERMANENT, or DEFECT), message, retry guidance, correlation ID, and observability tags
- **Automatic failure classification** — common exceptions are mapped to appropriate failure types (e.g. `SocketTimeoutException` → transient network timeout, HTTP 429 → transient with rate-limit handling)
- **Policy-driven retries** — centralised retry logic with fixed, exponential backoff, and immediate policies, respecting the failure's `retryAfter` hint and configurable time budgets
- **Guided retry** — for feedback-loop scenarios such as LLM interactions, where failure context from one attempt informs the next
- **Functional composition** — chain operations with `map`, `flatMap`, `recover`, and `recoverWith`, preserving correlation IDs through the pipeline
- **Built-in observability** — the `OpReporter` interface receives failure events for logging, metrics, and alerting, with built-in reporters for SLF4J and JSON-lines output
- **Defect escalation** — bugs (unchecked exceptions) propagate and page operators via `OperationalExceptionHandler`, rather than being silently swallowed

## Design principle

Recoverable failures flow as values. Defects crash and page. Terminal errors terminate. Outcome makes this distinction explicit and enforceable.

## Repository

View the source and documentation on [GitHub](https://github.com/javai-org/outcome).
