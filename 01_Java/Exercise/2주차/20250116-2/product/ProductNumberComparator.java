import java.util.Comparator;

public class ProductNumberComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getProductNo() - p2.getProductNo();
    }
}
