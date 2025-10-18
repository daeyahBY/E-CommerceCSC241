public class Cart{
    private final int cartId;
    private final String customerName;  
    private final List<CartItem> items;

    public Cart(int cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public int getCartId() {
        return cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(String productId) {
        items.removeIf(item -> item.getProduct().getId().equals(productId));
    }

    public double getTotalAmount() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                '}';
    }
}