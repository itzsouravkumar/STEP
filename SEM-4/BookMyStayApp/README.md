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

### Use Case 7: Add-On Service Selection
**Goal:** Extend the booking model to support optional services, demonstrating how real-world business features can be added without modifying core booking or allocation logic.

**Actor:**
* **Guest** – selects optional services for an existing reservation.
* **Add-On Service** – represents an individual optional offering.
* **Add-On Service Manager** – manages the association between reservations and selected services.

**Flow:**
1. Guest selects one or more add-on services.
2. Selected services are added to a list.
3. The list of services is mapped to the corresponding reservation ID.
4. Additional cost for the reservation is calculated.
5. Core booking and inventory state remain unchanged.

**Key Concepts Used**
* **Business Extensibility** - Real-world bookings often include additional offerings beyond the primary product. The system must support new features without disrupting existing logic.
* **One-to-Many Relationship** - A single reservation can have multiple associated services. This relationship is modeled using a map from reservation ID to a list of services.
* **Map and List Combination** - `Map<String, List<Service>>` allows efficient lookup of services for a reservation. Lists preserve insertion order and allow multiple services to be attached.
* **Composition over Inheritance** - Services are composed with reservations rather than inherited. This avoids rigid class hierarchies and supports flexible feature growth.
* **Separation of Core and Optional Features** - Add-on services are managed independently of room allocation and inventory. This prevents optional features from complicating critical booking workflows.
* **Cost Aggregation** - Service costs are calculated separately and combined when needed. This keeps pricing logic modular and easier to extend.

**Key Requirements**
* Allow multiple services to be attached to a single reservation.
* Store selected services using a reservation-to-services mapping.
* Calculate total additional cost for selected services.
* Ensure add-on logic does not modify booking or inventory state.
* Support easy addition of new service types.

**Key Benefits**
* Flexible attachment of optional services to reservations
* Clean mapping between bookings and value-added features
* Easy expansion of services without core booking changes

**Drawbacks of Previous Use Case**
* Use Case 6 confirmed room allocation but treated bookings as static entities.
* Without add-on support, the system could not model common real-world booking enhancements.

### Use Case 8: Booking History & Reporting
**Goal:** Introduce historical tracking of confirmed bookings to provide operational visibility, enable audits, and support reporting, reinforcing a persistence-oriented mindset without introducing external storage.

**Actor:**
* **Admin** – reviews booking history and reports for operational purposes.
* **Booking History** – maintains a record of confirmed reservations.
* **Booking Report Service** – generates summaries and reports from stored booking data.

**Flow:**
1. A booking is successfully confirmed.
2. The confirmed reservation is added to booking history.
3. Booking history maintains records in insertion order.
4. Admin requests booking information or reports.
5. Stored reservations are retrieved and displayed as required.

**Key Concepts Used**
* **Operational Visibility** - Real systems require visibility into past transactions. Historical data allows administrators to understand system usage and behavior.
* **List Data Structure** - A `List<Reservation>` is used to store confirmed bookings. Lists preserve insertion order, making them suitable for chronological records.
* **Ordered Storage** - Bookings are stored in the order they are confirmed. This naturally reflects real-world timelines and supports sequential reporting.
* **Historical Tracking** - Once stored, bookings form an audit trail. This enables later review, analysis, and verification of system actions.
* **Reporting Readiness** - Storing structured booking data prepares the system for reporting. Reports can be generated without reprocessing live booking flows.
* **Separation of Data Storage and Reporting** - Booking history focuses on storing data. Reporting logic is delegated to a separate service, reducing coupling.
* **Persistence Mindset (Without Storage Medium)** - Although data is stored in memory, the system treats history as long-lived information. This prepares learners conceptually for file-based or database persistence in later stages.

**Key Requirements**
* Store each confirmed reservation in booking history.
* Maintain bookings in the order they are confirmed.
* Allow retrieval of stored reservations for review.
* Generate summary reports from booking history.
* Ensure reporting does not modify stored booking data.

**Key Benefits**
* Complete and traceable booking audit trail
* Simplified reporting and administrative analysis
* Improved support for customer issue resolution

