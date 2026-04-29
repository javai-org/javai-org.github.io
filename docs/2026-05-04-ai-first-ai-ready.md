---
title: "AI-First Is Not AI-Ready"
date: 2026-05-04
description: "Blind spots in AI-first venture diligence."
author: michael
linkedinPost: ""
summary: "An essay on why AI-first companies are not necessarily AI-ready - and on the new forms of risk that venture diligence has not yet learned to price."
---

<figure class="title-composite">
  <img src="/images/ai-first-ai-ready.png"
       alt="Cartoon of two shrink-wrapped products side by side on a retail shelf. The left, battered and bulging, is taped with handwritten labels: 'AI-ready (may require some work)', 'cognitive debt', 'undocumented agentic flows', 'unquantified stochastic behaviour' — price tag $500k. The right, neat and crisply wrapped, carries an 'AI-READY · CERTIFIED' banner and printed labels: 'TRANSFERABLE', 'RISK-QUANTIFIED', 'STATISTICALLY VALIDATED' — price tag $10M.">
  <figcaption class="title-composite-caption">
    <span>The product is not the product; the <em>company</em> is the product.</span>
  </figcaption>
  <p class="title-composite-credit">Graphic: © Michael Mannion, 2026.</p>
</figure>

> AI can compress the distance between idea and product, making young companies look more mature than they are. For investors, the danger is not merely overpaying for hype. It is failing to price new forms of risk: stochastic product behaviour, cognitive debt, key-person dependency, and inference-cost fragility. The dot-com boom mistook clicks for business quality. The AI-first boom risks mistaking demos and technical prowess for investable enterprise value. AI velocity is not company maturity. The AI opportunity is real, but "AI-first" does not equate to "AI-ready".

## The new eyeballs: from clicks to demos

During the dot-com boom, many investors treated "[eyeballs](https://www.washingtonpost.com/archive/business/1999/11/14/valuing-dot-coms-counting-eyeballs-isnt-enough/e890f185-c13d-473e-a850-82f56c8a793c/)" — clicks, traffic, time-on-site — as substitutes for harder evidence of business quality. Companies that priced like utilities sometimes had the cash flow of student newspapers. When the correction came, it did not invalidate the internet. The internet was real. Twenty-five years later, the largest companies in the world are internet companies. What collapsed in 2000–2002 was not the technology. It was the market's pricing indiscipline. Eventually, valuations adjusted to cash-flow realities, and [a sounder framework](https://www.mckinsey.com/capabilities/strategy-and-corporate-finance/our-insights/valuing-dot-coms-after-the-fall) for valuing internet companies developed gradually in the decades that followed.

The lesson, then, is not that the dot-com boom proved the internet was worthless. It is that real technological revolutions can still produce irrational valuations when investors don't yet know how to price a genuinely novel asset class. Ground-breaking technology is mispriced not because the technology is fake, but because the diligence framework lags behind the technology curve. Investors keep using the metrics that worked for the previous era — and reach for the closest available proxy when the new metrics are not yet established.

The current AI boom is a similar moment. The technology is real. Large language models, agentic systems, retrieval-augmented architectures — these are genuine capabilities, not vapour. But the same kind of substitution is happening on the diligence side. Demos are standing in for evidence of durability. AI-assisted development speed is standing in for evidence of engineering maturity. Visionary founder claims are standing in for evidence of an investable enterprise — though this last one is hardly new. The AI-first boom may not be mispricing fake technology. It is certainly mispricing fragile companies built on real technology.

## The opportunity is real

