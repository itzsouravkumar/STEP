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

## IntelliJ Setup
1. Open the `STEP` repository in IntelliJ IDEA.
2. Navigate to `SEM-4/TrainConsistManagementApp/App/src`.
3. Add Java classes and run from IntelliJ as the project evolves.
