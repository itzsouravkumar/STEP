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
### Use Case 3: Centralized Room Inventory Management
**Goal:** Introduce centralized inventory management by replacing scattered availability variables with a single, consistent data structure, demonstrating how `HashMap` solves real-world state management problems.

**Actor:** `RoomInventory` – responsible for managing and exposing room availability across the system.

**Flow:**
1. The system initializes the inventory component.
2. Room types are registered with their available counts.
3. Availability is stored and retrieved from a centralized `HashMap`.
4. Updates to availability are performed through controlled methods.
5. The current inventory state is displayed when requested.

**Key Concepts Used**
- **Problem of Scattered State:** In previous use cases, availability was stored in separate variables leading to inconsistency and poor scalability.
- **HashMap:** `HashMap<String, Integer>` is used to map room types to available room counts for fast access, updates, and lookups based on a logical key.
- **O(1) Lookup:** Provides average constant-time complexity for get and put operations, making it suitable for frequent availability checks.
- **Single Source of Truth:** Centralized structure eliminates discrepancies caused by multiple representations of the same state.
- **Encapsulation of Inventory Logic:** Inventory-related operations are encapsulated within a dedicated class reducing coupling.
- **Separation of Concerns:** Inventory manages how many rooms are available, not what a room is (where room attributes remain in the `Room` domain model).
- **Scalability:** Adding a new room type requires only inserting a new entry into the map.

**Key Requirements**
- Initialize room availability using a constructor.
- Store room availability using a `HashMap`.
- Provide methods to retrieve current availability.
- Support controlled updates to room availability.

### Use Case 4: Room Search & Availability Check
**Goal:** Enable guests to view available rooms and their details without modifying system state, reinforcing safe data access and clear separation of responsibilities.

**Actor:**
Guest – initiates a search to view available room options.
Search Service – handles read-only access to inventory and room information.

**Flow:**
1. Guest initiates a room search request.
2. The system retrieves availability data from the inventory.
3. Room details and pricing are obtained from room objects.
4. Unavailable room types are filtered out.
5. Available room types and their details are displayed.
6. System state remains unchanged.

**Key Concepts Used**
- **Read-Only Access** - Search operations are designed to read data without altering it. This prevents unintended side effects and ensures system stability.
- **Defensive Programming** - The search logic performs checks to ensure only valid and available room types are displayed. This protects the system from incorrect assumptions and invalid data usage.
- **Separation of Concerns** - Search functionality is isolated from inventory mutation and booking logic. This ensures that searching does not interfere with allocation or availability updates.
- **Inventory as State Holder** - Inventory is accessed only to retrieve current availability counts. No updates are performed during search operations.
- **Domain Model Usage** - Room objects provide descriptive information such as pricing and amenities. This avoids duplicating room-related data in the inventory layer.
- **Validation Logic** - Room types with zero availability are excluded from the search results. This ensures that guests see only actionable options.

**Key Requirements**
- Retrieve room availability from the centralized inventory.
- Display only room types with availability greater than zero.
- Show room details and pricing using room domain objects.
- Ensure inventory data is not modified during search operations.
- Maintain a clear boundary between search logic and booking logic.

**Key Benefits**
- Accurate availability visibility without state mutation
- Reduced risk of accidental inventory corruption
- Clear separation between read-only and write operations

**Drawbacks of Previous Use Case**
- Use Case 3 introduced centralized inventory but did not differentiate between read and write access.
- Without explicit separation, inventory could be accidentally modified during non-booking operations.
