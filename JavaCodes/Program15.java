import course.Course;
import enrollment.Enrollment;
import student.Student;

/* Design a student management system using Java 
packages. The system should manage information 
about students, courses, and their enrolments. You will 
organize the functionality across multiple packages and 
use object-oriented principles such as encapsulation. 
1. In the student package, create a Student class 
with fields for studentId, name, and age. Include 
a constructor to initialize these fields and a 
getStudentInfo() method to return the student's 
details. 
2. In the course package, create a Course class 
with fields for courseId, courseName, and credits. 
Include a constructor and a getCourseInfo() 
method to return the course's details. 
3. In the enrollment package, create an Enrollment 
class that holds references to Student and 
Course objects. Include a constructor and a 
getEnrollmentInfo() method to return the 
enrollment details. 
  
4. In the default package, create instances of 
Student, Course, and Enrolment, then print 
details using the getStudentInfo(), 
getCourseInfo(), and getEnrollmentInfo() 
methods. */

public class Program15
{
    public static void main(String args[])
    {
        Student student = new Student(101, "Aditya Bhardwaj", 20);
        Course course = new Course("CS101", "Java Programming", 4);
        Enrollment enrollment = new Enrollment(student, course);

        System.out.println(student.getStudentInfo());
        System.out.println(course.getCourseInfo());
        System.out.println(enrollment.getEnrollmentInfo());
    }
}
