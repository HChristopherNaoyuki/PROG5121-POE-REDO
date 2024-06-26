/*
 * Author: Naoyuki Christopher Higaki
 * Student Number: ST10462415
 * 
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
    private static List<Task> taskList = new ArrayList<>();

    // Constructor
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
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

    // Setter method for task status
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    // Static method to get all tasks
    public static List<Task> getAllTasks() {
        return taskList;
    }

    // Method to print task details
    public String printTaskDetails() {
        return "Task Name: " + taskName + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Duration: " + taskDuration + " hours\n" +
                "Task Status: " + taskStatus;
    }
}
