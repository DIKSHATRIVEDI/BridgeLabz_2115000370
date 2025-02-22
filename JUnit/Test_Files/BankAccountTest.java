package junit;

import junit.framework.TestCase;

public class BankAccountTest extends TestCase {
    private BankAccount account;

    protected void setUp() {
        account = new BankAccount(100.0);
    }

    public void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    public void testWithdrawSufficientFunds() {
        boolean result = account.withdraw(30.0);
        assertTrue(result);
        assertEquals(70.0, account.getBalance(), 0.001);
    }

    public void testWithdrawInsufficientFunds() {
        boolean result = account.withdraw(150.0);
        assertFalse(result);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    public void testWithdrawNegativeAmount() {
        boolean result = account.withdraw(-10.0);
        assertFalse(result);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    public void testDepositNegativeAmount() {
        account.deposit(-20.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }
}
