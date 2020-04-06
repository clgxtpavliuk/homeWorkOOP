package bankingApplicationTask;

public class DebitAccount extends BankAccount {

    @Override
    public void withdraw(int amountToWithdraw) throws DebitAccountException {
        if (getBalance() < amountToWithdraw) {
            throw new DebitAccountException("Not enough money in your account!");
        }
        setBalance(getBalance() - amountToWithdraw);
        generateEvent(amountToWithdraw + " withdraw from debit account");
    }

    @Override
    public void calculatePaymentFee() {
        setFee(getBalance() * 0.01);
        System.out.println("Fee = " + getFee());
    }

    @Override
    public void generateEvent(String data) {
        notifyAll(data);
    }
}
