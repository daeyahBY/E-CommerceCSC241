public class OrderInventory {
    private List<Order> orders;

    public OrderInventory() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Order> getOrdersByCustomer(String customerName) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerName().equals(customerName)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    public Order placeOrder(String customerName, List<CartItem> items) {
        double totalAmount = 0;
        for (CartItem item : items) {
            totalAmount += item.getTotalPrice();
        }
        int newOrderId = orders.size() + 1; // Simple order ID generation
        Order newOrder = new Order(newOrderId, customerName, items, totalAmount);
        addOrder(newOrder);
        return newOrder;
    }

    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public boolean updateOrderStatus(int orderId, Order.Status status) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus(status);
            return true;
        }
        return false;
    }
}
