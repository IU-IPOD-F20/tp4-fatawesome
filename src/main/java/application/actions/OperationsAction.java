package application.actions;

import application.BankAgencyActionList;

public class OperationsAction extends BankAgencyActionList {
    public OperationsAction(String message, String code, String title, BankAgencyActionList returnTo) {
        super(message, code, title);
        this.addAction(new DepositAction("Deposit money on an account", "1", returnTo));
        this.addAction(new WithdrawAction("Withdraw money from an account", "2", returnTo));
        this.addAction(returnTo);
    }
}
