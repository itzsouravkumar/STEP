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

## UC-4: Maintain Ordered Bogie IDs (TreeSet & SortedSet)

### Drawback of UC-3 Approach
In UC-3, uniqueness is handled with `HashSet`, but `HashSet` does not preserve order.
Train composition must follow a physical sequence:
`Locomotive -> Passenger -> Cargo -> Guard Coach`

So we need a structure that supports ordered chaining and efficient insertion/deletion.
For this use case, `LinkedList` is used.

### Goal
Maintain ordered bogie composition while supporting efficient insertion/removal operations.

### Actor
User

### Flow
1. User adds bogies to the train consist.
2. System stores bogies in a `LinkedList`.
3. Pantry Car is inserted in the middle.
4. First and last bogies are removed.
5. Final ordered consist is displayed.

### Key Concepts Used in UC-4
- `LinkedList` - Doubly linked list implementation of `List`.
- Node structure concept - Each element links to previous/next nodes.
- `addFirst()` / `addLast()` - Attach bogies at ends.
- `add(index, element)` - Insert bogie in middle.
- `removeFirst()` / `removeLast()` - Detach from head/tail.
- Order preservation - Maintains physical train sequence.

### Key Requirements
- Create `LinkedList<String>` for consist.
- Add bogies: `Engine`, `Sleeper`, `AC`, `Cargo`, `Guard`.
- Insert `Pantry Car` at position `2`.
- Remove first and last bogie.
- Display final ordered consist.

### Reference Code (UC-4)
```java
import java.util.LinkedList;

public class UseCase4MaintainOrderedBogieConsist {
    public static void main(String[] args) {
        System.out.println("UC4 Maintain Ordered Bogie Consist -");
        System.out.println("=");

        LinkedList<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        trainConsist.add(2, "Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);

        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist);

        System.out.println("UC4 ordered consist operations completed...");
    }
}
```

UC-4 file location:
`App/src/UseCase4MaintainOrderedBogieConsist.java`

### Expected Output Format
```text
UC4 Maintain Ordered Bogie Consist -
=
Initial Train Consist:
[Engine, Sleeper, AC, Cargo, Guard]
After Inserting 'Pantry Car' at position 2:
[Engine, Sleeper, Pantry Car, AC, Cargo, Guard]
After Removing First and Last Bogie:
[Sleeper, Pantry Car, AC, Cargo]
UC4 ordered consist operations completed...
```

### Key Benefits
- Models real-world chaining behavior.
- Teaches when `LinkedList` is better than `ArrayList`.
- Demonstrates insertion/deletion efficiency.
- Helps visualize node-based structures.

## UC-5: Preserve Insertion Order of Bogies (LinkedHashSet)

### Drawback of UC-4 Approach
In UC-4, sequence is maintained using `LinkedList`.
However, when uniqueness is also required for train formation, plain list-based structures can still allow duplicates unless manually validated.
We need a structure that:
- Preserves attachment order
- Prevents duplicate bogies automatically

This use case introduces `LinkedHashSet`.

### Goal
Maintain insertion order while enforcing uniqueness.

### Actor
User

### Flow
1. User adds bogies.
2. `LinkedHashSet` stores the formation.
3. Duplicate entries are ignored.
4. Formation is printed in original insertion order.

### Key Concepts Used in UC-5
- `LinkedHashSet` - Unique elements + insertion order preservation.
- `Set` interface - Prevents duplicates by design.
- `add()` - Adds bogies; duplicate add is ignored.
- Automatic deduplication - No manual duplicate check needed.
- Ordered iteration - Prints in actual insertion sequence.

### Key Requirements
- Create `LinkedHashSet<String>` to represent train formation.
- Attach bogies: `Engine`, `Sleeper`, `Cargo`, `Guard`.
- Try duplicate insertion (e.g., `Sleeper` again).
- Print final formation using `System.out.println()`.
- Ensure output has no duplicate bogies.

### Reference Code (UC-5)
```java
import java.util.LinkedHashSet;
import java.util.Set;

public class UseCase5PreserveInsertionOrderBogies {
    public static void main(String[] args) {
        System.out.println("UC5 Preserve Insertion Order of Bogies");

        Set<String> trainFormation = new LinkedHashSet<>();
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(trainFormation);
        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println("UC5 formation setup completed...");
    }
}
```

UC-5 file location:
`App/src/UseCase5PreserveInsertionOrderBogies.java`

