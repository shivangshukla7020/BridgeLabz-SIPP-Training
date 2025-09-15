import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Example {
    @BugReport(description = "Null pointer exception possible")
    @BugReport(description = "Needs input validation")
    public void buggyMethod() {
        System.out.println("Executing buggy method");
    }
}

public class RepeatableAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = Example.class.getMethod("buggyMethod");
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for(BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
        new Example().buggyMethod();
    }
}