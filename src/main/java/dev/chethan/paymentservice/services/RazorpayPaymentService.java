package dev.chethan.paymentservice.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazorpayPaymentService implements PaymentService {
    private RazorpayClient razorpayClient;

    public RazorpayPaymentService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String createPaymentLink(String orderId) throws RazorpayException {
        // Logic to create a payment link using Razorpay API
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000); //10rs transaction
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", System.currentTimeMillis() + 1000 * 15 * 60); // 15 min expiry
        paymentLinkRequest.put("reference_id",orderId);
        paymentLinkRequest.put("description","Payment for order no " + orderId);
        JSONObject customer = new JSONObject();
        customer.put("name","+919741838053");
        customer.put("contact","Chethan C K");
        customer.put("email","chethan.ckm.1997@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("Order Items","Order items details");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://chethan.dev/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        return payment.get("short_url");
    }

    @Override
    public String getPaymentStatus(String paymentId) {
        // Logic to get the payment status using Razorpay API
        return null;
    }
}
