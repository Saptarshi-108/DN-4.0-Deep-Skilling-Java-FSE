package Week1_DataStructuresandAlgorithms.Exercise2_EcommercePlatformSearchFunction.code;

import java.util.Arrays;

public class BinarySearch {

    public static void sortProducts(Product[] products) {
        Arrays.sort(products); // Uses compareTo from Product class
    }

    public static int binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) {
                return mid;
            } else if (midId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
