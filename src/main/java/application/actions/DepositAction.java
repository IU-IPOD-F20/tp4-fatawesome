package application.actions;

import action.ActionContext;
import application.BankAgencyActionList;
import application.BankAgencyGenericAction;
import bank.BankAgency;

import java.util.Scanner;

public class DepositAction extends BankAgencyGenericAction {
    private final BankAgencyActionList returnTo;
    protected DepositAction(String lineMessage, String code, BankAgencyActionList returnTo) {
        super(lineMessage, code);
        this.returnTo = returnTo;
    }

    @Override
    public void execute(ActionContext<BankAgency> e) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account id:");
        String id = scanner.next().toLowerCase();
        System.out.println("Enter amount of deposit:");
        double amount = Double.parseDouble(scanner.next());
        e.getContext().getAccount(id).deposit(amount);
        System.out.println("Deposit action complete");
        this.returnTo.execute(e);
    }
}
