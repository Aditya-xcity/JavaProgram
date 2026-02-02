// Question: Taking input from Command line and convert objects into primitive data type
// Name - ADITYA BHARDWAJ
// Section - D2
// Roll No - 07
// Course – B TECH
// Branch – CSE

class Program1 {
    public static void main(String[] args) {


        String name = args[0];
        String course = args[1];
        String universityRollNo = args[2];


        int semester = Integer.parseInt(args[3]);

        // Displaying the information
        System.out.println("Name: " + name);
        System.out.println("UniversityRollNo: " + universityRollNo);
        System.out.println("Course: " + course);
        System.out.println("Semester: " + semester);
    }
}
