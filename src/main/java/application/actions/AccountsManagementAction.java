package application.actions;

import application.BankAgencyActionList;

public class AccountsManagementAction extends BankAgencyActionList {
    public AccountsManagementAction(String message, String code, String title, BankAgencyActionList returnTo) {
        super(message, code, title);
        this.addAction(new AddAccountAction("Add an account", "1", returnTo));
        this.addAction(new DeleteAccountAction("Delete an account", "2", returnTo));
        this.addAction(returnTo);
    }
}
