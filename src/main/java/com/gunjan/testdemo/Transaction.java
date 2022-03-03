package com.gunjan.testdemo;

import java.util.LinkedList;
import java.util.List;

public class Transaction {
	List<Account> accounts = new LinkedList<Account>();

	public Transaction(List<Account> accounts) {
		super();
		this.accounts = accounts;
	}

	public Account findAccount(int accNo) {
		for (Account a : accounts) {
			if (a.getAccNo() == accNo) {
				return a;
			}
		}
		return null;
	}

	public double withdraw(int accNo, double amt) {
		Account acc = findAccount(accNo);
		if (acc.getBalance() > amt) {
			double temp = acc.getBalance() - amt;
			acc.setBalance(temp);
			return temp;
		}
		else {
			return amt;
		}
	}

	public double deposit(int accNo, double amt) {
		Account acc = findAccount(accNo);
		double temp = acc.getBalance() + amt;
		acc.setBalance(temp);
		return temp;
	}

}
