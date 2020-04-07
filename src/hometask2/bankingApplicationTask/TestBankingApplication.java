package hometask2.bankingApplicationTask;

public class TestBankingApplication {
    public static void main(String[] args) {
        DebitAccount debitAccount = new DebitAccount();
        CreditAccount creditAccount = new CreditAccount();

        ObserverOne observerOne = new ObserverOne();
        ObserverTwo observerTwo = new ObserverTwo();

        debitAccount.subscribe(observerOne);
        debitAccount.subscribe(observerTwo);

        creditAccount.subscribe(observerOne);
        creditAccount.subscribe(observerTwo);

        try {
            positiveScenario(debitAccount);
        } catch (DebitAccountException e) {
            e.printStackTrace();
        }
        System.out.println();
        try {
            positiveScenario(creditAccount);
        } catch (DebitAccountException e) {
            e.printStackTrace();
        }
        System.out.println();
        try {
            negativeScenario(debitAccount);
        } catch (DebitAccountException e) {
            e.printStackTrace();
        }
        try {
            negativeScenario(creditAccount);
        } catch (DebitAccountException e) {
            e.printStackTrace();
        }
        System.out.println();
        try {
            negativeScenarioTwo(debitAccount);
        } catch (DebitAccountException e) {
            e.printStackTrace();
        }
        try {
            negativeScenarioTwo(creditAccount);
        } catch (DebitAccountException e) {
            e.printStackTrace();
        }
    }

    private static void positiveScenario(BankAccount bankAccount) throws DebitAccountException {
        bankAccount.addMoney(10);
        bankAccount.withdraw(5);
        System.out.println("Balance: " + bankAccount.getBalance());
    }

    private static void negativeScenario(BankAccount bankAccount) throws DebitAccountException {
        bankAccount.addMoney(10);
        bankAccount.withdraw(20);
        System.out.println("Balance: " + bankAccount.getBalance());
    }

    private static void negativeScenarioTwo(BankAccount bankAccount) throws DebitAccountException {
        bankAccount.addMoney(-10);
        bankAccount.withdraw(20);
        System.out.println("Balance: " + bankAccount.getBalance());
    }
}