### Expected Output Format
```text
UC5 Preserve Insertion Order of Bogies
Final Train Formation:
[Engine, Sleeper, Cargo, Guard]
Note:
LinkedHashSet preserves insertion order and removes duplicates automatically.
UC5 formation setup completed...
```

### Key Benefits
- Enforces real-world business rules by preventing duplicate bogies.
- Preserves physical attachment sequence of the train.
- Demonstrates ordering plus uniqueness in one data structure.
- Builds foundation for safe and predictable train composition.

## UC-6: Map Bogie to Capacity (HashMap)

### Drawback of UC-5 Approach
In UC-5, formation uses bogie names with ordering and uniqueness.
But real railway operation requires each bogie to carry operational attributes:
- Seating capacity for passenger bogies
- Load capacity for goods bogies
- Safety-related limits

A flat set of names cannot store this associated data.

### Goal
Associate each bogie with seating/load capacity using key-value mapping.

### Actor
User

### Flow
1. User creates bogie-capacity mapping.
2. System stores bogie names as keys and capacities as values.
3. Entries are inserted into `HashMap`.
4. System iterates over `entrySet()`.
5. Capacity details are displayed.
6. Program continues.

### Key Concepts Used in UC-6
- `HashMap` - Key-value storage for bogie and capacity.
- `Map` interface - Represents mapping between unique keys and values.
- `put()` - Inserts bogie-capacity pairs.
- Key-value association - Binds each bogie to its property.
- `entrySet()` iteration - Accesses key and value together.
- Fast lookup by key - Efficient retrieval for validation/planning.

### Key Requirements
- Create `HashMap<String, Integer>` for bogie capacities.
- Insert values for `Sleeper`, `AC Chair`, `First Class`, `Cargo`.
- Use `put()` for insertion.
- Iterate with `entrySet()`.
- Print each bogie with its capacity.

### Reference Code (UC-6)
```java
import java.util.HashMap;
import java.util.Map;

public class UseCase6MapBogieToCapacity {
    public static void main(String[] args) {
        System.out.println("==");
        System.out.println("UC6 Map Bogie to Capacity (HashMap)");

        Map<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Cargo", 120);
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);

        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("UC6 bogie-capacity mapping completed...");
    }
}
```

UC-6 file location:
`App/src/UseCase6MapBogieToCapacity.java`

### Expected Output Format
```text
==
UC6 Map Bogie to Capacity (HashMap)
Bogie Capacity Details:
First Class -> 24
Cargo -> 120
Sleeper -> 72
AC Chair -> 56
UC6 bogie-capacity mapping completed...
```

Note: `HashMap` iteration order is not guaranteed.

### Key Benefits
- Models real-world attribute mapping in software systems.
- Introduces key-value representation over flat collections.
- Enables fast lookup and validation of bogie properties.
- Builds foundation for analytics and planning in later use cases.

## UC-7: Sort Bogies by Capacity (Comparator)

### Drawback of UC-6 Approach
UC-6 stores bogies with capacities, but does not rank or order them for planning.
Railway operations often need capacity-based ordering to prioritize utilization and reporting.

### Goal
Sort passenger bogies by seating capacity using custom comparator logic.

### Actor
User

### Flow
1. User creates passenger bogie objects.
2. Bogies are stored in a `List`.
3. System applies `Comparator` sorting by capacity.
4. Sorted bogies are displayed.
5. Program continues.

### Key Concepts Used in UC-7
- `Comparator` interface - Custom business-rule sorting logic.
- Custom objects - Bogies modeled with `name` and `capacity`.
- `List` collection - Dynamic storage for multiple objects.
- `sort()` - Reorders list using comparator logic.
- Lambda/method references - Concise comparison expression.
- Separation of data and behavior - Cleaner maintainability.

### Key Requirements
- Create a `Bogie` class with `name` and `capacity`.
- Create `List<Bogie>` for passenger bogies.
- Add `Sleeper`, `AC Chair`, `First Class`, `General`.
- Use `Comparator.comparingInt()` for capacity sorting.
- Display before and after sorting.

### Reference Code (UC-7)
```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UseCase7SortBogiesByCapacity {
    private static class Bogie {
        private final String name;
        private final int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("UC7 Sort Bogies by Capacity (Comparator)");

        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }

        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("After Sorting by Capacity:");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }

        System.out.println("UC7 sorting completed...");
    }
}
```

UC-7 file location:
`App/src/UseCase7SortBogiesByCapacity.java`

