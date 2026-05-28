import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) {
        products.add(product);
    };

    public List<Product> getProducts() {
        return products;
    };

    public int getNextId() {
        return products.size();
    }

    public double getTotalValue() {
        double suma = 0;

        for (Product product : products) {
            double math = product.getCena() * product.getIlosc();
            suma += math;
        }

        return suma;
    }
}
