package by.it_academy.jd2.mk_jd2_92_22.product.services.api;

import by.it_academy.jd2.mk_jd2_92_22.product.entity.Product;

public interface IProductServices extends IEssenceService<Product> {
    void add(Product product);
}
