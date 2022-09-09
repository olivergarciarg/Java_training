package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic","Sausage", 3.56, "White Roll");
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.12);
//        double price = hamburger.itemizedHamburger();
        System.out.println("Total burger price is " + hamburger.itemizedHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
        healthyBurger.addHamburgerAddition1("Egg", 5.43);
        healthyBurger.addHealthyAddition1("Lentils", 5.43);
        System.out.println("Total healthy burger price is " + healthyBurger.itemizedHamburger());
        healthyBurger.itemizedHamburger();

        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.itemizedHamburger();
    }
}