### Expected Output Format
```text
UC7 Sort Bogies by Capacity (Comparator)
Before Sorting:
Sleeper -> 72
AC Chair -> 56
First Class -> 24
General -> 90
After Sorting by Capacity:
First Class -> 24
AC Chair -> 56
Sleeper -> 72
General -> 90
UC7 sorting completed...
```

### Key Benefits
- Introduces object-based collection handling over primitive strings.
- Applies business rules using custom sorting.
- Improves planning and capacity analysis.
- Prepares students for enterprise collection processing.

## UC-8: Filter Passenger Bogies Using Streams

### Drawback of UC-7 Approach
UC-7 sorts bogies, but does not support conditional selection based on business rules.
Railway admins often need filtered views, such as only high-capacity bogies.
Traditional loops are verbose and mix iteration details with business logic.

### Goal
Filter passenger bogies using Stream pipelines based on seating capacity.

### Actor
User

### Flow
1. User creates a list of bogies.
2. System converts list to stream.
3. `filter()` is applied with capacity condition.
4. Matching bogies are collected to a new list.
5. Filtered bogies are displayed.
6. Program continues.

### Key Concepts Used in UC-8
- Stream API - Declarative collection processing.
- `stream()` - Builds stream pipeline from list.
- `filter()` - Selects elements matching condition.
- Lambda expressions - Concise rule definition.
- `collect(toList())` - Converts pipeline result to list.
- Declarative style - Focuses on business intent over loop mechanics.

### Key Requirements
- Reuse Bogie object style from UC-7.
- Create stream from bogie list.
- Apply condition: `b.capacity > 60`.
- Collect into a new list.
- Display filtered bogies.

### Reference Code (UC-8)
```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase8FilterPassengerBogiesUsingStreams {
    static class Bogie {
        private final String name;
        private final int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static List<Bogie> filterByCapacityGreaterThan(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("UC8 Filter Passenger Bogies Using Streams -");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        List<Bogie> filtered = filterByCapacityGreaterThan(bogies, 60);
        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie bogie : filtered) {
            System.out.println(bogie);
        }

        System.out.println("UC8 filtering completed...");
    }
}
```

UC-8 file location:
`App/src/UseCase8FilterPassengerBogiesUsingStreams.java`

### Expected Output Format
```text
UC8 Filter Passenger Bogies Using Streams -
All Bogies:
Sleeper -> 72
AC Chair -> 56
First Class -> 24
General -> 90
Filtered Bogies (Capacity > 60):
Sleeper -> 72
General -> 90
UC8 filtering completed...
```

### Suggested Test Cases
- `testFilter_CapacityGreaterThanThreshold()`
- `testFilter_CapacityEqualToThreshold()`
- `testFilter_CapacityLessThanThreshold()`
- `testFilter_MultipleBogiesMatching()`
- `testFilter_NoBogiesMatching()`
- `testFilter_AllBogiesMatching()`
- `testFilter_EmptyBogieList()`
- `testFilter_OriginalListUnchanged()`

### Key Benefits
- Reduces boilerplate iteration code.
- Improves readability of business filtering rules.
- Introduces functional-style Java programming.
- Strengthens maintainable collection processing skills.

## UC-9: Group Bogies by Type (Collectors.groupingBy)

### Drawback of UC-8 Approach
UC-8 filters bogies but still returns a flat list.
Operational reporting often needs categorized structure (by bogie type/class), not flat output.

### Goal
Group bogies into categories using stream collectors.

### Actor
User

### Flow
1. User creates a list of bogies.
2. System converts list into stream.
3. `Collectors.groupingBy()` is applied.
4. Bogies are grouped into `Map<String, List<Bogie>>`.
5. Grouped result is displayed.
6. Program continues.

### Key Concepts Used in UC-9
- `Collectors.groupingBy()` - Classifies elements by key.
- Stream pipeline - Transforms list to grouped map.
- `Map<String, List<Bogie>>` output structure.
- Lambda/method reference classification logic.
- Data aggregation into logical clusters.
- Structured transformation for reporting.

### Key Requirements
- Reuse Bogie object list.
- Create stream using `stream()`.
- Apply `Collectors.groupingBy()` by bogie type.
- Store result in `Map<String, List<Bogie>>`.
- Print grouped structure.

