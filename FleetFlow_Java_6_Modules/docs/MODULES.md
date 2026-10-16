# Module-wise algorithm coverage

| Module | Included topics | Complexity note |
|---|---|---|
| 1. FleetFlow data integration | CSV loading, field lookup, status counts, delivery partner counts | Linear scan per search: O(N) |
| 2. String algorithms | Naive matching, KMP prefix function, Z-function, Rabin–Karp double hash, edit distance | KMP/Z O(n+m); edit distance O(nm) |
| 3. Dynamic programming | Levenshtein, matrix-chain, TSP bitmask, 0/1 knapsack | TSP O(2^n n^2); knapsack O(nW) |
| 4. Network flow | Edmonds–Karp max flow, bipartite matching | Edmonds–Karp O(VE^2) |
| 5. NP-completeness & approximation | Subset sum, vertex cover 2-approximation, LPT scheduling, knapsack | Subset sum O(nT); LPT O(n log n + nm) in this simple implementation |
| 6. Randomized & parallel | Randomized quicksort, Miller–Rabin, reservoir sampling, ForkJoin reduction | Quicksort expected O(n log n); reservoir O(n); reduction work O(n) |

Some topics from the complete syllabus (e.g. SA-IS, Dinic, min-cost flow, Cook–Levin proof, PTAS/FPTAS, scan, suffix automata) are suitable for a future extension; this ZIP prioritizes runnable implementations for a menu-driven college demo.
