# Hotel Booking Management System

(App-Based Learning Using Core Java & Data Structures)

## Objective
This project focuses on the design and implementation of a Hotel Booking Management System to demonstrate how Core Java and fundamental data structures are applied to solve real-world software engineering challenges.
Rather than treating data structures as isolated theory, the system shows how they enable:
- Fair request handling using FIFO principles
- Real-time inventory consistency across booking operations
- Prevention of double-booking through uniqueness enforcement
- Extensible and maintainable system design suitable for real applications

## Learning Approach
The application is developed incrementally, with each use case introducing one new concept at a time while reinforcing previously learned ideas. Every design decision is intentional and mirrors how production systems evolve—from simple, rigid implementations to scalable, robust architectures.

Each stage highlights:
- Why a specific data structure is needed
- What problem it solves in a real business context
- What limitations exist before refactoring

## Scope & Focus
- The emphasis is on data structures, object-oriented design, and advanced Java concepts
- User input and UI handling are intentionally minimized to maintain focus on core logic and system behavior
- All interactions are deterministic and console-based for clarity, traceability, and ease of debugging

## Outcome
By the end of this project, learners will understand not only how to use Java data structures, but when and why to use them—bridging the gap between academic knowledge and real-world system design.

## Use Cases

### Use Case 1: Application Entry & Welcome Message
**Description:**
This class represents the entry point of the Hotel Booking Management System.
At this stage, the application:
- Starts execution from the `main()` method
- Displays a welcome message ("Welcome to BookMyStay!")
- Confirms that the system has started successfully ("System started successfully.")

No business logic, data structures, or user input is implemented in this use case.
The goal is to establish a clear and predictable application startup point.

### Use Case 2: Basic Room Types & Static Availability
**Goal:** Introduce object modeling through inheritance and abstraction before introducing data structures, allowing students to focus on domain design rather than optimization.

**Actor:** User – runs the application to view predefined room types and their availability.

**Flow:**
1. User runs the application.
2. Room objects representing different room types are created.
3. Availability for each room type is stored using simple variables.
4. Room details and availability information are printed to the console.
5. Application terminates.

**Key Concepts Used**
- **Abstract Class** - Represents a generalized concept that should not be instantiated directly.
- **Inheritance** - Concrete room classes (`SingleRoom`, `DoubleRoom`, `SuiteRoom`) extend the abstract `Room` class.
- **Polymorphism** - Room objects are referenced using the `Room` type, enabling uniform handling.
- **Encapsulation** - Room attributes are encapsulated within the `Room` class.
- **Static Availability Representation** - Room availability is stored using simple variables to highlight the limitations of hardcoded and scattered state management.
- **Separation of Domain and State** - Room objects represent the room, while availability variables represent current system state.

**Key Requirements**
- Define an abstract `Room` class with common attributes.
- Create concrete room classes for Single, Double, and Suite rooms.
- Initialize room objects in the application entry point.
- Store room availability using individual variables.
- Display room details and availability to the console.
