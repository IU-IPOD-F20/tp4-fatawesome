package application;

import action.Action;
import action.ActionContext;
import action.ActionList;
import bank.BankAgency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAgencyActionList implements ActionList<BankAgency> {
    private final String message;
    private final String code;
    private final String title;
    private final List<Action<BankAgency>> actionList;

    public BankAgencyActionList(String message, String code, String title) {
        this.message = message;
        this.code = code;
        this.title = title;
        this.actionList = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int size() {
        return this.actionList.size();
    }

    @Override
    public boolean addAction(Action<BankAgency> ac) {
        return this.actionList.add(ac);
    }

    @Override
    public boolean removeAction(Action<BankAgency> ac) {
        return false;
    }

    @Override
    public Action<BankAgency> getAction(int index) {
        return this.actionList.get(index);
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public void execute(ActionContext<BankAgency> e) throws Exception {
        BankAgency ag = e.getContext();
        // OK
        System.out.println("--");
        System.out.println("  " + ag.getAgencyName() + " (" + ag.getAgencyLoc() + ")");
        System.out.println(this.getTitle());
        System.out.println("--");

        // OK
        System.out.println("  Choose");
        this.actionList.forEach(action -> {
            System.out.println("    " + action.actionCode() + " - " + action.actionMessage());
        });

//        // HUIOK
//        System.out.println("\n" + "    0 - To quit this menu");

        // OK
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().toLowerCase();
        Action<BankAgency> action = actionList.stream()
                .filter(a -> a.actionCode().equals(choice))
                .findAny()
                .orElse(this);
        action.execute(e);
    }
}
