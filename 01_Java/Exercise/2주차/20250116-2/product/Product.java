public class Product {
    private int productNo;
    private String name;
    private int price;

    public Product(int productNo, String name, int price) {
        this.productNo = productNo;
        this.name = name;
        this.price = price;
    }

    public int getProductNo() {
        return productNo;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.productNo + ", " + this.name + ", " + this.price;
    }
}

class Test {
    public static void main(String[] args) {
        ProductList list = new ProductList();

        list.add(new Product(1, "c", 5000));
        list.add(new Product(3, "b", 2000));
        list.add(new Product(2, "a", 4000));

        for(Product product : list.products) {
            System.out.println(product.toString());
        }

        list.sort((p1, p2) -> p1.getPrice() - p2.getPrice());
        System.out.println();

        for(Product product : list.products) {
            System.out.println(product.toString());
        }

        list.sort(new ProductNameComparator());
        System.out.println();

        for(Product product : list.products) {
            System.out.println(product.toString());
        }
    }
}