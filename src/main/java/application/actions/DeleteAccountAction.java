package application.actions;

import action.ActionContext;
import application.BankAgencyActionList;
import application.BankAgencyGenericAction;
import bank.BankAgency;

import java.util.Scanner;

public class DeleteAccountAction extends BankAgencyGenericAction {

    private final BankAgencyActionList returnTo;

    public DeleteAccountAction(String lineMessage, String code, BankAgencyActionList returnTo) {
        super(lineMessage, code);
        this.returnTo = returnTo;
    }

    @Override
    public void execute(ActionContext<BankAgency> e) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account id:");
        String id = scanner.next().toLowerCase();
        e.getContext().removeAccount(id);
        System.out.println("Delete action complete");
        this.returnTo.execute(e);
    }
}
