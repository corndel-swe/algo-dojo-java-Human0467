# Algo Dojo Java

<p align="center">
  <img width="200px" src="src/main/resources/images/logo.png" alt="Algo Dojo Logo" />
</p>

Welcome to the Algo Dojo, your dedicated training ground for battling algorithms and data structures in Java!

This repository provides a collection of common algorithms, implemented and set up for basic testing and performance
benchmarking.

It's a place to explore, understand, and compare different algorithmic approaches.

## Getting Started

First, clone this repository to your local machine:

```bash
git clone <YOUR-REPO-URL>
cd algo-dojo-java
````

You can choose your preferred development environment pick one and follow the steps below.

- **IntelliJ IDEA** (recommended)
- **VSCode & CLI**

### Using IntelliJ IDEA

1. **Import the Project:** Open IntelliJ IDEA and choose "Open" or "Import Project". Navigate to the `algo-dojo-java`
   directory and select its `pom.xml` file. IntelliJ should recognise it as a Maven project and automatically download
   dependencies.
    - If it doesn't execute the `clean` & `install` maven goals. (`Help > Find Action > Execute Maven Goal`)
2. **JMH Benchmarking Plugin:** Install
   the [JMH Benchmarking Plugin](https://plugins.jetbrains.com/plugin/7529-jmh-java-microbenchmark-harness) from
   IntelliJ's plugin marketplace (`File > Settings > Plugins`). Once installed, JMH benchmark classes (those with
   `@Benchmark` annotations and typically located in each package containing "Benchmark" in their name) will be runnable
   directly from the IDE.
    - Look for the orange play button next to the clock icon. You can run the entire benchmark class
      or individual benchmark methods.
3. **Running Tests (JUnit):** The project uses JUnit for unit testing. Navigate to the corresponding test class (e.g.,
   in `src/test/java`), and click the green play button next to the class or method to execute tests.

### Using the CLI & VsCode

This project utilises the **Maven Wrapper** (`./mvnw` on Unix/macOS/Linux, `mvnw.cmd` on Windows). It automatically downloads the correct Maven version for the project, so you don't need a global Maven installation.


1. **Initial Setup and Dependencies:**
   Run the following command from the project root to perform a clean build and download all necessary dependencies:

   ```bash
   ./mvnw clean install
   ```

   This command cleans any previous build artifacts, compiles the code, runs unit tests, and installs the project's
   artifacts into your local Maven repository. This also ensures all external dependencies are downloaded and available.

2. **Running Benchmarks:**
   This project uses the JMH Maven Plugin for benchmark execution.
   To run the benchmarks you will need to build the jar file for the project and then run the jar passing the
   benchmark class as an argument.
    - You will want to do this step each time you work on the repo to keep the jar up to date.

   ```bash
     ./mvnw clean verify
   
     java -jar target/benchmarks.jar SortingBenchmark
   ```

3. **Running Tests (JUnit):**
   To execute all unit tests in the project, run:

   ```bash
   ./mvnw test
   ```

To run specific tests, you can use the `-Dtest` flag (for class names or patterns):

   ```bash
   # Run a specific test class
   ./mvnw test -Dtest=MyAwesomeTest

   # Run multiple test classes
   ./mvnw test -Dtest=MyAwesomeTest,AnotherUnitTest

   # Run all tests in a specific package
   ./mvnw test -Dtest=com.corndel.sorting.*Test
   ```

## Benchmarking && JMH

This project leverages the **Java Microbenchmark Harness (JMH)** to measure and compare the performance of
various algorithm implementations within the dojo.

JMH is a specialised framework designed to help you measure the speed of small pieces of Java code. It
handles complex JVM behaviors (like Just-In-Time compilation, garbage collection, and dead code
elimination) that can distort simple timing measurements, providing reliable benchmark results.

Within JMH benchmarks, the `Blackhole` mechanism prevents the JVM's JIT compiler from optimising away computations whose
results are not explicitly used. By "consuming" the benchmark's output, `Blackhole` ensures the measured code is fully
executed.

Each benchmark class within this project (e.g., `SortingBenchmark`) follows a similar structure, utilising JMH
annotations to define test parameters, manage setup phases, and specify the methods and parameters to be measured.

### Sorting && Interpreting Benchmark Results

The `sorting` package doesn't have any work for you to do, however it does
demonstrate how we can benchmark different solutions to help choose the most
performant one.

Feel free to run the `SortingBenchmark` class.

JMH systematically sets up various test scenarios. For each combination of `arraySize` (1,000 and 10,000 items) and the four sorting methods (Bubble, Insertion, Merge, Quick Sort), a distinct benchmark is prepared.

For each of these specific benchmark scenarios, JMH creates a new, isolated Java process (a "fork"). This ensures that previous tests do not interfere with the current measurement.

Within each fork, JMH first enters a **Warmup Phase**. As configured in the `BenchmarkConfig` class, the `@Benchmark` runs for at least 2 iterations and for a minimum of 1 second, repeatedly. This warming-up is because the JVM's JIT compiler optimises the code during this time, making it run faster based on observed usage patterns. JMH discards the results from this phase.

After the warmup is complete, JMH proceeds to the **Measurement Phase**. Here, the `benchmarkSort` method is executed for actual performance recording, as configured for 2 iterations and at least 2 seconds.

Finally, after all measurement iterations for a specific scenario are complete, JMH calculates the `Average Time` per operation, which forms the core result.

A result table may look something similar to this.

```txt
Benchmark                       (arraySize)        (sorter)  Mode  Cnt          Score   Error  Units
SortingBenchmark.benchmarkSort         1000     BUBBLE_SORT  avgt    2    1208766.102          ns/op
SortingBenchmark.benchmarkSort         1000  INSERTION_SORT  avgt    2      77355.031          ns/op
SortingBenchmark.benchmarkSort         1000      MERGE_SORT  avgt    2      49039.550          ns/op
SortingBenchmark.benchmarkSort         1000      QUICK_SORT  avgt    2      21177.616          ns/op
SortingBenchmark.benchmarkSort        10000     BUBBLE_SORT  avgt    2  145963978.250          ns/op
SortingBenchmark.benchmarkSort        10000  INSERTION_SORT  avgt    2    6743038.553          ns/op
SortingBenchmark.benchmarkSort        10000      MERGE_SORT  avgt    2    1355871.755          ns/op
SortingBenchmark.benchmarkSort        10000      QUICK_SORT  avgt    2     966735.516          ns/op
```
Let's break down the reports columns.

- Benchmark: The specific benchmark method being run.
- (arraySize): The size of the array used in that particular test.
- (sorter): The sorting algorithm being measured in that test.
- Mode: The type of measurement (e.g., avgt for average time per operation).
- Cnt: The number of measurement iterations performed.
- Score: The measured performance result (e.g., average time per operation).
- Error: The statistical uncertainty of the score.
- Units: The units of the score (e.g., ns/op for nanoseconds per operation).

For both array sizes, Quick Sort and Merge Sort significantly outperform Bubble Sort and Insertion Sort, with Quick Sort generally being the fastest and the performance difference becoming more visible for larger arrays.

## Let battle commence

Now that you have an understanding of the Algo Dojo and the tools at your disposal for benchmarking, your training begins!

It's time to don your ceremonial robes, step into the arena and spar with different algorithms, implementing techniques such as brute force, two-pointers, and recursion. 

Move over to [TODO](./TODO.md) to take on your first challenge!