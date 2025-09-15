import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello!");
    }
}

public class CustomLoggingProxy {
    public static void main(String[] args) {
        Greeting greeting = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            new InvocationHandler() {
                private final Greeting impl = new GreetingImpl();
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("Method called: " + method.getName());
                    return method.invoke(impl, args);
                }
            }
        );
        greeting.sayHello();
    }
}