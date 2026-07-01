---
title: "Clean Code Was Never More Important"
subtitle: "When code was slower to produce, architectural mistakes accumulated at human speed. Now they can accumulate at machine-assisted speed."
date: 2026-07-01
description: "AI does not merely produce more code - it produces more plausible code. A weak codebase generated with AI can look professional while remaining structurally incoherent, which is exactly why architectural judgement matters more now than ever."
author: michael
summary: "AI amplifies the judgement already present in an organisation; it does not supply the judgement that is missing. Clean code is not prettiness - it is the structure that lets a competent human understand the problem. In the AI era, it is the steering wheel."
---

<figure class="title-composite title-composite--duo">
  <div class="title-composite-pair">
    <img src="/images/moog-modules.jpg" alt="Three coupled Moog synthesizer modules: 921 oscillator, 911 envelope generator, 902 amplifier">
    <img src="/images/robert-c-martin.jpg" alt="Robert C. Martin (Uncle Bob)">
  </div>
  <figcaption class="title-composite-caption">
    <span>Iconic modular design: Moog synthesizer modules</span>
    <span>Robert C. Martin (&ldquo;Uncle Bob&rdquo;)</span>
  </figcaption>
  <p class="title-composite-credit">
    Moog modules photograph: <a href="https://commons.wikimedia.org/wiki/File:Moog_921,_911,_902_modules.jpg">Gordon Joly</a>, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC BY-SA 2.0</a> (cropped).<br>
    Martin photograph: <a href="https://en.wikipedia.org/wiki/Robert_C._Martin">Wikipedia</a>.
  </p>
</figure>

A LinkedIn post recently described "the coming AI slop refactor wave". The poster was imagining the moment when organisations discover that the code they generated quickly, cheaply, and enthusiastically with AI now has to be made to work as a coherent system.

The observation resonated because the pattern is not new. Around 2010, many organisations learned that cheap offshore software was not cheap once the hidden cost of making it maintainable arrived. Before that, startups learned the same lesson with throwaway prototypes that accidentally became production systems. The industry keeps rediscovering the same law: typing can be accelerated, but judgement cannot be skipped.

AI changes the scale of the problem. It does not merely produce more code. It produces more plausible code. That plausibility is precisely what makes the danger harder to see.

A weak codebase written by an inexperienced human typically looks weak (to an expert at least). It has obvious smells: poor naming, duplication, deep nesting, abstraction-level mixing, inappropriate dependencies, comments that apologise for the code, tests that barely test anything. A weak codebase generated with AI may look much better. It may have tidy classes, reasonable names, dependency injection, controllers, services, repositories, DTOs, exhaustive tests, comments, and a shape that resembles the software architecture diagrams in books.

And yet the system may still be wrong.

The abstractions may be decorative rather than useful. The domain language may be absent or misleading. The tests may assert incidental behaviour while leaving the real business invariants unprotected. The database migrations may exist but fail to reflect an intentional model of change. Logging may be abundant but useless. Boundaries may follow framework fashion rather than business meaning. Every file may look acceptable, while the system as a whole fails to cohere.

*This is why clean code has probably never mattered more.*

Not because AI threatens software engineering. It does not. Used well, AI is an extraordinary accelerator. A strong engineer with a capable model can now explore designs, generate scaffolding, write tests, interrogate unfamiliar APIs, and collapse days of mechanical work into minutes. For people with taste, discipline, and architectural judgement, this is a veritable new superpower.

But that is exactly the point. AI amplifies the judgement already present in the organisation. It does not supply the judgement that is missing.

## Clean code is not prettiness

One of the reasons this subject is so easily trivialised is that "clean code" is often mistaken for aesthetic preference.

To some people it means nice formatting. To others it means short methods, good variable names, low cyclomatic complexity, or a pleasing absence of obvious mess. These things matter. They are useful signals. But they are not the substance of the matter.

Clean code is not merely code that looks tidy. Clean code is code in which the structure of the program helps a competent human understand the structure of the problem.

It expresses the domain clearly. It localises change. It keeps abstraction levels distinct. It avoids unnecessary coupling. It gives important concepts expressive names. It makes illegal states difficult to represent. It places behaviour where it belongs. It allows the next engineer to reason about consequences without loading the entire system into their head.

Clean architecture extends the same principle beyond the file and the class. It is not a diagram with boxes labelled "controller", "service", "repository", and "database". It is the deliberate organisation of boundaries, dependencies, policies, data flow, and invariants so that the system remains understandable under pressure.

The distinction matters because AI is increasingly good at imitating the surface signs of clean code. It can produce files that look professional. It can mimic framework conventions. It can generate plausible abstractions. It can add comments that sound helpful. It can produce tests that look like tests.

But it cannot reliably know whether the abstraction is the right one for your organisation, your domain, your future changes, your regulatory constraints, your team's cognitive capacity, or your operational reality.

That has to come from somewhere else.

## The missing steering mechanism

It is tempting to say that organisations treated clean code as optional. But that frames it as a choice, and in my experience it rarely is. The deeper and more common problem is simpler and less comfortable: the working knowledge of what "clean code" actually means in practice is not to hand. Most teams cannot consistently recognise it, let alone produce it on demand.

