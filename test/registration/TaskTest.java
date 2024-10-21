/*
 * Purpose: This class contains unit tests for the Task class to ensure correct functionality.
 */

package registration;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {
    @Test
    public void testCheckTaskDescription_Valid() {
        Task test = new Task("Login Feature", "Create Login", "Robyn Harrison", 8);
        assertTrue(test.checkTaskDescription("Create Login to authenticate users"));
    }

    @Test
    public void testCheckTaskDescription_Invalid() {
        Task test = new Task("Login Feature", "Create Login", "Robyn Harrison", 8);
        assertFalse(test.checkTaskDescription("Create Login to authenticate users with a very very long description that exceeds the fifty characters limit"));
    }

    @Test
    public void testCreateTaskID() {
        Task test = new Task("Login Feature", "Create Login", "Robyn Harrison", 8);
        assertEquals("LO:1:RH", test.getTaskID());
    }

    @Test
    public void testPrintTaskDetails() {
        Task test = new Task("Login Feature", "Create Login", "Robyn Harrison", 8);
        String expected = "Task Name: Login Feature\nTask Description: Create Login\nDeveloper Details: Robyn Harrison\nTask Duration: 8 hours\nTask Status: null\nTask ID: LO:1:RH";
        assertEquals(expected, test.printTaskDetails());
    }

    @Test
    public void testGetAllTasks() {
        new Task("Login Feature", "Create Login", "Robyn Harrison", 8);
        new Task("Registration Feature", "Create Registration", "John Doe", 10);
        assertEquals(2, Task.getAllTasks().size());
    }
}
