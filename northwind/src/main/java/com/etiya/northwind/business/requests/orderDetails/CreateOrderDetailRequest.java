package com.etiya.northwind.business.requests.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDetailRequest {
    @NotNull
    private int orderId;
    @NotNull
    private int productId;
    @NotNull
    @NotBlank
    @PositiveOrZero
    private double unitPrice;
    private int quantity;
    private double discount;

}
