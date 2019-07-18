package com.demo.springDockerDemo.models;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.couchbase.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document
@ToString
public class Product {

    @Id
    private Integer _productId;
    @Field
    private String productName;
    @Field
    private String productCategory;
    @Field
    private Double productPrice;
    @Field
    private Integer productQuantity;
}
