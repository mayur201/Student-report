import java.util.ArrayList;
import java.util.List;

public class StudentReport {

  static class Student {
    String name;
    int age;
    int semester;
    int englishMarks;
    int mathMarks;
    int scienceMarks;

    public Student(String name, int age, int semester, int englishMarks, int mathMarks, int scienceMarks) {
      this.name = name;
      this.age = age;
      this.semester = semester;
      this.englishMarks = englishMarks;
      this.mathMarks = mathMarks;
      this.scienceMarks = scienceMarks;
    }

    public double getAverageMarks() {
      return (englishMarks + mathMarks + scienceMarks) / 3.0;
    }
  }

  public static void main(String[] args) {
    // Create a list of students
    List<Student> students = new ArrayList<>();
    students.add(new Student("Mayur", 20, 1, 90, 80, 85));
    students.add(new Student("Bob", 21, 2, 80, 70, 77));
    students.add(new Student("Gautam", 22, 1, 70, 60, 90));
    students.add(new Student("KK", 23, 2, 60, 50, 88));

    // Calculate average percentage of whole class in recent semester
    int totalMarks = 0;
    int totalStudents = 0;
    for (Student student : students) {
      if (student.semester == 2) {
        totalMarks += student.englishMarks + student.mathMarks + student.scienceMarks;
        totalStudents++;
      }
    }
    double averagePercentage = totalMarks / (totalStudents * 3.0) * 100;
    System.out.println("Average percentage of whole class in recent semester: " + averagePercentage + "%\n");

    // Calculate average marks of students in English
    totalMarks = 0;
    totalStudents = 0;
    for (Student student : students) {
      totalMarks += student.englishMarks;
      totalStudents++;
    }
    double averageMarks = totalMarks / totalStudents;
    System.out.println("Average marks of students in English: " + averageMarks);
    
    // Calculate average marks of students in Maths
    totalMarks = 0;
    totalStudents = 0;
    for (Student student : students) {
      totalMarks += student.mathMarks;
      totalStudents++;
    }
    averageMarks = totalMarks / totalStudents;
    System.out.println("Average marks of students in Maths: " + averageMarks);
    
    // Calculate average marks of students in Science
    totalMarks = 0;
    totalStudents = 0;
    for (Student student : students) {
      totalMarks += student.scienceMarks;
      totalStudents++;
    }
    averageMarks = totalMarks / totalStudents;
    System.out.println("Average marks of students in Science: " + averageMarks);


    // Find top 2 consistent students across all semesters
    students.sort((s1, s2) -> (int) (s2.getAverageMarks() - s1.getAverageMarks()));
    System.out.println("Top 2 consistent students across all semesters:");
    for (int i = 0; i < 2; i++) {
      System.out.println(students.get(i).name + ": " + students.get(i).getAverageMarks());
    }
  }
}
