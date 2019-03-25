package kotlinfromjava.methods;

import java.util.List;

public class WithMethods {

    //public void useList(List<String> stringList) { }

    public void useList(List<Integer> stringList) {
    }


    public static void main(String[] args) {
        KWithMethods methods = new KWithMethods();
        methods.useIntList(null);
        methods.useStringList(null);
        final String myName = methods.getMyName();
        methods.setMyName("Pippo");
    }

}
