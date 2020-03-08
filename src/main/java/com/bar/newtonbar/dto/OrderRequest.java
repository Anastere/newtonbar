package com.bar.newtonbar.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private long userId;
    private List<OrderItem> orderRequest;

}
