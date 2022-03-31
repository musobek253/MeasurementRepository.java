package uz.coding.appwarhouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.coding.appwarhouse.entity.Currency;

@Projection(types = Currency.class)
public interface CustomCurrency {

    Integer getId();

    String getName();

    Boolean getActive();
}
