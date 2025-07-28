import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber, holderName, coverageType;
    LocalDate expiryDate;
    double premium;

    Policy(String num, String name, String type, LocalDate expiry, double premium) {
        this.policyNumber = num;
        this.holderName = name;
        this.coverageType = type;
        this.expiryDate = expiry;
        this.premium = premium;
    }

    @Override
    public String toString() {
        return policyNumber + " | " + holderName + " | " + coverageType + " | " + expiryDate + " | " + premium;
    }
}

public class InsuranceSystem {
    Map<String, Policy> hashPolicies = new HashMap<>();
    Map<String, Policy> linkedPolicies = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> treePolicies = new TreeMap<>();

    // Add policy
    public void addPolicy(Policy p) {
        hashPolicies.put(p.policyNumber, p);
        linkedPolicies.put(p.policyNumber, p);
        treePolicies.computeIfAbsent(p.expiryDate, k -> new ArrayList<>()).add(p);
    }

    // Retrieve by policy number
    public Policy getPolicy(String num) {
        return hashPolicies.get(num);
    }

    // List policies expiring in next 30 days
    public List<Policy> expiringSoon() {
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(30);
        List<Policy> res = new ArrayList<>();
        for (Map.Entry<LocalDate, List<Policy>> e : treePolicies.subMap(now, true, limit, true).entrySet())
            res.addAll(e.getValue());
        return res;
    }

    // List policies by policyholder
    public List<Policy> byHolder(String name) {
        List<Policy> res = new ArrayList<>();
        for (Policy p : linkedPolicies.values())
            if (p.holderName.equalsIgnoreCase(name)) res.add(p);
        return res;
    }

    // Remove expired policies
    public void removeExpired() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> it = linkedPolicies.entrySet().iterator();
        while (it.hasNext()) {
            Policy p = it.next().getValue();
            if (p.expiryDate.isBefore(today)) {
                hashPolicies.remove(p.policyNumber);
                it.remove();
                treePolicies.get(p.expiryDate).remove(p);
            }
        }
    }

    public static void main(String[] args) {
        InsuranceSystem sys = new InsuranceSystem();
        sys.addPolicy(new Policy("P1","John","Health",LocalDate.now().plusDays(10),5000));
        sys.addPolicy(new Policy("P2","Alice","Auto",LocalDate.now().plusDays(40),3000));
        sys.addPolicy(new Policy("P3","John","Home",LocalDate.now().minusDays(5),7000));

        System.out.println("Retrieve P1: " + sys.getPolicy("P1"));
        System.out.println("Expiring soon: " + sys.expiringSoon());
        System.out.println("Policies by John: " + sys.byHolder("John"));
        sys.removeExpired();
        System.out.println("After removing expired: " + sys.linkedPolicies.values());
    }
}
