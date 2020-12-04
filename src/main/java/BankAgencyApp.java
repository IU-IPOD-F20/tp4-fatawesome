import java.util.Locale;
import java.util.Scanner;

import application.AccesBankAgency;
import bank.BankAgency;
import bank.Account;
import bank.exception.AccountException;

public class BankAgencyApp {
	public static void printMenu(BankAgency ag) {
        printMenuHeader(ag, "General Menu");
        System.out.println("  Choose");
		System.out.println("    1 - List of the Agency accounts");
		System.out.println("    2 - See an account (by its number)");
        System.out.println("    3 - Operations on an account");
        System.out.println("    4 - Accounts management");
//		System.out.println("p - See the accounts of an owner (by its name)");
//		System.out.println("d - Deposit money on an account");
//		System.out.println("r - Withdraw money from an account");
		printExit();
	    printChoicePrompt();
	}

    public static void printOperationsMenu(BankAgency ag) {
        printMenuHeader(ag, "Menu Operation on an account");
        System.out.println("  Choose:");
        System.out.println("    1 - Deposit money on an account");
        System.out.println("    2 - Withdraw money from an account");
        printExit();
        printChoicePrompt();
    }

    public static void printAccountsManagementMenu(BankAgency ag) {
        printMenuHeader(ag, "Menu Accounts management");
        System.out.println("  Choose:");
        System.out.println("    1 - Add an account");
        System.out.println("    2 - Delete an account");
        printExit();
        printChoicePrompt();
    }

    public static void printMenuHeader(BankAgency ag, String menuName) {
        System.out.println("--");
        System.out.println("  " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
        System.out.println("  " + menuName);
        System.out.println("--");
    }

    public static void printExit() {
        printExit(0);
    }
    public static void printExit(Integer choiceNumber) {
        System.out.println("\n" + choiceNumber + " - To quit this menu");
    }

    public static void printChoicePrompt() {
        System.out.println("Choice ?");
    }

	public static void tempo() {
		Scanner scanner ;
		scanner = new Scanner (System.in );
		System.out.print("Type any car + return to continue ... ");
		scanner.next();
	}

	public static void main(String argv[]) {

		String choice;

		boolean proceed;
		Scanner scanner;
		BankAgency myAgency;

		String name, number;
		Account c;
		double amount;

		scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);

		myAgency = AccesBankAgency.getBankAgency();

		proceed = true;
		while (proceed) {
			BankAgencyApp.printMenu(myAgency);
			choice = scanner.next();
			choice = choice.toLowerCase();
			switch (choice) {
				case "0" :
					System.out.println("ByeBye");
//					BankAgencyApp.tempo();
					proceed = false;
					break;
				case "1" :
					myAgency.print();
//					BankAgencyApp.tempo();
					break;
				case "2" :
					System.out.print("Account Number -> ");
					number = scanner.next();
					c = myAgency.getAccount(number);
					if (c==null) {
						System.out.println("Account non existing ...");
					} else {
						c.print();
					}
//					BankAgencyApp.tempo();
					break;
                case "3" :
                    printOperationsMenu(myAgency);
                    choice = scanner.next().toLowerCase();
//                    BankAgencyApp.tempo();
                    break;
                case "4" :
                    printAccountsManagementMenu(myAgency);
                    choice = scanner.next().toLowerCase();
//                    BankAgencyApp.tempo();
                    break;
				case "p" : // TODO
					System.out.print("Owner -> ");
					name = scanner.next();
					BankAgencyApp.ownerAccounts(myAgency, name);
//					BankAgencyApp.tempo();
					break;
				case "d" :
					System.out.print("Account Number -> ");
					number = scanner.next();
					System.out.print("Deposit amount -> ");
					amount = scanner.nextDouble();
					BankAgencyApp.depositOnAccount(myAgency, number, amount);
//					BankAgencyApp.tempo();
					break;
				case "r" :
					System.out.print("Account Number -> ");
					number = scanner.next();
					System.out.print("Withdraw amount -> ");
					amount = scanner.nextDouble();
					BankAgencyApp.withdrawFromAccount(myAgency, number, amount);
//					BankAgencyApp.tempo();
					break;
				default :
					System.out.println("Problem ...");
//					BankAgencyApp.tempo();
					break;
			}
		}

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