### Reference Code (UC-9)
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9GroupBogiesByType {
    static class Bogie {
        private final String type;
        private final int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static Map<String, List<Bogie>> groupByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }

    public static void main(String[] args) {
        System.out.println("UC9 - Group Bogies by Type");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        Map<String, List<Bogie>> grouped = groupByType(bogies);
        System.out.println("Grouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey());
            for (Bogie bogie : entry.getValue()) {
                System.out.println("Capacity -> " + bogie.getCapacity());
            }
        }

        System.out.println("UC9 grouping completed...");
    }
}
```

UC-9 file location:
`App/src/UseCase9GroupBogiesByType.java`

### Expected Output Format
```text
UC9 - Group Bogies by Type
All Bogies:
Sleeper -> 72
AC Chair -> 56
First Class -> 24
Sleeper -> 70
AC Chair -> 60
Grouped Bogies:
Bogie Type: First Class
Capacity -> 24
Bogie Type: Sleeper
Capacity -> 72
Capacity -> 70
Bogie Type: AC Chair
Capacity -> 56
Capacity -> 60
UC9 grouping completed...
```

### Suggested Test Cases
- `testGrouping_BogiesGroupedByType()`
- `testGrouping_MultipleBogiesInSameGroup()`
- `testGrouping_DifferentBogieTypes()`
- `testGrouping_EmptyBogieList()`
- `testGrouping_SingleBogieCategory()`
- `testGrouping_MapContainsCorrectKeys()`
- `testGrouping_GroupSizeValidation()`
- `testGrouping_OriginalListUnchanged()`

### Key Benefits
- Converts flat data into meaningful grouped structure.
- Supports operational reporting and monitoring.
- Introduces advanced stream collectors.
- Builds foundation for dashboards and analytics.

## UC-10: Count Total Seats in Train (reduce)

### Drawback of UC-9 Approach
UC-9 groups bogies, but grouped structure alone does not provide numeric metrics.
Railway planning needs total seating capacity for operational decisions and utilization forecasting.

### Goal
Aggregate seating capacities into one total value using stream reduction.

### Actor
User

### Flow
1. User creates a list of bogies.
2. System converts list into stream.
3. `map()` extracts capacities.
4. `reduce()` sums capacities.
5. Total seating capacity is displayed.
6. Program continues.

### Key Concepts Used in UC-10
- `map()` - Transforms Bogie objects into numeric capacities.
- `reduce()` - Aggregates multiple values into one result.
- Method reference (`Integer::sum`) for concise aggregation.
- Functional aggregation over imperative loops.
- Stream pipeline combining transformation + reduction.
- Numeric analytics for operational metrics.

### Key Requirements
- Reuse Bogie object list.
- Create stream using `stream()`.
- Apply `map(b -> b.capacity)` logic.
- Use `reduce(0, Integer::sum)` for total.
- Display total seating capacity.

### Reference Code (UC-10)
```java
import java.util.ArrayList;
import java.util.List;

public class UseCase10CountTotalSeatsInTrain {
    static class Bogie {
        private final String name;
        private final int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static int totalSeatingCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("UC10 Count Total Seats in Train -");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }

