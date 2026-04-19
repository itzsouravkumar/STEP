# Train Consist Management App

Console-based Java app to simulate railway train consist management.

## App Scope
- Passenger bogies: Sleeper, AC Chair, First Class
- Goods bogies: Rectangular, Cylindrical
- Capacity tracking, safety checks, validation, and runtime handling

## Use Cases Implemented (up to UC-9)

## UC-1: Initialize Train and Display Consist Summary
- Purpose: Start the app and show initial train consist state.
- Problem Addressed: System needs a clear entry point and initial status.
- Flow: Run app, initialize list, print count and consist.
- Core Java: Class, `main()`, `ArrayList`, `List`.
- Validation Focus: Confirms empty consist at startup.
- File: `App/src/TrainConsistApp.java`.
- Outcome: Foundation ready for all upcoming use cases.

## UC-2: Add Passenger Bogies to Train
- Purpose: Support dynamic add/remove operations on passenger bogies.
- Problem Addressed: UC-1 had initialization but no bogie updates.
- Flow: Add bogies, remove one, check existence, print final state.
- Core Java: `ArrayList` methods `add`, `remove`, `contains`.
- Validation Focus: Confirms list mutation behavior is correct.
- File: `App/src/UseCase2AddPassengerBogies.java`.
- Outcome: Basic consist CRUD behavior is established.

## UC-3: Track Unique Bogie IDs
- Purpose: Ensure duplicate bogie IDs are not accepted.
- Problem Addressed: List-based storage allows accidental duplicates.
- Flow: Insert multiple IDs including duplicates and inspect result.
- Core Java: `HashSet` with automatic uniqueness.
- Validation Focus: Duplicate IDs are ignored safely.
- File: `App/src/UseCase3TrackUniqueBogieIds.java`.
- Outcome: ID integrity is enforced at collection level.

## UC-4: Maintain Ordered Bogie Consist
- Purpose: Keep bogie order controllable from front and rear.
- Problem Addressed: Order-sensitive operations need better structure.
- Flow: Add at ends, remove from ends, inspect sequence.
- Core Java: `LinkedList` deque-like operations.
- Validation Focus: Correct order after insertion and deletion.
- File: `App/src/UseCase4MaintainOrderedBogieConsist.java`.
- Outcome: Operational ordering logic becomes explicit.

## UC-5: Preserve Insertion Order of Bogies
- Purpose: Keep insertion order while also avoiding duplicates.
- Problem Addressed: `HashSet` removes duplicates but loses order.
- Flow: Add bogies with repeats and print final ordered set.
- Core Java: `LinkedHashSet` for ordered uniqueness.
- Validation Focus: Order retained and duplicates skipped.
- File: `App/src/UseCase5PreserveInsertionOrderBogies.java`.
- Outcome: Predictable, clean bogie listing for reporting.

## UC-6: Map Bogie to Capacity
- Purpose: Link each bogie type/ID to its seat capacity.
- Problem Addressed: Sequential lists are weak for keyed lookup.
- Flow: Insert key-value entries and fetch mapped capacities.
- Core Java: `HashMap` operations `put`, `get`, `containsKey`.
- Validation Focus: Accurate capacity retrieval by key.
- File: `App/src/UseCase6MapBogieToCapacity.java`.
- Outcome: Fast lookup model for capacity analytics.

## UC-7: Sort Bogies by Capacity
- Purpose: Arrange bogies by capacity for planning visibility.
- Problem Addressed: Unsorted data hides high/low-capacity structure.
- Flow: Build bogie list, apply sort, print ordered output.
- Core Java: `Comparator` with `Collections.sort`/`List.sort`.
- Validation Focus: Ascending/expected ordering of capacities.
- File: `App/src/UseCase7SortBogiesByCapacity.java`.
- Outcome: Capacity ranking becomes easy to interpret.

## UC-8: Filter Passenger Bogies Using Streams
- Purpose: Extract bogies above a capacity threshold.
- Problem Addressed: Manual loop filtering is verbose and repetitive.
- Flow: Stream list, apply `filter`, collect matching bogies.
- Core Java: Stream API `filter()` and `collect()`.
- Validation Focus: Only eligible bogies remain in results.
- File: `App/src/UseCase8FilterPassengerBogiesUsingStreams.java`.
- Outcome: Cleaner and reusable filtering logic.

## UC-9: Group Bogies by Type
- Purpose: Organize bogies into categorized groups.
- Problem Addressed: Flat lists are hard for type-wise reporting.
- Flow: Stream bogies and group with classification key.
- Core Java: `Collectors.groupingBy()`.
- Validation Focus: Correct keys and grouped member counts.
- File: `App/src/UseCase9GroupBogiesByType.java`.
- Outcome: Structured output for dashboards and summaries.

## Quick Run
From `SEM-4/TrainConsistManagementApp/App/src`:
`javac <ClassName>.java`
`java <ClassNameWithoutDotJava>`

## Branch Workflow
- `train-consist-management-app-main`: README updates
- `train-consist-dev`: cumulative UC code
- `feature/TCM-UC-*`: respective UC implementation
