// Method References – Invoice Object Creation

class Invoice {
    String transactionId;
    Invoice(String id) {
        this.transactionId = id;
    }
}

class Billing {
    void generate(List<String> txIds) {
        List<Invoice> invoices =
            txIds.stream()
                 .map(Invoice::new)  // constructor reference
                 .collect(Collectors.toList());

        invoices.forEach(inv -> print "Invoice created for Tx: " + inv.transactionId);
    }
}
