package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new SavingsAccount());
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void checkingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new CheckingAccount();
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(BigDecimal.valueOf(100.0));
        assertEquals(0.1, bank.totalInterestPaid().doubleValue(), DOUBLE_DELTA);
    }

    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new SavingsAccount();
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(BigDecimal.valueOf(1500.0));

        assertEquals(2.0, bank.totalInterestPaid().doubleValue(), DOUBLE_DELTA);
    }

    @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new MaxiSavingsAccount();
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(BigDecimal.valueOf(3000.0));

        assertEquals(170.0, bank.totalInterestPaid().doubleValue(), DOUBLE_DELTA);
    }

}
