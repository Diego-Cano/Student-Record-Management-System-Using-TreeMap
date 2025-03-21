import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for StudentRecordManager
 * Contains test cases for normal scenarios and edge cases
 */
public class StudentRecordManagerTest {
    
    private StudentRecordManager manager;
    
    @BeforeEach
    public void setUp() {
        manager = new StudentRecordManager();
        // Add some test records
        manager.addStudent(1001, "John Smith", 3.8);
        manager.addStudent(1002, "Jessica Davis", 3.2);
        manager.addStudent(1003, "Michael Brown", 3.5);
    }
    
    // NORMAL TEST CASES
    
    /**
     * Test case for adding a new student successfully
     */
    @Test
    public void testAddNewStudent() {
        boolean result = manager.addStudent(1004, "David Wilson", 2.9);
        assertTrue(result);
        assertEquals(4, manager.getStudentCount());
        Student david = manager.getStudentById(1004);
        assertNotNull(david);
        assertEquals("David Wilson", david.getName());
        assertEquals(2.9, david.getGpa());
    }
    
    /**
     * Test case for deleting an existing student
     */
    @Test
    public void testDeleteExistingStudent() {
        boolean result = manager.deleteStudent(1002);
        assertTrue(result);
        assertEquals(2, manager.getStudentCount());
        assertNull(manager.getStudentById(1002));
    }
    
    /**
     * Test case for updating a student's GPA
     */
    @Test
    public void testUpdateStudentGpa() {
        boolean result = manager.updateStudentGpa(1003, 3.9);
        assertTrue(result);
        Student michael = manager.getStudentById(1003);
        assertEquals(3.9, michael.getGpa());
    }
    
    // EDGE TEST CASES
    
    /**
     * Test case for attempting to add a student with a duplicate ID
     */
    @Test
    public void testAddDuplicateStudent() {
        boolean result = manager.addStudent(1001, "Duplicate Student", 4.0);
        assertFalse(result);
        assertEquals(3, manager.getStudentCount());
        Student john = manager.getStudentById(1001);
        assertEquals("John Smith", john.getName());
    }
    
    /**
     * Test case for attempting to delete a non-existent student
     */
    @Test
    public void testDeleteNonExistentStudent() {
        boolean result = manager.deleteStudent(9999);
        assertFalse(result);
        assertEquals(3, manager.getStudentCount());
    }
    
    /**
     * Test case for attempting to update a non-existent student
     */
    @Test
    public void testUpdateNonExistentStudent() {
        boolean result = manager.updateStudentGpa(9999, 4.0);
        assertFalse(result);
    }
}