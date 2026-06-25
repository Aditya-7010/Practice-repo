package DeepSkill.DataStructuresandAlgorithms.ECommercePlatformSearch;

public class Search {

    public static Product linearSearch(Product[] products, int targetId) {

        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }

        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == targetId)
                return products[mid];

            if (products[mid].getProductId() < targetId)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(42, "Electric grill", "Electronics"),
            new Product(46, "Pen", "Stationary"),
            new Product(54, "Notebook", "Stationary"),
            new Product(76, "USB Flash Drive", "Electronics"),
            new Product(78, "T-shirt", "Clothing")
        };

        Product result1 = linearSearch(products, 76);
        System.out.println("Linear Search: " + result1);

        Product result2 = binarySearch(products, 54);
        System.out.println("Binary Search: " + result2);
    }
}