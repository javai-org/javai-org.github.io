# Having Senior Developers Is Not Enough: AI, Craft, and What Deming Would Say Now

## The productivity miracle and the junior problem

Something strange is happening in software teams that adopted AI early.

The seniors are ecstatic. A capable engineer with twenty years of experience, good instincts for abstractions, and a model on their right-hand screen is doing in a day what used to take a month. They are dreaming up systems on Monday that exist by Friday. For the first time in their careers, the bottleneck is their imagination rather than their typing speed.

The juniors are quieter. They are still there, still paid, still assigned to teams. But the work that used to build them is dissolving. The tedious jobs — debugging a null pointer through three layers of abstraction, tracing a strange constant back through ten-year-old commits, writing the hundredth CRUD endpoint — were never just work. They were the apprenticeship. They were how craft accumulated, by osmosis, from thousands of small encounters with consequence. That work is now dispatched in minutes by a model, and the juniors never accumulate the hours.

The visible risk is disengagement. A junior who never struggles does not develop the judgement that only struggle produces, and is understandably tempted to accept whatever the model gives them. The invisible risk is worse: the codebases they eventually inherit will have been written primarily by a tool whose output they cannot meaningfully critique, and they will not know what they do not know.

Most commentary about AI in software stops here, at the junior problem. It is real. But it is only half the picture, and not the more dangerous half.

## The hidden half of the problem

In a surprising number of organisations, the seniors whom the juniors look to *do not have the craft either*.

In much of the industry, "Senior" turns out to be a payroll category, not a skill tier. It correlates with age, with tenure, with having shipped things. It does not, by itself, guarantee that the person writing your architecture has read a book since 2014, can name more than one design pattern, can explain why a six-hundred-line service class is a problem, or could tell you what separates a healthy codebase from a rotting one. Many of them genuinely cannot. They have spent fifteen years writing the same God-object with a slightly different naming convention. Yet the industry has never had a reliable way to distinguish them from the engineer down the hall who watches Hickey talks, re-reads Uncle Bob on weekends, and has strong opinions about abstraction level consistency.

The organisational symptoms are just as telling. Architecture review reduced to "does it compile and pass tests?" Promotion systems that reward delivery volume over design stewardship. Juniors routinely shielded from code archaeology and refactoring work on the grounds that it is not the best use of their time. Each is a signal that the system has quietly stopped investing in the craft it claims to depend on.

Such veterans do have real expertise, but it is specific and narrow. They know where the bodies are buried. They know why `OrderProcessor` has that strange null check on line 847. They know which abstraction cannot be touched without three teams getting paged. This is the expertise of a curator — genuinely valuable in a system that has to keep running — *but it is not the expertise of an architect*. It tells you what not to break; what is likely to break if you touch it. It does not tell you how to craft a clean architecture.

AI exposes this distinction at an almost cruel scale. When a model produces a plausible-looking service with subtly wrong coupling, or poor cohesion, leaked domain logic, or an abstraction that will pay compounding interest for a decade, the engineer reviewing it needs enough internalised judgement to push back. A senior with craft feels the wrongness in their gut before they can articulate it. A senior without it sees code that compiles, passes tests, and looks like what they would have written themselves. They sign off. The codebase grows. Nobody notices anything is wrong until the system is years deep into a structural problem that is now enormously expensive to fix.

Meanwhile, the authority piece makes this worse than the junior problem, because the junior at least knows they are a junior. The fifteen-year veteran who wrote half the codebase has institutional capital that is earned in one currency — knowing the system's history — and spent in another: deciding what it should look like next. Those are completely different skills, but the organisation does not distinguish between them. Tenure cashes out as architectural authority by default.

## AI as amplifier

The central insight of the next decade of software engineering will be this: AI does not create quality. It amplifies whatever quality culture already exists.

A team with strong craft — people who read widely, refactor continuously, debate design in pull requests, mentor each other, leave files better than they found them — will use AI to ship better systems, faster, than anyone thought possible. They will catch the model's bad suggestions because they have calibration. They will use its output as a starting point, not a resting point. They will save time where it should be saved, and spend it where it matters.

A team without that culture will produce substandard code (*AI slop*, to use modern parlance) at an industrial scale. And, for a while, that code will *look* better than what the team produced before, because the model has read millions of public repositories and can mimic professional conventions more faithfully than many practising professionals. A generic CRUD endpoint generated by a capable model is probably better structured than what the average fifteen-year veteran would hand-roll. This creates a short, seductive honeymoon in which an organisation with no engineering culture appears to be improving.

The bill arrives later. The code that looks professional has the same structural problems it always had, now wrapped in a veneer of competence that makes the flaws hard to see. Coupling accumulates. Cohesion frays. The same team that could barely ship features a year ago is now shipping five times as many, each carrying invisible debt that the management layer has no way to measure. Three years later, velocity collapses. Nobody can work out why. The engineers who could have diagnosed it have long since left.

There is a subtler feedback loop sitting under all of this. Models are trained on public code. Most public code is mediocre. The most statistically probable suggestion is the median suggestion. Seniors who cannot tell the median from the excellent will validate the median, and the median will become the organisation's house style. Organisations without craft were already producing substandard code; AI accelerates its creation.

## The Deming reframe: quality is a system output

The temptation at this point is to blame individuals. The veterans should read more. The juniors should try harder. Someone in the office should raise the bar. This is the oldest mistake in quality thinking, and the 20th century's most celebrated quality guru [W. Edwards Deming](https://en.wikipedia.org/wiki/W._Edwards_Deming) spent his career arguing against it.

