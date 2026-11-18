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
4. Once assigned:
    a. Create the appropriate feature branch.
    b. Implement Iteration 1 (Naive code) in both Java and Python.
    c. Commit, Push, and create a Pull Request.
    d. **STOP** and wait for user feedback/review.
5. Upon receiving feedback/review:
    a. Perform Staff-level Review using inline comments via `gh api` or GitHub UI (if requested to do the review itself).
    b. Implement Iteration 2 (Refactored code) in both Java and Python.
    c. Commit, Push, and finalize the PR.
6. Verify and push the final changes.
