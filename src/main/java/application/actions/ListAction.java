package application.actions;

import action.ActionContext;
import application.BankAgencyActionList;
import application.BankAgencyGenericAction;
import bank.BankAgency;

public class ListAction extends BankAgencyGenericAction {
    private final BankAgencyActionList returnTo;

    public ListAction(String lineMessage, String code, BankAgencyActionList returnTo) {
        super(lineMessage, code);
        this.returnTo = returnTo;
    }

    @Override
    public void execute(ActionContext<BankAgency> e) throws Exception {
        e.getContext().print();
        this.returnTo.execute(e);
    }
}
