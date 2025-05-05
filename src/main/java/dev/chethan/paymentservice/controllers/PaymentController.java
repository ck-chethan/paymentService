package dev.chethan.paymentservice.controllers;

import com.razorpay.RazorpayException;
import dev.chethan.paymentservice.dtos.CreatePaymentLinkRequestDto;
import dev.chethan.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDto createPaymentLinkRequestDto) throws RazorpayException {
        return paymentService.createPaymentLink(createPaymentLinkRequestDto.getOrderId());
    }

    @PostMapping("/webhook")
    public void hanleWebhook(@RequestBody String payload) {
        // Handle the webhook payload from Razorpay
        // This is where you would process the payment status update
        System.out.println("Webhook received: " + payload);
    }
}
