# Open Innovation Challenge: openEHR for clinical innovation — Submission

*Innovation Catalyst powered by DayOne. Application submitted 19 June 2026.*

## Project name

Evidence-Based Validation of AI Clinical Querying

## Tell us more about your team and/or organization

*Briefly describe your team size, key expertise, and relevant experience your team has in digital health, healthcare IT, clinical workflows, or openEHR?*

Team size: 3

- Software engineering in combination with probabilistic testing
- Clinical trials operations
- AI regulation

## Your location

*[Not captured in the saved form — the location selector did not record a value in the saved HTML.]*

## Type of your organization

Other

## What usecase are you addressing?

Other

## Your website

mavai.org, mavai.ch

## Help us understand what problem are you solving

*Please limit your answer to 300 words.*

The emergence of large language models (LLMs) creates an opportunity to make openEHR data more accessible by allowing clinicians, researchers, and analysts to query clinical repositories using natural language rather than requiring specialist knowledge of AQL. Several solutions are already demonstrating the feasibility of converting natural language questions into executable AQL queries.

However, query generation by LLMs is inherently probabilistic rather than deterministic. A generated query may be syntactically valid yet still retrieve the wrong clinical concept, apply incorrect filtering criteria, omit important constraints, or fail to satisfy organisational governance requirements. As AI-assisted querying becomes more widely adopted, healthcare organisations will need objective evidence that such systems are performing reliably and safely.

The problem this proposal addresses is therefore not how to generate AQL from natural language, but how to measure, validate, monitor, and continuously improve the reliability of AI-generated clinical queries. Today, organisations can often demonstrate that an AI system works in selected examples, but they typically lack statistically rigorous methods for quantifying how often it works correctly, how performance changes between model versions, and whether safety guardrails remain effective over time.

This proposal aims to provide an evidence-based framework for assessing the performance of AI-powered clinical query generation systems, enabling organisations to make informed decisions about deployment, governance, and ongoing operational monitoring.

## How are you trying to solve this problem?

*Please describe your proposed solution in 500 words or less.*

The proposed solution is a statistical validation and monitoring framework for AI-powered clinical query generation systems.

The framework will evaluate the performance of natural language to AQL conversion by repeatedly exercising an AI system against a curated corpus of clinical questions and reference queries. Each generated query will be assessed against a set of measurable criteria, including syntactic validity, successful execution, semantic correctness, result-set equivalence, safety constraints, and latency.

Rather than reporting isolated examples of success or failure, the framework will apply statistical methods to quantify performance in terms of observed success rates, confidence levels, confidence intervals, and regression detection across model versions and configurations. This enables organisations to answer questions such as:

- How often does the system generate clinically correct queries?
- How confident can we be in the measured success rate?
- Has performance improved or degraded following a model upgrade?
- Which categories of clinical questions are most error-prone?
- How effective are safety and governance guardrails?

The solution will leverage openEHR’s deterministic execution model and AQL’s formal semantics to create reproducible, measurable evaluation workflows. Results can be used during development, model selection, acceptance testing, and operational monitoring, providing objective evidence to support governance and deployment decisions.

The project will deliver a proof-of-concept demonstrating how statistical assurance techniques can be applied to AI-assisted querying within the openEHR ecosystem.

## What is the expected impact of your idea?

*Please limit your answer to 300 words.*

The proposed solution aims to increase confidence in the safe and effective use of AI within the openEHR ecosystem.

As natural language interfaces become more common, healthcare organisations will increasingly need objective evidence that AI-generated clinical queries are reliable, accurate, and operating within defined governance boundaries. By providing a statistical framework for measuring and monitoring performance, the project enables organisations to move beyond anecdotal demonstrations and make evidence-based decisions about deployment and ongoing use.

The expected benefits include:

- Increased trust in AI-assisted access to clinical data.
- Earlier detection of performance regressions following model, prompt, or configuration changes.
- Improved visibility into failure modes and high-risk query categories.
- Objective measurement of the effectiveness of safety and governance controls.
- Reduced effort required to validate AI-enabled clinical applications.
- Support for organisational AI governance, auditability, and risk management initiatives.

More broadly, the project seeks to establish a repeatable approach to performance assurance for probabilistic systems within healthcare. While demonstrated using natural language to AQL conversion, the same principles could be applied to other AI-powered capabilities within the openEHR ecosystem, helping organisations adopt innovative technologies while maintaining appropriate levels of safety, transparency, and accountability.

## What is the current stage of your project / idea?

*Include why is your team interested in participating in the validation phase with University Hospital Basel? Please limit your answer to 200 words.*

The underlying statistical assurance technology already exists as an open-source project, and has been applied to the validation of probabilistic software systems, including AI-enabled applications. The proposed project represents an adaptation of these techniques to the specific challenges of AI-assisted clinical query generation within the openEHR ecosystem.

At present, the idea is at the concept and design stage. The problem space has been identified, the proposed methodology has been defined at a high level, and initial investigation has confirmed the availability of suitable use cases, including natural language to AQL conversion.

The next stage would be the development of a proof-of-concept that integrates with an openEHR environment, establishes a representative corpus of clinical questions and reference queries, and demonstrates statistical measurement of query-generation reliability, safety, and performance.

