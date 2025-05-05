package dev.chethan.paymentservice.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {
    // Configuration for Razorpay SDK
    // This is where you would set up your Razorpay client with API keys and other settings
    @Value("${razorpay.key.id}")
    private String razorpayKeyId;
    @Value("${razorpay.key.secret}")
    private String razorpaySecret;

    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException {
        // Replace with your Razorpay API key and secret
        return new RazorpayClient(razorpayKeyId, razorpaySecret);
    }
}
