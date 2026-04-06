# Train Consist Management App

(App-Based Learning Using Core Java & Data Structures)

## Objective
This project focuses on building a **Train Consist Management System** in Semester 4 using Core Java and Data Structures.
The application simulates how a railway system manages a train consist (collection of bogies attached to an engine).

The application supports:
- Passenger bogies (`Sleeper`, `AC Chair`, `First Class`) with seat capacity tracking
- Goods bogies (`Rectangular`, `Cylindrical`) with cargo type and safety constraints
- Tracking composition, capacity, cargo types, and safety compliance

## Current Status
This repository is set up for incremental use-case based development.
Each use case introduces one or more Java concepts through a realistic railway scenario.

## Directory Structure
```text
TrainConsistManagementApp/
├── README.md
└── App/
    └── src/
```

## UC-1: Initialize Train and Display Consist Summary

### Goal
Initialize the Train Consist Management App and display the initial state of the train.

### Actor
User

### Flow
1. User runs the program.
2. Application prints welcome message.
3. Train consist is initialized.
4. Initial bogie count is displayed.
5. Program continues.

### Key Concepts Used in UC-1
- `Class` - Container for application logic and data.
- `main()` method - Entry point of Java program: `public static void main(String[] args)`.
- `static` keyword - Allows JVM to invoke `main()` without object creation.
- `ArrayList` - Dynamic list used to store bogies.
- `List` interface - Abstraction over list implementations.
- `System.out.println()` - Console output for status/summary.
- Dynamic initialization - Start with empty collection and grow later.

### Key Requirements
- Create a Java class for the Train App.
- Implement `main()` as the entry point.
- Print welcome message:
  `=== Train Consist Management App ===`
- Initialize an empty `List` using `ArrayList`.
- Display initial bogie count using `size()`.

### Reference Code (UC-1)
```java
import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Train initialized successfully...");

        List<String> consist = new ArrayList<>();

        System.out.println("Initial Bogie Count: " + consist.size());
        System.out.println("Current Train Consist: " + consist);
        System.out.println("System ready for operations...");
    }
}
```

### Expected Output Format
```text
=== Train Consist Management App ===
Train initialized successfully...
Initial Bogie Count: 0
Current Train Consist: []
System ready for operations...
```

### Key Benefits
- Introduces application startup flow.
- Shows where execution begins in Java.
- Demonstrates why dynamic collections are preferred over fixed arrays.
- Builds the foundation for all subsequent use cases.

## UC-2: Add Passenger Bogies to Train (ArrayList Operations)

### Drawback of UC-1 Approach
In UC-1, the train consist is initialized but contains no bogies.
There is no way to add, remove, or inspect bogies dynamically.
To simulate a real railway system, the application must support:
- Adding passenger bogies
- Removing bogies
- Checking whether a bogie exists

### Goal
Allow dynamic insertion and removal of passenger bogies using `ArrayList`.

### Actor
User

### Flow
1. User runs program.
2. Passenger bogies are added.
3. Bogies are displayed.
4. A bogie is removed.
5. Existence is checked.
6. Program continues.

### Key Concepts Used in UC-2
- `ArrayList` - Resizable collection supporting runtime insertion/deletion.
- `add()` - Inserts elements in the list.
- `remove()` - Deletes elements from the list.
- `contains()` - Checks whether an element exists.
- Insertion order preservation - `ArrayList` keeps add order.
- CRUD operations - Create, Read, Update, Delete on collections.

### Key Requirements
- Create `ArrayList<String>` for passenger bogies.
- Add bogies: `Sleeper`, `AC Chair`, `First Class`.
- Print list after insertion.
- Remove one bogie (example: `AC Chair`).
- Use `contains()` to check if `Sleeper` exists.
- Print final list state.

### Reference Code (UC-2)
```java
import java.util.ArrayList;
import java.util.List;

public class UseCase2AddPassengerBogies {
    public static void main(String[] args) {
        System.out.println("UC2 Add Passenger Bogies to Train");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies: " + passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies: " + passengerBogies);

        boolean containsSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Checking if 'Sleeper' exists: Contains Sleeper?: " + containsSleeper);
        System.out.println("Final Train Passenger Consist: " + passengerBogies);
        System.out.println("UC2 operations completed successfully...");
    }
}
```

UC-2 file location:
`App/src/UseCase2AddPassengerBogies.java`

### Expected Output Format
```text
UC2 Add Passenger Bogies to Train
After Adding Bogies:
Passenger Bogies: [Sleeper, AC Chair, First Class]
After Removing 'AC Chair':
Passenger Bogies: [Sleeper, First Class]
Checking if 'Sleeper' exists: Contains Sleeper?: true
Final Train Passenger Consist: [Sleeper, First Class]
UC2 operations completed successfully...
```

### Key Benefits
- Demonstrates real-world list management.
- Shows how collections grow dynamically.
- Introduces CRUD behavior on data structures.
- Helps students visualize how bogies are attached and detached.

## UC-3: Track Unique Bogie IDs (Set - HashSet)

### Drawback of UC-2 Approach
In UC-2, bogies are stored in a `List`, which allows duplicate values.
In a railway system, duplicate bogie IDs are unsafe and violate business rules.
Example invalid case:
`BG101, BG101`

To enforce uniqueness, UC-3 introduces the `Set` data structure.

### Goal
Ensure no duplicate bogie IDs are added to the train.

### Actor
User

### Flow
1. User adds bogie IDs.
2. System inserts IDs into `HashSet`.
3. Duplicates are ignored automatically.
4. Unique bogie IDs are displayed.

### Key Concepts Used in UC-3
- `Set` interface - Collection type that does not allow duplicates.
- `HashSet` - `Set` implementation using hashing for fast operations.
- `add()` - Inserts values into the set.
- Automatic deduplication - Duplicate values are ignored.
- Unordered storage - No index-based insertion order guarantee.

### Key Requirements
- Create `HashSet<String>` for bogie IDs.
- Add duplicate values intentionally.
- Print the final set.
- Observe that duplicates are removed automatically.

### Reference Code (UC-3)
```java
import java.util.HashSet;
import java.util.Set;

public class UseCase3TrackUniqueBogieIds {
    public static void main(String[] args) {
        System.out.println("UC3 Track Unique Bogie IDs -");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG104");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogieIds);
        System.out.println("Note:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed...");
    }
}
```

UC-3 file location:
`App/src/UseCase3TrackUniqueBogieIds.java`

### Expected Output Format
```text
UC3 Track Unique Bogie IDs -
Bogie IDs After Insertion:
[BG104, BG103, BG102, BG101]
Note:
Duplicates are automatically ignored by HashSet.
UC3 uniqueness validation completed...
```

Note: `HashSet` output order is not guaranteed, but duplicates will always be removed.

### Key Benefits
- Enforces business constraints.
- Prevents data corruption.
- Teaches when to use `Set` instead of `List`.
- Introduces uniqueness as a real-world requirement.

## IntelliJ Setup
1. Open the `STEP` repository in IntelliJ IDEA.
2. Navigate to `SEM-4/TrainConsistManagementApp/App/src`.
3. Add Java classes and run from IntelliJ as the project evolves.
