# Agent Knowledge Base: Code Review Curriculum Development

## 🎯 Project Vision
This project is a curated educational repository designed to teach software engineering excellence. Instead of providing just "perfect" code, it utilizes a pedagogical "Before and After" approach. By intentionally implementing common anti-patterns and then refactoring them under the guidance of a Staff-level review, students can learn not just *what* a design pattern is, but *why* it is necessary and *how* to identify the smells that trigger its use. The goal is to move beyond "finding bugs" and instead focus on systemic risk mitigation, scalability, and maintainability — the hallmarks of a Staff Software Engineer at companies like Google, Meta, and Microsoft. Once built, this repository will have 30 open Pull Requests that documents 30 architectural anti-patterns and their production-grade solutions. 

## 📚 The Curriculum (30 Lessons)
The curriculum is divided into modules, each focusing on a specific area of software craftsmanship. 

Master the ability to review code through the lens of:
- **Architectural Alignment:** Does this fit the larger system?
- **Reliability:** Will this fail gracefully in production?
- **Scalability:** Does this hold up under $100\times$ load?
- **Security:** Is the data protected and the API idempotent?
- **Mentorship:** Is the feedback constructive and Socratic?

### Module 1: Foundational Clean Code & Architecture
1.  **The God Class**: Decomposing monolithic classes into specialized services (Completed).
2.  **Tight Coupling**: Replacing hard dependencies with Interfaces/Dependency Injection.
3.  **Lack of Error Handling**: Moving from basic try-catch to global exception handling and custom error types.
4.  **Hardcoded Configurations**: Implementing a centralized configuration management system.
5.  **Inefficient Data Structures**: Optimizing time/space complexity in business logic.

### Module 2: Object-Oriented Design Patterns (SOLID)
6.  **Single Responsibility Principle (SRP)**: Refactoring classes that do "too much."
7.  **Open/Closed Principle (OCP)**: Using Strategy/Template patterns to allow extension without modification.
8.  **Liskov Substitution Principle (LSP)**: Fixing broken inheritance hierarchies.
9.  **Interface Segregation Principle (ISP)**: Splitting "Fat Interfaces" into lean, client-specific ones.
10. **Dependency Inversion Principle (DIP)**: High-level modules depending on abstractions, not concretions.

### Module 3: Behavioral & Creational Patterns
11. **The Singleton Trap**: Refactoring overused Singletons to Dependency Injection.
12. **The Factory Pattern**: Managing complex object creation.
13. **The Observer Pattern**: Decoupling event producers from consumers.
14. **The Strategy Pattern**: Implementing interchangeable algorithms.
15. **The Command Pattern**: Encapsulating requests as objects for undo/redo/queuing.

### Module 4: Persistence & Data Access
16. **The Active Record Anti-pattern**: Moving to Data Mapper/Repository patterns.
17. **N+1 Query Problem**: Optimizing database access in loops.
18. **Leaky Abstractions**: Preventing persistence details from bleeding into the business layer.
19. **Transaction Management**: Ensuring ACID properties across service boundaries.
20. **Concurrency Issues**: Solving race conditions and deadlocks in shared resources.

### Module 5: Production-Grade Engineering
21. **Lack of Logging/Observability**: Implementing structured logging and tracing.
22. **Poor API Design**: Refactoring REST endpoints for consistency and versioning.
23. **Security Vulnerabilities**: Fixing common flaws (e.g., SQL injection, XSS) via architectural guards.
24. **Testing Debt**: Moving from "no tests" to a Pyramid approach (Unit $\rightarrow$ Integration $\rightarrow$ E2E).
25. **Synchronous Bottlenecks**: Introducing Asynchronous processing/Message Queues.

### Module 6: Advanced Refactoring & Maintenance
26. **Conditional Complexity**: Replacing deeply nested `if-else` with Polymorphism.
27. **Primitive Obsession**: Introducing Value Objects to replace generic types.
28. **Feature Envy**: Moving methods to the classes that own the data.
29. **Dead Code & Technical Debt**: Systematic removal of unused logic and modernization.
30. **The Capstone**: A full-scale refactor of a legacy system applying all previous lessons.


## 🛠️ The Golden Path (Operational Workflow)

As an AI Agent, your job is to help with curriculum development, one problem at a time. In the Prompt, you would have received instructions what module to develop. As an AI Agent, you should follow the following Steps in order, starting from Step 1, then Step 2, then Step 3, then Step 4 and finally Step 5. 

### Step 1: Branching
- Create a new feature branch: `git checkout -b feature/module-X-problem-Y`.

### Step 2: Iteration 1 (The "Naive" Implementation)
- **Persona**: Junior Software Developer.
- **Goal**: Implement Functional but "Naive" code in both Java and Python. Once Implemented create a Pull Request on Github which would serve as Iteration 1 for learning the anti pattern.
- **Characteristics**:
    - Must run and pass basic functional requirements.
    - Must clearly exhibit the target anti-pattern (resembling Junior/Mid-level code).
