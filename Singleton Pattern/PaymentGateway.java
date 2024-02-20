import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PaymentGatewayManager {
    private PaymentGatewayManager() {
        System.out.println("Payment Gate Manager Initialised");
    }

    private static PaymentGatewayManager instance;
    private static Lock mtx = new ReentrantLock();

    public static PaymentGatewayManager getInstance() {
        if (instance == null) { // first check without locking
            mtx.lock(); // acquire the lock before creating the instance
            try {
                if (instance == null) { // double check locking
                    instance = new PaymentGatewayManager();
                }
            } finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through the payment gateway");
    }

}

public class PaymentGateway {

    public static void main(String[] args) {
        PaymentGatewayManager paymentGateway = PaymentGatewayManager.getInstance();

        paymentGateway.processPayment(100.0);

        PaymentGatewayManager anotherPaymentGateway = PaymentGatewayManager.getInstance();

        if (paymentGateway == anotherPaymentGateway) {
            System.out.println("Both instances are same");
        } else {
            System.out.println("Both instances are different");
        }
    }
}