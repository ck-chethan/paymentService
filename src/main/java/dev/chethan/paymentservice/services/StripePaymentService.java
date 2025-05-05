package dev.chethan.paymentservice.services;

public class StripePaymentService implements PaymentService {
    @Override
    public String createPaymentLink(String orderId) {
        // Logic to create a payment link using Stripe API
        return null;
    }

    @Override
    public String getPaymentStatus(String paymentId) {
        // Logic to get the payment status using Stripe API
        return null;
    }
}
