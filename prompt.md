# Test Prompt for New Sessions

Use this prompt when starting a new Cline session to verify that the agent correctly initializes using the project documentation.

## The Prompt

\"I want to continue development on the Code Review Curriculum project. 

First, please initialize your session by reading `Agent.md` and `learn.md` to understand the project vision, the 30-lesson curriculum, and the technical execution guardrails.

Follow the 'Lesson Development Cycle' exactly as defined in the documentation.\"

## Expected Behavior
The agent should:
1. Read `Agent.md` and `learn.md`.
2. Acknowledge the project vision, the 30-lesson map, and the language parity requirement (Java & Python).
3. Await instructions on which specific problem to implement.
4. Once assigned, create the appropriate feature branch (e.g., `feature/module-X-problem-Y`).
5. Implement Iteration 1 (Naive code) in both Java and Python.
6. Create a PR and perform a Staff-level Review using inline comments via `gh api` or GitHub UI.
7. Implement Iteration 2 (Refactored code) in both Java and Python.
8. Verify and push the final changes.
