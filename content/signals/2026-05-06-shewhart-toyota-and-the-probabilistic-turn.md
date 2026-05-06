---
title: "Shewhart, Toyota, and the Probabilistic Turn"
date: 2026-05-06
description: "Why probabilistic software demands the statistical discipline that car manufacturers absorbed a century ago - and what we still have to learn from them."
author: michael
linkedinPost: "https://www.linkedin.com/pulse/shewhart-toyota-probabilistic-tur-mike-mannion-wq2re"
summary: "LLMs break software's binary view of correctness. The discipline that replaces it already exists - it was built at Bell Labs, refined in Nagoya, and has been waiting for software to need it."
---

<figure class="title-composite">
  <img src="/images/shewhart-ai-composite.png" alt="Walter A. Shewhart">
  <figcaption class="title-composite-caption">
    <span>Walter A. Shewhart</span>
    <span>Shewhart's famous control chart</span>
  </figcaption>
  <p class="title-composite-credit">
    Shewhart photograph: <a href="https://en.wikipedia.org/wiki/Walter_A._Shewhart#/media/File:WAShewhart.jpg">Wikipedia</a> (public domain).
  </p>
</figure>

## The reversal

For thirty years, software was something a car company *adopted*. Detroit, Wolfsburg, Toyota City, and Seoul had to learn continuous integration, agile teams, over-the-air updates, the conventions of microservices, and the economics of keeping a platform team on staff. A modern car is a [software-defined product](https://www.mckinsey.com/features/mckinsey-center-for-future-mobility/focus-areas/software-defined-vehicles-and-e-e-architecture) with a chassis attached: tens of millions of lines of code, dozens of electronic control units, and a release cadence that looks more like a SaaS roadmap than a model year. The discipline of software development is now as core to a car manufacturer as the discipline of drivetrain design.

For most of that period, the technology transfer ran one way. Software houses thought they had nothing to learn from the assembly line. They were the future; the industrialists were trying to catch up.

The arrival of LLMs has quietly reversed the direction of that current. The software profession has just been handed a class of components - *stochastic components* - whose behaviour it does not know how to characterise, qualify, or trust. This is territory that older engineering disciplines mapped a century ago. It is time to learn from them.

## The binary worldview

Mainstream software testing rests on a proposition so unexamined it has become invisible: *the thing either works or it doesn't*.

A professional developer writes a unit test. The test pins the behaviour of a function to a specific output for a specific input. Run it - green. Change the function in a way that breaks the behaviour - red. The test does two jobs at once: it verifies that the logic is correct now, and it stands as an alarm bell against any future change that would break it. This is the regression test, and for deterministic code it is one of the [great engineering inventions](https://archive.org/details/est-driven-development-by-example) of the late 20th century.

The worldview underneath is simple: a function is a mathematical mapping. The same input produces the same output. Forever. Under that assumption, correctness is binary and a single example is enough to pin it. Two runs with identical input yielding different outputs is, by definition, a bug. The profession's disciplines - continuous integration, test-driven development, the whole test-pyramid vocabulary - are all built on that foundation.

Academia reached for correctness by a different route. Formal methods - mathematical specifications that could be proven by mathematical argument - gave the discipline genuine rigour, but at a cost: the notation was itself a specialist language, unreadable to the stakeholders whose intent it was meant to capture, and, more importantly for this argument, its proofs declared correctness a binary property of the function.

[Bertrand Meyer's Eiffel](https://en.wikipedia.org/wiki/Object-Oriented_Software_Construction) brought a pragmatic slice of that tradition - pre-conditions, post-conditions, invariants - into mainstream object-oriented programming. Yet even his groundbreaking Design by Contract concept was silent on the hard question: what to do when a service sometimes satisfies its contract and sometimes does not, and whether the ratio is acceptable.

## What LLMs break

Code that calls an LLM does not live in that world. Ask the same model the same question with the same context twice and you will get two different answers. Raise the [temperature](https://platform.openai.com/docs/api-reference/chat/create) (a parameter the developer can turn one way to influence the LLM's "imagination") and the spread widens. Change the embedding provider, the retrieval index, the tokeniser, or the system prompt and the distribution shifts. Run the same [evaluation](https://crfm.stanford.edu/helm/) a week later, after a silent model update, and the ground has moved under your feet.

This is not a defect to be engineered away. Non-determinism is intrinsic to the mechanism. Binary pass/fail testing, applied to a probabilistic system, is like picking a ball out of a bag. It's green. What does that tell you? One run passes, the next fails, and the test suite turns into a coin toss.

The profession's first reflex has been to deny the problem or route around it. Mock the model. Pin the temperature to zero. Assert against a fixed golden string and pretend the determinism was real. Each of these patches a symptom and leaves the underlying mistake in place: the system is not deterministic, and testing it *as if* it were substitutes a fiction for the evidence you actually need.

It is worth pausing on why that reflex comes so readily. Software has lived with non-determinism for decades. A network call sometimes fails. A downstream service's latency varies by orders of magnitude. Concurrent processes interleave in ways the test never saw. The profession learned to treat these as *exceptional*: retry, time out, mock the client, pin the clock, isolate the race. In each case the non-determinism sat in the failure or timing channel, and the underlying logic could still be reasoned about as if it were deterministic once those channels had been clamped.

LLMs do not permit the same trick. The non-determinism is in the value channel, at the heart of what the system is for - you cannot mock the variance away without mocking out the thing under test. LLMs have not introduced non-determinism to software; they have made it *obtrusive*, and impossible to route around.

I'll go one step further: pretending a non-deterministic system is deterministic is kind of the opposite of engineering — a discipline founded on recognising that machines operate within tolerances, with no pretence of perfectly predictable behaviour.

## What car manufacturers knew

Mechanical engineering never had the luxury of the binary view. A brake pad is not "correct" at 12 mm exactly (what *is* 12mm exactly?) It is correct *within tolerance* - 12.0 mm ± 0.05 mm, say - because no manufacturing process in history has produced two physically identical artefacts. The question that matters is not "is this part correct?" It is *what fraction of the parts coming off this line fall inside the tolerance band, and with what confidence can we make that claim*?

That is the central move. The unit of analysis is not the part. It is the *population* of parts, and the *process* that produced them.

The statistical apparatus required to answer those questions is not exotic, and it did not begin in the factory. At the Rothamsted Experimental Station in England in the 1920s and 1930s, Ronald Fisher was working out the [design of experiments](https://en.wikipedia.org/wiki/The_Design_of_Experiments) and the [analysis of variance](https://en.wikipedia.org/wiki/Statistical_Methods_for_Research_Workers) on problems of crop yield and fertiliser trials - the statistical toolkit that the later industrial tradition, Taguchi's especially, would borrow back. At Bell Labs in those same years, [Walter A. Shewhart](https://archive.org/details/in.ernet.dli.2015.150272) gave industry the control chart and the distinction between common-cause and special-cause variation - the idea that a process is *in statistical control* when its output distribution is stable, *even if no individual output is predictable*. 

[W. Edwards Deming](https://mitpress.mit.edu/9780262541152/out-of-the-crisis/) carried that discipline to post-war Japan, where it became a key part of what the world later called the [Toyota Production System](https://en.wikipedia.org/wiki/The_Toyota_Way). Genichi Taguchi refined the economics, framing every deviation from target as a [quantifiable loss to society](https://en.wikipedia.org/wiki/Taguchi_loss_function) rather than a step function at the tolerance boundary. Acceptance sampling, codified in MIL-STD-105 and later in [ISO 2859-1](https://www.iso.org/standard/85464.html), gave buyers a way to decide, from a small sample, whether an incoming lot met an agreed quality level at an agreed confidence.

None of this was invented for cars specifically. All of it is what cars run on today. A modern automotive supply chain is a cathedral of statistical process control, and it has to be, because the alternative - inspecting every part against an ideal - is both uneconomic and naive about what can actually be known.

> *"The long-range contribution of statistics depends not so much upon getting … statisticians into industry as it does in creating a statistically minded generation of physicists, chemists, engineers and others … directing the production processes of tomorrow."*
>
> - Walter A. Shewhart, [*Statistical Method from the Viewpoint of Quality Control*](https://archive.org/details/CAT10502416) (1939)

Shewhart's prediction held for nearly every engineering discipline that matured after him. It has not yet held for software. For most developers, it isn't on the radar.

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

That practice, if it is to look like the unit-testing revolution did, has to include several things at once. A vocabulary that distinguishes deterministic assertions from probabilistic ones. Frameworks that run a system *n* times, summarise the output distribution, and report pass or fail against a stated confidence level - not against a single observation. CI infrastructure that treats the variance of a probabilistic test as a legitimate signal rather than a nuisance to be muted. And, perhaps hardest, a cultural acceptance that "this component satisfies its specification 96.2% of the time, with a 95% confidence interval" is a *more honest* engineering statement than "the test is green", not a weaker one.

The honesty will soon stop being optional. LLM-backed systems are already being shipped under regulatory regimes - the [EU AI Act](https://artificialintelligenceact.eu/article/15/) the most conspicuous, with the full regulatory map tracked at [javai.ch](https://javai.ch) - that presume their operators can say something quantitative about reliability. A team that can only report "the tests pass" is not merely under-tooled; in high-risk AI contexts, it may be unable to demonstrate the quantified accuracy, robustness, lifecycle consistency, and monitoring evidence that regulators increasingly expect. The regulatory vocabulary is converging on statistical claims faster than the engineering practice is producing them.

## The humility required

The uncomfortable part of this turn is that it asks software - a discipline that for two generations has seen itself as the frontier - to apprentice itself, again, to industries it used to consider primitive. The [Toyota plant](https://en.wikipedia.org/wiki/The_Toyota_Way) is not a museum. It is a live, instrumented, fifty-year-old demonstration of how to manage a stochastic process to a stated quality level, at scale, for decades on end.

The software profession has spent those same decades learning to build, without learning to characterise with statistical rigour what it has built.

The reversal at the top of this piece is the technology transfer the next decade actually requires. Car manufacturers had to learn software to survive the move to software-defined vehicles. Software is now going to have to learn manufacturing statistics to survive the move to probabilistic components. The direction of humility has flipped, and the sooner the profession notices, the less painfully it will adjust.

If the 20th century's great quality insight was Deming's - *that quality is a system output, owned by management* - the 21st century's, for software, may be the one [Shewhart implied](https://archive.org/details/CAT10502416) and [Taguchi made explicit](https://en.wikipedia.org/wiki/Taguchi_loss_function): *that correctness, for the systems we are now building, is a statistical claim, or it is nothing at all*.

Nobody is coming to invent this discipline for software. The mathematics, the case studies, and the regulatory questions are already there. What remains is for the profession to do what every mature engineering discipline before it has done: accept that the output of a real process is a distribution, and learn - from the people who have been doing it all along - how to reason about one.

Software has long called itself engineering. The word means something. A profession unwilling to live up to it should stop using it.


## The practical work

The essay above argues for a discipline; the discipline requires tools. javai.org is building open-source probabilistic testing frameworks for mainstream languages - starting with Java and Rust, with Python and others to follow - as practical on-ramps into the statistical tradition described above. The effort is deliberately broad and welcomes contribution from quality experts, statisticians, developers, and sponsors who read this and see the same gap. Projects, documentation, and contact routes are at [javai.org](https://javai.org).


## Sources

| Source                                                                                                                                                                                                     | Relevance                                                                                                                                                                |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [McKinsey Center for Future Mobility — Software-Defined Vehicles](https://www.mckinsey.com/features/mckinsey-center-for-future-mobility/focus-areas/software-defined-vehicles-and-e-e-architecture)        | The scale of software inside modern cars; why carmakers had to become software companies.                                                                                |
| [Kent Beck, *Test-Driven Development: By Example* (2002)](https://archive.org/details/est-driven-development-by-example)                                                                                   | The canonical formulation of unit testing as deterministic pass/fail with regression-alarm function.                                                                     |
| [Bertrand Meyer, *Object-Oriented Software Construction*](https://en.wikipedia.org/wiki/Object-Oriented_Software_Construction)                                                                             | Design by Contract — pre-conditions, post-conditions, invariants — as the closest mainstream OO got to formal specification.                                             |
| [OpenAI API reference: temperature & sampling](https://platform.openai.com/docs/api-reference/chat/create)                                                                                                 | Provider documentation showing that LLM output is sampled, not deterministic.                                                                                            |
| [Stanford HELM (Holistic Evaluation of Language Models)](https://crfm.stanford.edu/helm/)                                                                                                                  | Living benchmark documenting reproducibility across LLM evaluations.                                                                                                     |
| [R. A. Fisher, *Statistical Methods for Research Workers* (1925)](https://en.wikipedia.org/wiki/Statistical_Methods_for_Research_Workers)                                                                  | The applied-statistics toolkit (significance testing, ANOVA) that later industrial work drew on.                                                                         |
| [R. A. Fisher, *The Design of Experiments* (1935)](https://en.wikipedia.org/wiki/The_Design_of_Experiments)                                                                                                | The foundational work on experimental design that the Taguchi tradition later extended.                                                                                  |
| [Walter A. Shewhart, *Economic Control of Quality of Manufactured Product* (1931)](https://archive.org/details/in.ernet.dli.2015.150272)                                                                   | Origin of statistical process control and the common-cause / special-cause distinction.                                                                                  |
| [Walter A. Shewhart, *Statistical Method from the Viewpoint of Quality Control* (1939)](https://archive.org/details/CAT10502416)                                                                           | Source of the quoted passage on creating a statistically minded engineering generation.                                                                                  |
| [W. Edwards Deming, *Out of the Crisis* (MIT Press)](https://mitpress.mit.edu/9780262541152/out-of-the-crisis/)                                                                                            | The transmission of statistical quality discipline from Bell Labs to post-war Japan.                                                                                     |
| [Toyota Motor Corporation — Total Quality Management history](https://www.toyota-global.com/company/history_of_toyota/75years/data/company_information/management_and_finances/management/tqm/change.html) | Toyota's corporate account of statistical quality control adoption (1949), the Deming Application Prize (1965), and the evolution of Total Quality Management at Toyota. |
| [Taguchi loss function](https://en.wikipedia.org/wiki/Taguchi_loss_function)                                                                                                                               | The economic reframing of tolerance as continuous loss rather than step-function pass/fail.                                                                              |
| [ISO 2859-1: Sampling procedures for inspection by attributes](https://www.iso.org/standard/85464.html)                                                                                                    | Formal acceptance sampling: deciding a population's quality from a sample, at stated confidence.                                                                         |
| [EU AI Act, Article 15: Accuracy, Robustness and Cybersecurity](https://artificialintelligenceact.eu/article/15/)                                                                                          | Regulatory requirement for quantitative accuracy and robustness claims for high-risk AI systems.                                                                         |
| [javai.ch](https://javai.ch)                                                                                                                                                                               | Companion site tracking AI-regulation sources, phased inception dates, and enforcement timelines — in particular the EU AI Act and the Swiss-specific regime.            |
