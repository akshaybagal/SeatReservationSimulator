# SeatReservationSimulator

This project is a simulation of seat reservation system in trains. This repository is specifically the back-end system built using Java,
JDBC and REST architecture for API development.

User can search for required trains based on source station, destination statin and the journey date.
User can reserve seats for required type of tarin, type of coach and number of seats.

This backend resources are exposed to front-end using multiple end-points with JSON response.
Client systems can interact with this back-end system using end-points exposed by passing required parameters.

The entire back-end is divided into 4 major tiers.
1. Application Layer: This is the layer where API request first hitsfrom clients.
2. Business Layer: This tier contains The resource classes of all end-points which is core of REST architecture.
3. Data Access Layer: The dedicated tier for all database operations.
4. Presentation layer: This tier is a collection of response classes for all end-points.

Built Using:

Java, NetBeans IDE using Glassfish server 4.1.1.
JDBC, JSON, MS-SQL, Stored Procedures.
