package dev.chethan.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentLinkRequestDto {
    private String orderId;
}
