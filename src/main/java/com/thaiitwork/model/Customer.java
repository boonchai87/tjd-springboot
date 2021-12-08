package com.thaiitwork.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    @DBRef
    private Address address;

   /* @DBRef
    private List<Order> orders;*/
}