- **Action**: Implement in **both Java and Python**.
- **Execution**: `git add .` $\rightarrow$ `git commit -m "feat: iteration 1 - naive implementation"` $\rightarrow$ `git push` $\rightarrow$ `gh pr create`.
- **VERIFICATION**: Verify the PR is successfully created before proceeding. Once PR creation is verified, move to Step 3

### Step 3: Staff-Level Review (Inline Comments)
- **Persona**: Staff Software Engineer / Architect at Google.
- **Action**: Being an AI Agent assuming the above persona, Conduct a rigorous, pedagogical code review via **inline comments** on the PR raised in Step 2. Ensure comments are being generated on the Pull Request on the actual location of the problem.
- **Requirements**:
    - Use specific terminology (e.g., "Temporal Coupling," "Cyclomatic Complexity").
    - Reference SOLID and other industry standards.
    - Explain the *business risk* (e.g., "This will increase the time-to-market...").
- **CONTINUATION**: Once the critiques are posted via `gh api` or UI on Iteration 1 of Pull Request, proceed to Step 4.

### Step 4: Iteration 2 (Production-Grade Refactor)
- **Persona**: Staff Software Engineer / Architect at Google.
- **Goal**: Analyze the Review comments generated in Step 3, fixing the naive code to resolve the review comments, generate another iteration in the open Pull request on Github which resolves the comments.
- **Standards**:
    - **Decoupling**: High use of interfaces and DI.
    - **Modularization**: Clear boundaries between layers (API $\rightarrow$ Service $\rightarrow$ Repository).
    - **Maintainability**: Clear naming, documentation, and high testability.
- **Action**: Implement the refactor in **both Java and Python** based on the review comments.
- **Execution**: `git add .` $\rightarrow$ `git commit -m "feat: iteration 2 - production-grade refactor"` $\rightarrow$ `git push`.

### Step 5: Verification & Finalization
- Ensure the PR has now 2 iterations. On the first iteration naive code has been implemented, and comments are provided. on the 2nd iteration, implementation fixes the comments provided on iteration 1.

## 📊 Quality Matrix

| Dimension | Iteration 1 (The Smell) | Iteration 2 (The Solution) |
| :--- | :--- | :--- |
| **Structure** | Monolithic / Rigid | Modular / Flexible |
| **Dependencies** | Hardcoded / Tight | Injected / Loose |
| **Testing** | Difficult / Manual | Easy / Automated (Mockable) |
| **Naming** | Generic / Vague | Intent-revealing / Precise |
| **Logic** | Procedural / Nested | Declarative / Polymorphic |

## 📋 Session Initialization

### Initialization Checklist
Every new session should start by:
1. Reading `Agent.md` to understand the current progress and curriculum.
2. Running `git status` to verify the current branch and working tree state.

### The Session Start Prompt
Use this prompt when starting a new Cline session:
> "I want to continue development on the Code Review Curriculum project. First, please initialize your session by reading `Agent.md` to understand the project vision, the 30-lesson curriculum, and the technical execution guardrails. Follow the 'Golden Path' workflow exactly as defined in the documentation."

### Expected Agent Behavior
1. Read `Agent.md`.
2. Acknowledge the project vision, the 30-lesson map, and the language parity requirement (Java & Python).
3. Await instructions on which specific problem to implement.
4. Once assigned, execute the The Golden Path (Operational Workflow) starting from Step 1 and ending after Step 5.

## ⚠️ Technical Guardrails & Lessons Learned, from previous iterations of Agents execution in cline. 
This section documents technical pitfalls to avoid and the operational requirements for maintaining the repository.

### 1. Git Branch Switching & Untracked Files
- **The Problem**: Attempting to `git checkout` between branches while having untracked or modified files (e.g., `Agent.md`) causes the checkout to abort.
- **The Fix**: 
    - Before switching branches, check for untracked files using `git status`.
    - If a file should live in `main` but is currently modified in a feature branch:
        1. Commit it to the feature branch first, then checkout `main` and merge/cherry-pick.
        2. OR, remove/stash the local change before switching.
- **Rule**: Never leave "global" documentation files in a dirty state when moving between feature branches.

### 2. Precise File Editing (The `editor` Tool)
- **The Problem**: The `editor` tool fails if `old_text` is omitted for an existing file or if the `old_text` does not match the file content exactly.
- **The Fix**: 
    - **Always** call `read_files` immediately before an `editor` call if you are modifying an existing file.
    - Copy the exact block of text from the `read_files` output into the `old_text` field.
    - For appending to the end of a file, use `insert_line` with `line_count + 1`.

### 3. Global vs. Local Configuration
- **The Problem**: Placing global blueprints inside feature branches.
- **The Fix**: 
    - Feature branches are treated as Pull Requests for specific lessons. They should contain *only* the code for that lesson.
    - All project-wide documentation, curriculum maps, and guidelines must reside in the `main` branch.

### 4. Language Parity
- **The Requirement**: Every lesson must be implemented in **both Java and Python**.
- This ensures the curriculum is language-agnostic and demonstrates that architectural patterns apply across different paradigms.
- Ensure the directory structure reflects this: `module-X/problem-Y/java/...` and `module-X/problem-Y/python/...`.
