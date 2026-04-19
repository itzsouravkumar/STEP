# Train Consist Management App

Console-based Java app to simulate railway train consist management.

## App Scope
- Passenger bogies: Sleeper, AC Chair, First Class
- Goods bogies: Rectangular, Cylindrical
- Capacity tracking, safety checks, validation, and runtime handling

## Use Cases Implemented (up to UC-3)

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

## Quick Run
From `SEM-4/TrainConsistManagementApp/App/src`:
`javac <ClassName>.java`
`java <ClassNameWithoutDotJava>`

## Branch Workflow
- `train-consist-management-app-main`: README updates
- `train-consist-dev`: cumulative UC code
- `feature/TCM-UC-*`: respective UC implementation
