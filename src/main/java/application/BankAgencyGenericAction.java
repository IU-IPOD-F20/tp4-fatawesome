package application;

import action.Action;
import bank.BankAgency;

public abstract class BankAgencyGenericAction implements Action<BankAgency> {
    private final String lineMessage;
    private final String code;

    protected BankAgencyGenericAction(String lineMessage, String code) {
        this.lineMessage = lineMessage;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return this.lineMessage;
    }

    @Override
    public String actionCode() {
        return this.code;
    }
}
