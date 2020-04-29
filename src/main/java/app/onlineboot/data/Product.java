package app.onlineboot.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    private Long productID;

    private String productName, productType, productInfo;

    private Integer productPrice;

     public Product(Long productID) {
        this.productID = productID;
    }

}
