package com.payment;

public class App {

    private PaymentService paymentService;
    private PaymentSystemService paymentSystemService;
    private PriceService priceService;
    private UserInputService userInputService;
    private UserViewService userViewService;

    public static void main(String[] args) {
        App app = new App();
        
        app.setPaymentService(new PaymentService());
        app.setPaymentSystemService(new PaymentSystemService());
        app.setPriceService(new PriceService());
        app.setUserInputService(new UserInputService());
        app.setUserViewService(new UserViewService());
        
        app.processPayment();
    }

    public void processPayment() {
        userViewService.showMessage("How you want to pay?\n1.ApplePay\n2.GooglePay\n3.Visa\n");

        Integer systemId = userInputService.getUserInput();
        PaymentSystem system = paymentSystemService.getPaymentSystem(systemId);

        userViewService.showMessage("Enter total price: ");
        Integer price = userInputService.getUserInput();

        priceService.validatePrice(price);

        userViewService.showMessage("Sending request to " + system);
        
        PaymentResult result = paymentService.getPaymentResult();

        userViewService.showMessage("Result is: " + result.getResult());
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setPaymentSystemService(PaymentSystemService paymentSystemService) {
        this.paymentSystemService = paymentSystemService;
    }

    public void setPriceService(PriceService priceService) {
        this.priceService = priceService;
    }

    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public void setUserViewService(UserViewService userViewService) {
        this.userViewService = userViewService;
    }
}
