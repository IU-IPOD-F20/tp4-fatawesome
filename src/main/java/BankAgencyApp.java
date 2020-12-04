import java.util.Scanner;

import application.AccesBankAgency;
import application.BankAgencyActionContext;
import application.BankAgencyActionList;
import application.BankAgencyGenericAction;
import application.actions.AccountsManagementAction;
import application.actions.GetAccountAction;
import application.actions.ListAction;
import application.actions.OperationsAction;
import bank.BankAgency;
import bank.Account;
import bank.exception.AccountException;

public class BankAgencyApp {
    public static BankAgencyGenericAction getListAction(BankAgencyActionList returnTo) {
        return new ListAction("List of the Agency accounts", "1", returnTo);
    }

    public static BankAgencyGenericAction getAccountAction(BankAgencyActionList returnTo) {
        return new GetAccountAction("See an account (by its number)", "2", returnTo);
    }

    public static BankAgencyActionList getOperationsAction(BankAgencyActionList returnTo) {
        return new OperationsAction("Operations on an account", "3", "Menu Operation on an account", returnTo);
    }

    public static BankAgencyActionList getAccontsManagementAction(BankAgencyActionList returnTo) {
        return new AccountsManagementAction("Accounts management", "4", "Menu Accounts management", returnTo);
    }

    public static void main(String[] args) throws Exception {
        BankAgencyActionList actionList = new BankAgencyActionList("Return to main menu", "0", "General Menu");
        actionList.addAction(getListAction(actionList));
        actionList.addAction(getAccountAction(actionList));
        actionList.addAction(getOperationsAction(actionList));
        actionList.addAction(getAccontsManagementAction(actionList));

        actionList.execute(BankAgencyActionContext.getInstance(AccesBankAgency.getBankAgency()));
    }

	public static void ownerAccounts(BankAgency ag, String ownerName) {
		Account []  t;

		t = ag.getAccountsOf(ownerName);
		if (t.length == 0) {
			System.out.println("no account on this name ...");
		} else {
			System.out.println("  " + t.length + " accounts for " + ownerName);
			for (int i=0; i<t.length; i++)
				t[i].print();
		}
	}

	public static void depositOnAccount(BankAgency ag, String accountNumber, double amount) {
		Account c;

		c = ag.getAccount(accountNumber);
		if (c==null) {
			System.out.println("Account not existing ...");
		} else {
			System.out.println("Balance before deposit: "+c.balance());
			try {
				c.deposit(amount);
				System.out.println("Balance after deposit: "+c.balance());
			} catch (AccountException e) {
				System.out.println("Deposit error, Balance unchanged: " + c.balance());
				System.out.println(e.getMessage());
			}
		}
	}

	public static void withdrawFromAccount(BankAgency ag, String accountNumber, double amount) {
		Account c;

		c = ag.getAccount(accountNumber);
		if (c==null) {
			System.out.println("Account not existing ...");
		} else {
			System.out.println("Balance before withdrawal: " + c.balance());
			try {
				c.withdraw(amount);
				System.out.println("Balance after withdrawal: "+c.balance());
			} catch (AccountException e) {
				System.out.println("Withdraw error, Balance unchanged: " + c.balance());
				System.out.println(e.getMessage());
			}
		}

	}
}
