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
    private static List<Task> allTasks = new ArrayList<>();

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = "To Do"; // Default status is set to "To Do"
        allTasks.add(this);
    }

    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    public String createTaskID() {
        if (taskName != null && taskName.length() >= 2 && developerDetails != null && developerDetails.length() >= 3) {
            return taskName.substring(0, 2).toUpperCase() + ":" + allTasks.size() + ":" + developerDetails.substring(0, 3).toUpperCase();
        } else {
            return "Invalid task or developer name";
        }
    }

    public void setTaskStatus(String status) {
        this.taskStatus = status;
    }

    public String printTaskDetails() {
        String taskId = createTaskID();
        return "Task Name: " + taskName + "\nTask Description: " + taskDescription + "\nDeveloper: " + developerDetails + "\nTask Duration: " + taskDuration + " hours" + "\nTask Status: " + taskStatus + "\nTask ID: " + taskId;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public String getTaskName() {
        return taskName;
    }

    public static List<Task> getAllTasks() {
        return allTasks;
    }
}
