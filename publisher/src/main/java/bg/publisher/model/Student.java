package bg.publisher.model;

import java.util.List;

public class Student {

    private String id;
    private String name;
    private String facultyNumber;
    private int year;
    private String degree;
    private List<Course> enrolledCourses;

    public Student() {
    }

    public Student(String name, String facultyNumber, int year, String degree) {
        this.name = name;
        this.facultyNumber = facultyNumber;
        this.year = year;
        this.degree = degree;
    }

    public Student(String name, String facultyNumber, int year, String degree, List<Course> enrolledCourses) {
        this.name = name;
        this.facultyNumber = facultyNumber;
        this.year = year;
        this.degree = degree;
        this.enrolledCourses = enrolledCourses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", facultyNumber='" + facultyNumber + '\'' +
                ", year=" + year +
                ", degree='" + degree + '\'' +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }
}
