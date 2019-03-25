package javafromkotlin.arrays;

public class ArrayTest {

    private static Animal[] animals = new Dog[10];

    private Animal[] zoo;
    private int[] ages;

    public void setZoo(Animal[] zoo) {
        this.zoo = zoo;
    }

    public void setAges(int[] ages) {
        this.ages = ages;
    }

    public static void main(String[] args) {
        animals[0] = new Cat();
    }
}
