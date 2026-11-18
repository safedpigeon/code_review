# Agent Knowledge Base: Code Review Curriculum Development

## 🎯 Project Vision
This project is a curated educational repository designed to teach software engineering excellence. Instead of providing just "perfect" code, it utilizes a pedagogical "Before and After" approach. By intentionally implementing common anti-patterns and then refactoring them under the guidance of a Staff-level review, students can learn not just *what* a design pattern is, but *why* it is necessary and *how* to identify the smells that trigger its use.

## 📚 The Curriculum (30 Lessons)
The curriculum is divided into modules, each focusing on a specific area of software craftsmanship. 

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

## 🔄 The Lesson Development Cycle
For every lesson, the following workflow must be strictly followed. **Crucially, every lesson must be implemented in both Java and Python to ensure language-agnostic architectural patterns.**

### Step 1: Branching
- Create a new feature branch: `feature/module-X-problem-Y`.

### Step 2: Iteration 1 (Bad Code)
- **Goal**: Functional but "Naive" code.
- **Characteristics**:
    - Must run and pass basic functional requirements.
    - Must clearly exhibit the target anti-pattern.
    - Should resemble "Junior/Mid-level" code that prioritizes "making it work" over "making it right."

### Step 3: Staff-Level Review
- **Persona**: Staff Software Engineer / Architect.
- **Action**: Conduct a rigorous, pedagogical code review.
- **Requirements**:
    - Use specific terminology (e.g., "Temporal Coupling," "Cyclomatic Complexity").
    - Reference SOLID and other industry standards.
    - Explain the *business risk* (e.g., "This will increase the time-to-market for new features because...").

### Step 4: Iteration 2 (Production-Grade Refactor)
- **Goal**: Transform the "Before" into "After."
- **Standards**:
    - **Decoupling**: High use of interfaces and DI.
    - **Modularization**: Clear boundaries between layers (API $\rightarrow$ Service $\rightarrow$ Repository).
    - **Maintainability**: Clear naming, documentation, and high testability.

### Step 5: Verification & Push
- Verify functionality.
- Commit with a clear "Before $\rightarrow$ After" narrative.
- Push to remote (when online).

## 🛠️ Quality Matrix

| Dimension | Iteration 1 (The Smell) | Iteration 2 (The Solution) |
| :--- | :--- | :--- |
| **Structure** | Monolithic / Rigid | Modular / Flexible |
| **Dependencies** | Hardcoded / Tight | Injected / Loose |
| **Testing** | Difficult / Manual | Easy / Automated (Mockable) |
| **Naming** | Generic / Vague | Intent-revealing / Precise |
| **Logic** | Procedural / Nested | Declarative / Polymorphic |

## 📚 Current State
- **Current Progress**: Completed Module 1, Problem 1 (God Class).
- **Remaining**: 29 Lessons.

