package lv.tsi.webshop.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private long id;

    private String name;

    private String description;

    private float price;

    private String pictureUrl;

    private ProductCategory productCategory;

    public Product() {
    }

    public Product(String name, String description, Float price, String pictureUrl, ProductCategory productCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.productCategory = productCategory;
    }


    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
}
