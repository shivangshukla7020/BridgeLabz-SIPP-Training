public class BackgroundJob {
    public static void main(String[] args) {
        Runnable job = () -> System.out.println("Background job executed asynchronously.");
        Thread thread = new Thread(job);
        thread.start();
    }
}