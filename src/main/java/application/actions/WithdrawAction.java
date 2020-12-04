package application.actions;

import action.ActionContext;
import application.BankAgencyActionList;
import application.BankAgencyGenericAction;
import bank.BankAgency;

import java.util.Scanner;

public class WithdrawAction extends BankAgencyGenericAction {
    private final BankAgencyActionList returnTo;

    public WithdrawAction(String lineMessage, String code, BankAgencyActionList returnTo) {
        super(lineMessage, code);
        this.returnTo = returnTo;
    }

    @Override
    public void execute(ActionContext<BankAgency> e) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account id:");
        String id = scanner.next().toLowerCase();
        System.out.println("Enter amount to withdraw:");
        double amount = Double.parseDouble(scanner.next());
        e.getContext().getAccount(id).withdraw(amount);
        System.out.println("Withdraw action complete");
        this.returnTo.execute(e);
    }
}