        int total = totalSeatingCapacity(bogies);
        System.out.println("Total Seating Capacity of Train: " + total);
        System.out.println("UC10 aggregation completed...");
    }
}
```

UC-10 file location:
`App/src/UseCase10CountTotalSeatsInTrain.java`

### Expected Output Format
```text
UC10 Count Total Seats in Train -
Bogies in Train:
Sleeper -> 72
AC Chair -> 56
First Class -> 24
Sleeper -> 70
Total Seating Capacity of Train: 222
UC10 aggregation completed...
```

### Suggested Test Cases
- `testReduce_TotalSeatCalculation()`
- `testReduce_MultipleBogiesAggregation()`
- `testReduce_SingleBogieCapacity()`
- `testReduce_EmptyBogieList()`
- `testReduce_CorrectCapacityExtraction()`
- `testReduce_AllBogiesIncluded()`
- `testReduce_OriginalListUnchanged()`

### Key Benefits
- Introduces aggregation in functional style.
- Provides quantitative metrics for planning.
- Replaces error-prone manual summation loops.
- Builds foundation for advanced analytics use cases.

## UC-11: Validate Train ID & Cargo Codes (Regex)

### Drawback of UC-10 Approach
UC-10 computes metrics assuming input is already valid.
In real operations, malformed IDs and cargo codes are common and can corrupt downstream processes.

### Goal
Validate Train ID and Cargo Code formats using regex (`Pattern` and `Matcher`).

### Actor
User

### Flow
1. User enters Train ID and Cargo Code.
2. System compiles regex patterns.
3. `Matcher` checks input against patterns.
4. Valid/invalid result is shown.
5. Program continues.

### Key Concepts Used in UC-11
- Regex format rules (`TRN-\\d{4}`, `PET-[A-Z]{2}`)
- `Pattern` class for compiled regex
- `Matcher` class for applying regex on input
- `matches()` for full-string validation
- Input format enforcement before processing
- Data integrity protection

### Key Requirements
- Train ID pattern: `TRN-\\d{4}`
- Cargo code pattern: `PET-[A-Z]{2}`
- Compile patterns via `Pattern`
- Use `Matcher` + `matches()`
- Display validation results

### Reference Code (UC-11)
```java
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseCase11ValidateTrainIdAndCargoCode {
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    public static boolean isValidTrainId(String trainId) {
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("UC11 Validate Train ID and Cargo Code -");
        System.out.println("Enter Train ID (Format: TRN-1234):");
        String trainId = scanner.nextLine();

        System.out.println("Enter Cargo Code (Format: PET-AB):");
        String cargoCode = scanner.nextLine();

        boolean trainIdValid = isValidTrainId(trainId);
        boolean cargoCodeValid = isValidCargoCode(cargoCode);

        System.out.println("Validation Results:");
        System.out.println("Train ID Valid: " + trainIdValid);
        System.out.println("Cargo Code Valid: " + cargoCodeValid);
        System.out.println("UC11 validation completed...");
    }
}
```

UC-11 file location:
`App/src/UseCase11ValidateTrainIdAndCargoCode.java`

### Expected Output Format
```text
UC11 Validate Train ID and Cargo Code -
Enter Train ID (Format: TRN-1234):
TRN-6524
Enter Cargo Code (Format: PET-AB):
PET-FH
Validation Results:
Train ID Valid: true
Cargo Code Valid: true
UC11 validation completed...
```

### Suggested Test Cases
- `testRegex_ValidTrainID()`
- `testRegex_InvalidTrainIDFormat()`
- `testRegex_ValidCargoCode()`
- `testRegex_InvalidCargoCodeFormat()`
- `testRegex_TrainIDDigitLengthValidation()`
- `testRegex_CargoCodeUppercaseValidation()`
- `testRegex_EmptyInputHandling()`
- `testRegex_ExactPatternMatch()`

### Key Benefits
- Ensures correctness of operational input.
- Prevents malformed data from corrupting workflows.
- Introduces enterprise-grade regex validation.
- Builds robust input-handling foundation.

## UC-12: Safety Compliance Check for Goods Bogies

### Drawback of UC-11 Approach
Earlier use cases process goods bogies without enforcing domain-specific safety rules.
This is risky because cylindrical bogies should carry only liquid cargo like petroleum.
Without validation, unsafe train formation can pass silently.

### Goal
Encapsulate goods-bogie safety rules and validate them declaratively using streams.

### Actor
User

### Flow
1. User prepares goods bogie list.
2. System converts list into stream.
3. `allMatch()` applies safety condition.
4. Cylindrical bogies are checked for allowed cargo.
5. System marks train as safe/unsafe.
6. Program continues.

### Key Concepts Used in UC-12
- Streams API for declarative validation
- `allMatch()` for complete compliance checks
- Lambda-based business-rule predicates
- Conditional logic inside stream pipeline
- Short-circuit behavior for fast failure
- Domain safety policy modeling in code

### Key Requirements
- Create goods bogie collection with `type` and `cargo`.
- Stream the collection.
- Use `allMatch()` to validate each bogie.
- Rule: `Cylindrical` bogie must carry only `Petroleum`.
- Store result in boolean and display status.

### Reference Code (UC-12)
```java
import java.util.ArrayList;
import java.util.List;

public class UseCase12SafetyComplianceGoodsBogies {
    static class GoodsBogie {
        private final String type;
        private final String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static boolean isSafetyCompliant(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b ->
                !b.getType().equalsIgnoreCase("Cylindrical")
                        || b.getCargo().equalsIgnoreCase("Petroleum"));
    }

    public static void main(String[] args) {
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie bogie : goodsBogies) {
            System.out.println(bogie);
        }