Deming's central claim — drawn from decades of work in manufacturing, but applicable to any system that produces outputs — was that the overwhelming majority of quality problems are *system problems*, not people problems. When a factory produced defects, it was almost never because the workers were lazy or incompetent; it was because the system they worked in was designed, incentivised, or staffed in a way that reliably produced those defects. Exhortations to "do better" were worse than useless, because they told people they were responsible for outcomes they could not control. The only thing that actually changed quality was changing the system. And the system was the responsibility of management.

Everything in the previous sections is a Deming problem dressed up in Git.

Organisations whose "senior" engineers do not know what a code smell is are not organisations full of lazy individuals. They are organisations whose hiring, promotion, training, incentive, and review systems produced exactly the engineers they optimised for. If an engineer has never been given protected time to read outside their stack, never seen a pull request model productive architectural disagreement, never been promoted for refactoring, and never been educated on why fragile code is a defect, the system has told them — unambiguously — what it values. They have complied. The outcome is not a moral failing. It is a system output.

Yet software has one feature that makes the Deming problem worse than manufacturing ever had it. In a factory, a bad weld fails quickly. Defects surface within days or weeks; the feedback loop is tight enough that the system itself begins to punish bad practices. In software, architectural decay takes years to bite. You can ship a velocity-optimised product for three years before the accumulated coupling turns every new feature into a six-week project, engineers start leaving, and the whole thing grinds. By then the executive who optimised for speed has been promoted, moved on, and their successor inherits the ticking bomb. The market does not punish bad quality fast enough to teach management that quality matters. So management, rationally, does not invest in it.

This is why "just hire better engineers" never works as a fix. The engineers you have are the engineers your system produced. Different ones, dropped into the same system, will produce the same output. *The lever is further up*.

## Upper management as the lever

If we take Deming seriously (and we absolutely should), the intervention is not at the team level. It is not even at the engineering-leadership level. It is at the layer that owns the system: upper management.

This is uncomfortable, because upper management in most software organisations is itself a system output. The same forces that produced senior engineers without craft produced VPs of Engineering and CTOs without it, often by promoting those same seniors. Still others reach those same seats via a wholly non-technical route — careers, often outstanding, built on organisational goals, delivery timelines, and people management. *They are accountable for systems they have no vocabulary to inspect*. Telling that layer "you need to understand what quality is" is correct but recursive. The people best positioned to learn are the ones with the least professional incentive to, because their authority currently depends on **not having that gap exposed as a gap**.

## Confounding forces

Before an organisation can capture the productivity AI genuinely promises — rather than simply industrialise its existing weaknesses — it has to prepare itself, and the preparation has to be aimed at upper management. Upper management does not need to learn to code. It needs to develop a specific, narrow, *diagnostic* literacy: enough understanding of what good code actually is to distinguish craft from its imitation, enough humility to defer to those who have deeper literacy, and enough confidence to defend quality investments whose payoff comes years later. That last one is the hardest filter. Most executives can, in principle, learn what a code smell is. Very few can, in practice, tell a board "we are slowing down this quarter to fix foundations." And yet that is, in every meaningful sense, the entire job.

The executive is up against powerful forces. Boards that do not understand software quality hire CEOs who do not prioritise it. Investors on quarterly cycles will punish costs that buy maintainability if it dips velocity.

Deming called the job of breaking this pattern "driving fear out of the organisation" and considered it central to everything else. Half a century later, in an industry where most CTOs have tenure measured in single-digit years, fear has not noticeably retreated.

None of this is an argument for despair. It is an argument for being specific about where the work needs to happen.

## The path forward

What upper management actually needs is not technical training. It is an education in the quality principles that manufacturing, aviation, medicine, and every other mature engineering discipline absorbed decades ago — and that software, alone among major industries, has largely never required of its leaders.

Deming's work is the obvious starting point — above all his insistence that quality is the responsibility of management. The tradition that grew around him extends the same spirit: measuring what matters (e.g. throughput, in the Goldratt sense) rather than what is easy (e.g. cost), treating defects as signals from the system rather than failings of the individual, and holding to long-term thinking in environments that always reward the short term. None of this is arcane, and none of it requires the executive to write a line of code. It requires them to understand what good looks like, what warning signs look like, and why the feedback loops inside a software organisation are slower and more treacherous than the ones they know from operations or finance.

In practical terms for a software organisation, this literacy resolves into a short list of things upper management must ensure. First, that the senior engineers setting the tone — the ones shaping the architecture and mentoring everyone else — actually have the craft: clean code, sound design, a working knowledge of patterns, the judgement to see when code is shaky. Second, where that craft is missing, a deliberate mechanism for bringing it in from outside: through hiring, through training, through external review, through whatever channel the organisation can credibly open. Third, that junior engineers are apprenticed to whichever of those seniors has the craft, and not merely to whichever has the longest tenure. Fourth, that the organisation measures and rewards the right things: promotion criteria that value stewardship and teaching alongside delivery, and measurement that tracks rework, lead-time degradation, and defect escape rather than output volume alone. These are all questions an executive is well-placed to ask, and well-placed to answer. Almost none are being asked in most organisations today.

Education alone will not create craft in people who have spent fifteen years without it. But it will give them the tools to *recognise* craft when it is in front of them, and the authority to protect it. In a Deming sense, that is most of the job. The engineers are already there. Some of them are already excellent. What has been missing is a layer above them with the literacy to know it, and the will to act on it.

Nobody is coming to fix this from below. Not the juniors — they are being priced out of the apprenticeship. Not AI — it only amplifies what is already there. Not the seniors, in too many organisations — their currency is history, not architecture. The lever is, and always was, further up — and the quiet opportunity of this moment is that AI has made its position impossible to hide.
