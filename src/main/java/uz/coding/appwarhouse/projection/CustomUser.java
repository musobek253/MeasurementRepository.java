package uz.coding.appwarhouse.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.coding.appwarhouse.entity.User;

@Projection(types = User.class)
public interface CustomUser {
    Integer getId();

    String getFirstName();

    String getLastName();

    String getPhoneNumber();

    Integer getCode();

    String getPassword();

    Boolean getActive();
}
