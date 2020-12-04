package application.actions;

import action.ActionContext;
import application.BankAgencyGenericAction;
import bank.BankAgency;

public class ExitAction extends BankAgencyGenericAction {

    public ExitAction(String lineMessage, String code) {
        super(lineMessage, code);
    }

    @Override
    public void execute(ActionContext<BankAgency> context) throws Exception {

    }
}
