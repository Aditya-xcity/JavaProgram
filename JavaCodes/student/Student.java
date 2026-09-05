package student;

public class Student
{
    private final int studentId;
    private final String name;
    private final int age;

    public Student(int studentId, String name, int age)
    {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public String getStudentInfo()
    {
        return "Student ID: " + studentId + ", Name: " + name + ", Age: " + age;
    }
}