The project therefore combines an existing and proven statistical testing approach with a new application domain within healthcare and openEHR.

## How does your solution integrate with University Hospital Basel IT systems and data infrastructure (e.g., compatibility with openEHR standard)?

*Incl. what dependencies or external integrations might be required for implementation.*

The solution is intended to integrate at the openEHR standards boundary rather than requiring direct integration with underlying hospital databases.

For the proof of concept, the framework would interact with an openEHR-compatible environment using standard openEHR concepts and interfaces, in particular AQL as the query language for retrieving clinical data from an openEHR clinical data repository. This means the solution can evaluate AI-generated queries at the same semantic layer used by openEHR applications, without depending on the physical storage model or proprietary database structures.

The proposed validation framework is therefore compatible with openEHR-based infrastructure by design. It does not require changes to archetypes, templates, clinical data models, or repository internals. Instead, it exercises the natural language to AQL component, submits or validates generated AQL queries, compares results against reference queries or expected outcomes, and records statistical evidence about reliability, safety, and performance.

For University Hospital Basel, integration would depend on the available test environment, governance requirements, and data-access policies. The initial implementation could operate against synthetic, anonymised, or test clinical data, avoiding any need for direct access to identifiable patient information during early development. If later connected to real infrastructure, it would respect existing authentication, authorisation, audit logging, and data-protection controls.

In short, the solution is designed as an assurance layer around AI-assisted openEHR querying, not as a replacement for existing hospital IT systems.

## How scalable is your solution beyond the initial use case or institution?

*Please limit your answer to 300 words.*

The solution is designed to be highly scalable because it operates at the standards and governance layer rather than being tied to a specific implementation, AI model, or institution.

Although the initial proof of concept focuses on natural language to AQL conversion within an openEHR environment, the underlying statistical assurance methodology is applicable to any AI-powered system that exhibits probabilistic behaviour. Within healthcare, this includes clinical decision support, document classification, information extraction, coding assistance, summarisation, and other AI-enabled workflows.

Within the openEHR ecosystem, the approach is portable across organisations because it evaluates systems through standard interfaces and artefacts such as AQL queries, archetypes, templates, and clinical datasets. It does not depend on a specific database technology, vendor platform, or hospital infrastructure.

The framework is also designed to support continuous evaluation throughout the AI lifecycle. The same methodology can be used during development, model selection, acceptance testing, production monitoring, and governance reviews. This allows organisations to track performance over time, detect regressions, and evaluate the impact of model, prompt, or configuration changes using objective statistical evidence.

Beyond University Hospital Basel, the project could therefore serve as a reusable blueprint for trustworthy AI adoption across healthcare organisations and the broader openEHR community. While the initial use case is AI-assisted clinical querying, the longer-term impact is the establishment of a general framework for measuring, validating, and governing probabilistic systems in healthcare.

## How does your solution leverage openEHR or interoperable health data standards?

*Please limit your answer to 200 words.*

The proposed solution leverages openEHR by operating directly on its semantic and interoperability standards rather than on vendor-specific implementations.

The primary use case is the evaluation of AI systems that convert natural language questions into AQL (Archetype Query Language). Because AQL is a standard openEHR query language, the solution can assess AI-generated queries against openEHR-compliant repositories without requiring knowledge of underlying database structures.

The framework also benefits from openEHR’s archetype- and template-based modelling approach. Clinical questions, generated AQL, and resulting datasets can be evaluated against well-defined clinical concepts, enabling objective measurement of query correctness, safety, and performance.

Importantly, the solution does not modify clinical data models or introduce proprietary interfaces. It uses existing openEHR artefacts—including archetypes, templates, and AQL queries—as the basis for validation and monitoring. This promotes portability across openEHR implementations and supports interoperability between organisations that adopt the standard.

By building on openEHR’s formal semantic layer, the project demonstrates how AI-enabled clinical applications can be evaluated in a consistent, transparent, and standards-based manner.

## Please share links to relevant projects, products, publications, or case studies (optional)

- Open-source implementations of the probabilistic testing concept: https://mavai.org
- Statistical theory and programming model: https://r.mavai.org
- Published article: https://www.heise.de/hintergrund/Testen-im-Zeitalter-der-LLMs-Ein-probabilistischer-Ansatz-gegen-flakige-Tests-11298750.html?giftToken=99d5a006-5cfc-497e-add4-33f5966e9a58

## Any additional information you would like us to know (optional)

*If you have a deck or demo, you can add a link to it here. Make sure it can be viewed without further access request.*

I recently gave a talk on the probabilistic testing approach at Switzerland's annual NLP conference 'SwissText 2026'. Here is a link to the handout from the talk:

https://mavai.org/talks/2026-Swiss-Text-Handout.pdf

## Are you able to actively participate in the hybrid validation phase between July - October 2026?

*July is dedicated to onboarding and initial gap analysis, mentorship from the hospital begins in August, DemoDay is planned for October, 2026.*

Yes

## FINAL STEP

I have read, understood and hereby accept the Conditions of Application and the Privacy Policy and confirm that I agree to abide by these rules. *(Accepted.)*
