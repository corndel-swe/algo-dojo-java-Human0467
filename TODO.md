# TODOjo

Welcome to the Dojo, warrior!

## Two Pointers

The `two_pointers` package presents a collection of problems that can be solved using either a brute force approach (
involving iteration & nested loops) or a more optimised two-pointer solution.

For each problem in this package, the provided `instructions.md` provides a description, along with
pseudocode/steps for both the brute force and two-pointer implementations solutions.

Your task is to implement each algorithm. Once implemented, run their corresponding unit tests in `src/test` to verify
correctness.

Afterwards, execute the benchmark class in each package to observe and compare the performance difference
between the two approaches.

- [ ] [ArrayFilter](./src/main/java/com/corndel/two_pointers/array_filter/ArrayFilter.java)
- [ ] [ArrayReverser](./src/main/java/com/corndel/two_pointers/array_reverser/ArrayReverser.java)
- [ ] [PairSum](./src/main/java/com/corndel/two_pointers/pair_sum/PairSum.java)
- [ ] [ZeroShifter](./src/main/java/com/corndel/two_pointers/zero_shifter/ZeroShifter.java)
- [ ] [MaxWaterContainer](./src/main/java/com/corndel/two_pointers/max_water_container/MaxWaterContainer.java)

## Trees

When working with trees, we often need to traverse them to modify nodes or aggregate information. In the `trees`
package, you will practice your traversal techniques.

The [task.json](./src/main/resources/data/task.json) file represents a nested tree structure in JSON format, similar to a
response from an external API. 

The [Task](./src/main/java/com/corndel/trees/dto/Task.java) Data Transfer Object defines
the class structure that each method in this package will receive for traversal.

Two common approaches for tree traversal are the "stack" approach (iterative) and the "recursion" approach. (
Technically, the recursive approach uses the call stack internally, making the two conceptually similar, though their
code implementations differ.)

Again, the `instructions.md` provides a description of each solution. Your goal is to implement these
solutions, use the tests in `src/test` to verify your implementations, and use the Benchmark classes to compare
their performance.

- [ ] [TaskCounter](./src/main/java/com/corndel/trees/task_counter/TaskCounter.java)
- [ ] [DoneCounter](./src/main/java/com/corndel/trees/done_counter/DoneCounter.java)
- [ ] [MaxEffortFinder](./src/main/java/com/corndel/trees/max_effort_finder/MaxEffortFinder.java)
- [ ] [EffortTotaller](./src/main/java/com/corndel/trees/effort_totaller/EffortTotaller.java)
- [ ] [MarkAllDone](./src/main/java/com/corndel/trees/mark_all_done/MarkAllDone.java)

## Beyond

This repository offers a taste of applying different algorithmic approaches to two distinct classes of problems. As you
gain more experience working with algorithms, you will come to realise that the same foundational problems tend to
reappear in various forms.