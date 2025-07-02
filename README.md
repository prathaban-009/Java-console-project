🚌 Console-Based Bus Booking System
This is a simple, console-based bus ticket booking system developed in Java. It demonstrates fundamental Object-Oriented Programming (OOP) concepts through a practical application where users can view bus availability, book seats, and manage their bookings, while an admin can add new buses and view all bookings.

✨ Features
Admin Module:

Add new buses with specific bus numbers, AC/Non-AC status, and available dates.

View all existing bookings.

Secure login for admin access.

User Booking Module:

View available seats for a specific bus on a given date.

Book a seat on an available bus.

Cancel an existing booking using a unique booking ID.

View details of a specific booking.

Real-time Seat Management: Seats are marked as booked or available.

Unique Booking IDs: Each booking generates a unique ID for easy reference and cancellation.

🚀 How to Run the Project
To get this project up and running on your local machine, follow these simple steps:

Prerequisites
Java Development Kit (JDK) 8 or higher installed on your system.

Compilation and Execution
Save the files: Save all the provided Java files (App.java, Bus.java, BookingManager.java, Bookingblock.java) in a single directory (e.g., BusBookingSystem).

Open Terminal/Command Prompt: Navigate to the directory where you saved your files.

cd path/to/your/BusBookingSystem

Compile the Java files: Use the Java compiler (javac) to compile all .java files.

javac App.java Bus.java BookingManager.java Bookingblock.java

If there are no compilation errors, this command will generate .class files for each Java source file.

Run the application: Execute the App class, which contains the main method.

java App

The application will start in your console, presenting you with the main menu.

🕹️ Usage
Once the application is running, you will see a main menu:

__________________________________

         Welcome
        <------->
1:Admin
2:Booking
3:Exit booking
---->Enter the option:

Admin Access (Option 1)
Username: 1

Password: 1

Admin Options:

1: Add Buses (You'll be prompted for bus number, AC/Non-AC status, and date).

2: View All Bookings.

3: Return to the main menu.

Booking Module (Option 2)
Booking Options:

1: View Seats (Enter bus number and date to see seat availability).

2: Book Seat (Enter bus number, seat number, date, passenger name, and email). A unique booking ID will be generated.

3: Cancel Booking (Enter passenger ID, bus number, and date).

4: View Booking (Enter a specific booking ID to see its details).

5: Return to the main menu.

Exit (Option 3)
Exits the application.

💡 Object-Oriented Programming (OOP) Concepts Implemented
This project is a great example of fundamental OOP principles in action:

1. Classes and Objects
Bus Class: Acts as a blueprint for creating bus entities. Each Bus object represents a specific bus with its unique number, AC status, and a boolean array to track seat availability for a given date.

Bookingblock Class: The blueprint for individual booking records. Each Bookingblock object stores details like passenger name, email, bus number, seat number, booking date, and a unique passangerid.

BookingManager Class: Manages a collection of Bookingblock objects, providing methods to add, cancel, and display bookings.

App Class: The main entry point of the application, orchestrating user interactions and connecting different parts of the system.

2. Encapsulation
All classes (Bus, Bookingblock, BookingManager) use private access modifiers for their data members (e.g., busno, seats, passName, bookings).

Data is accessed and modified only through public getter and setter methods (e.g., getBusNumber(), setStatus(), addBooking()). This protects the internal state of objects and ensures data integrity.

3. Abstraction
Users interact with high-level functionalities (e.g., bookSeat(), cancelBooking()) without needing to know the complex internal logic of how seats are managed or how booking IDs are generated. The underlying details are hidden, providing a simplified interface.

4. Modularity
The system is divided into distinct, self-contained modules (classes), each responsible for a specific part of the system.

This separation of concerns makes the code easier to understand, maintain, debug, and extend. For instance, changes to how a Bus manages its seats won't directly impact how BookingManager handles booking records, as long as the public interfaces remain consistent.

🛠️ Code Structure
App.java: Contains the main method and handles the primary user interface, menu navigation, and orchestrates calls to Bus and BookingManager functionalities.

Bus.java: Defines the Bus class. Manages bus-specific properties like number, AC status, and an array representing the seats for a particular date. It includes methods for viewing seat status, booking, and canceling individual seats.

BookingManager.java: Defines the BookingManager class. It holds an ArrayList of Bookingblock objects and provides methods to add, cancel, and display booking information.

Bookingblock.java: Defines the Bookingblock class. Represents a single booking record, storing passenger details, bus and seat information, booking date, and a unique booking ID.

🚀 Future Enhancements
Data Persistence: Implement saving/loading data to a file (e.g., CSV, JSON) or a database to retain information between application runs.

Improved User Interface: Develop a GUI (Graphical User Interface) using Java Swing/JavaFX for a more user-friendly experience.

Input Validation: More robust validation for all user inputs (e.g., date format, valid seat numbers, non-empty strings).

Error Handling: More specific error messages and graceful handling of unexpected inputs.

Multiple Dates per Bus: Allow a single Bus object to have availability for multiple dates, rather than creating a new Bus object for each date. This would require a more complex data structure within the Bus class (e.g., Map<Date, boolean[]>).

User Accounts: Implement a more comprehensive user authentication system.

Search Functionality: Allow searching for buses by destination, time, etc.

📄 License
This project is open-source 