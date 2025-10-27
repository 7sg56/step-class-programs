class InventoryService {
public boolean checkStock(String item) {
System.out.println(" [InventoryService] Checking stock for " + item + "... OK");
return true;
}
}
class PaymentGateway {
public boolean makePayment(double amount) {
if (amount > 0) {
System.out.println(" [PaymentGateway] Processing $"+amount+"... Success");
return true;
}
return false;
}
}
class OrderService {
private PaymentGateway payment;
private InventoryService inventory;
public OrderService(PaymentGateway pg, InventoryService is) {
this.payment = pg; this.inventory = is;
}
public String placeOrder(String item, double price) {
System.out.println("[OrderService] Order received for: " + item);
// T2-T3: Check Stock
if (!inventory.checkStock(item)) return "Order Failed: Out of Stock";
// T4-T5: Make Payment
if (!payment.makePayment(price)) return "Order Failed: Payment Error";
// T6: Create Order
System.out.println("[OrderService] Creating order record...");
return "T7: Order Confirmation received. ID: #456";
}
}
class Customer {
private OrderService orderService;
public Customer(OrderService os) { this.orderService = os; }
public void checkout(String item, double price) {
System.out.println("T1: [Customer] Initiating checkout.");
String result = orderService.placeOrder(item, price);
System.out.println("Final Result: " + result);
}
}
public class SequenceTest {
public static void main(String[] args) {
InventoryService is = new InventoryService();
PaymentGateway pg = new PaymentGateway();
OrderService os = new OrderService(pg, is);
Customer c = new Customer(os);
c.checkout("Laptop" , 1200.00);
}
}