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
