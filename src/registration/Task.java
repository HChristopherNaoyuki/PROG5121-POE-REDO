/*
 * This program is written by Naoyuki Christopher Higaki.
 * Purpose: This class represents a task, including task details, status, and functionality to manage tasks.
 */

package registration;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;
    private String taskID;
    private static int taskCount = 0;
    private static List<Task> taskList = new ArrayList<>();

    // Constructor
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        taskCount++;
        this.taskID = createTaskID();
        taskList.add(this);
    }

    // Getter methods
    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public String getTaskID() {
        return taskID;
    }

    // Setter method for task status
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    // Static method to get all tasks
    public static List<Task> getAllTasks() {
        return taskList;
    }

    // Method to create task ID
    public String createTaskID() {
        String[] devNameParts = developerDetails.split(" ");
        String devInitials = devNameParts[0].substring(0, 1) + devNameParts[1].substring(0, 1);
        return taskName.substring(0, 2).toUpperCase() + ":" + taskCount + ":" + devInitials.toUpperCase();
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Name: " + taskName + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Duration: " + taskDuration + " hours\n" +
                "Task Status: " + taskStatus + "\n" +
                "Task ID: " + taskID;
    }

    // Method to check if task description length is valid
    public boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;
    }
}
