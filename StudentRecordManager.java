import java.util.Map;
import java.util.TreeMap;

/**
 * StudentRecordManager handles operations related to student records using TreeMap.
 * This class demonstrates the use of TreeMap for managing student data with sorted access.
 */
public class StudentRecordManager {
    
    // TreeMap to store student records with student ID as the key
    private TreeMap<Integer, Student> studentRecords;
    
    /**
     * Constructor initializes an empty TreeMap
     */
    public StudentRecordManager() {
        this.studentRecords = new TreeMap<>();
    }
    
    /**
     * Adds a new student record to the TreeMap
     * 
     * @param id the student's unique ID
     * @param name the student's name
     * @param gpa the student's GPA
     * @return true if added successfully, false if the ID already exists
     */
    public boolean addStudent(int id, String name, double gpa) {
        // Check if student ID already exists
        if (studentRecords.containsKey(id)) {
            return false; // Student ID already exists
        }
        
        // Create new Student object and add to the TreeMap
        Student student = new Student(id, name, gpa);
        studentRecords.put(id, student);
        return true;
    }
    
    /**
     * Deletes a student record based on the student ID
     * 
     * @param id the student ID to delete
     * @return true if deleted successfully, false if the ID doesn't exist
     */
    public boolean deleteStudent(int id) {
        if (!studentRecords.containsKey(id)) {
            return false; // Student ID doesn't exist
        }
        
        studentRecords.remove(id);
        return true;
    }
    
    /**
     * Updates the GPA of a student with the given ID
     * 
     * @param id the student ID to update
     * @param newGpa the new GPA value
     * @return true if updated successfully, false if the ID doesn't exist
     */
    public boolean updateStudentGpa(int id, double newGpa) {
        Student student = studentRecords.get(id);
        
        if (student == null) {
            return false; // Student ID doesn't exist
        }
        
        student.setGpa(newGpa);
        return true;
    }
    
    /**
     * Displays all student records sorted by student ID
     */
    public void displayAllRecords() {
        System.out.println("Student Records (sorted by ID):");
        System.out.println("--------------------------------");
        
        if (studentRecords.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        
        for (Map.Entry<Integer, Student> entry : studentRecords.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("--------------------------------");
    }
    
    /**
     * Finds and displays students with GPA higher than the specified value
     * 
     * @param minGpa the minimum GPA value to filter by
     * @return the number of students found
     */
    public int findStudentsWithHigherGpa(double minGpa) {
        System.out.println("Students with GPA higher than " + minGpa + ":");
        System.out.println("--------------------------------");
        
        int count = 0;
        for (Student student : studentRecords.values()) {
            if (student.getGpa() > minGpa) {
                System.out.println(student);
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("No students found with GPA higher than " + minGpa);
        }
        
        System.out.println("--------------------------------");
        return count;
    }
    
    /**
     * Returns the total number of student records
     * 
     * @return the size of the TreeMap
     */
    public int getStudentCount() {
        return studentRecords.size();
    }
    
    /**
     * Gets a student by ID
     * 
     * @param id the student ID to find
     * @return the Student object if found, null otherwise
     */
    public Student getStudentById(int id) {
        return studentRecords.get(id);
    }
    
    /**
     * Main method to test the StudentRecordManager functionality
     */
    public static void main(String[] args) {
        StudentRecordManager manager = new StudentRecordManager();
        
        // Add student records
        System.out.println("Adding student records...");
        manager.addStudent(1001, "John Smith", 3.8);
        manager.addStudent(1005, "Emily Johnson", 3.9);
        manager.addStudent(1003, "Michael Brown", 3.5);
        manager.addStudent(1002, "Jessica Davis", 3.2);
        manager.addStudent(1004, "David Wilson", 2.9);
        
        // Display all records (should be sorted by ID)
        manager.displayAllRecords();
        
        // Update a student's GPA
        System.out.println("\nUpdating GPA for student with ID 1003...");
        manager.updateStudentGpa(1003, 3.7);
        
        // Display updated records
        manager.displayAllRecords();
        
        // Find students with GPA higher than 3.5
        System.out.println("\nFinding students with GPA higher than 3.5:");
        manager.findStudentsWithHigherGpa(3.5);
        
        // Delete a student record
        System.out.println("\nDeleting student with ID 1002...");
        manager.deleteStudent(1002);
        
        // Display remaining records
        manager.displayAllRecords();
    }
}