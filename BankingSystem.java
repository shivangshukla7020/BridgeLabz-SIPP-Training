import java.util.*;

public class BankingSystem {
    Map<String, Double> accounts = new HashMap<>();
    TreeMap<Double, String> sortedAccounts = new TreeMap<>();
    Queue<String> withdrawals = new LinkedList<>();

    public void addAccount(String acc, double bal) {
        accounts.put(acc, bal);
        sortedAccounts.put(bal, acc);
    }

    public void requestWithdrawal(String acc) {
        withdrawals.add(acc);
    }

    public void processWithdrawals() {
        while (!withdrawals.isEmpty()) {
            String acc = withdrawals.poll();
            System.out.println("Processing withdrawal for " + acc);
        }
    }

    public static void main(String[] args) {
        BankingSystem bs = new BankingSystem();
        bs.addAccount("A1", 5000);
        bs.addAccount("A2", 2000);
        bs.addAccount("A3", 8000);
        System.out.println("Sorted by balance: " + bs.sortedAccounts);
        bs.requestWithdrawal("A1");
        bs.requestWithdrawal("A3");
        bs.processWithdrawals();
    }
}
    