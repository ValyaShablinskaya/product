package by.it_academy.jd2.mk_jd2_92_22.product.entity;

public class Product {
    private final int id;
    private final String name;
    private final double cost;
    private final double discount;
    private final String description;

    public Product(int id, String name, double cost, double discount, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.discount = discount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getDiscount() {
        return discount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}
