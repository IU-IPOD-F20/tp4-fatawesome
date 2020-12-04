package application.actions;

import action.ActionContext;
import application.BankAgencyActionList;
import application.BankAgencyGenericAction;
import bank.BankAgency;

import java.util.Scanner;

public class GetAccountAction extends BankAgencyGenericAction {
    private final BankAgencyActionList returnTo;

    public GetAccountAction(String lineMessage, String code, BankAgencyActionList returnTo) {
        super(lineMessage, code);
        this.returnTo = returnTo;
    }

    @Override
    public void execute(ActionContext<BankAgency> e) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account id:");
        String id = scanner.next().toLowerCase();
        e.getContext().getAccount(id);
        this.returnTo.execute(e);
    }
}
