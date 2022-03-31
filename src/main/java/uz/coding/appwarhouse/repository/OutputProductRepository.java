package uz.coding.appwarhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.coding.appwarhouse.entity.OutputProduct;
import uz.pdp.warehouse.entity.tamplet.OutputProduct;

import java.util.List;

public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {

    List<OutputProduct> getAllByOutputId(Integer output_id);
    List<OutputProduct> getAllByOutput_WarehouseId(Integer output_warehouse_id);

}