package org.example.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CoinTransactionDTO {

    private String name;
    private int id;
    private BigDecimal price ;
    private BigDecimal quantity;
    private static Timestamp dateTime;



    public CoinTransactionDTO(String name, BigDecimal quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public static Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        CoinTransactionDTO.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
