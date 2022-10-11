public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breath();
        dog.eat();
//        Bird bird = new Bird("Yorkie");
//        bird.breath();
//        bird.eat();
        Parrot parrot = new Parrot("Australian ringneck");
        parrot.breath();
        parrot.eat();
        parrot.fly();
        Penguin penguin = new Penguin("Emperor");
        penguin.breath();
        penguin.eat();
        penguin.fly();
    }
}