enum OrderState {
NEW, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}
class Order {
private OrderState state;
private int orderId;
public Order(int id) {
this.orderId = id;
this.state = OrderState.NEW;
System.out.println("Order #" + id + " State: NEW (logOrderCreation)");
}
public void transition(String event) {
System.out.print("Event: " + event + " $\rightarrow$ ");
if (state == OrderState.CANCELLED || state == OrderState.DELIVERED) {
System.out.println("No transition possible.");
return;
}
switch (state) {
case NEW:
if (event.equals("paymentReceived")) state = OrderState.PROCESSING;
else if (event.equals("customerCancel")) state = OrderState.CANCELLED;
break;
case PROCESSING:
if (event.equals("inventoryConfirmed")) {
System.out.println("(Exit: generateInvoice)");
state = OrderState.SHIPPED;
}
break;
case SHIPPED:
else if (event.equals("customerCancel")) state = OrderState.CANCELLED;
if (event.equals("deliveryScan")) state = OrderState.DELIVERED;
else if (event.equals("customerCancel")) state = OrderState.CANCELLED;
break;
// Note: Cancelled entry action handled in CANCELLED state printing
default:
break;
}
if (state == OrderState.CANCELLED) {
System.out.println("Order #" + orderId + " State: CANCELLED (Entry:initiateRefund)");
} else {
System.out.println("Order #" + orderId + " State: " + state);
}
}
}
public class StateTest {
public static void main(String[] args) {
Order order = new Order(789);
order.transition("paymentReceived");
order.transition("inventoryConfirmed");
order.transition("deliveryScan");
}
}