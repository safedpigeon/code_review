# Agent Knowledge Base: Code Review Curriculum Development

## 🎯 Objective
The goal of this project is to build a comprehensive educational repository that teaches software engineering excellence through a "Before and After" approach. Each lesson illustrates a common architectural anti-pattern and its subsequent resolution into a production-grade implementation.

## 🔄 The Lesson Development Cycle
For every lesson in the curriculum, the following workflow must be strictly followed:

### Step 1: Branching
- Create a new feature branch following the naming convention: `feature/module-X-problem-Y`.

### Step 2: Iteration 1 (Bad Code)
- **Goal**: Implement the feature using the specific anti-pattern targeted by the lesson.
- **Requirements**:
    - The code must be functional and runnable.
    - It must clearly exhibit the "smell" (e.g., God Class, Tight Coupling, Hardcoded Dependencies).
    - It should look like code written by a developer who understands *how* to make it work, but not *how* to make it maintainable.

### Step 3: Staff-Level Review
- **Persona**: Staff Software Engineer / Architect.
- **Action**: Perform a comprehensive code review of Iteration 1.
- **Review Standards**:
    - Cite specific design principles (e.g., SOLID, DRY, YAGNI).
    - Explain the long-term impact of the anti-pattern (e.g., "This will make unit testing impossible because...").
    - Provide a clear roadmap for the refactor.

### Step 4: Iteration 2 (Production-Grade Refactor)
- **Goal**: Transform the bad code into a professional, decoupled architecture.
- **Requirements**:
    - **SRP (Single Responsibility Principle)**: Break monolithic classes into specialized services.
    - **DIP (Dependency Inversion Principle)**: Use interfaces/abstract classes to decouple high-level logic from low-level implementation.
    - **Testability**: Ensure the new structure is easily mockable and testable.
    - **Readability**: Use clear naming conventions and professional documentation.

### Step 5: Verification & Push
- Run the final implementation to verify it still meets the original functional requirements.
- Commit changes with clear messages describing the transition from the anti-pattern to the solution.
- Push the branch to the remote repository.

## 🛠️ Quality Standards

| Phase | Quality Indicator | Avoid |
| :--- | :--- | :--- |
| **Iteration 1** | Functional, but monolithic/rigid. | Code that doesn't run or is completely broken. |
| **Staff Review** | Analytical, pedagogical, and critical. | Generic comments like "this is bad" or "fix this." |
| **Iteration 2** | Modular, decoupled, and extensible. | "Half-baked" refactors that still contain tight coupling. |

## 📚 Context Memory
- **Current Progress**: Completed Module 1, Problem 1 (God Class).
- **Key Patterns Used**: Repository Pattern, Service Orchestration, Dependency Injection.
- **Remaining**: 29 Lessons.
