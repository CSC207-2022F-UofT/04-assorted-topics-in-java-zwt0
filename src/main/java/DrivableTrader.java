/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.List;

public class DrivableTrader<T> extends Trader<T>{

    public DrivableTrader(List<T> inventory, List<T> wishlist, int money) {
        super(inventory, wishlist, money);
    }

    public DrivableTrader(int money) {
        super(money);
    }

    @Override
    public int getSellingPrice(T item) {
        int a = super.getSellingPrice(item);
        if(item instanceof Tradable){
            if(item instanceof Drivable){
                a+=((Drivable) item).getMaxSpeed();
                return a;
            }
        }
        return Tradable.MISSING_PRICE;
    }
}