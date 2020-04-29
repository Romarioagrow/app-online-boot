package app.onlineboot.repos;
import app.onlineboot.data.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    Product findByProductName(String productName);

}
