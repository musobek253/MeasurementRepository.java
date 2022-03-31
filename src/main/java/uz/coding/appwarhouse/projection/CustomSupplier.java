package uz.coding.appwarhouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.coding.appwarhouse.entity.Supplier;

@Projection(types = Supplier.class)
public interface CustomSupplier {
     Integer getId();

     String getName();

     boolean getActive();

     String getPhoneNumber();
}
