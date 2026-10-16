# FleetFlow — Intelligent Logistics Management Platform (Java)

A menu-driven, six-module Advanced Algorithms project. Uses Java only (no external libraries required), with a CSV reader and a dataset folder.

## Dataset source and attribution

The application uses the same general delivery-logistics field schema as the public **Delivery Logistics** dataset published in the GitHub repository below, which describes its source as a Kaggle Indian Delivery Logistics dataset:

- Repository / dataset reference: https://github.com/kabeerK992/india-multi-partner-delivery-dashboard
- Dataset file in that repository: `Delivery_Logistics.csv`
- Related Kaggle dataset reference: https://www.kaggle.com/dsv/9673933 (Logistics and Supply Chain Dataset; CC0 Public Domain listing)

**Important:** The CSV included in this ZIP contains 250 generated demo records so the Java program runs immediately without a Kaggle login or internet access. It is not represented as the original Kaggle CSV. For a project submission requiring the real external data, download the source CSV and replace `data/Delivery_Logistics.csv`. Keep the column names used by the code, or adapt the field names in `DataRepository.java` if the dataset's schema differs.

## Requirements

- JDK 17 or newer recommended (JDK 11+ should work).
- Windows PowerShell, Command Prompt, macOS Terminal, or Linux terminal.
- No Maven/Gradle and no third-party Java libraries needed.

## Run on Windows PowerShell

1. Extract the ZIP.
2. Open PowerShell in the extracted `FleetFlow_Java_6_Modules` folder.
3. Check Java:

```powershell
java -version
javac -version
```

4. Compile all source files:

```powershell
javac -d out src/fleetflow/*.java
```

5. Run the application:

```powershell
java -cp out fleetflow.Main
```

Run with a different CSV path if required:

```powershell
java -cp out fleetflow.Main "data/Delivery_Logistics.csv"
```

## Menu map

1. **Module 1 — FleetFlow data integration:** search Delivery ID, Tracking Code, Destination Address, any CSV field, summary statistics, preview records.
2. **Module 2 — String algorithms:** naive matching, KMP, Z-function, double-hash Rabin–Karp, edit-distance spelling suggestion.
3. **Module 3 — Dynamic programming:** Levenshtein edit distance, matrix-chain multiplication, bitmask TSP, 0/1 knapsack.
4. **Module 4 — Network flow:** Edmonds–Karp maximum flow and bipartite matching.
5. **Module 5 — NP-completeness & approximation:** subset sum, vertex-cover 2-approximation, LPT load balancing, knapsack.
6. **Module 6 — Randomized & parallel algorithms:** randomized quicksort, Miller–Rabin, reservoir sampling, ForkJoin parallel reduction.

## Complexity / scope notes

- This is an educational algorithms demonstration, not a production dispatch system.
- TSP bitmask DP is limited to 12 cities in the menu because its time and memory grow exponentially.
- The vertex-cover approximation uses a maximal-matching style 2-approximation.
- Miller–Rabin uses fixed-seed random bases for repeatable demos; for extremely large values, Java's `BigInteger` is used for modular multiplication.
- The included 250-row demo CSV is synthetic. `tracking_code` and `destination_address` are generated demo fields (not personal/customer data), added so you can demonstrate address and tracking-code searches in the terminal. Do not cite demo outputs as real-world logistics findings.
