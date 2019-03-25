package javafromkotlin.properties;

public class User {

    private final String firstName;
    private final String lastName;
    private int age;
    private boolean enabled;

    public User(String firstName, String lastName, int age, boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.enabled = enabled;
    }

    public String getCompleteName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void doSomething() {
        System.out.println("I'm doing something!");
    }

    public void when(Runnable runnable) {
        runnable.run();
    }
}
