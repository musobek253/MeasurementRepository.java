package uz.coding.appwarhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.coding.appwarhouse.entity.Warehouse;
import uz.coding.appwarhouse.projection.CustomWarehouse;

import java.util.List;

@RepositoryRestResource(path = "warehouse", collectionResourceRel = "list", excerptProjection = CustomWarehouse.class)
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    List<Warehouse> findAllByIdIn(List<Integer> singletonList);
}
