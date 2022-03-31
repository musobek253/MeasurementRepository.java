package uz.coding.appwarhouse.projection;
import org.springframework.data.rest.core.config.Projection;
import uz.coding.appwarhouse.entity.Measurement;

@Projection(types = Measurement.class)
public interface CustomMeasurement {

    Integer getId();

    String getName();

    Boolean getActive();
}
