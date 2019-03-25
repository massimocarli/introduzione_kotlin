package kotlinfromjava.properties;

public class PropertyTest {

    public static void main(String[] args) {
        final User user = new User("Pippo", 50, true);
        // Getters
        final String name = user.getName();
        final int age = user.getAge();
        final boolean enabled = user.getEnabled();

    }
}
