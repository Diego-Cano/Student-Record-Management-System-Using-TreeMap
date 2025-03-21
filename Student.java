/**
 * Student class represents a student entity with an ID, name, and GPA.
 * This class serves as the value in our TreeMap implementation.
 */
public class Student {
    private int id;
    private String name;
    private double gpa;
    
    /**
     * Constructor to create a new Student object
     * 
     * @param id the unique identifier for the student
     * @param name the name of the student
     * @param gpa the Grade Point Average of the student
     */
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    
    // Getters and setters
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    /**
     * Returns a string representation of the Student
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}