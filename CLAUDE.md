# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Algorithm problem-solving practice in Java, organized by platform/source. No build tool (Maven/Gradle) — this is a plain IntelliJ IDEA module (`algorithm.iml`). Compiled output goes to `out/`.

## Running Code

Each file has its own `main()` method with hardcoded test inputs. Run a single problem directly from IntelliJ or via the command line:

```bash
# Compile
javac -d out src/inflearn_allinone/Part8_Climbing_Stairs.java

# Run (from project root)
java -cp out inflearn_allinone.Part8_Climbing_Stairs
```

Baekjoon problems use `Scanner` for stdin — pipe input when running from terminal:

```bash
echo "5\nbe\nez\naq\ntip\nape" | java -cp out baekjoon.silver.단어정렬_1181
```

## Source Structure

| Package | Platform | Notes |
|---|---|---|
| `inflearn_allinone/` | Inflearn course | Part3–Part8 map to course sections; `replay/` = review passes |
| `programmers/level{1,2,3}/` | Programmers.co.kr | Named by problem number |
| `baekjoon/` | Baekjoon OJ | Subpackages by tier (silver, sprout, …) |
| `hanghae_study_2th/` | Hanghae99 study | Day-by-day study session files |
| `goorm/` | Goorm IDE | Subpackages by topic (dfsbfs, hash, queue, …) |
| `coding_test/` | Company tests | linetech_2021, nhap_practice, cafe24 |
| `dictionary/` | Reference | Canonical implementations of DFS/BFS/PQ/sort/permutation/GCD |

## File Naming Conventions

- `_X` or `_x` suffix — unsolved or incorrect solution (work in progress)
- `inflearn_allinone/Part{N}Test{M}.java` — Nth course section, Mth problem
- `hanghae_study_2th/Day{N}_LV{M}_{id}[_X].java` — study day, Programmers level, problem id
- `programmers/level{N}/test_{id}[_X].java` — problem id from Programmers

## Inflearn Course Section Map

| Part | Topic |
|---|---|
| Part3 | 필수 자료구조 (Data Structures: HashMap, HashSet, two-pointer) |
| Part4 | 재귀 (Recursion / DFS-based search) |
| Part5 | 정렬 / 이진탐색 (Sorting / Binary Search) |
| Part6–7 | 그래프 (BFS / DFS) |
| Part8 | DP (Dynamic Programming) |

## Code Patterns

Each problem file is self-contained — test input is hardcoded in `main()`, and the actual logic is in a `solution()` method. Problems with multiple approaches label them `Solution1`, `Solution2`, etc., with time complexity noted in the Javadoc.

The `dictionary/` package holds clean reference implementations (e.g., `DfsStack.java`, `DfsRecursive.java`, `Bfs.java`, `Pq.java`) — consult these when implementing standard algorithms from scratch.