**Drawbacks of Previous Use Case**
* Use Case 7 extended booking functionality but did not retain historical data.
* Without booking history, completed transactions could not be reviewed or analyzed.

### Use Case 9: Error Handling & Validation
**Goal:** Strengthen system reliability by introducing structured validation and error handling, ensuring that invalid inputs and inconsistent states are detected and handled early.

**Actor:**
* **Guest** – provides booking input that must be validated.
* **Invalid Booking Validator** – validates input and system state before processing requests.

**Flow:**
1. Guest provides booking input.
2. System validates input values and system constraints.
3. If validation fails, an error is raised immediately.
4. A meaningful failure message is displayed.
5. The system prevents invalid state changes and continues running safely.

**Key Concepts Used**
* **Input Validation** - Validation ensures that incoming data conforms to expected rules before processing. This prevents invalid or inconsistent data from entering the system.
* **Custom Exceptions** - Domain-specific exceptions are used to represent invalid booking scenarios. Custom exceptions make error causes explicit and improve code readability.
* **Fail-Fast Design** - The system detects errors as early as possible and stops further processing. This avoids cascading failures and simplifies debugging.
* **Guarding System State** - Checks are performed before inventory updates or allocations. This ensures that critical state, such as availability counts, remains valid.
* **Graceful Failure Handling** - Errors are communicated clearly without crashing the application. This improves system usability and maintainability.
* **Correctness over Happy Path** - The system is designed to handle incorrect usage, not just ideal scenarios. This reflects real-world conditions where invalid input is common.

**Key Requirements**
* Validate room types before processing bookings.
* Prevent inventory from reaching invalid or negative values.
* Throw and handle custom exceptions for invalid scenarios.
* Display clear and informative failure messages.
* Ensure the system remains stable after errors.

**Key Benefits**
* Early detection of invalid system states
* Reduced risk of silent data corruption
* More stable and predictable application behavior

**Drawbacks of Previous Use Case**
* Use Case 8 focused on storing and reporting booking data but assumed valid input.
* Without validation, incorrect data could corrupt system state and reports.

### Use Case 10: Booking Cancellation & Inventory Rollback
**Goal:** Enable safe cancellation of confirmed bookings by correctly reversing system state changes, ensuring inventory consistency and predictable recovery behavior.

**Actor:**
* **Guest** – initiates a cancellation request for an existing booking.
* **Cancellation Service** – validates cancellations and performs controlled rollback operations.

**Flow:**
1. Guest initiates a cancellation request.
2. The system validates the reservation to ensure it exists and is cancellable.
3. The allocated room ID is recorded in a rollback structure.
4. Inventory count for the corresponding room type is incremented.
5. Booking history is updated to reflect the cancellation.
6. System state is restored consistently.

**Key Concepts Used**
* **State Reversal** - Cancellation requires undoing previously completed operations. The system must revert inventory and booking state without introducing inconsistencies.
* **Stack Data Structure** - A `Stack<String>` is used to track recently released room IDs. Stacks follow a Last-In-First-Out (LIFO) order, which naturally models rollback behavior.
* **LIFO Rollback Logic** - The most recent allocation is the first to be reversed. This aligns with real-world undo operations and simplifies recovery logic.
* **Controlled Mutation** - State changes during cancellation are performed in a strict, predefined order. This prevents partial rollbacks and protects system integrity.
* **Inventory Restoration** - Inventory counts are incremented immediately after cancellation. This ensures availability accurately reflects the current system state.
* **Validation of Cancellation Requests** - The system verifies that a reservation exists before allowing cancellation. Invalid or duplicate cancellation attempts are rejected safely.

**Key Requirements**
* Allow cancellation of confirmed bookings only.
* Validate reservation existence before performing rollback.
* Release allocated room IDs back to the availability pool.
* Restore inventory counts accurately and immediately.
* Prevent cancellation of non-existent or already cancelled bookings.

**Key Benefits**
* Safe recovery of inventory after cancellations
* Consistent system state across the booking lifecycle
* Controlled and predictable rollback behavior

**Drawbacks of Previous Use Case**
* Use Case 9 focused on input validation but did not address reversing valid operations.
* Without rollback support, confirmed bookings could not be safely undone.

