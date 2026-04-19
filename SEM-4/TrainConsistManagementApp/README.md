# Train Consist Management App

Console-based Java app to model railway train consist operations.

## Scope
- Passenger bogies: Sleeper, AC Chair, First Class
- Goods bogies: Rectangular, Cylindrical
- Capacity, composition, cargo safety, validation, and runtime handling

## Use Cases (Implemented up to UC-10)
| UC | Topic | Core Concept | Class |
|---|---|---|---|
| 1 | Initialize Train and Show Consist | Class, main(), ArrayList | `TrainConsistApp.java` |
| 2 | Add Passenger Bogies | ArrayList add/remove/contains | `UseCase2AddPassengerBogies.java` |
| 3 | Track Unique Bogie IDs | HashSet uniqueness | `UseCase3TrackUniqueBogieIds.java` |
| 4 | Maintain Ordered Bogie Consist | LinkedList ordering operations | `UseCase4MaintainOrderedBogieConsist.java` |
| 5 | Preserve Insertion Order | LinkedHashSet order + uniqueness | `UseCase5PreserveInsertionOrderBogies.java` |
| 6 | Map Bogie to Capacity | HashMap key-value mapping | `UseCase6MapBogieToCapacity.java` |
| 7 | Sort Bogies by Capacity | Comparator and sorting | `UseCase7SortBogiesByCapacity.java` |
| 8 | Filter Passenger Bogies | Streams filter + collect | `UseCase8FilterPassengerBogiesUsingStreams.java` |
| 9 | Group Bogies by Type | Collectors.groupingBy | `UseCase9GroupBogiesByType.java` |
| 10 | Count Total Seats | Streams map + reduce | `UseCase10CountTotalSeatsInTrain.java` |

## Quick Run
From `SEM-4/TrainConsistManagementApp/App/src`:
`javac <ClassName>.java`
`java <ClassNameWithoutDotJava>`

## Branch Workflow
- `train-consist-management-app-main`: README updates
- `train-consist-dev`: cumulative UC code
- `feature/TCM-UC-*`: respective UC implementation
