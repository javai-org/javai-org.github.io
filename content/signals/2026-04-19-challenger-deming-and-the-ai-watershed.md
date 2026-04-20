---
title: "Deming, Challenger, and the Watershed Moment of AI"
date: 2026-04-19
description: "Why the real AI risk to software organisations sits with upper management - and what Deming and Challenger still have to teach them."
author: michael
linkedinPost: ""
summary: "A watershed-moment essay on why AI amplifies, rather than creates, software quality - and why the responsibility rests with those who own the system."
---

<figure class="title-composite">
  <div class="title-composite-images">
    <img src="/images/deming.png" alt="W. Edwards Deming, photographed at the U.S. Census Bureau">
    <img src="/images/deming-ai-title-image.png" alt="An AI-era composition, juxtaposed with Deming's portrait">
  </div>
  <figcaption class="title-composite-caption">
    <span>20th Centrury Quality Guru William E. Deming</span>
    <span>AI-generated stuff</span>
  </figcaption>
  <p class="title-composite-credit">
    Deming photograph: <a href="https://www.census.gov/library/photos/1939/w-edwards-deming.html">U.S. Census Bureau</a> (public domain).
  </p>
</figure>

## The productivity miracle and the junior problem

Something strange is happening in software teams that adopted AI early.

Many seniors are ecstatic. A capable engineer with twenty years of experience, good instincts for abstractions, and a model on their right-hand screen is doing in a day what used to take a month. They are dreaming up systems on Monday that exist by Friday. For the first time in their careers, the bottleneck is their imagination rather than their typing speed.

