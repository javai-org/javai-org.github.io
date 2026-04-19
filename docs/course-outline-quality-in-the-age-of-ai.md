# Quality in the Age of AI
## A One-Day Course for Engineering Leadership

---

### Summary

A one-day, executive-level programme designed to give upper management the diagnostic literacy to protect software quality in the AI era — without teaching them to code.

By the end of the day, participants will be able to walk into their engineering organisation and form defensible, evidence-based views about whether their systems, teams, and AI adoption practices are healthy. They will leave with a set of questions to ask, a set of metrics to stop overweighting, and at least one concrete investment to propose.

---

### Who this is for

- CTOs, CIOs, VPs of Engineering, Heads of Product Engineering
- COOs and CFOs with software-engineering portfolios
- Non-technical executives whose P&L includes engineering cost or velocity
- Board members of software-heavy organisations

Ideal group size: 8–16 participants. The course is substantially more valuable when two or more participants attend from the same organisation — the back-at-the-office conversation is where the day either lands or evaporates.

---

### Why now

The adoption of AI coding assistants has reset the economics of software development. Skilled engineers now produce in a day what used to take a month. Less-skilled engineers produce code at the same multiplier, but their code accumulates invisible architectural debt that only surfaces years later. The gap between healthy and unhealthy engineering cultures is widening rapidly, and quality — always a system-level property — is becoming the decisive variable.

This course exists because most upper-management teams lack the vocabulary to see that gap, and therefore the authority to do anything about it.

---

### Learning outcomes

By the end of the day, participants will be able to:

1. Recognise the visual signatures of healthy vs. unhealthy code without reading code themselves
2. Identify the behavioural signals of a strong engineering culture — and the warning signs of a weak one
3. Ask targeted, non-trivial questions that separate genuine craft from cargo-culting
4. Distinguish between metrics that incentivise quality and metrics that destroy it
5. Frame the economic case for quality investments in terms their board will understand
6. Evaluate whether their organisation's AI adoption is helping or harming long-term maintainability

---

### Design philosophy

This is not a lecture. It is not a technical course in disguise. And it is not a motivational programme about "valuing quality" in the abstract.

The day is built on the principle that non-technical executives can *see* code quality — or the lack of it — once they know what to look at. Visual patterns of complexity are obvious to anyone, in the same way that an unsafe building site is obvious to a non-architect. Signals of engineering health are visible in pull-request reviews, velocity charts, postmortems, and how engineers talk about the codebase. Much of the day is spent teaching participants to perceive what has been in front of them the whole time.

---

### Pre-work (~90 minutes)

To be completed before attending. Materials provided in advance.

- Chapter 3 of W. Edwards Deming, *Out of the Crisis* (on systems and the role of management)
- Joel Spolsky, "Things You Should Never Do, Part I" (the essay on rewrites)
- A short primer (~6 pages) on technical debt as a balance-sheet liability
- One hour of reflection on a specific system in the participant's organisation they would like to understand better — this becomes a running case study for the day

---

### Agenda

| Time          | Session                                           | Format                          |
|---------------|---------------------------------------------------|---------------------------------|
| 09:00 – 10:30 | **The Stakes: Two Companies**                     | Case study + discussion         |
| 10:30 – 10:45 | Break                                             |                                 |
| 10:45 – 12:15 | **What Quality Actually Is**                      | Visual walkthrough + exercise   |
| 12:15 – 13:15 | Lunch                                             |                                 |
| 13:15 – 14:30 | **Reading the Room: Diagnostic Literacy**         | Exercise + role play            |
| 14:30 – 14:45 | Break                                             |                                 |
| 14:45 – 15:45 | **What Management Controls: The Deming Levers**   | Discussion + case studies       |
| 15:45 – 16:00 | Break                                             |                                 |
| 16:00 – 17:00 | **AI as Amplifier**                               | Discussion + worked examples    |
| 17:00 – 17:30 | **Commitments**                                   | Structured individual work      |

---

### Session detail

#### Session 1 — The Stakes: Two Companies (90 min)

Two anonymised case studies of software-heavy organisations with similar starting conditions. Over 36 months, one invests in quality; the other optimises for velocity. Participants see feature throughput, bug rates, on-call burden, engineer attrition, and cost-to-add-a-representative-feature at months 6, 18, and 36.

