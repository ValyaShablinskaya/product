package by.it_academy.jd2.mk_jd2_92_22.product.storage;

import by.it_academy.jd2.mk_jd2_92_22.product.entity.Product;
import by.it_academy.jd2.mk_jd2_92_22.product.entity.ProductBuilder;
import by.it_academy.jd2.mk_jd2_92_22.product.storage.api.IProductStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductStorage implements IProductStorage {
    private static ProductStorage instance = new ProductStorage();
    public List<Product> data = new ArrayList<>();

    private ProductStorage() {
        this.data.add(ProductBuilder.create().setId(1).setName("Hills").setCost(100.0).setDiscount(20.0).
                setDescription("medical").build());
        this.data.add(ProductBuilder.create().setId(2).setName("Royal Canin").setCost(80.0).setDiscount(15.0).
                setDescription("healthy").build());
        this.data.add(ProductBuilder.create().setId(3).setName("Acana").setCost(120.0).setDiscount(25.0).
                setDescription("tasty").build());
    }

    @Override
    public List<Product> get() {
        return this.data;
    }

    @Override
    public Optional<Product> getById(int id) {
        return this.data.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Product> save(Product product) {

        this.data.add(product);
        return getById(product.getId());
    }

    public static ProductStorage getInstance(){
        return instance;
    }
}
