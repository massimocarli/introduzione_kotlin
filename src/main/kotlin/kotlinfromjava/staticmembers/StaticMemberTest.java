package kotlinfromjava.staticmembers;

public class StaticMemberTest {


    public static void main(String[] args) {
        //final String name = CompClass.Companion.getName();
        //CompClass.Companion.setName("Pippo");
        //final String name = CompClass.name;
        //CompClass.getName()
        CompClass.getName();
        CompClass.setName("Pippo");
        CompClass.Companion.stMethod();
        CompClass.stMethod();
    }
}
