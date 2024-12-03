package Servicei.com;
import Exception.com.*;
public interface Cjc {
public void addCourse() throws CourseNotFoundException, CourseNotFoundException;
public void viewCourse();
public void addFaculty()throws  FacultyNotFoundException, InvalidCourseForFacultyException;
public void viewFaculty();
public void addBatch() throws BatchNotFoundException;
public void viewBatch();
public void addStudent() throws StudentNotFoundException;
public void viewStudent();
}