        boolean safe = isSafetyCompliant(goodsBogies);
        System.out.println("Safety Compliance Status: " + safe);
        if (safe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("UC12 safety validation completed...");
    }
}
```

UC-12 file location:
`App/src/UseCase12SafetyComplianceGoodsBogies.java`

### Expected Output Format
```text
UC12 - Safety Compliance Check for Goods Bogies
Goods Bogies in Train:
Cylindrical -> Petroleum
Open -> Coal
Box -> Grain
Cylindrical -> Coal
Safety Compliance Status: false
Train formation is NOT SAFE.
UC12 safety validation completed...
```

### Suggested Test Cases
- `testSafety_AllBogiesValid()`
- `testSafety_CylindricalWithInvalidCargo()`
- `testSafety_NonCylindricalBogiesAllowed()`
- `testSafety_MixedBogiesWithViolation()`
- `testSafety_EmptyBogieList()`

### Key Benefits
- Enforces real-world safety constraints in code.
- Prevents unsafe cargo configurations early.
- Replaces manual validations with declarative stream rules.
- Improves reliability of train formation logic.

## UC-13: Performance Comparison (Loops vs Streams)

### Drawback of UC-12 Approach
UC-12 uses streams for readability and concise safety checks, but it does not measure runtime behavior.
For large train datasets with frequent filtering and validation, assumptions about speed can be misleading.
Without performance measurement:
- Developers optimize blindly.
- Stream and loop tradeoffs remain unclear.
- Decisions become style-driven instead of evidence-driven.

### Goal
Compare loop-based and stream-based filtering performance using `System.nanoTime()`.

### Actor
User

### Flow
1. User prepares a collection of bogies.
2. System records start time using `System.nanoTime()`.
3. Filtering is executed using loop logic.
4. System records elapsed loop duration.
5. Filtering is executed using stream logic.
6. System records elapsed stream duration.
7. Execution times are displayed and results are compared.
8. Program continues.

### Key Concepts Used in UC-13
- `System.nanoTime()` for high-resolution execution-time measurement.
- Performance benchmarking for small code blocks.
- Loop-based filtering using imperative iteration.
- Stream-based filtering using declarative pipeline (`filter`, `collect`).
- Micro-measurement awareness for runtime decisions.
- Evidence-driven optimization mindset.

### Key Requirements
- Create a bogie collection for performance testing.
- Capture start and end timestamps with `System.nanoTime()`.
- Run loop-based filtering and stream-based filtering.
- Compute elapsed time using `(end - start)`.
- Display execution duration for both approaches.
- Confirm both approaches return consistent filtered results.

### Reference Code (UC-13)
```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13PerformanceComparisonLoopsVsStreams {
    static class Bogie {
        private final String name;
        private final int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static List<Bogie> filterUsingLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> filteredBogies = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > threshold) {
                filteredBogies.add(bogie);
            }
        }
        return filteredBogies;
    }

    public static List<Bogie> filterUsingStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(bogie -> bogie.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static List<Bogie> createBogieDataset(int size) {
        List<Bogie> bogies = new ArrayList<>();
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General"};

        for (int i = 0; i < size; i++) {
            String type = bogieTypes[i % bogieTypes.length];
            int capacity = 40 + (i % 80);
            bogies.add(new Bogie(type, capacity));
        }

        return bogies;
    }

    public static void main(String[] args) {
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");

        int capacityThreshold = 60;
        List<Bogie> bogies = createBogieDataset(200000);

        System.out.println("Total Bogies Prepared: " + bogies.size());
        System.out.println("Filtering Rule: Capacity > " + capacityThreshold);

        long loopStart = System.nanoTime();
        List<Bogie> loopFiltered = filterUsingLoop(bogies, capacityThreshold);
        long loopEnd = System.nanoTime();
        long loopElapsed = loopEnd - loopStart;

        long streamStart = System.nanoTime();
        List<Bogie> streamFiltered = filterUsingStream(bogies, capacityThreshold);
        long streamEnd = System.nanoTime();
        long streamElapsed = streamEnd - streamStart;

        System.out.println("Loop Filtered Bogies: " + loopFiltered.size());
        System.out.println("Stream Filtered Bogies: " + streamFiltered.size());
        System.out.println("Execution Time (Loop): " + loopElapsed + " ns");
        System.out.println("Execution Time (Stream): " + streamElapsed + " ns");
        System.out.println("Results Match: " + (loopFiltered.size() == streamFiltered.size()));
        System.out.println("UC13 benchmarking completed...");
    }
}
```

UC-13 file locations:
`App/src/UseCase13PerformanceComparisonLoopsVsStreams.java`
`App/src/UseCase13PerformanceComparisonLoopsVsStreamsTest.java`

### Expected Output Format
```text
UC13 - Performance Comparison (Loops vs Streams)
Total Bogies Prepared: 200000
Filtering Rule: Capacity > 60
Loop Filtered Bogies: 147500
Stream Filtered Bogies: 147500
Execution Time (Loop): 9157000 ns
Execution Time (Stream): 12298000 ns
Results Match: true
UC13 benchmarking completed...
```

### Suggested Test Cases
- `testLoopFilteringLogic()`
- `testStreamFilteringLogic()`
- `testLoopAndStreamResultsMatch()`
- `testExecutionTimeMeasurement()`
- `testLargeDatasetProcessing()`

### Key Benefits
- Introduces practical performance benchmarking in Java.
- Compares imperative and declarative filtering styles with evidence.
- Prevents premature optimization assumptions.
- Builds measurement-driven development habits.

## UC-14: Handle Invalid Bogie Capacity (Custom Exception)

### Drawback of UC-13 Approach
UC-13 compares performance but assumes all bogie data is valid.
In real train systems, invalid values like zero or negative capacity may enter from user input or corrupted data.
If invalid capacities are accepted:
- Passenger allocation becomes incorrect.
- Safety and reporting logic become unreliable.
- Defects propagate silently into later use cases.

### Goal
Prevent invalid passenger bogies from being created by enforcing capacity validation with a custom exception.

### Actor
User

### Flow
1. User attempts to create a passenger bogie.
2. System validates bogie capacity.
3. If capacity is less than or equal to zero, custom exception is thrown.
4. If capacity is valid, bogie is created successfully.
5. Program continues safely.

### Key Concepts Used in UC-14
- Custom exception (`InvalidCapacityException`) for domain-specific validation failure.
- Exception inheritance using `extends Exception`.
- `throw` keyword to raise business-rule violations.
- `throws` declaration in constructor signature.
- Fail-fast validation to reject invalid objects at creation time.
- Business rule enforcement inside domain model.

### Key Requirements
- Create `InvalidCapacityException` class.
- Validate capacity inside passenger bogie constructor.
- Throw exception when capacity is less than or equal to zero.
- Declare constructor with `throws InvalidCapacityException`.
- Ensure invalid bogies are never added to train consist.

### Reference Code (UC-14)
```java
import java.util.ArrayList;
import java.util.List;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class UseCase14HandleInvalidBogieCapacity {
    static class PassengerBogie {
        private final String type;
        private final int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return type + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("UC14 - Handle Invalid Bogie Capacity (Custom Exception)");

        List<PassengerBogie> consist = new ArrayList<>();

        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            consist.add(sleeper);
            System.out.println("Added: " + sleeper);
        } catch (InvalidCapacityException e) {
            System.out.println("Error while adding Sleeper bogie: " + e.getMessage());
        }

        try {
            PassengerBogie invalid = new PassengerBogie("AC Chair", 0);
            consist.add(invalid);
            System.out.println("Added: " + invalid);
        } catch (InvalidCapacityException e) {
            System.out.println("Error while adding AC Chair bogie: " + e.getMessage());
        }

        System.out.println("Final Passenger Bogies in Train:");
        for (PassengerBogie bogie : consist) {
            System.out.println(bogie);
        }
        System.out.println("UC14 exception handling completed...");
    }
}
```

UC-14 file locations:
`App/src/UseCase14HandleInvalidBogieCapacity.java`
`App/src/UseCase14HandleInvalidBogieCapacityTest.java`

### Expected Output Format
```text
UC14 - Handle Invalid Bogie Capacity (Custom Exception)
Added: Sleeper -> 72
Error while adding AC Chair bogie: Capacity must be greater than zero
Final Passenger Bogies in Train:
Sleeper -> 72
UC14 exception handling completed...
```

### Suggested Test Cases
- `testException_ValidCapacityCreation()`
- `testException_NegativeCapacityThrowsException()`
- `testException_ZeroCapacityThrowsException()`
- `testException_ExceptionMessageValidation()`
- `testException_ObjectIntegrityAfterCreation()`
- `testException_MultipleValidBogiesCreation()`

### Key Benefits
- Protects train consist from invalid passenger data.
- Encapsulates validation into the domain object.
- Introduces checked exception handling clearly.
- Encourages defensive and fail-fast programming.
- Prevents downstream failures in later use cases.

## UC-15: Safe Cargo Assignment Using try-catch-finally

### Drawback of UC-14 Approach
UC-14 validates bogies during object creation, but runtime operations can still introduce unsafe states.
In real railway workflows, cargo assignment happens dynamically and invalid combinations can be selected during execution.
Without runtime exception handling:
- Application flow can terminate abruptly.
- Error feedback becomes unclear.
- Cleanup and mandatory logging may be skipped.

### Goal
Safely handle unsafe cargo assignment attempts without crashing the Train Consist Management App.

### Actor
User

### Flow
1. User attempts to assign cargo to a goods bogie.
2. System validates shape-cargo compatibility.
3. If unsafe combination is detected, exception is thrown.
4. Exception is caught in `catch` block.
5. Error message is displayed.
6. `finally` block executes completion logging.
7. Program continues safely.

### Key Concepts Used in UC-15
- `try-catch-finally` for structured exception handling.
- Runtime exception handling during operational logic.
- Custom runtime exception (`CargoSafetyException`).
- `throw` for signaling unsafe conditions.
- Graceful failure handling without application crash.
- `finally` for mandatory completion logging.

### Key Requirements
- Create custom runtime exception class `CargoSafetyException`.
- Validate cargo-shape compatibility before assignment.
- Throw exception when petroleum is assigned to rectangular bogie.
- Catch exception inside assignment logic.
- Use `finally` block for completion logging.
- Ensure program continues after a failure.

### Reference Code (UC-15)
```java
public class UseCase15SafeCargoAssignmentUsingTryCatchFinally {
    static class CargoSafetyException extends RuntimeException {
        CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        private final String shape;
        private String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
            this.cargo = "Unassigned";
        }

