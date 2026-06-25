package DeepSkill.DataStructuresandAlgorithms.InventoryManagement;

public class InventorySoftware {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addProduct(
            new Product(43, "Toothpaste", 20, 100)
        );

        inventoryManager.addProduct(
            new Product(102, "HairOil", 100, 200)
        );

        inventoryManager.displayInventory();

        inventoryManager.updateProduct(
            42,
            "Toothpaste",
            89,
            100
        );

        inventoryManager.deleteProduct(102);

        System.out.println("\nUpdated Inventory:");
        inventoryManager.displayInventory();
    }
}
