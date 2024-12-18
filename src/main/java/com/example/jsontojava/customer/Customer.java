package com.example.jsontojava.customer;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private String name;
    private String email;
    private String phone;
}
