//Base interface representing a food item.
// Component
interface FoodItem {
    String getDescription();

    double getPrice();
}

// Concrete Component -- Pizza
class Pizza implements FoodItem {
    public String getDescription() {
        return "Pizza";
    }

    public double getPrice() {
        return 200.0;
    }

}

// Concrete Component -- Burger
class Burger implements FoodItem {
    public String getDescription() {
        return "Burger";
    }

    public double getPrice() {
        return 100.0;
    }
}

// Decorater interface
abstract class Decorater implements FoodItem {
    protected FoodItem foodItem;

    public Decorater(FoodItem item) {
        this.foodItem = item;
    }
}

// concrete decorater for adding extra cheese
class ExtraCheeseDecorater extends Decorater {
    private double extraCheesePrice;

    public ExtraCheeseDecorater(FoodItem item, double price) {
        super(item);
        this.extraCheesePrice = price;
    }

    public String getDescription() {
        return foodItem.getDescription() + " with extra cheese";
    }

    public double getPrice() {
        return foodItem.getPrice() + extraCheesePrice;
    }

}

//concrete decorater with adding extra sauce
class ExtraSauceDecorater extends Decorater {
    private double extraSaucePrice;

    public ExtraSauceDecorater(FoodItem item, double price){
        super(item);
        this.extraSaucePrice = price;
    }

    public String getDescription() {
        return foodItem.getDescription() + " with extra sauce";
    }

    public double getPrice() {
        return foodItem.getPrice() + extraSaucePrice;
    }
}

public class Swiggy {
    public static void main(String[] args) {
        // Order a burger and a pizza

        FoodItem pizzaOrder = new Pizza();
        FoodItem burgerOrder = new Burger();

        pizzaOrder = new ExtraCheeseDecorater(pizzaOrder, 10.0);
        pizzaOrder = new ExtraSauceDecorater(pizzaOrder, 5.0);

        burgerOrder = new ExtraCheeseDecorater(burgerOrder, 15.0);
        burgerOrder = new ExtraCheeseDecorater(burgerOrder, 20);

        System.out.println("Pizza order dexcription: " + pizzaOrder.getDescription());
        System.out.println("Price of Pizza Order: " + pizzaOrder.getPrice());

        System.out.println("Burger order decription: " + burgerOrder.getDescription());
        System.out.println("Burger order price: " + burgerOrder.getPrice());
        

    }

}
