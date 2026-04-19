# Train Consist Management App

Console-based Java app to model railway train consist operations.

## Scope
- Passenger bogies: Sleeper, AC Chair, First Class
- Goods bogies: Rectangular, Cylindrical
- Capacity, composition, cargo safety, validation, and runtime handling

## Use Cases (Implemented up to UC-2)
| UC | Topic | Core Concept | Class |
|---|---|---|---|
| 1 | Initialize Train and Show Consist | Class, main(), ArrayList | `TrainConsistApp.java` |
| 2 | Add Passenger Bogies | ArrayList add/remove/contains | `UseCase2AddPassengerBogies.java` |

## Quick Run
From `SEM-4/TrainConsistManagementApp/App/src`:
`javac <ClassName>.java`
`java <ClassNameWithoutDotJava>`

## Branch Workflow
- `train-consist-management-app-main`: README updates
- `train-consist-dev`: cumulative UC code
- `feature/TCM-UC-*`: respective UC implementation
