public class Wallet {

    private float balance;

    public float getTotalMoney() {
        return balance;
    }

    public void setTotalMoney(float money) {
        balance = money;
    }

    public void addMoney(float deposit) {
        balance += deposit;
    }

    public void withdrawMoney(float debit) {
        balance -= debit;
    }
}