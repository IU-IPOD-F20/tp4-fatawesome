package application;

import action.ActionContext;
import bank.BankAgency;

public class BankAgencyActionContext implements ActionContext<BankAgency> {
    private final BankAgency agency;
    private static volatile BankAgencyActionContext instance;

    private BankAgencyActionContext(BankAgency agency) {
        this.agency = agency;
    }

    public static BankAgencyActionContext getInstance(BankAgency agency) {
        BankAgencyActionContext result = instance;
        if (result != null) {
            return result;
        }
        synchronized (BankAgencyActionContext.class) {
            if (instance == null) {
                instance = new BankAgencyActionContext(agency);
            }
            return instance;
        }
    }

    @Override
    public BankAgency getContext() {
        return this.agency;
    }
}
