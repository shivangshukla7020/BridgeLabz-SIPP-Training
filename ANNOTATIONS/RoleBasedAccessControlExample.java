import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RoleAllowed {
    String value();
}

@RoleAllowed("ADMIN")
class AdminService {
    public void performAdminTask() {
        System.out.println("Admin task performed");
    }
}

public class RoleBasedAccessControlExample {
    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER";
        Class<?> cls = AdminService.class;
        if(cls.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed role = cls.getAnnotation(RoleAllowed.class);
            if(role.value().equals(currentUserRole)) {
                AdminService service = new AdminService();
                service.performAdminTask();
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}