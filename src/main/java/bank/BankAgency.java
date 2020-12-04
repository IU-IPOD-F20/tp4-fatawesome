package bank;

import java.util.ArrayList;

import bank.exception.ABAccountAlreadyExistingException;
import bank.exception.ABInexistingAccountException;
import bank.exception.ABNullAccountException;


// V ARRAYLLIST OK

public class BankAgency {
	private String name, loc;
	private ArrayList<Account> accounts;

	public BankAgency(String pNomAgence, String pLocAgence) {
		this.name = pNomAgence;
		this.loc = pLocAgence;
		this.accounts = new ArrayList<Account>();
	}

	public String getAgencyName() {
		return this.name;
	}

	public String getAgencyLoc() {
		return this.loc;
	}

	public int getNbAccounts() {
		return this.accounts.size();
	}

	public Account getAccount(String pNumCompte) {
		return this.findAccount(pNumCompte);
	}

	public Account[] getAccountsOf(String pOwnerName) {
		Account t[], cTemp;
		ArrayList<Account> alTemp;
		int nbC, nbCTemp, i;

		t = null;

		alTemp = new ArrayList<Account>();
		nbC = this.accounts.size();
		for (i = 0; i < nbC; i++) {
			cTemp = accounts.get(i);
			if (cTemp.getOwner().equals(pOwnerName)) {
				alTemp.add(cTemp);
			}
		}

		if (alTemp.size() != 0) {
			nbCTemp = alTemp.size();
			t = new Account[nbCTemp];
			for (i = 0; i < nbCTemp; i++) {
				t[i] = alTemp.get(i);
			}
		} else {
			t = new Account[0];
		}
		return t;
	}

	public void print() {
		int i, nbC;
		Account cTemp;

		System.out.println();
		System.out.println("Name: " + this.name + " (" + this.loc + ")");
		System.out.println("" + this.accounts.size() + " Accounts:");
		nbC = this.accounts.size();
		for (i = 0; i < nbC; i++) {
			cTemp = accounts.get(i);
			cTemp.print();
			System.out.println("   Balance: " + cTemp.balance());
		}
		System.out.println();
	}

	public String toString() {
		return "Agency Name: " + this.name + " (" + this.loc + ") : "+this.accounts.size()+" accounts";
	}

	public void addAccount(Account pAccountToAdd) throws ABNullAccountException, ABAccountAlreadyExistingException {
		Account c;

		if (pAccountToAdd == null) {
			throw new ABNullAccountException("Errorr adding 'null' Account in Agency " 
					+ this.name + " (" + this.loc + ")");
		}

		c = this.findAccount(pAccountToAdd.getAccountNumber());

		if (c != null) {
			throw new ABAccountAlreadyExistingException(
					"Error adding existing Account ("
					+ pAccountToAdd.getAccountNumber() + ") in Agency " 
					+ this.name + " (" + this.loc + ")");
		} else {
			this.accounts.add(pAccountToAdd);

		}
	}

	public void removeAccount(String pNumCompte) throws ABInexistingAccountException{
		Account c;
		c = this.findAccount(pNumCompte);

		if (c == null) {
			throw new ABInexistingAccountException(
					"Error suppressing inexisting Account ("
					+ pNumCompte+ ") in Agency " 
					+ this.name + " (" + this.loc + ")");
		} else {
			this.accounts.remove(c);
		}
	}

	private Account findAccount(String pNC) {
		Account c, cTemp;
		int i, nbC;

		nbC = this.accounts.size();
		c = null;
		for (i = 0; i < nbC && c == null; i++) {
			cTemp = accounts.get(i);
			if (cTemp.getAccountNumber().equals(pNC)) {
				c = cTemp;
			}
		}
		return c;
	}
}