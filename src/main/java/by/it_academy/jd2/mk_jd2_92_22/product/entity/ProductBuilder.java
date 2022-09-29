package by.it_academy.jd2.mk_jd2_92_22.product.entity;

public class ProductBuilder {
    private int id;
    private String name;
    private double cost;
    private double discount;
    private String description;

    private ProductBuilder() {
    }

    public static ProductBuilder create() {
        return new ProductBuilder();
    }

    public ProductBuilder setId(int id) {
        this.id = id;
        return this;
    }
    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setCost(double cost) {
        this.cost = cost;
        return  this;
    }

    public ProductBuilder setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Product build() {
        return new Product(id, name, cost, discount, description);
    }
}
