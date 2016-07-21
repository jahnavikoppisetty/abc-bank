package com.abc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public BigDecimal totalInterestEarned() {
    	BigDecimal total = BigDecimal.ZERO;
        for (Account account : accounts)
            total = total.add(account.interestEarned());
        return total;
    }

    public String getStatement() {
    	StringBuilder statement = new StringBuilder();
    	statement.append("Statement for " + name + "\n");
    	statement.append("************************************");
    	BigDecimal total = BigDecimal.ZERO;
    	 for (Account a : accounts) {
    		 statement.append("\n" + a.getStatement() + "\n");
    		 total = total.add(a.sumTransactions());
    	 }
    	 statement.append("************************************");
    	 statement.append("\nTotal In All Accounts " + Util.toDollars(total));
    	 return statement.toString();
    }
    
}
