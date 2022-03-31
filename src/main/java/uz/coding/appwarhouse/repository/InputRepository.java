package uz.coding.appwarhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.coding.appwarhouse.entity.Input;
import uz.pdp.warehouse.entity.tamplet.Input;

import java.util.List;

@Repository
public interface InputRepository extends JpaRepository<Input, Integer> {

    List<Input> getAllByWarehouseId(Integer warhauseId);
}