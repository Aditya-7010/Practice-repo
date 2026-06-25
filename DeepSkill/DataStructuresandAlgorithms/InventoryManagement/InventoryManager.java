package DeepSkill.DataStructuresandAlgorithms.InventoryManagement;
import java.util.HashMap;

public class InventoryManager {
    private HashMap<Integer, Product> inventory;
    
    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductID(), product);
        System.out.println("Product id: " + product.getProductID() + " was added");
    }

    public void updateProduct(int productID, String productName, int quantity, double price) {
        Product product = inventory.get(productID);
        if (product != null) {
            product.setProductName(productName);
            product.setPrice(price);
            product.setQuantity(quantity);
        }
        else {
            System.out.println("Product does not exist to be updated");
        }
    }

    public void deleteProduct(int productID) {
        if (inventory.remove(productID) != null) {
            System.out.println("Product was deleted");
        }
        else {
            System.out.println("Product does not exist");
        }
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println("productID: " + product.getProductID() + 
                               " product name: " + product.getProductName() +
                               " quantity: " + product.getQuantity() + 
                               " price: " + product.getPrice()
            );
        }
    }
}
