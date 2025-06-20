package Week1_DataStructuresandAlgorithms.Exercise2_EcommercePlatformSearchFunction.code;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(3, "Keyboard", "Electronics"),
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Mouse", "Electronics"),
            new Product(5, "T-Shirt", "Apparel"),
            new Product(4, "Shoes", "Footwear")
        };

        int targetId = 5;

        // Linear Search
        int linearIndex = LinearSearch.linearSearch(products, targetId);
        if (linearIndex != -1) {
            System.out.println("Linear Search: Found " + products[linearIndex].getProductName());
        } else {
            System.out.println("Linear Search: Product not found.");
        }

        // Binary Search
        BinarySearch.sortProducts(products);
        int binaryIndex = BinarySearch.binarySearch(products, targetId);
        if (binaryIndex != -1) {
            System.out.println("Binary Search: Found " + products[binaryIndex].getProductName());
        } else {
            System.out.println("Binary Search: Product not found.");
        }
    }
}
