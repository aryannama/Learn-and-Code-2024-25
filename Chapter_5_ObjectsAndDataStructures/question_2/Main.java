public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();

        if (customer.makePayment(100)) {
            System.out.println("Payment successful!");
        } else {
            System.out.println("Come back later and get my money");
        }
    }
}