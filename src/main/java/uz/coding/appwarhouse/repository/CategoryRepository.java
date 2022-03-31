package uz.coding.appwarhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.coding.appwarhouse.entity.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByName(String name);

    boolean existsByNameNot(String name);

    List<Category> findAllByParentCategoryIdNull();
}
