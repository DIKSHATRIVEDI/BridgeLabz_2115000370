import java.util.*;
class BankingSystem {
    private Map<String, Double> accountMap = new HashMap<>();
    private NavigableMap<Double, String> sortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();
    public void addAccount(String accountNumber, double balance) {
        accountMap.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }
    public void withdrawalRequest(String accountNumber) {
        if (accountMap.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal requested for account --> " + accountNumber);
        }
        else {
            System.out.println("Account not found");
        }
    }
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawalRequest for account --> " + accountNumber);
        }
    }
    public void display() {
        System.out.println("Accounts sorted by balance --> ");
        for (Map.Entry<Double, String> entry : sortedAccounts.entrySet()) {
            System.out.println("Account --> " + entry.getValue() + " - Balance --> $" + entry.getKey());
        }
    }
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("B-1", 5000.00);
        bank.addAccount("B-2", 3000.00);
        bank.addAccount("B-3", 7000.00);
        bank.withdrawalRequest("B-2");
        bank.withdrawalRequest("B-3");
        bank.processWithdrawals();
        bank.display();
    }
}
