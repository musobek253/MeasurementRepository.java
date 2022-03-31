package uz.coding.appwarhouse.payload;

import lombok.Data;

import java.util.Date;

@Data
public class InputProductDto {
    private Integer productId;
    private Double amount;
    private Double price;
    private Integer inputId;
    private Date expireDate;
}
