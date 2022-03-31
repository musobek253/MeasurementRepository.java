package uz.coding.appwarhouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.coding.appwarhouse.entity.Client;

@Projection(types = Client.class)
public interface CustomClient {
    Integer getId();
    String getName();
    String getPhoneNumber();
}
