import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(Order order);
}

class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println("Hello, " + name + "! order #" + order.getId() + " is now placed " + order.getStatus() + ".");
    }
}

class Restaurant implements Observer {
    private String restaurantName;

    public Restaurant(String name) {
        this.restaurantName = name;
    }

    @Override
    public void update(Order order) {
        System.out
                .println("Restaurant " + restaurantName + ": order # " + order.getId() + " is now " + order.getStatus());
    }
}

class DeliveryPartner implements Observer {
    private String driverName;

    public DeliveryPartner(String name) {
        this.driverName = name;
    }

    @Override
    public void update(Order order) {
        System.out
                .println("Driver " + driverName + ": order # " + order.getId() + " is now " + order.getStatus());

    }
}

class CallCenter implements Observer {
    @Override
    public void update(Order order) {
        System.out
                .println("Call Centre: order #" + ": order # " + order.getId() + " is now " + order.getStatus());

    }
}

class Order {
    private int id;
    private String status;
    private List<Observer> observers = new ArrayList<>();

    public Order(int id) {
        this.id = id;
        this.status = "Order Placed";
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        status = newStatus;
        notifyObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

public class OrderStatus {
    public static void main(String[] args) {
        // create an order
        Order order1 = new Order(123);

        // Create customer, restaurant, driver to track the order
        Customer customer1 = new Customer("Customer 1");
        Restaurant restaurant1 = new Restaurant("Restaurant 1");
        DeliveryPartner driver1 = new DeliveryPartner("Driver 1");
        CallCenter callCenter = new CallCenter();

        // attach the obersers to the order
        order1.attach(customer1);
        order1.attach(restaurant1);
        order1.attach(driver1);
        order1.attach(callCenter);

        // simulate order status updates
        order1.setStatus("Out for delivery");

        // detach the oberver if needed
        order1.detach(callCenter);

        order1.setStatus("Delivered");
    }

}
