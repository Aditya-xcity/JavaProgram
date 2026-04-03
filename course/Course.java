package course;

public class Course
{
    private final String courseId;
    private final String courseName;
    private final int credits;

    public Course(String courseId, String courseName, int credits)
    {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseInfo()
    {
        return "Course ID: " + courseId + ", Course Name: " + courseName + ", Credits: " + credits;
    }
}
