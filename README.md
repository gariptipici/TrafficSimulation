# TrafficSimulation
A tiny traffic emulator

Developed using Spring Boot

 We have a vehicles directory of following types:

o   Car

o   Bus

o   Truck

Total count 1000 (generated)

·         These vehicles are moving in city and every 5 seconds report about remaining fuel in tank.


Mileage stats:

o   Car

·         Full tank: 40 liters

·         Avg. consumption/ 5sec: 0.1 liter

o   Bus

·         Full tank: 100liters

·         Avg. cons /5sec : 0.5 liter

o   Truck

·         Full tank: 130liters

·         Avg. cons / 5sec: 0.7 liter



·         Once fuel is less than 10% of tank system sends vehicle to refuel. Refueling happens within 10 secs.

·         Vehicles also could randomly send other events to the system

o   Alert

·         Meaning: Defect was found in this type of vehicle

·         Action: System reduces fuel tank of vehicles with the same type on 3%

o   Incident

·         Meaning: Vehicle reports own id and id of other vehicle with whom it had collision

·         Action: System sets both vehicles remaining fuel = “0”

 


1.    Emulator (java only) of vehicles in city behavior created.

2.    Implemented backend (Spring boot, in-memory database h2db)

3.    Considered potential scalability of backend

There are no security requirements
