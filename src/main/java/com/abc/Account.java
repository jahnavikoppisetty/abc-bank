package com.abc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

	public List<Transaction> transactions;

	public Account() {
		this.transactions = new ArrayList<Transaction>();
	}

	public void deposit(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			transactions.add(new Transaction(amount));
		}
	}

	public void withdraw(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			transactions.add(new Transaction(amount.negate()));
		}
	}

	public BigDecimal interestEarned() {
		BigDecimal amount = sumTransactions();
		return calculateInterest(amount);
		// switch(accountType){
		// case SAVINGS:
		// if (amount <= 1000)
		// return amount * 0.001;
		// else
		// return 1 + (amount-1000) * 0.002;
		//// case SUPER_SAVINGS:
		//// if (amount <= 4000)
		//// return 20;
		// case MAXI_SAVINGS:
		// if (amount <= 1000)
		// return amount * 0.02;
		// if (amount <= 2000)
		// return 20 + (amount-1000) * 0.05;
		// return 70 + (amount-2000) * 0.1;
		// default:
		// return amount * 0.001;
		// }
	}

	public BigDecimal sumTransactions() {
		BigDecimal amount = BigDecimal.ZERO;
		for (Transaction transaction : transactions) {
			amount = amount.add(transaction.getTransactionAmount());
		}
		return amount;
	}

	abstract AccountType getAccountType();

	abstract BigDecimal calculateInterest(BigDecimal amount);

	public String getStatement() {
		StringBuilder sb = new StringBuilder();

		sb.append(getAccountType().getDescription());
		sb.append("\n =====================================");
		BigDecimal total = BigDecimal.ZERO;
		for (Transaction transaction : transactions) {
			if (transaction.getTransactionAmount().compareTo(BigDecimal.ZERO) > 0){
				sb.append(String.format(" \n Amount Deposited - $%f", transaction.getTransactionAmount()));
			} else {
				sb.append(String.format(" \n Amount Withdrawn - $%f", transaction.getTransactionAmount()));
			}
			total = total.add(transaction.getTransactionAmount());
		}
		sb.append("\n =====================================");
		sb.append("\n Total Balance - $%d " + total);
		sb.append("\n =====================================");
		return sb.toString();
	}

}
