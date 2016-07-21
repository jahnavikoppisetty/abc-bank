package com.abc;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	
    private final BigDecimal transactionAmount;

    private final Date transactionDate;

    public Transaction(BigDecimal amount) {
        this.transactionAmount = amount;
        this.transactionDate = DateProvider.getInstance().now();
    }

    public BigDecimal getTransactionAmount() {
    	return transactionAmount;
    }
    
    public Date getTransactionDate() {
    	return transactionDate;
    }
}
