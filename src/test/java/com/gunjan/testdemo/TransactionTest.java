package com.gunjan.testdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionTest {
	List<Account> accounts = new LinkedList<Account>();

	Transaction tn = new Transaction(accounts);

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Initializing the sample data....");
		accounts.add(new Account(1001, "Mahendra", 23000D));
		accounts.add(new Account(1002, "Sonali", 29000D));
		accounts.add(new Account(1003, "Dakshata", 2100D));
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Cleaning / Deleting the sample ....");
		accounts.clear();
	}

	@Test
	void testDeposit() {
		System.out.println("testing deposits...");
		tn.deposit(1001, 3000);
		double amt = tn.findAccount(1001).getBalance();
		assertEquals(26000D,amt,0.01);
	}

	@Test
	void testWithdraw() {
		System.out.println("testing withdrawals...");
		tn.withdraw(1003, 3000);
		double amt = tn.findAccount(1003).getBalance();
		assertEquals(2100D, amt,0.01);
	}

}
