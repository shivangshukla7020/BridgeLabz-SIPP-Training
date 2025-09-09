interface PaymentProcessor {
    void processPayment(double amount);

    default void refund(double amount) {
        System.out.println("Refunded " + amount + " back to account.");
    }
}

class PayApp implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount);
    }
}