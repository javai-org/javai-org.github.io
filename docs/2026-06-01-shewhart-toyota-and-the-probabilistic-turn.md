---
title: "Shewhart, Toyota, and the Probabilistic Turn"
date: 2026-04-21
description: "Why probabilistic software demands the statistical discipline that car manufacturers absorbed a century ago - and what we still have to learn from them."
author: michael
linkedinPost: ""
summary: "LLMs break software's binary view of correctness. The discipline that replaces it already exists - it was built at Bell Labs, refined in Nagoya, and has been waiting for software to need it."
---

<!-- TODO: composite title image. Suggested: Walter Shewhart or a control chart alongside an automotive assembly line or a tolerance-dimensioned engineering drawing. -->

## The reversal

For thirty years, software was something a car company *adopted*. Detroit, Wolfsburg, Toyota City, and Seoul had to learn continuous integration, agile teams, over-the-air updates, the grammar of microservices, and the economics of keeping a platform team on staff. A modern car is a software product with a chassis attached: tens of millions of lines of code, dozens of electronic control units, and a release cadence that looks more like a SaaS roadmap than a model year. [TODO citation: e.g. McKinsey on software-defined vehicles; BCG SDV report; VW CARIAD reorganisation]. The discipline of software development is now as core to a car manufacturer as the discipline of drivetrain design.

For most of that period, the technology transfer ran one way. Software houses had nothing to learn from the assembly line. They were the future; the industrialists were trying to catch up.

The arrival of LLMs has quietly reversed the direction of that current. The software profession has just been handed a class of components - *stochastic components* - whose behaviour it does not know how to characterise, qualify, or trust. This is territory that older engineering disciplines mapped a century ago. It is time to learn from them.

## The binary worldview

Mainstream software testing rests on a proposition so unexamined it has become invisible: *the thing either works or it doesn't*.

A professional developer writes a unit test. The test pins the behaviour of a function to a specific output for a specific input. Run it - green. Change the function in a way that breaks the behaviour - red. The test does two jobs at once: it verifies that the logic is correct now, and it stands as an alarm bell against any future change that would break it. This is the regression test, and for deterministic code it is one of the great engineering inventions of the late 20th century. [TODO citation: Beck on TDD; Meszaros *xUnit Test Patterns*; or a canonical history of unit testing].

The worldview underneath is simple: a function is a mathematical mapping. The same input produces the same output, forever. Under that assumption, correctness is binary and a single example is enough to pin it. Two runs with identical input yielding different outputs is, by definition, a bug. The profession's disciplines - continuous integration, test-driven development, the whole test-pyramid vocabulary - are all built on that foundation.

Academia reached for correctness by a different route. Formal methods - mathematical specifications that could be discharged by proof - gave the discipline genuine rigour, but at a cost: the notation was itself a specialist language, opaque to the stakeholders whose intent it was meant to capture, and, more importantly for this argument, its proofs declared correctness a binary property of the function. Bertrand Meyer's Eiffel brought a pragmatic slice of that tradition - pre-conditions, post-conditions, invariants - into mainstream programming. [TODO citation: Meyer, *Object-Oriented Software Construction* / *Design by Contract*]. Yet even Design by Contract was silent on the hard question: what to do when a service sometimes satisfies its contract and sometimes does not, and whether the ratio is acceptable.

## What LLMs break