### Use Case 11: Concurrent Booking Simulation (Thread Safety)
**Goal:** Demonstrate how concurrent access to shared resources can lead to inconsistent system state and show how synchronization ensures correctness under multi-user conditions.

**Actor:**
* **Multiple Guests** – submit booking requests concurrently.
* **Concurrent Booking Processor** – processes booking requests in a multi-threaded environment.

**Flow:**
1. Multiple guests submit booking requests simultaneously.
2. Requests are added to a shared booking queue.
3. Threads retrieve requests using synchronized access.
4. Room allocation and inventory updates are performed inside critical sections.
5. The system completes allocations without conflicts or inconsistencies.

**Key Concepts Used**
* **Race Conditions** - Race conditions occur when multiple threads access and modify shared data simultaneously. The final system state becomes dependent on execution timing rather than logic.
* **Thread Safety** - Thread safety ensures that shared resources behave correctly when accessed by multiple threads. This is critical in systems handling concurrent user actions.
* **Shared Mutable State** - The booking queue and inventory are shared across threads. Uncontrolled access to shared mutable data can corrupt system state.
* **Critical Sections** - Critical sections are blocks of code that must be executed by only one thread at a time. Synchronization ensures exclusive access to these sections.
* **Synchronized Access** - Synchronization mechanisms are used to protect shared resources. This prevents interleaving operations that could lead to double allocation.
* **Concurrency vs. Parallelism** - Concurrency focuses on correctness when tasks overlap in time. This use case emphasizes correctness over performance optimization.

**Key Requirements**
* Simulate multiple booking requests occurring at the same time.
* Use shared data structures for booking requests and inventory.
* Ensure inventory updates are performed in a thread-safe manner.
* Prevent double allocation under concurrent execution.
* Maintain consistent system state under load.

**Key Benefits**
* Safe multi-user booking simulation
* Correct room allocations under concurrent load
* Foundation for building scalable, multi-user systems

**Drawbacks of Previous Use Case**
* Earlier use cases assumed a single-threaded execution model.
* Such assumptions are unsafe in real production environments where concurrent access is common.

### Use Case 12: Data Persistence & System Recovery
**Goal:** Introduce persistence and recovery concepts by ensuring that critical system state survives application restarts, transitioning learners from in-memory thinking to durable system design.

**Actor:**
* **System** – initiates save and restore operations during shutdown and startup.
* **Persistence Service** – handles storing and retrieving system state from persistent storage.

**Flow:**
1. The system prepares for shutdown.
2. Current booking and inventory state is serialized into a persistent format.
3. Serialized data is written to a file.
4. System restarts.
5. Persisted data is loaded from the file.
6. Inventory and booking state are restored into memory.
7. System resumes operation with recovered state.

**Key Concepts Used**
* **Stateful Applications** - A stateful application maintains data beyond a single execution cycle. Business systems must preserve state to ensure continuity and correctness.
* **Persistence** - Persistence refers to storing application state in a durable medium. This prevents data loss caused by restarts, crashes, or redeployments.
* **Serialization** - Serialization converts in-memory objects into a format suitable for storage. This allows complex data structures to be written to files and later reconstructed.
* **Deserialization** - Deserialization restores objects from persisted data back into memory. Correct deserialization is essential for accurate system recovery.
* **Inventory Snapshot** - The inventory state is captured at a point in time. Restoring this snapshot ensures availability reflects the last known valid state.
* **Failure Tolerance** - The system handles missing or corrupted persistence data safely. This prevents crashes and allows the application to start in a known, valid state.
* **Preparation for Database Integration** - File-based persistence introduces durability concepts without database complexity. This prepares learners conceptually for future database-backed systems.

**Key Requirements**
* Persist booking history and inventory state to a file.
* Restore persisted data during application startup.
* Ensure the restored state accurately reflects the last saved state.
* Handle missing or corrupted persistence files gracefully.
* Allow the system to continue operating safely after recovery.

**Key Benefits**
* No data loss across application restarts
* More realistic and production-aligned system behavior
* Smooth conceptual transition toward database-backed systems

**Drawbacks of Previous Use Case**
* Earlier use cases relied entirely on in-memory data structures.
* As a result, all business state was lost when the application terminated.
