package com.turkcell.pair8.invoiceservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetail {
    private int productId;
    private String productName;
    private String companyName;
    private String companyId;
    private String action;
}
