package com.invillia.acme.resource.dto;

import com.invillia.acme.entity.domain.PaymentStatus;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

public class PaymentDTO implements Serializable {
    private Long id;
    private PaymentStatus status = PaymentStatus.RECEIVED;
    @ApiModelProperty(notes = "Número do Cartão de Crédito - campo obrigatório")
    @Size(min = 14, max = 14, message = "Números de Cartão de Crédito devem conter 14 dígitos")
    private String creditCardNumber;
    private LocalDateTime paymentDate = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}
