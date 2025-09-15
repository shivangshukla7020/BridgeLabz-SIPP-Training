import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Sample {
    @ImportantMethod
    public void methodOne() {
        System.out.println("Method One executed");
    }

    @ImportantMethod(level = "MEDIUM")
    public void methodTwo() {
        System.out.println("Method Two executed");
    }
}

public class ImportantMethodExample {
    public static void main(String[] args) throws Exception {
        Method[] methods = Sample.class.getDeclaredMethods();
        for(Method method : methods) {
            if(method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }
}