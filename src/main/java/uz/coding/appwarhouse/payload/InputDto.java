package uz.coding.appwarhouse.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InputDto {

    private Timestamp date;
    private Integer warehouseId;
    private Integer supplierId;
    private Integer currencyId;
    private String factureNumber;
}
