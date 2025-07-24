import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String title;
    public CourseType(String title) { this.title = title; }
    public String getTitle() { return title; }
}

class ExamCourse extends CourseType {
    public ExamCourse(String title) { super(title); }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title) { super(title); }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title) { super(title); }
}

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();
    public void addCourse(T course) { courseList.add(course); }
    public List<T> getCourses() { return courseList; }
    public static void printCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getTitle());
        }
    }
}

public class MultiLevelUniversityCourseManagementSystem {
    public static void main(String[] args) {
        Course<ExamCourse> exams = new Course<>();
        exams.addCourse(new ExamCourse("Maths Exam"));

        Course<AssignmentCourse> assignments = new Course<>();
        assignments.addCourse(new AssignmentCourse("OOP Assignment"));

        Course.printCourses(exams.getCourses());
        Course.printCourses(assignments.getCourses());
    }
}