Where that knowledge is missing, the consequences are not a matter of luck. The quality of the code is poor, and because it is poor the technical debt is high. Guaranteed. No amount of wanting clean code substitutes for knowing, concretely, what it looks like in this codebase, this domain, this change.

The business wanted features. The product organisation wanted dates. Management wanted velocity. Technical debt was acknowledged in principle and deferred in practice. Architecture was whatever survived the last urgent delivery cycle. But underneath all of that sat the missing skill.

This was always expensive. **But AI makes it dangerous** in a new way because it removes one of the natural brakes on software decay: the speed at which humans can type and assemble code.

When code was slower to produce, architectural mistakes accumulated at human speed. Now they can accumulate at machine-assisted speed.

This does not mean the code is worse in every local respect. In fact, that is the trap. The generated endpoint may be better than what many teams would have written by hand. The migration may be adequate. The class structure may look sensible. The pull request may contain tests. The demo may work.

But software systems do not fail only because individual files are badly written. They fail because the concepts do not fit together. They fail because coupling accumulates quietly. They fail because responsibilities are blurred. They fail because no one can say what the system is supposed to mean. They fail because every change requires an archaeological expedition.

A codebase can look clean in the small and still be rotten in the large.

That is the coming refactor wave: not exactly a mass of ugly AI-generated code, but a mass of plausible, locally acceptable, structurally incoherent code that organisations ship before anyone with architectural judgement had a chance to weigh in.

## Who catches the wrongness

In the AI era, "senior developer" cannot be allowed to mean "person who has been around long enough to approve the pull request." It has to mean something stronger. A senior engineer must be able to look at plausible code and ask: what concept is this really expressing? Which dependency direction is being introduced here? What invariant is unprotected? Is this abstraction buying optionality, or merely adding ceremony? Does this test protect behaviour, or only freeze implementation detail?

AI-generated code needs exactly this kind of review, because its failure mode is rarely "obviously stupid" — it is "reasonable enough". The model suggests the median solution, the one thousands of public repositories taught it was statistically plausible. But the statistically plausible answer is not necessarily the excellent answer, the appropriate answer, or even the safe answer.

That demands a kind of senior many organisations do not have, and cannot reliably identify. I have argued the full case in [Deming, Challenger, and the Watershed Moment of AI](/signals/2026-04-19-deming-challenger-and-the-ai-watershed/), but three conclusions bear repeating here, because they are what clean code now depends on:

- **AI amplifies the quality culture that already exists; it does not create one.** A disciplined team uses it to ship better systems faster. A team without that discipline industrialises its weaknesses behind a veneer of professional-looking output — and enjoys a seductive honeymoon before velocity collapses.
- **"Senior" is too often a payroll category, not a skill tier.** The curator of a decaying codebase knows where the bodies are buried; that is genuine expertise, but it is not the expertise of an architect. Give that person sign-off authority over AI-assisted work and they will approve code because it compiles, passes tests, and looks more polished than what they themselves can produce.
- **Quality is a system output, not a people problem.** Following Deming: the engineers an organisation has are the ones its hiring, promotion, incentive, and review systems produced. Exhortations to "do better" change nothing. The lever sits with upper management, who need not write code but do need a diagnostic literacy — enough to tell quality from its imitation, and the strength of character to fund foundations whose payoff comes years later.

The stakes are a missed opportunity, not merely bad code. AI could help excellent teams move faster without becoming reckless, help juniors learn, and make exploratory design cheaper — but only where there is human judgement to apply. Without it, the acceleration turns into a maintenance tax. The edge cases arrive, the "simple" change touches twelve modules, every fix creates two more defects. At that point the consultants arrive, and the "AI slop refactor wave" begins.

Upper management: this is now your call.

---

The judgement AI cannot supply is neither mysterious nor new. It has been written down for decades, and the canon repays reading now more than ever — not as a model can recite it, but as a practitioner has internalised it:

- [Robert C. Martin](https://en.wikipedia.org/wiki/Robert_C._Martin), *Clean Code* (2008) and *Clean Architecture* (2017) — what a code smell is, and why dependency direction and boundaries are the substance, not the diagram.
- Gamma, Helm, Johnson & Vlissides, [*Design Patterns*](https://en.wikipedia.org/wiki/Design_Patterns) (1994) — the shared vocabulary that lets you recognise and talk about code structures - even with an LLM.
- Eric Evans, [*Domain-Driven Design*](https://en.wikipedia.org/wiki/Domain-driven_design) (2003) — making the domain speak through the code, so that an abstraction earns its place instead of decorating one.
- Michael Feathers, [*Working Effectively with Legacy Code*](https://www.informit.com/store/working-effectively-with-legacy-code-9780131177055) (2004) — how to tame a system you have inherited and did not design; the survival kit for the refactor wave.
- Frederick P. Brooks, [*The Mythical Man-Month*](https://en.wikipedia.org/wiki/The_Mythical_Man-Month) (1975) — conceptual integrity: why a system can be clean in every part and incoherent as a whole.
- David Parnas, [*On the Criteria To Be Used in Decomposing Systems into Modules*](https://dl.acm.org/doi/10.1145/361598.361623) (1972) — the original case for information hiding, and still the clearest one.

None of it requires abandoning AI. All of it is what lets you direct AI toward something worth keeping.

Clean code was never a luxury.
