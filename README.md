# Registration and Login Application

## Overview
This Java application provides user registration and login functionality, including username and password validation. Users can register with their first name, last name, username, and password, and then log in to manage tasks in the EasyKanban system.

## Features
- **User Registration**: Validates usernames and passwords before registration.
- **User Login**: Checks login credentials against registered users.
- **Task Management**: Users can add, view, delete, and search tasks.
- **Reports**: Generate reports based on tasks and their statuses.

## Classes
1. **Login**: Handles user registration and login functionalities.
2. **Registration**: Main entry point that manages user interactions via a graphical interface.
3. **Task**: Represents a task with various properties and methods for managing task details.

## Requirements
- Java Development Kit (JDK)
- Java Swing library for GUI

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/HChristopherNaoyuki/PROG5121-POE-REDO.git
   ```
2. Navigate to the project directory:
   ```bash
   cd registration
   ```
3. Compile the Java files:
   ```bash
   javac *.java
   ```
4. Run the application:
   ```bash
   java Registration
   ```

## Usage
1. Launch the application.
2. Follow the prompts to register a new user.
3. Log in with the registered credentials.
4. Use the main menu to manage tasks:
   - Add tasks
   - Show reports
   - Quit the application

## Unit Testing
The application includes unit tests to validate the functionalities. Anyone can contribute to improving and expanding the tests to cover more scenarios or find potential errors.

## Contributing
We welcome contributions! Feel free to open issues, submit pull requests, or provide feedback.

1. Fork the repository.
2. Create a new branch for your feature or fix.
3. Commit your changes.
4. Push to your fork and create a pull request.