No code is shown. The session establishes that quality is a compounding economic asset with a delayed payoff — which is exactly why most organisations under-invest in it.

#### Session 2 — What Quality Actually Is (90 min)

The conceptual heart of the day. Three concepts, all taught visually.

*Complexity.* Coupling diagrams, nesting depth, module size. A ball-of-mud architecture side-by-side with a layered one. A six-hundred-line method next to a refactored version. Participants will see the difference immediately, without reading a line of code.

*Patterns and anti-patterns.* An introduction to the idea that patterns have names, a literature, and decades of professional argument behind them — anchored in analogies the participants already understand, such as accounting conventions, medical protocols, and building codes.

*Code smells.* A short exercise in which participants review five anonymised code snippets and rank them from healthy to problematic. Their intuitions are typically correct, and the session ends with participants realising they are allowed to trust what they see.

#### Session 3 — Reading the Room (75 min)

The diagnostic session, and the highest-value hour of the day.

Signals of engineering health that participants can observe without reading code: the shape of pull-request reviews, the tone of postmortems, the pattern of velocity charts over 18 months, the way engineers talk about the codebase ("our system" vs. "the legacy thing"), the bus factor on critical modules, the way rework shows up in sprint data.

Participants then work through a battery of diagnostic questions they can ask their engineering leaders:

- *"Show me the last refactoring PR."*
- *"Who is the only person who can safely change the payments service?"*
- *"If we were starting from scratch, what would we do differently?"*
- *"What is our slowest file to change, and why?"*
- *"How do we know the system is healthy?"*

Each question is paired with worked examples of what strong and weak answers sound like.

#### Session 4 — What Management Controls (60 min)

The Deming section, and the part that turns insight into agency. A structured walk through the system levers management actually has:

- *Time and slack.* Can engineers invest in quality, or only in features?
- *Metrics.* What is measured and rewarded — and what does that incentive structure produce?
- *Definition of done.* Is it "it ships" or "it ships, is tested, is documented, has been reviewed for architectural fit"?
- *Hiring calibration.* Who sets the bar, and what is it actually measuring?
- *Training and deliberate learning time.* Does the organisation fund the development of craft, or only the exploitation of it?
- *Political cover.* Are quality investments protected from quarterly pressure, or the first thing cut when a deadline slips?

Each lever is paired with a short case study of an organisation that changed one of them deliberately, and the outcome that followed.

#### Session 5 — AI as Amplifier (60 min)

A focused module on the question of the moment. How AI adoption interacts with existing culture: healthy teams ship dramatically better systems; unhealthy teams ship dramatically worse ones, now wrapped in a professional-looking veneer that makes the rot harder to see.

Participants learn what healthy AI adoption looks like in practice (engineers reading output critically, rejecting suggestions, using the model to accelerate learning rather than replace it) and what unhealthy adoption looks like (commit-and-forget, erosion of review culture, juniors who cannot work unaided). The session closes by returning to Deming: AI does not create a quality culture, it exposes whether you already had one.

#### Session 6 — Commitments (30 min)

Each participant leaves with three concrete artefacts:

1. One question they will ask their engineering leader within the next seven days
2. One metric they will stop overweighting
3. One small investment they will propose — a book study, a refactoring sprint, a hiring bar adjustment, a slack budget for learning

No abstractions. Each commitment is small, testable, and reversible. Participants share commitments in pairs to create lightweight accountability.

---

### What participants leave with

- A printed diagnostic field guide, including the full question bank from Session 3
- A curated reading list covering Deming, technical debt, quality economics, and engineering culture
- The slide deck and case studies in editable form, for internal re-use
- Access to a 90-day follow-up discussion with the facilitator
- Three personal commitments, and a named peer to check in with at 30 days

---

### Logistics

- **Format:** In-person preferred; remote-delivered version available
- **Duration:** 8 hours including breaks, plus ~90 minutes of pre-work
- **Group size:** 8–16 participants
- **Materials:** Pre-work pack delivered two weeks in advance; participants bring a laptop or tablet, but no prior technical preparation is required
- **Venue:** Standard meeting room with projector and whiteboard

---

### About the facilitator

*[To be completed]*

---

### Contact

*[To be completed]*
