import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AmazonSorting {

    public class OrderSorter implements Comparator<Order> {

        @Override
        public int compare(Order order1, Order order2) {

            if (isPrimeOrder(order1.metaData) && isPrimeOrder(order2.metaData)) {
                // Both are prime orders hence sort by orderId if metatData is same
                if (order1.metaData.compareTo(order2.metaData) == 0) {
                    return order1.orderId.compareTo(order2.orderId);

                } else {
                    return order1.metaData.compareTo(order2.metaData);
                }
            } else if (isPrimeOrder(order1.metaData) && !isPrimeOrder(order2.metaData)) {
                return -1;// priortitize the prime order

            } else if (isPrimeOrder(order2.metaData) && !isPrimeOrder(order1.metaData)) {
                return 1;// priortitize the prime order
            }

            // non prime orders ordering maintained as it is
            return 0;
        }

    }

    public class Order {
        String orderId;
        String metaData;

        public Order(String orderId, String metaData) {
            this.orderId = orderId;
            this.metaData = metaData;
        }

        @Override
        public String toString() {
            return "Order [orderId=" + orderId + ", metaData=" + metaData + "]";
        }

    }

    public String[][] solve(String[][] A) {
        List<Order> orders = new ArrayList<>();
        String[][] sortedOrders = new String[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            orders.add(new Order(A[i][0], A[i][1]));
        }
        orders.sort(new OrderSorter());

        for (int i = 0; i < sortedOrders.length; i++) {
            sortedOrders[i][0] = orders.get(i).orderId;
            sortedOrders[i][1] = orders.get(i).metaData;
        }
        // orders.forEach(System.out::println);
        return sortedOrders;
    }

    private boolean isPrimeOrder(String str) {
        return str != null ? !str.chars().allMatch(Character::isDigit) : false;
    }

    public static void main(String[] args) {
        String[][] orders = { { "a1", "aab" }, { "bh6", "675" }, { "b5d", "12" }, { "1a", "aab" } };
        AmazonSorting amazonSorting = new AmazonSorting();
        amazonSorting.solve(orders);
    }
}
