public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432", "Adi Pattnaik");
        context.setPaymentStrategy(creditCard);
        context.executePayment(250.75);

        System.out.println();

        PaymentStrategy paypal = new PayPalPayment("adi.pattnaik@gmail.com");
        context.setPaymentStrategy(paypal);
        context.executePayment(150.00);
    }
}
