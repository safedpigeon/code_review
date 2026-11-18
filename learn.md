# Execution Guide: Lessons Learned & Technical Guardrails

This document serves as an operational manual for AI agents (Cline) working on this repository. It documents technical pitfalls encountered during early development and provides the \"golden path\" for executing the curriculum to avoid repetitive mistakes.

## ⚠️ Technical Gotchas & Fixes

### 1. Git Branch Switching & Untracked Files
**The Problem**: Attempting to `git checkout` between branches while having untracked or modified files (e.g., `Agent.md`) in the working directory causes the checkout to abort.
**The Fix**: 
- Before switching branches, check for untracked files using `git status`.
- If a file should live in `main` but is currently modified in a feature branch:
    1. Commit it to the feature branch first, then checkout `main` and merge/cherry-pick.
    2. OR, remove/stash the local change before switching.
- **Rule**: Never leave \"global\" documentation files in a dirty state when moving between feature branches.

### 2. Precise File Editing (The `editor` Tool)
**The Problem**: The `editor` tool fails if `old_text` is omitted for an existing file or if the `old_text` does not match the file content exactly (case-sensitive, whitespace-sensitive).
**The Fix**: 
- **Always** call `read_files` immediately before an `editor` call if you are modifying an existing file.
- Copy the exact block of text from the `read_files` output into the `old_text` field.
- For appending to the end of a file, use `insert_line` with `line_count + 1`.

### 3. Global vs. Local Configuration
**The Problem**: Placing global blueprints (like `Agent.md`) inside feature branches.
**The Fix**: 
- Feature branches are treated as Pull Requests for specific lessons. They should contain *only* the code for that lesson.
- All project-wide documentation, curriculum maps, and guidelines must reside in the `main` branch.

### 4. Language Parity
**The Requirement**: Every lesson must be implemented in **both Java and Python**.
- This ensures the curriculum is language-agnostic and demonstrates that architectural patterns apply across different paradigms.
- Ensure the directory structure reflects this: `module-X/problem-Y/java/...` and `module-X/problem-Y/python/...`.

## 🛠️ Operational Workflow (The \"Golden Path\")

### Lesson Implementation Cycle (Git-Centric Approach)
To ensure the pedagogical value of the curriculum, the **Git history must tell the story**. Do not bundle all work into a single commit.

1. **Branch**: `git checkout -b feature/module-X-problem-Y`.
2. **Iteration 1 (The \"Naive\" implementation)**:
    - Implement the problem in **both Java and Python**.
    - Focus on functionality first.
    - Intentionally introduce the anti-pattern. 
    - **COMMIT**: `git add .` -> `git commit -m \"feat: iteration 1 - naive implementation of [Problem Name]\"`
    - **PUSH & PR**: `git push origin feature/module-X-problem-Y` -> `gh pr create` to establish the review baseline.
    - **VERIFICATION**: Verify that the PR has been successfully created before moving to the review phase.
3. **Staff Review (Inline Comments)**:
    - **DO NOT** create `review.md` or other documentation files inside the feature branch.
    - **ACTION**: Use the GitHub API (`gh api`) or GitHub UI to add **inline comments** directly to the Iteration 1 commit in the PR.
    - This mirrors real-world professional code reviews and keeps the repository clean of metadata files.
    - **CONTINUATION**: Once all critical anti-patterns are commented on, proceed immediately to Iteration 2.
4. **Iteration 2 (The \"Production\" implementation)**:
    - Implement the refactor in **both Java and Python** based on the inline review comments.
    - Apply SOLID principles and Design Patterns.
    - **COMMIT**: `git add .` -> `git commit -m \"feat: iteration 2 - production-grade refactor\"`
    - **PUSH**: `git push origin feature/module-X-problem-Y`.
5. **Verification & Finalization**:
    - Run the code to ensure no regressions.
    - Ensure the PR narrative clearly shows the transition from Naive -> Reviewed -> Refactored.

### Network & Connectivity
- **Offline Mode**: This project may be developed in environments with intermittent internet.
- **Constraint**: Do not attempt `git push`, `git pull`, or `fetch_web_content` unless the user explicitly confirms connectivity is restored. Use local commits to track progress.

## 📋 Session Initialization Checklist
Every new session should start by:
1. Reading `Agent.md` to understand the current progress and curriculum.
2. Reading `learn.md` to align with the technical execution guardrails.
3. Running `git status` to verify the current branch and working tree state.
