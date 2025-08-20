// Lambda Expressions – Notification Filtering

class Alert {
    String type;  // e.g., "critical", "reminder"
    String message;
}

class App {
    void showAlerts(List<Alert> alerts, Predicate<Alert> filter) {
        alerts.stream().filter(filter).forEach(a -> print a.message);
    }

    void demo() {
        List<Alert> alerts = ...;

        // only critical alerts
        Predicate<Alert> criticalOnly = (a) -> a.type.equals("critical");

        showAlerts(alerts, criticalOnly);
    }
}
