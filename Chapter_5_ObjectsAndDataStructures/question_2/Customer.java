public class Customer {

    private String firstName;
    private String lastName;
    private Wallet wallet = new Wallet();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean makePayment(float amount) {
        if (wallet.getTotalMoney() >= amount) {
            wallet.withdrawMoney(amount);
            return true;
        }
        return false;
    }

    public void addMoney(float amount) {
        wallet.addMoney(amount);
    }
}