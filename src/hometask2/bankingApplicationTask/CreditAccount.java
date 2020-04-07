package hometask2.bankingApplicationTask;

public class CreditAccount extends BankAccount {
    @Override
    public void withdraw(int amountToWithdraw) throws DebitAccountException {
        setBalance(getBalance() - amountToWithdraw);
        generateEvent(amountToWithdraw + " withdraw from credit account");
    }

    @Override
    public void calculatePaymentFee() {
        if (getBalance() >= 0) {
            setFee(getBalance() * 0.01);
            System.out.println("Fee = " + getFee());
        } else {
            setFee(Math.abs(getBalance() * 0.05));
            System.out.println("Fee = " + getFee());
        }
    }

    @Override
    public void generateEvent(String data) {
        notifyAll(data);
    }
}
