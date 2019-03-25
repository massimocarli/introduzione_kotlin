package kotlinfromjava.visibility;

public class UseProtected {

    public static void main(String[] args) {
        ProtClass pc = new ProtClass();
        pc.protFunc();
    }
}
