package bankingApplicationTask;

public abstract class BankAccount extends AbstractObseverable{
    private int balance = 0;
    private double fee;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public void addMoney(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount cannot be negative!");
        }
            balance = balance + amount;
        generateEvent(amount + " added to account");
    }

    public abstract void withdraw(int amountToWithdraw) throws DebitAccountException;

    public abstract void calculatePaymentFee();

}
