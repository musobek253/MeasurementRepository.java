package uz.coding.appwarhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.coding.appwarhouse.entity.InputProduct;
import uz.pdp.warehouse.entity.tamplet.InputProduct;

import java.util.List;

public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {

    List<InputProduct> getAllByInputId(Integer inputId);

    List<InputProduct> getAllByInput_WarehouseId(Integer warehouseId);

}