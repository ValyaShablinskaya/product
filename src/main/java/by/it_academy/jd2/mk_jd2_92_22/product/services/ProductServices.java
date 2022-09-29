package by.it_academy.jd2.mk_jd2_92_22.product.services;

import by.it_academy.jd2.mk_jd2_92_22.product.entity.Product;
import by.it_academy.jd2.mk_jd2_92_22.product.services.api.IProductServices;
import by.it_academy.jd2.mk_jd2_92_22.product.services.exception.EntityAlreadyExistException;
import by.it_academy.jd2.mk_jd2_92_22.product.services.exception.EntityNotFoundException;
import by.it_academy.jd2.mk_jd2_92_22.product.storage.ProductStorage;
import by.it_academy.jd2.mk_jd2_92_22.product.storage.api.IProductStorage;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ProductServices implements IProductServices {
    private static final ProductServices instance = new ProductServices();
    private final IProductStorage storage;


    private ProductServices() {
        this.storage = ProductStorage.getInstance();
    }

    @Override
    public List<Product> get() {
        return this.storage.get();
    }

    @Override
    public Product get(int id) {
        return this.storage.getById(id).orElseThrow(() -> new EntityNotFoundException("Данный продукт не найден"));
    }

    @Override
    public void validate(Product item) {
        if (item == null) {
            throw new IllegalStateException("Вы не передали продукт");
        }
        if (storage.getById(item.getId()).isPresent()) {
          throw new EntityAlreadyExistException("Это id уже существует");
        }
        if (item.getName() == null || item.getName().isBlank()) {
            throw new IllegalStateException("Вы не заполнили название продукта");
        }
        if (item.getCost() <= 0) {
            throw new IllegalStateException("Стоимомть продукта должна быть больше 0");
        }
        if (item.getDiscount() < 0) {
            throw new IllegalStateException("Скидка должна быть больше 0");
        }
        if (item.getDescription() == null || item.getDescription().isBlank()) {
            throw new IllegalStateException("Вы не заполнили описание продукта");
        }
    }

    @Override
    public Product add(Product product) {
        this.validate(product);
        return storage.save(product).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public static ProductServices getInstance() {
        return instance;
    }
}
