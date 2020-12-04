package bank;

import bank.exception.AccountException;

public class Account {
	private String owner;
	private String accountNumber;
	private double debits, credits;
	private int nbDebits, nbCredits;

	public Account() {
		this("No number", "No owner");
	}

	public Account(String pAccountNumber, String pOwnerName) {
		this.accountNumber = pAccountNumber;
		this.owner = pOwnerName;
		this.debits = 0;
		this.credits = 0;
		this.nbCredits = 0;
		this.nbDebits = 0;
	}

	public double balance() {
		return this.credits - this.debits;
	}

	public String getOwner() {
		return this.owner;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void print() {
		System.out.println(this.toString());
	}

	public String toString() {
		return "  Num.: " + this.accountNumber + " - Owner: " + this.owner
				+ " - Debit " + this.debits + " E / Credit " + this.credits
				+ " E / NbOps " + (this.nbCredits + this.nbDebits);
	}

	public void withdraw(double pSum) throws AccountException {
		if (pSum < 0) {
			throw new AccountException(
					"Error negative withdraw value forbidden " + this.accountNumber);
		}
		this.debits = this.debits + pSum;
		this.nbDebits++;
	}

	public void deposit(double pSum) throws AccountException {
		if (pSum < 0) {
			throw new AccountException(
					"Error negative deposit value forbidden " + this.accountNumber);
		}
		this.credits = this.credits + pSum;
		this.nbCredits++;
	}

	public void setOwner(String pOwnerName) {
		this.owner = pOwnerName;
	}
}