Nothing I write here should be read as a claim that AI is a bubble in the dismissive sense. AI genuinely changes software production, knowledge work, automation, customer operations, analytics, research, and product development. A capable technical founder using modern agentic tools can now build at extraordinary speed. The seductive belief that animates a great deal of current optimism — that one exceptional technical founder with agentic AI tools may equal a team of twenty developers — has truth in it. AI, in the right hands, does massively amplify individual productivity. Enterprise spending tells the same story at scale: generative-AI spend was [estimated at $37 billion in 2025](https://menlovc.com/perspective/2025-the-state-of-generative-ai-in-the-enterprise/), up from $11.5 billion the year before, with about half of that going to user-facing AI applications.

But productivity amplification is different from institutional capability. A single engineer can ship a working product in weeks; a single engineer cannot, in those same weeks, become an organisation. The leverage that AI provides at the level of code does not extend automatically to documentation, evaluation, transferability, or governance. The more powerful the leverage, the more serious the management discipline required to convert it into durable enterprise value.

## A working product is not an investable company

AI compresses the time between idea and product. That can make a company look more mature than it really is. The shape this essay will keep returning to is a familiar one: two founders — one carrying the idea, the network, and the sales charisma, the other having built the product largely with agentic tools. The product is real. The demo is impressive. There are early enterprise customers, a story about AI-first efficiency, and a claim that one engineer can do the work of twenty. None of that proves the company is an investable enterprise.

The missing evidence is rarely visible to the casual diligence eye. On the technical side it is the absence of documentation, technical transferability, regression tests, probabilistic tests (more on this in a moment), security review, production runbooks, and credible second-line technical capability. The conventional non-technical absences — a clean balance sheet and the rest of the standard diligence checklist — matter too, but those failures are already familiar territory and well surfaced by existing practice. The technical absences are the ones that mainstream diligence is least equipped to find. Each of these absences is, individually, fixable. Cumulatively, they constitute the difference between a working product and an investable company. AI can accelerate the creation of a product before it accelerates the creation of a company.

## Software engineering itself is still catching up

To understand why AI-first companies tend to underinvest in evaluation evidence, it helps to remember what mainstream software engineering was built around. The assumption of determinism: once you can assert that a given input produces the desired output, ship. The familiar suite of testing techniques — unit tests, integration tests, regression tests, contract tests — rests on the assumption that, for fixed input, the feature produces a fixed output; any deviation is a defect to be fixed.

LLM-based and agentic systems disturb this model. They are stochastic and distributional in behaviour. The same input does not produce the same output; the same output does not necessarily mean the same underlying behaviour; and a small change to a prompt, a model version, or a retrieval corpus can shift the entire output distribution in ways that a deterministic test suite is structurally unable to detect.

It may appear obvious to some readers that probabilistic systems need statistical testing, but it is not yet engineering lore. The technical founder may not be negligent for missing this. Many capable engineers have never been trained to evaluate software behaviour through statistical concepts such as representative sampling, pass-rate estimates, confidence intervals. Some may even reject probabilistic testing precisely because it does not yet look like ordinary software-engineering orthodoxy.

The absence of mainstream practice, however, does not mean the absence of risk. AI systems increasingly interact with customers autonomously — generating responses, making decisions, taking actions on customers' behalf. The guardrails around that autonomy must be reliable to a measured, auditable degree of confidence; without that measurement, the company's exposure to harm is, by definition, unquantified.

The conceptual tools are not absent. The statistical ideas — representative sampling, confidence intervals, pass-rate estimation, regression over distributions — are well understood, and open-source frameworks for applying them to software exist: punit for Java, feotest for Rust, among others at [javai.org](https://javai.org). But they remain niche rather than standard practice. Software engineering is still learning how to test systems that do not behave like software used to behave.

## Unquantified risk is unpriceable risk

What software engineering is still learning, investors must learn too — and faster, because capital is being deployed now. Traditional SaaS diligence never had to ask about a product's behaviour at the level of individual outputs; what mattered for valuation lived above that level — unit economics, retention, pipeline, contract quality.

LLM-based and agentic products do not displace those questions; they add a new one at the layer below. Such a product does not produce one answer; it produces a range of answers. Some are accurate. Some are inaccurate. Some are flat-out wrong. And some are materially damaging to the customer who acted on them or whose data was erroneously changed. Through that customer, harm reaches the company: its reputation, retention, and position with regulators. This is the exposure the investor inherits, and it cannot be priced unless the range of answers itself is measured.

"Does it work?" is still the right investor question for the deterministic parts of the product — login, billing, deployment, the rest of the standard SaaS surface. For the agentic and LLM-based features, it is necessary but no longer sufficient. Three further questions sit alongside it: Have this product's agentic features and guardrails been tested appropriately — that is, probabilistically? And what confidence level has been achieved for those features and guardrails?

The investor's concern is twofold: what is known about the product's risk, and how much trust the answer deserves. "95% of test cases pass" derived from a small, narrowly chosen test set is not the same risk picture as the same figure derived from a large, representative one — the first leaves wide uncertainty about how the product really behaves; the second narrows it. The headline number is rarely the answer. What gives it meaning is the discipline behind it: what was tested, against what definition of acceptable, and on what scale.

"Acceptable" here is broader than accuracy alone. An answer can be technically correct and still take ten times too long, or cost the company more than the customer paid for the feature through excessive token burn. 

A serious AI-first company should therefore be able to show, as artefacts, what was tested, the estimated rate of acceptable behaviour *with confidence bounds*, how that estimate shifts across model and prompt changes, and how it actually performs in front of real customers. The absence of these artefacts is not just a documentation gap. It is unquantified risk — risk the company cannot describe and the investor cannot price. 

This is one novel category of risk that AI-first companies bring with them: risk that lives in the behaviour of the product itself, and that can be measured, bounded, and priced — but only with the kind of statistically grounded evidence that mainstream practice has not yet absorbed. Where that evidence exists, the risk becomes priceable. Where it does not, the risk does not disappear; it waits.

## Cognitive debt: the invisible balance-sheet item

Alongside the risk that lives in the product's behaviour, AI-first companies bundle a second novel risk into the product itself. It is harder to quantify than the first, and one a company is unlikely to want to measure even when it could, because the answer is rarely flattering. This is "cognitive debt".

In a pre-agentic startup, this debt took a single familiar shape: critical knowledge in one person's head, not yet committed to organisational memory. The bus factor was a question about people. 

AI-first companies have introduced a second, more troubling shape. Code, prompts, agent workflows, and design decisions are increasingly produced by agents and shipped, sometimes after passing the tests they were asked to pass. 

Furthermore, code review is not a substitute for authorship: reading code produces measurably less understanding and retention than writing it — the [generation effect](https://en.wikipedia.org/wiki/Generation_effect), robustly documented in memory research. The reviewer catches what is visible on the page; what is implicit or structural largely passes them by. What emerges is a spectrum, not a binary — code authored by an engineer who still remembers why, code skimmed by an engineer in review, and code merged with no human inspection at all. Cognitive debt grows at every step up, and agentically generated code increasingly lives in the upper third.

<figure class="inline-diagram">
  <img src="/images/cognitive-debt-spectrum.png"
       alt="Vertical diagram showing a codebase as a spectrum, from bottom to top: 'Developer-authored — authored by an engineer who still remembers why', 'AI-generated, reviewed — code skimmed by an engineer in review', and 'AI-generated, unreviewed — generated, merged, never read'. A bold upward arrow alongside, labelled 'cognitive debt', indicates that cognitive debt rises as code moves up the spectrum."
       width="540">
  <figcaption>The cognitive-debt spectrum across a codebase.</figcaption>
  <p class="inline-diagram-credit">Diagram: © Michael Mannion, 2026.</p>
</figure>

The two forms behave differently. Classical cognitive debt can, in principle, be paid down by sitting the holder down and extracting what they know. The agentic form has no full holder: the prompt has been forgotten or paraphrased, the model updated, the agent's reasoning trace discarded, and the reviewer remembers (for a time) only what they saw on the page. The only durable artefact is the code itself — which may be correct, plausible-looking, subtly wrong, or all three at once. Classical cognitive debt means one person understands how and why the system works. Agentic cognitive debt means that even with reviewers in the loop, no one fully does — and asking the agent will not necessarily produce the same answer twice. The bus-factor question stops being "who can read the code?" and becomes "who understands the system?"

Compared with the technical debt most engineers know — the accumulated friction that makes a system harder to change than it should be — cognitive debt is something else, and it can crater a valuation. 

Technical debt is at least nameable: developers can point to it, tools can flag it, a team can estimate its size. Cognitive debt, on the other hand, is *what the company does not know that it does not know*. It is the gap between what the system requires to be safely operated, repaired, extended, and transferred, and what the company can demonstrate it actually knows — in any form a suitably qualified successor could read.

And the gap is not static. AI-first products evolve rapidly — code is generated, prompts iterate, models change, agentic workflows shift — so documentation that closed yesterday's gap is already dated. Cognitive debt accumulates continuously; paying it down is a continuous discipline, not a one-off exercise.

Transferability is the defining characteristic of a company's value: if it's not transferable, it's not worth investing in — save where part of the investment is specifically earmarked for building that transferability.

## Escaping the indispensability trap

All of which suggests an obvious remedy: make the system transferable.

Yet the very person best placed to do that work has reasons to leave it undone. The more completely the founder documents the system, the less able they are to claim that only they can operate it. In a fragile startup — in cash-flow distress, with a blurry runway, with an entrepreneur whose interests may not be perfectly aligned with the technical founder's — indispensability is not just an organisational liability. It's personal leverage.

The technical founder is often asked to do something that is both organisationally responsible *and* personally disadvantageous: *make themselves less indispensable*.

A fully documented system, validated as transferable to another qualified engineer, is good for the company and good for investors. But it may weaken the founder's bargaining position; or may be viewed as a pathway to ousting them. In our imagined two-founder startup, undocumented knowledge is not just an engineering weakness. It's political capital.

This founder's reluctance is rational, not adversarial. The solution is incentive alignment. The entrepreneur must frame knowledge transfer in any form — documentation, mentorship, paired work — not as replacement, but as *value creation* — and the founder must share materially in the value created, through equity, options, or vesting tied to transferability milestones.

There is also a useful symmetry. The technical founder who built the product with agentic tools is ideally placed to apply those same tools to keeping its documentation current as the product evolves. This does not replace the need for external validation, but it dramatically lowers the cost of unquestionably arduous work.

The investor must make it non-optional. Two distinct obligations, two distinct levers: the entrepreneur should make the technical founder *want* to document; the investor should make the company unable to raise without it. None of this is exotic. What is exotic, in many AI-first companies, is doing it at all. The journey, in both cases, is from indispensability to investability.

## The fragile AI-first company

An AI-first company of the shape this essay has described looks reasonable on the surface. There is a real product, early enterprise customers, an entrepreneur with the network and the sales story, and a technical founder who has built the product with agentic tools.

Less visibly, there is no validated technical handover, no statistical evidence that the product behaves acceptably under representative use, and balance-sheet pressure that the next funding round is expected to relieve. Each item is, alone, unremarkable. Taken together, they describe a class of company in which the product is real and the enterprise is fragile.

There is a further structural difference. A SaaS business has near-zero marginal cost: serving one more customer is nearly free once the software is built. An AI-first business does not. Each query, each agent action, each retrieval-augmented response carries a real *inference cost* — paid to OpenAI, Anthropic, Google, or a similar provider — and those costs scale roughly linearly with usage. They are also uncontrolled: the price of the largest variable cost line is set by a third party whose pricing decisions and model behaviour the company does not negotiate. What an investor sees as "gross margin" in an AI-first company is therefore unstable in ways a SaaS gross margin is not. The fragility is not only at the product level. It is at the unit-economics level.

There is also the question of availability. Model providers are not utilities. They have outages, deprecations, and roadmap decisions that can render an agentic feature inoperable overnight. A company whose product depends on a single provider is one incident away from a service interruption, and one product decision away from a forced migration. Mission-critical agentic features need a failover path — a pre-configured route to an alternative model or vendor. That discipline is to vendor lock-in what backups are to data loss: routine in mature engineering practice, frequently absent in AI-first companies built at speed.

What is priced as a $10 million AI-first company may, after honest risk adjustment, be worth materially less — not because the product is bad, but because cognitive debt, unmeasured stochastic behaviours, unstable unit economics, and vendor concentration are entirely absent from the model. The mispricing is not malicious. It is the predictable result of pricing the product rather than the company; of using yesterday's map in today's territory.

The pattern is not hypothetical. Builder.ai is the most-cited cautionary case: an AI narrative drawing major strategic backing, against operational and financial reality the narrative did not, in the end, support — [accumulating revenue questions, layoffs, and emergency financing](https://restofworld.org/2025/builderai-ai-apps-downfall/) before entering [insolvency](https://www.bloomberg.com/news/articles/2025-06-05/builder-ai-files-for-bankruptcy-after-creditors-seize-accounts). It will not be the last; when technology moves faster than diligence practice, the likelihood of mispricing increases.

## What entrepreneurs must do

This work begins with the entrepreneur, and with an idea older than AI. [Deming](https://en.wikipedia.org/wiki/W._Edwards_Deming) spent decades arguing that quality is the responsibility of management, not of workers: that quality cannot be inspected into a finished product but must be built in, and that a manager who delegates the quality question to the workers has misunderstood the job. (I [explored this argument at greater length](https://javai.org/signals/2026-04-19-deming-challenger-and-the-ai-watershed/) in an earlier essay.)

The parallel to the AI-first company is direct, with one consequential shift in lens: the entrepreneur's product IS the company, not just the licences the company sells. Quality, in that broader sense, includes transferability, statistically grounded reliability, and the survivability of the company without any single person. The entrepreneur is management, the technical founder is the operator, and the entrepreneur cannot delegate that question to the technical founder, cannot inspect it in by demanding a successful demo, and cannot escape ownership of the system the company has become.

Entrepreneurs must learn enough technical literacy to manage what they are selling — the company, not just the licences. They must stop treating the technical founder as a magician; distinguish a demo from evidence; understand cognitive debt; understand why stochastic features require statistical testing; understand LLM failure modes, their consequences, and their mitigations — on top of the ordinary disciplines of running any company.

The entrepreneur does not need to become a software engineer or a statistician. But they do need to know enough not to confuse velocity with durability.

## What technical founders must do

Technical founders must convert AI-first velocity into AI-governed capability.

Part of the list is unromantic but familiar: document architecture, decisions, agentic workflows, and prompt strategy; build traditional regression tests for the deterministic parts; build guardrails against known LLM failure modes; monitor production behaviour; onboard second-line technical capability; and treat transferability as technical excellence rather than as a managerial chore.

The other part is unromantic and likely *unfamiliar* — not because it is new to humanity, but because it is new to mainstream software engineering: build probabilistic evaluation harnesses for the stochastic parts; measure cost distributions rather than averages; track model and prompt changes as first-class artefacts; design for vendor failover so the product can tolerate the disappearance of any single provider; treat distributional regression as seriously as traditional regression. The methods themselves are well understood — by statisticians, by parts of the AI-research community, and by a small testing community already working on this — but they are not yet well known. The technical founder who takes them on is not just doing diligence. They are catching their discipline up.

It is the unglamorous work that converts a working product into an institutionally defensible one. In an AI-first company, undocumented brilliance is not an asset class; it is a risk concentration.

## What investors must do

Investors must extend SaaS diligence into AI-native diligence. The traditional categories still apply, but each acquires an additional AI-specific layer.

**Business diligence** still asks the familiar questions: ARR/MRR, churn, gross margin, pipeline, customer concentration, contract quality, go-to-market strategy, and the repeatability of the sales process. None of these become less important because the product is AI-native. Several become harder, because customers may be unwilling to be named, contracts may be heavily customised, and gross margins may be dominated by inference cost in ways that are unstable across model versions.

**Financial diligence** must look hard at debt, arrears, government loans, creditor waivers, tax position, payroll, founder loans, personal guarantees, runway, and a credible 13-week cash-flow model. AI-first companies frequently combine extraordinary product progress with extraordinary balance-sheet stress, because the cost of building has fallen but the cost of running — inference, retrieval, tools, evaluation — has not. 

**Technical diligence** must cover architecture, codebase, deployment, observability, security, and hard evidence of transferability. Each of these is a familiar item; what is new is that all of them must be present rather than just most.

**AI-specific diligence** is the new layer: stochastic behaviour, probabilistic testing, confidence intervals, model-change governance, prompt regression, inference cost distributions. This is where the industry's diligence practice is least mature. Along with cognitive debt, it is where the largest mispricings are likely to be found.

**Regulatory diligence** must ask where the company operates and whether it is meeting the rules that follow. AI-first companies typically hold data about people, which in Europe means GDPR conformance — an investor should demand evidence of it, not assume it. In regulated sectors more frameworks apply: the EU AI Act for high-risk uses, FDA guidance on AI/ML-enabled medical devices, sector-specific obligations elsewhere. ISO/IEC 42001 (the AI management system standard) is sometimes cited as a catch-all answer; it is not. Few startups hold certification, and even where they do, the standard requires processes rather than guaranteeing the statistical evidence this essay has been arguing for, or directly addressing key-person dependency. For those interested in digging deeper, [javai.ch](https://javai.ch) curates the regulatory landscape.

AI does not rewrite due diligence; it expands it. If the product cannot survive the loss of one technical founder, or an outage at one model vendor, investors are not buying a company — they are buying exposure to a single point of failure. Such exposure is not merely concentration risk. It is mispriced risk, and the mispricing is the investor's to absorb.

## Conclusion: disaster is avoidable

The lesson of the dot-com boom is not that the internet was worthless. It is that technological revolutions outrun the diligence used to price them. AI will be no different.

The opportunity is real. AI-first companies may become some of the most valuable businesses of the next decade. But the winners will not merely be those that build fastest. They will be those that become measurable, transferable, governable, and financially resilient.

Disaster is avoidable. Entrepreneurs must learn enough technical literacy to manage AI's risks soberly rather than be intoxicated by its upsides. Technical founders must turn undocumented brilliance into institutional capability. Investors must demand evidence, transferability, and probabilistic reliability before assigning valuations.

AI-first describes the method. AI-ready describes the maturity. AI-disciplined describes the winner.
