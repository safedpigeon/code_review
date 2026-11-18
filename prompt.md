# Test Prompt for New Sessions

Use this prompt when starting a new Cline session to verify that the agent correctly initializes using the project documentation.

## The Prompt

"I want to continue development on the Code Review Curriculum project. 

First, please initialize your session by reading `Agent.md` and `learn.md` to understand the project vision, the 30-lesson curriculum, and the technical execution guardrails.

Once you have aligned yourself with the project standards, please proceed with the development of **Module 1, Problem 2: Tight Coupling**. 

Follow the 'Lesson Development Cycle' exactly as defined in the documentation."

## Expected Behavior
The agent should:
1. Read `Agent.md` and `learn.md`.
2. Acknowledge the project vision and the 30-lesson map.
3. Identify that it needs to create a branch `feature/module-1-problem-2`.
4. Implement Iteration 1 (Naive code).
5. Perform a Staff-level Review.
6. Implement Iteration 2 (Refactored code).
7. Verify and commit.