        public String getShape() {
            return shape;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return shape + " -> " + cargo;
        }
    }

    public static boolean assignCargoSafely(GoodsBogie bogie, String cargo) {
        try {
            validateCargoCompatibility(bogie, cargo);
            bogie.setCargo(cargo);
            System.out.println("Cargo assigned successfully: " + bogie);
            return true;
        } catch (CargoSafetyException e) {
            System.out.println("Cargo assignment failed: " + e.getMessage());
            return false;
        } finally {
            System.out.println("Cargo assignment validation completed for: " + bogie.getShape());
        }
    }

    private static void validateCargoCompatibility(GoodsBogie bogie, String cargo) {
        if (bogie.getShape().equalsIgnoreCase("Rectangular")
                && cargo.equalsIgnoreCase("Petroleum")) {
            throw new CargoSafetyException("Petroleum cannot be assigned to Rectangular bogie");
        }
    }

    public static void main(String[] args) {
        System.out.println("UC15 - Safe Cargo Assignment Using try-catch-finally");

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        GoodsBogie open = new GoodsBogie("Open");

        assignCargoSafely(cylindrical, "Petroleum");
        assignCargoSafely(rectangular, "Petroleum");
        assignCargoSafely(open, "Coal");

        System.out.println("Final Goods Bogies State:");
        System.out.println(cylindrical);
        System.out.println(rectangular);
        System.out.println(open);
        System.out.println("UC15 runtime exception handling completed...");
    }
}
```

UC-15 file locations:
`App/src/UseCase15SafeCargoAssignmentUsingTryCatchFinally.java`
`App/src/UseCase15SafeCargoAssignmentUsingTryCatchFinallyTest.java`

### Expected Output Format
```text
UC15 - Safe Cargo Assignment Using try-catch-finally
Cargo assigned successfully: Cylindrical -> Petroleum
Cargo assignment validation completed for: Cylindrical
Cargo assignment failed: Petroleum cannot be assigned to Rectangular bogie
Cargo assignment validation completed for: Rectangular
Cargo assigned successfully: Open -> Coal
Cargo assignment validation completed for: Open
Final Goods Bogies State:
Cylindrical -> Petroleum
Rectangular -> Unassigned
Open -> Coal
UC15 runtime exception handling completed...
```

### Suggested Test Cases
- `testCargo_SafeAssignment()`
- `testCargo_UnsafeAssignmentHandled()`
- `testCargo_CargoNotAssignedAfterFailure()`
- `testCargo_ProgramContinuesAfterException()`
- `testCargo_FinallyBlockExecution()`

### Key Benefits
- Improves runtime safety during cargo operations.
- Demonstrates practical unchecked exception handling.
- Teaches structured error handling flow.
- Ensures execution continuity after failures.
- Reinforces defensive operational coding.

## IntelliJ Setup
1. Open the `STEP` repository in IntelliJ IDEA.
2. Navigate to `SEM-4/TrainConsistManagementApp/App/src`.
3. Add Java classes and run from IntelliJ as the project evolves.