Code that calls an LLM does not live in that world. Ask the same model the same question with the same context twice and you will get two different answers. Raise the temperature (a parameter the developer can turn one way to increase the LLM's imagination, or the other way to do the opposite) and the spread widens. Change the embedding provider, the retrieval index, the tokeniser, or the system prompt and the distribution shifts. Run the same evaluation a week later, after a silent model update, and the ground has moved under your feet. [TODO citation: provider docs on sampling/temperature; an eval-reproducibility paper; HELM or similar].

This is not a defect to be engineered away. Non-determinism is *the mechanism by which these systems work*. Binary pass/fail testing, applied to a probabilistic system, does not fail gracefully - it fails nonsensically. One run passes, the next fails, and the test suite turns into a random-number generator with a stack trace.

The profession's first reflex has been to deny the problem or route around it. Mock the model. Pin the temperature to zero. Assert against a fixed golden string and pretend the determinism was real. Each of these patches a symptom and leaves the underlying category error in place: the system is not deterministic, and testing it *as if* it were substitutes a fiction for the evidence you actually need.

It is worth pausing on why that reflex comes so readily. Software has lived with non-determinism for decades. A network call sometimes fails. A downstream service's latency varies by orders of magnitude. Concurrent processes interleave in ways the test never saw. The profession learned to treat these as *exceptional*: retry, time out, mock the client, pin the clock, isolate the race. In each case the non-determinism sat in the failure or timing channel, and the underlying logic could still be reasoned about as if it were deterministic once those channels had been clamped. LLMs do not permit the same trick. The non-determinism is in the value channel, at the heart of what the system is for - you cannot mock the variance away without mocking out the thing under test. LLMs have not introduced non-determinism to software; they have made it *obtrusive*, and impossible to route around.

I'll go one step further: pretending a non-deterministic system is deterministic is kind of the opposite of engineering - a discipline founded on the idea of creating machines that operate predictably even in the face of uncertainty. This is a disservice to the profession and its an insult to the product's users. 

We can do better. We must.

## What car manufacturers knew

Mechanical engineering never had the luxury of the binary view. A brake pad is not "correct" at 12 mm exactly (what *is* 12mm exactly?!). It is correct *within tolerance* - 12.0 mm ± 0.05 mm, say - because no manufacturing process in history has produced two physically identical artefacts. The question that matters is not "is this part correct?" It is *what fraction of the parts coming off this line fall inside the tolerance band, and with what confidence can we make that claim*?

That is the central move. The unit of analysis is not the part. It is the *population* of parts, and the *process* that produced them.

The statistical apparatus required to answer those questions is not exotic, and it did not begin in the factory. At the Rothamsted Experimental Station in England in the 1920s, Ronald Fisher was working out the design of experiments and the analysis of variance on problems of crop yield and fertiliser trials [TODO citation: Fisher, *Statistical Methods for Research Workers* (1925); *The Design of Experiments* (1935)] - the statistical toolkit that the later industrial tradition, Taguchi's especially, would borrow back. At Bell Labs in those same years, Walter Shewhart gave industry the control chart and the distinction between common-cause and special-cause variation - the idea that a process is *in statistical control* when its output distribution is stable, *even if no individual output is predictable*. [TODO citation: Shewhart, *Economic Control of Quality of Manufactured Product* (1931)]. 

W. Edwards Deming carried that discipline to post-war Japan, where it became the statistical spine of what the world later called the Toyota Production System. [TODO citation: Deming, *Out of the Crisis*; or a history of TPS — Ohno, Liker]. Genichi Taguchi refined the economics, framing every deviation from target as a quantifiable loss to society rather than a step function at the tolerance boundary. [TODO citation: Taguchi loss function; Taguchi & Wu]. Acceptance sampling, codified in MIL-STD-105 and later in ISO 2859-1, gave buyers a way to decide, from a small sample, whether an incoming lot met an agreed quality level at an agreed confidence. [TODO citation: ISO 2859-1].

None of this was invented for cars specifically. All of it is what cars run on today. A modern automotive supply chain is a cathedral of statistical process control, and it has to be, because the alternative - inspecting every part against an ideal - is both uneconomic and epistemically naive.

> *"The long-range contribution of statistics depends not so much upon getting a lot of highly trained statisticians into industry as it does in creating a statistically minded generation of physicists, chemists, engineers and others who will in any way have a hand in developing and directing the production processes of tomorrow."*
>
> - Walter A. Shewhart [TODO citation: *Statistical Method from the Viewpoint of Quality Control*, 1939]

Shewhart's prediction held for nearly every engineering discipline that matured after him. It has not yet held for software. In mainstream software, it is not even on the radar.

## The questions change

The deepest thing the manufacturing tradition offers software is not a technique. It is a change of question.

"Does the test pass?" is a question from the binary world. Applied to an LLM-backed component, it is not even wrong - it is unanswerable, because the answer depends on which run you happened to observe. The useful questions, borrowed intact from the factory floor, are different:

- *What fraction of outputs satisfy the specification?*
- *With what statistical confidence is that fraction estimated?*
- *Is the process producing those outputs in statistical control, or has it drifted?*
- *When an input sits near the boundary of acceptable behaviour, how much of the output distribution falls outside it, and at what cost?*

Each of these has a century of theory and practice behind it. None of them collapse to green or red. All of them require a test to do something a unit test was never designed to do: run the system many times, model the distribution of outputs, and render a statistically informed verdict about whether the *process* - model plus prompt plus retrieval plus guardrails - is fit for the purpose.

This is not a rejection of unit testing. Deterministic code remains deterministic, and a unit test remains the right instrument for it. What is being proposed is an additional instrument, on an additional axis, for a class of component whose non-determinism is written on the tin.

## The discipline software has not yet built

Everything needed for this turn is already in the intellectual commons. Statistical process control is a hundred years old. Acceptance sampling is older than TCP/IP. The mathematics of estimating a proportion from Bernoulli trials, a tolerance interval, or a drift statistic is undergraduate material. The methods are not missing. What is missing is the *engineering mindset and practice* that puts them in the developer's hands the way JUnit put assertions in the minds of Java developers twenty-five years ago.

That practice, if it is to look like the unit-testing revolution did, has to include several things at once. A vocabulary that distinguishes deterministic assertions from probabilistic ones. Frameworks that run a system *n* times, summarise the output distribution, and report pass or fail against a stated confidence level - not against a single observation. CI infrastructure that treats the variance of a probabilistic test as a legitimate signal rather than a nuisance to be muted. And, perhaps hardest, a cultural acceptance that "this component satisfies its specification 96.2% of the time, with a 95% confidence interval of ±0.8%" is a *more honest* engineering statement than "the test is green", not a weaker one.

The honesty will soon stop being optional. LLM-backed systems are already being shipped under regulatory regimes - the EU AI Act the most conspicuous [TODO citation: EU AI Act, esp. Article 15 on accuracy, robustness and cybersecurity for high-risk systems; for the full regulatory map, phased inception dates, and enforcement timeline, see the companion site [javai.ch](https://javai.ch), which tracks these in depth alongside the Swiss-specific regime] - that presume their operators can say something quantitative about reliability. A team that can only report "the tests pass" is not merely under-tooled; in more and more contexts, it is non-compliant. The regulatory vocabulary is converging on statistical claims faster than the engineering practice is producing them.

## The humility required

The uncomfortable part of this turn is that it asks software - a discipline that for two generations has seen itself as the frontier - to apprentice itself, again, to industries it used to consider primitive. The Toyota plant is not a museum. It is a live, instrumented, fifty-year-old demonstration of how to manage a stochastic process to a stated quality level, at scale, for decades on end. [TODO citation: a contemporary TPS or lean manufacturing reference; perhaps Liker *The Toyota Way*]. The software profession has spent those same decades learning to build, without learning to characterise with statistical rigour what it has built. With deterministic systems, there was no need. With seemingly-deterministic systems - network calls, latency, concurrency - it got away. With probabilistic ones, it will not.

The reversal at the top of this piece is therefore not a neat rhetorical flourish. It is the technology transfer the next decade actually requires. Car manufacturers had to learn software to survive the move to software-defined vehicles. Software is now going to have to learn manufacturing statistics to survive the move to probabilistic components. The direction of humility has flipped, and the sooner the profession notices, the less painfully it will adjust.

If the 20th century's great quality insight was Deming's - *that quality is a system output, owned by management* - the 21st century's, for software, may be the one Shewhart implied and Taguchi made explicit: *that correctness, for the systems we are now building, is a statistical claim, or it is nothing at all*. [TODO citation: Shewhart's implicit statement runs through *Economic Control of Quality of Manufactured Product* (1931) and is sharpest in *Statistical Method from the Viewpoint of Quality Control* (1939) — a process is meaningfully "correct" only when its output distribution is characterised and in control. Taguchi made the claim explicit via the loss function, which quantifies deviation from target as continuous loss rather than a pass/fail step — see Taguchi & Wu, *Off-Line Quality Control* (1979) and Taguchi, *Introduction to Quality Engineering* (1986).]

Nobody is coming to invent this discipline for software. The mathematics is already written. The industrial case studies are already in the textbooks. The regulators are already asking the questions. What remains is for the profession to do what every mature engineering discipline before it has done: accept that the output of a real process is a distribution, and learn - from the people who have been doing it all along - how to reason about one.


## The practical work

The essay above argues for a discipline; the discipline requires tools. javai.org is building open-source probabilistic testing frameworks for mainstream languages - starting with Java and Rust, with Python and others to follow - as practical on-ramps into the statistical tradition described above. The effort is deliberately broad and welcomes contribution from quality experts, statisticians, developers, and sponsors who read this and see the same gap. Projects, documentation, and contact routes are at [javai.org](https://javai.org).


## Sources

| Source                                                                                                | Relevance                                                                                                                                 |
|-------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| [TODO: McKinsey / BCG on software-defined vehicles]                                                   | The scale of software inside modern cars; why carmakers had to become software companies.                                                 |
| [TODO: Beck on TDD / Meszaros *xUnit Test Patterns*]                                                  | The canonical formulation of unit testing as deterministic pass/fail with regression-alarm function.                                      |
| [TODO: LLM provider docs on sampling/temperature; reproducibility paper such as HELM]                 | Evidence that LLM output is non-deterministic by design.                                                                                  |
| [TODO: Fisher, *Statistical Methods for Research Workers* (1925); *The Design of Experiments* (1935)] | Agricultural origins of the modern applied-statistics toolkit (ANOVA, design of experiments) that the industrial tradition later drew on. |
| [TODO: Shewhart, *Economic Control of Quality of Manufactured Product* (1931)]                        | Origin of statistical process control and the common-cause / special-cause distinction.                                                   |
| [TODO: Shewhart, *Statistical Method from the Viewpoint of Quality Control* (1939)]                   | Source of the quoted passage.                                                                                                             |
| [TODO: Deming, *Out of the Crisis*; history of the Toyota Production System — Ohno, Liker]            | The transmission of statistical quality discipline from Bell Labs to post-war Japan to modern manufacturing.                              |
| [TODO: Taguchi loss function; Taguchi & Wu]                                                           | The economic reframing of tolerance as continuous loss rather than step-function pass/fail.                                               |
| [TODO: ISO 2859-1 / MIL-STD-105]                                                                      | Formal acceptance sampling: deciding a population's quality from a sample, at stated confidence.                                          |
| [TODO: EU AI Act, Article 15]                                                                         | Regulatory requirement for quantitative accuracy and robustness claims for high-risk AI systems.                                          |
| [javai.ch](https://javai.ch)                                                                          | Companion site tracking AI-regulation sources, phased inception dates, and enforcement timelines — in particular the EU AI Act and the Swiss-specific regime. Canonical pointer for readers who want the current regulatory map. |
