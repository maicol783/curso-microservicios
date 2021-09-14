package academy.digitallab.store.serviceproduct.repository;

import academy.digitallab.store.serviceproduct.entity.Category;
import academy.digitallab.store.serviceproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> /*Se pasa la entidad y el tipo de dato de la PK */{

    public List<Product> findByCategory(Category category);
    public Product findByName(String name);

}
