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

### Use Case 5: Booking Request (First-Come-First-Served)
**Goal:** Handle multiple booking requests fairly by introducing a request intake mechanism that preserves arrival order, reflecting real-world booking behavior during peak demand.

**Actor:**
Reservation – represents a guest’s intent to book a room.
Booking Request Queue – manages and orders incoming booking requests.

**Flow:**
1. Guest submits a booking request.
2. The request is added to the booking queue.
3. Requests are stored in arrival order.
4. Queued requests wait for processing by the allocation system.
5. No inventory mutation occurs at this stage.

**Key Concepts Used**
- **Problem of Simultaneous Requests** - During peak demand, multiple booking requests can arrive at nearly the same time. Without ordering, requests may be processed inconsistently, leading to unfair allocation.
- **Queue Data Structure** - A `Queue<Reservation>` is used to store booking requests. Queues naturally model waiting lines where elements are processed in sequence.
- **FIFO Principle** - FIFO (First-Come-First-Served) ensures that the earliest request is processed first. This mirrors fairness expectations in real booking systems.
- **Fairness** - Using a queue guarantees that no request can bypass another. All guests are treated equally based on request arrival time.
- **Request Ordering** - The queue preserves insertion order automatically. This eliminates the need for manual sorting or timestamp comparison.
- **Decoupling Request Intake from Allocation** - Requests are collected first and processed later. This separation prepares the system for controlled allocation and concurrency handling.

**Key Requirements**
- Accept booking requests from guests.
- Store requests in a queue structure.
- Preserve the order in which requests arrive.
- Ensure no room allocation or inventory updates occur at this stage.
- Prepare requests for subsequent processing.

**Key Benefits**
- Fair and deterministic booking request handling
- Predictable system behavior under peak load
- Simplified request coordination before allocation

**Drawbacks of Previous Use Case**
- Use Case 4 allowed room visibility but did not handle booking intent.
- Without a request intake mechanism, simultaneous booking attempts could not be managed fairly.

### Use Case 6: Reservation Confirmation & Room Allocation
**Goal:** Confirm booking requests by assigning rooms safely while ensuring inventory consistency and preventing double-booking under all circumstances.

**Actor:**
Booking Service – processes queued booking requests and performs room allocation.
Inventory Service – maintains and updates room availability state.

**Flow:**
1. Booking request is dequeued from the request queue.
2. The system checks availability for the requested room type.
3. A unique room ID is generated and assigned.
4. The room ID is recorded to prevent reuse.
5. Inventory count is decremented immediately.
6. Reservation is confirmed.

**Key Concepts Used**
- **Problem of Double Booking** - Without controlled allocation, the same room may be assigned to multiple guests. This results in room ID collisions and inconsistent system state.
- **Set Data Structure** - A `Set<String>` is used to store allocated room IDs. Sets enforce uniqueness by design, preventing duplicate room assignments.
- **Uniqueness Enforcement** - By checking against an existing set of room IDs, the system guarantees that no room is assigned more than once. This removes the need for manual duplicate checks.
- **Mapping Room Types to Assigned Rooms** - A `HashMap<String, Set<String>>` maps each room type to its allocated room IDs. This allows grouped tracking and simplifies validation and reporting.
- **Atomic Logical Operations** - Room allocation is treated as a single logical unit. Assignment and inventory update occur together to avoid partial or inconsistent state.
- **Inventory Synchronization** - Inventory is updated immediately after allocation. This ensures that availability reflects the current system state at all times.

**Key Requirements**
- Retrieve booking requests from the queue in FIFO order.
- Generate and assign a unique room ID for each confirmed reservation.
- Prevent reuse of room IDs across all allocations.
- Update inventory immediately after successful allocation.
- Ensure allocation logic maintains system consistency.

**Key Benefits**
- Guaranteed uniqueness of room assignments
- Immediate synchronization between booking and inventory
- Elimination of double-booking scenarios

**Drawbacks of Previous Use Case**
- Use Case 5 handled request ordering but did not confirm bookings.
- Without allocation and uniqueness enforcement, queued requests could still result in conflicting assignments.
