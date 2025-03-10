import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ProductList {
    List<Product> products = new LinkedList<>();

    public void add(Product p) {
        this.products.add(p);
    }

    public void sort(Comparator<Product> comparator) {
        Collections.sort(this.products, comparator);
    }
}
