package nivel2_sql_persistance.factory;

import nivel2_sql_persistance.product_management.Flower;
import nivel2_sql_persistance.product_management.Material;
import nivel2_sql_persistance.product_management.Product;
import nivel2_sql_persistance.product_management.Tree;

public class ProductFactory {
    private static ProductFactory instance;

    private ProductFactory() {
    }

    public static ProductFactory getInstance() {
        if (instance == null) {
            instance = new ProductFactory();
        }
        return instance;
    }

    public Product createProduct(String type, double price, String attribute) {
        switch (type.toLowerCase()) {
            case "tree":
                return new Tree(price, Double.parseDouble(attribute));
            case "flower":
                return new Flower(price, attribute);
            case "decoration":
                Material material = Material.valueOf(attribute.toUpperCase());
                return new nivel2_sql_persistance.product_management.Decoration(price, material);
            default:
                throw new IllegalArgumentException("Invalid product type");
        }
    }
}