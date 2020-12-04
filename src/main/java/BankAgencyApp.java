import application.AccesBankAgency;
import application.BankAgencyActionContext;
import application.BankAgencyActionList;
import application.BankAgencyGenericAction;
import application.actions.AccountsManagementAction;
import application.actions.GetAccountAction;
import application.actions.ListAction;
import application.actions.OperationsAction;

public class BankAgencyApp {
    public static BankAgencyGenericAction getListAction(BankAgencyActionList returnTo) {
        return new ListAction("List of the Agency accounts", "1", returnTo);
    }

    public static BankAgencyGenericAction getAccountAction(BankAgencyActionList returnTo) {
        return new GetAccountAction("See an account (by its number)", "2", returnTo);
    }

    public static BankAgencyActionList getOperationsAction(BankAgencyActionList returnTo) {
        return new OperationsAction("Operations on an account", "3", "Menu Operation on an account", returnTo);
    }

    public static BankAgencyActionList getAccontsManagementAction(BankAgencyActionList returnTo) {
        return new AccountsManagementAction("Accounts management", "4", "Menu Accounts management", returnTo);
    }

    public static void main(String[] args) throws Exception {
        BankAgencyActionList actionList = new BankAgencyActionList("Return to main menu", "0", "General Menu");
        actionList.addAction(getListAction(actionList));
        actionList.addAction(getAccountAction(actionList));
        actionList.addAction(getOperationsAction(actionList));
        actionList.addAction(getAccontsManagementAction(actionList));

        actionList.execute(BankAgencyActionContext.getInstance(AccesBankAgency.getBankAgency()));
    }
}
