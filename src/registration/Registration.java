/*
 * Author: Naoyuki Christopher Higaki
 * Student Number: ST10462415
 * 
 * This program is written by Naoyuki Christopher Higaki.
 * Purpose: This class serves as the main entry point 
 * for the registration and login application, including task management features.
 */

package registration;

import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class Registration {
    public static void main(String[] args) {
        Login myLogin = new Login();

        // User registration information input
        String firstName = JOptionPane.showInputDialog(null, "Enter your first name:");
        String lastName = JOptionPane.showInputDialog(null, "Enter your last name:");
        String username = JOptionPane.showInputDialog(null, "Enter username (max 5 characters, must contain an underscore):");
        String password = JOptionPane.showInputDialog(null, "Enter password (min 8 characters, must contain a capital letter, a number, and a special character):");

        // Registering the user
        String registrationMessage = myLogin.registerUser(username, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, registrationMessage);

        // Check if registration was successful
        if (!registrationMessage.contains("successfully")) {
            JOptionPane.showMessageDialog(null, "Registration failed. Exiting program.");
            return;
        }

        // User login process
        if (!myLogin.loginUser(username, password)) {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");
        } else {
            // Successful login message
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + ", " + lastName + ". It is great to see you again.");
            JOptionPane.showMessageDialog(null, myLogin.returnLoginStatus(username, password));

            // Welcome message to EasyKanban
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

            // Main menu selection
            String appFeature = JOptionPane.showInputDialog(null, "Choose option:\n1) Add tasks\n2) View tasks\n3) Show Report\n4) Quit");

            while (!appFeature.equals("4")) {
                switch (appFeature) {
                    case "1":
                        addTasks();
                        break;
                    case "2":
                        viewTasks();
                        break;
                    case "3":
                        showReport();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                }
                appFeature = JOptionPane.showInputDialog(null, "Choose option:\n1) Add tasks\n2) View tasks\n3) Show Report\n4) Quit");
            }
            JOptionPane.showMessageDialog(null, "Exiting EasyKanban. Goodbye!");
        }
    }

    // Method to add tasks
    private static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of tasks you wish to add:"));
        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog(null, "Enter task name:");
            String taskDescription = JOptionPane.showInputDialog(null, "Enter task description (max 50 characters):");

            // Task description length validation
            while (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                taskDescription = JOptionPane.showInputDialog(null, "Enter task description (max 50 characters):");
            }

            String devDetails = JOptionPane.showInputDialog(null, "Enter developer details (Name and Surname):");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter task duration (Hours):"));

            // Task status selection
            String[] options = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            // Default to "To Do" if user closes the task status dialog
            if (taskStatus == null) {
                taskStatus = "To Do";
            }

            // Creating and adding the new task
            Task newTask = new Task(taskName, taskDescription, devDetails, taskDuration);
            newTask.setTaskStatus(taskStatus);
        }
        JOptionPane.showMessageDialog(null, "Tasks added successfully.");
    }

    // Method to view tasks
    private static void viewTasks() {
        List<Task> allTasks = Task.getAllTasks();
        if (allTasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available. Coming Soon.");
        } else {
            StringBuilder taskDetails = new StringBuilder();
            for (Task task : allTasks) {
                taskDetails.append(task.printTaskDetails()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, taskDetails.toString());
        }
    }

    // Method to show report options
    private static void showReport() {
        List<Task> allTasks = Task.getAllTasks();
        if (allTasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available to generate report.");
            return;
        }

        String[] reportOptions = {"Delete task using Task Name", "Search Array for task assigned to developer", "Display details for task with longest duration"};
        String reportChoice = (String) JOptionPane.showInputDialog(null, "Select report option:", "Show Report", JOptionPane.QUESTION_MESSAGE, null, reportOptions, reportOptions[0]);
        if (reportChoice != null) {
            switch (reportChoice) {
                case "Delete task using Task Name":
                    String taskNameToDelete = JOptionPane.showInputDialog(null, "Enter the name of the task to delete:");
                    deleteTaskByName(taskNameToDelete);
                    break;
                case "Search Array for task assigned to developer":
                    String developerName = JOptionPane.showInputDialog(null, "Enter the developer name to search for:");
                    searchTasksByDeveloper(developerName);
                    break;
                case "Display details for task with longest duration":
                    displayTaskWithLongestDuration();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid report option.");
            }
        }
    }

    // Method to delete task by name
    private static void deleteTaskByName(String taskName) {
        List<Task> allTasks = Task.getAllTasks();
        Task taskToDelete = null;
        for (Task task : allTasks) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                taskToDelete = task;
                break;
            }
        }
        if (taskToDelete != null) {
            allTasks.remove(taskToDelete);
            JOptionPane.showMessageDialog(null, "Task with name \"" + taskName + "\" deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Task with name \"" + taskName + "\" not found.");
        }
    }

    // Method to search for tasks assigned to a specific developer
    private static void searchTasksByDeveloper(String developerName) {
        List<Task> allTasks = Task.getAllTasks();
        StringBuilder tasksFound = new StringBuilder();
        boolean tasksFoundFlag = false;
        for (Task task : allTasks) {
            if (task.getDeveloperDetails().equalsIgnoreCase(developerName)) {
                tasksFound.append(task.printTaskDetails()).append("\n\n");
                tasksFoundFlag = true;
            }
        }
        if (tasksFoundFlag) {
            JOptionPane.showMessageDialog(null, "Tasks assigned to developer \"" + developerName + "\":\n\n" + tasksFound.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for developer \"" + developerName + "\".");
        }
    }

    // Method to display task with the longest duration
    private static void displayTaskWithLongestDuration() {
        List<Task> allTasks = Task.getAllTasks();
        if (allTasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        Task longestDurationTask = allTasks.get(0);
        for (Task task : allTasks) {
            if (task.getTaskDuration() > longestDurationTask.getTaskDuration()) {
                longestDurationTask = task;
            }
        }

        JOptionPane.showMessageDialog(null, "Task with the longest duration:\n\n" + longestDurationTask.printTaskDetails());
    }
}