Many juniors are paying for it. Some have been let go; others have left the industry on their own. Reports from the [US](https://digitaleconomy.stanford.edu/app/uploads/2025/11/CanariesintheCoalMine_Nov25.pdf), the [UK](https://www.theguardian.com/business/2025/jun/30/uk-entry-level-jobs-chatgpt-launch-adzuna), and [Germany](https://www.handelsblatt.com/technik/ki/arbeitsmarkt-ki-verdraengt-berufseinsteiger-welche-skills-jetzt-gefragt-sind/100144856.html) are a tiny sample of a global trend. For those who remain, the work that used to build them is dissolving. The tedious jobs - debugging a null pointer through three layers of abstraction, tracing a strange constant back through ten-year-old commits, writing the hundredth CRUD endpoint - were never just work. They were the apprenticeship. They were how judgement - "craft" - accumulated, by osmosis, from thousands of small encounters with consequence. That work is now dispatched in minutes by a model, and the juniors never accumulate the hours.

A junior who never struggles does not develop the judgement that only struggle produces, and is understandably tempted to accept whatever the LLM gives them. The code they ship will have been written primarily by a tool whose output they could not meaningfully critique. The initial productivity gains will likely be offset by what some are calling *[cognitive debt](https://www.media.mit.edu/projects/your-brain-on-chatgpt/overview/)* - a term that has begun to [circulate](https://www.linkedin.com/posts/margaret-anne-storey_we-have-many-tools-to-measure-the-quality-activity-7442570993128308736-TwQW) for exactly this consequence: code shipped without ever being held in a human head inevitably leads to a bigger bill when someone *has to* understand it. 

Much commentary about AI in software stops here, at the junior problem. It is real, troubling, sad. But it is only part of the picture, and not the most dangerous part.

## The unspoken senior problem

Software engineering remains an unusually heterogeneous profession. [Industry surveys](https://survey.stackoverflow.co/2025/developers/) consistently show that many practitioners did not come through a traditional computer-science pathway, and that a large share learned to code outside formal education. This means that many seniors whom the juniors look to *do not have the craft either*.

So in much of the industry, "Senior" turns out to be a payroll category, not a skill tier. It correlates with age, with tenure, with having shipped things. It does not, by itself, guarantee that the person writing your architecture has read a book since 2014, can name more than one design pattern, or could tell you what separates a healthy codebase from a rotting one. Many of them genuinely cannot. They have spent fifteen years writing the same God-object with a slightly different naming convention. Yet the industry has never had a reliable way to distinguish them from the engineer who finds clean code instinctive, takes pleasure in its particular aesthetic, and is faintly revolted by a mishmash of abstraction levels.

The organisational symptoms are just as telling. Architecture review reduced to 'does it compile and pass tests?' Delivery speed praised; cyclomatic complexity unmentioned. Refactoring crowded out by the pressure to ship features and fix bugs. Each is a signal that the system has quietly stopped investing in the expertise it claims to depend on.

Such veterans do have real expertise, but it is specific and narrow. They know where the bodies are buried. They know why `OrderProcessor` has that strange null check on line 847. They know which abstraction cannot be touched without involving three teams. This is the expertise of a curator - genuinely valuable in a system that has to keep running - *but it is not the expertise of an architect*. It tells you what not to break; what is likely to break if you touch it. It does not tell you how to build a clean architecture.

AI exposes this distinction at an almost cruel scale. When a model produces a plausible-looking service with subtly wrong coupling, or poor cohesion, leaked domain logic, or an abstraction that will pay compounding interest for a decade, the engineer reviewing it needs enough internalised judgement to push back. Such a senior feels the wrongness in their gut before they can articulate it. A senior without it sees code that compiles, passes tests, and looks like something they likely could not have written themselves, but would have been proud of if they had. They sign it off. More cognitive debt; this time with the authority of seniority behind it.

The authority makes this worse than the junior problem, because the junior at least knows they are a junior. Tenure becomes architectural authority by default.

## AI as amplifier

The central insight of the next decade of software engineering will be this: AI does not create quality. It [amplifies](https://cloud.google.com/blog/products/devops-sre/announcing-the-2024-dora-report) whatever quality culture already exists.

A team with strong engineering discipline - people who read widely, refactor continuously, debate design in pull requests, mentor each other, leave files better than they found them - will use AI to ship better systems, faster, than anyone thought possible. They will catch the model's bad suggestions because they have calibration. They will use its output as a starting point, not a resting point. They will save time where it should be saved, and spend it where it matters.

A team without that culture will produce substandard code at an industrial scale. And, for a while, that code will *look* better than what the team produced before, because the model has read millions of public repositories and can mimic professional conventions more faithfully than many practising professionals. A generic CRUD endpoint generated by a capable model is probably better structured than what the average fifteen-year veteran would hand-roll. This creates a short, seductive honeymoon in which an organisation with no engineering culture appears to be improving.

The code that looks professional has the same structural problems it always had, now wrapped in a veneer of competence that makes the flaws hard to see. Coupling accumulates. Cohesion frays. The same team that could barely ship features a year ago is now shipping five times as many, each carrying invisible debt that the management layer has no way to measure. Three years later, velocity collapses. Nobody can work out why. The engineers who could have diagnosed the problem have long since left.

There is a subtler feedback loop sitting under all of this. Models are trained on public code. Most public code is mediocre. The most statistically probable suggestion is the median suggestion. Seniors who cannot tell the median from the excellent will validate the median, and the median will become the organisation's house style. Organisations without that discipline were already producing substandard code; [AI accelerates its creation](https://gitclear-public.s3.us-west-2.amazonaws.com/GitClear-AI-Copilot-Code-Quality-2025.pdf).

## The Deming reframe: quality is a system output

The temptation at this point is to blame individuals. The veterans should read more. The juniors should try harder. Someone in the office should raise the bar. This is the oldest mistake in quality thinking, and the 20th century's most celebrated quality guru [W. Edwards Deming](https://en.wikipedia.org/wiki/W._Edwards_Deming) spent his career arguing against it.

Deming's central claim - drawn from decades of work in manufacturing, but applicable to any system that produces outputs - was that the overwhelming majority of quality problems are *system problems*, not people problems. When a factory produced defects, it was almost never because the workers were lazy or incompetent; it was because the system they worked in was designed, incentivised, or staffed in a way that reliably produced those defects. Exhortations to "do better" were worse than useless, because they told people they were responsible for outcomes they could not control. The only thing that actually changed quality was changing the system. And the system was the responsibility of management.

Everything in the previous sections is a Deming problem dressed up in Git.

Organisations whose "senior" engineers do not know what a code smell is are not organisations full of lazy individuals. They are organisations whose hiring, promotion, training, incentive, and review systems produced exactly the engineers they optimised for. If an engineer has never been given protected time to read outside their stack, never seen a pull request cause a meaningful architectural discussion, never received recognition for refactoring, and never been educated on why fragile code is a defect, the system has told them - unambiguously - what it values. They have complied. The outcome is not a moral failing. It is a system output.

Yet software has one feature that makes the Deming problem worse than manufacturing ever had it. In a factory, a bad weld fails quickly. Defects surface within days or weeks; the feedback loop is tight enough that the system itself begins to punish bad practices. In software, architectural decay can take years to bite. You can ship a velocity-optimised product for three years before the accumulated coupling turns every new feature into a six-week project, engineers start leaving, and the whole thing grinds. By then the executive who optimised for speed has moved on, and their successor inherits the impenetrable beast. The market does not punish bad quality fast enough to teach management that quality matters. So management, rationally, does not invest in it. (The irony is that manufacturing - Deming's own home ground - is no longer immune: a modern car is as much code as metal, and inherits software's slower feedback along with everything else.)

This is why "just hire better engineers" never works as a fix. The engineers you have are the engineers your system produced. Different ones, dropped into the same system, will produce the same output. *The lever is further up*.

## Upper management as the lever

If we take Deming seriously (and we absolutely should), the intervention is not at the team level. It is not even at the engineering-leadership level. It is at the layer that owns the system: upper management.

This is uncomfortable, because upper management in most software organisations is itself a system output. The same forces that produced senior engineers without that expertise produced VPs of Engineering and CTOs without it, often by promoting those same seniors. Still others reach those same seats via a wholly non-technical route - careers, often outstanding, built on organisational goals, delivery timelines, and people management. *They are accountable for systems they have no vocabulary to inspect*. Telling that layer "you need to understand what quality is" is easy to say, but they are the hardest audience to reach. *Their authority currently rests on appearing to know enough already*. Asking them to admit otherwise is asking them to give up the very thing that put them in the seat.

But before an organisation can capture the productivity AI genuinely promises, rather than simply industrialise its existing weaknesses, it has to prepare itself, and the preparation has to be aimed at upper management. Upper management does not need to learn to code. It needs to develop a specific, narrow, *diagnostic* literacy: enough understanding of what good code actually is to distinguish quality from its imitation, and enough confidence to defend quality investments whose payoff comes years later. That last one is the hardest filter. Most executives can, in principle, learn what a code smell is. Very few can, in practice, tell a board "we are slowing down this quarter to fix foundations." And yet that is, in every meaningful sense, the entire job. A classic from the man himself:

> *"Support of top management is not sufficient. It is not enough that top management commit themselves for life to quality and productivity. They must know what it is that they are committed to – that is, what they must do. These obligations cannot be delegated. Support is not enough: action is required."*
>
> - [Deming](https://deming.org/institute-leadership/)

## Confounding forces

The executive is up against powerful forces. Boards that do not understand software quality hire CEOs who do not prioritise it. Investors on quarterly cycles will punish costs that buy maintainability if it dips velocity. Deming called the job of breaking this pattern "driving fear out of the organisation" and considered it central to everything else. Half a century later, in an industry where most CTOs have tenure measured in single-digit years, fear has not noticeably retreated.

Those with authority have agendas of their own, and engineering judgement often loses when it collides with them. The quintessential example is [Challenger](https://www.nasa.gov/history/rogersrep/v1ch5.htm). Engineers raised warnings, management overrode them, and reality enforced the truth 73 seconds after liftoff. Software rarely operates at stakes like these, and we are fortunate for that. Less fortunate, perhaps, that the quieter failures go unexamined - even though every one of them is a signal of organisational dysfunction, and therefore an opportunity to improve.

Reading those signals, however, requires measurement. In the majority of development organisations I have encountered in my 40-year career, there is little sign of it beyond cost. Even basic delivery signals are weak or absent, and richer indicators of quality, rework, defect escape, architectural health, or process stability are harder still to find.

None of this is an argument for despair. It is an argument for being specific about where the work needs to happen.

## The path forward

What upper management actually needs is not technical training. It is an education in the quality principles that manufacturing, aviation, medicine, and every other mature engineering discipline absorbed decades ago - and that software, alone among major industries, has largely never required of its leaders.

Deming's work is the obvious starting point - above all his insistence that quality is the responsibility of management. The tradition that grew around him extends the same spirit: measuring what matters (e.g. throughput, in the Goldratt sense) rather than what is easy (e.g. cost), treating defects as signals from the system rather than failings of the individual, and holding to long-term thinking in environments that always reward the short term. None of this is new, and none of it requires the executive to write a line of code. It requires them to understand what good looks like, what warning signs look like, and why the feedback loops inside a software organisation are slower and more treacherous than the ones they know from operations or finance.

In practical terms for a software organisation, this literacy resolves into a short list of things upper management must ensure. First, that the senior engineers setting the tone - the ones shaping the architecture and mentoring everyone else - actually have the fundamentals: clean code, sound design, a working knowledge of patterns, the nose for bad signs. Second, where those fundamentals are missing, a deliberate mechanism for bringing them in from outside: through hiring, through training, through external review, through whatever channel the organisation can credibly open. Third, that junior engineers are apprenticed to whichever of those seniors has them, and not merely to whichever has the longest tenure. Fourth, that the organisation measures and rewards what matters rather than what is easy. None of this is technical. None of it is hidden. Too few are doing it. But many more could.

Education alone will not create expertise in people who have spent fifteen years without it. But it will give them the tools to *recognise* quality when it is in front of them, and the authority to protect it. Deming might have called this management's raison d'être. The engineers are already there. Some of them are already excellent. What has been missing is a layer above them with the eye to recognise it, the will to act on it, and the conviction to embody its implications across the organisation. Say it with me: quality culture starts at the top.

Nobody is coming to fix this from below. Not the juniors - they are being priced out of the apprenticeship. Not AI - it only amplifies what is already there. Not the seniors who know the system's history but not how to shape its future. The lever is, and always was, further up. If the opportunity is wasted, the responsibility sits where it always has - with those who own the system.


## Sources

| Source                                                                                                                                                                                                                                          | Relevance                                                                 |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| [Stanford Digital Economy Lab (Nov 2025)](https://digitaleconomy.stanford.edu/app/uploads/2025/11/CanariesintheCoalMine_Nov25.pdf)                                                                                                              | US - early-career software developer employment decline under AI.         |
| [The Guardian (Jun 2025)](https://www.theguardian.com/business/2025/jun/30/uk-entry-level-jobs-chatgpt-launch-adzuna)                                                                                                                           | UK - Adzuna data on entry-level job market since ChatGPT's launch.        |
| [Handelsblatt (Aug 2025)](https://www.handelsblatt.com/technik/ki/arbeitsmarkt-ki-verdraengt-berufseinsteiger-welche-skills-jetzt-gefragt-sind/100144856.html)                                                                                  | Germany - AI displacing entry-level professionals.                        |
| [MIT Media Lab - Your Brain on ChatGPT (2025)](https://www.media.mit.edu/projects/your-brain-on-chatgpt/overview/)                                                                                                                              | Cognitive cost of LLM use; origin of the term *cognitive debt*.           |
| [Margaret-Anne Storey, LinkedIn (2025)](https://www.linkedin.com/posts/margaret-anne-storey_we-have-many-tools-to-measure-the-quality-activity-7442570993128308736-TwQW)                                                                        | Discussion of *intent debt* and *cognitive debt* in software engineering. |
| [Stack Overflow Developer Survey (2025)](https://survey.stackoverflow.co/2025/developers/)                                                                                                                                                      | Heterogeneity of developer training pathways.                             |
| [DORA 2024 (Google Cloud)](https://cloud.google.com/blog/products/devops-sre/announcing-the-2024-dora-report)                                                                                                                                   | AI adoption's effect on delivery throughput and stability.                |
| [GitClear (2025)](https://gitclear-public.s3.us-west-2.amazonaws.com/GitClear-AI-Copilot-Code-Quality-2025.pdf)                                                                                                                                 | Large-scale analysis warning of AI-driven maintainability decay.          |
| [The Deming Institute](https://deming.org/institute-leadership/)                                                                                                                                                                                | Primary source for Deming on top management's obligations.                |
| [Rogers Commission Report (1986)](https://www.nasa.gov/history/rogersrep/v1ch5.htm)                                                                                                                                                             | Challenger - management overriding engineering warnings.                  |
