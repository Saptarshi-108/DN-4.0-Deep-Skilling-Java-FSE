package Week1_DataStructuresandAlgorithms.Exercise2_EcommercePlatformSearchFunction.code;

public class LinearSearch {

    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return i;
            }
        }
        return -1;
    }
}
