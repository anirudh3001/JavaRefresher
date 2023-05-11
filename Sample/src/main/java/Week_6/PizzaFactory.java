package Week_6;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


enum Pizza_Type {
    PEPPERONI,
    CHEESE;
}

@Slf4j
class Pizza{
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();

    public void prepare(){
        log.info("Preparing: "+name+" Using dough, sauce and toppings:");
        for(String topping: toppings){
            log.info(" "+topping);
        }
    }

    public void bake(){
        log.info("Baking pizza in the oven:"+name);
    }

    public void box(){
        log.info("Packing "+name+" into a box");
    }
    public String getName(){
        return name;
    }

}

class CheesePizza extends Pizza{
    public CheesePizza(){
        name = "Cheese Pizza";
        dough = "Sour Dough";
        sauce = "Chilli Tomato";
        toppings.add("Bread Crumbs");
        toppings.add("Cherry Tomatoes");
    }
}

class PepperoniPizza extends Pizza{
    public PepperoniPizza(){
        name = "Pepperoni Pizza";
        dough = "Normal Dough";
        sauce = "Pink Sauce";
        toppings.add("Chicken Sausage");
        toppings.add("Olives");
        toppings.add("Jalapeno");

    }
}
public class PizzaFactory {
   public Pizza createPizza(Pizza_Type type){
       if(type.equals(Pizza_Type.PEPPERONI)){
           return new PepperoniPizza();
       }
       else if(type.equals(Pizza_Type.CHEESE)){
           return new CheesePizza();
       }
       else return null;
   }

   public static void main(String args[]){
       PizzaFactory pizzaFactory = new PizzaFactory();

       Pizza cheesepizza = pizzaFactory.createPizza(Pizza_Type.CHEESE);
       Pizza pepperonipizza = pizzaFactory.createPizza(Pizza_Type.PEPPERONI);

       cheesepizza.prepare();
       cheesepizza.bake();
       cheesepizza.box();

       pepperonipizza.prepare();
       pepperonipizza.bake();
       pepperonipizza.box();

   }
}
