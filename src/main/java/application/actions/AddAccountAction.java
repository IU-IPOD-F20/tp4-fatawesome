package application.actions;

import action.ActionContext;
import application.BankAgencyActionList;
import application.BankAgencyGenericAction;
import bank.Account;
import bank.BankAgency;

import java.util.Scanner;

public class AddAccountAction extends BankAgencyGenericAction {

    private final BankAgencyActionList returnTo;

    public AddAccountAction(String lineMessage, String code, BankAgencyActionList returnTo) {
        super(lineMessage, code);
        this.returnTo = returnTo;
    }

    @Override
    public void execute(ActionContext<BankAgency> e) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next().toLowerCase();
        String name = scanner.next().toUpperCase();
        e.getContext().addAccount(new Account(id, name));
        System.out.println("Add action complete");
        this.returnTo.execute(e);
    }
}
