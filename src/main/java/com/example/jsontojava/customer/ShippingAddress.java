package com.example.jsontojava.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {
    private String street;
    private String city;
    private String zipCode;
    private String country;
}
