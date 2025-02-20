import java.time.LocalDate;
import java.util.*;
class InsurancePolicy {
    private String policyNumber;
    private String policyHolder;
    private LocalDate expiryDate;
    public InsurancePolicy(String policyNumber, String policyHolder, LocalDate expiryDate) {
        this.policyNumber=policyNumber;
        this.policyHolder=policyHolder;
        this.expiryDate=expiryDate;
    }
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyHolder() { return policyHolder; }
    public LocalDate getExpiryDate() { return expiryDate; }
    @Override public String toString() {
        return "Policy Number --> " + policyNumber + ", Policy Holder --> " + policyHolder + ", Expiry Date --> " + expiryDate;
    }
}
class InsurancePolicyManagementSystem {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private NavigableMap<LocalDate, InsurancePolicy> sortedPolicyMap = new TreeMap<>();
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPolicyMap.put(policy.getExpiryDate(), policy);
    }
    public InsurancePolicy getPolicyByNumber(String policyNumber) { return policyMap.get(policyNumber); }
    public List<InsurancePolicy> getPoliciesExpiringWithin(int days) {
        LocalDate now = LocalDate.now();
        LocalDate thresholdDate = now.plusDays(days);
        return new ArrayList<>(sortedPolicyMap.subMap(now, true, thresholdDate, true).values());
    }
    public List<InsurancePolicy> getPoliciesByHolder(String policyHolder) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyHolder().equalsIgnoreCase(policyHolder)) {
                result.add(policy);
            }
        }
        return result;
    }
    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        Iterator<Map.Entry<LocalDate, InsurancePolicy>> iterator = sortedPolicyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().isBefore(now)) {
                InsurancePolicy policy = entry.getValue();
                policyMap.remove(policy.getPolicyNumber());
                orderedPolicyMap.remove(policy.getPolicyNumber());
                iterator.remove();
            }
        }
    }
    public void listAllPolicies() {
        for (InsurancePolicy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }
}
public class InsurancePolicyManagement {
    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();
        system.addPolicy(new InsurancePolicy("P123", "Riya", LocalDate.now().plusDays(10)));
        system.addPolicy(new InsurancePolicy("P124", "Siya", LocalDate.now().plusDays(40)));
        system.addPolicy(new InsurancePolicy("P125", "Jiya", LocalDate.now().plusDays(20)));
        system.addPolicy(new InsurancePolicy("P126", "Piya", LocalDate.now().minusDays(5)));
        System.out.println("All Policies --> ");
        system.listAllPolicies();
        System.out.println("Policies Expiring in Next 30 Days --> ");
        for (InsurancePolicy policy : system.getPoliciesExpiringWithin(30)) {
            System.out.println(policy);
        }
        System.out.println("Policies for Piya");
        for (InsurancePolicy policy : system.getPoliciesByHolder("Piya")) {
            System.out.println(policy);
        }
        System.out.println("Removing Expired Policies ");
        system.removeExpiredPolicies();
        System.out.println("All Policies After Cleanup --> ");
        system.listAllPolicies();
    }
}
