package uz.coding.appwarhouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.coding.appwarhouse.entity.Warehouse;

@Projection(types = Warehouse.class)
public interface CustomWarehouse {

    Integer getId();

    String getName();

    Boolean getActive();
}
