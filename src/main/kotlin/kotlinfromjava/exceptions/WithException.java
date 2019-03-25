package kotlinfromjava.exceptions;

import java.io.IOException;

import static kotlinfromjava.exceptions.ExceptionsKt.maybeThrowsEx;

public class WithException {

    public static void main(String[] args) {
        try {
            maybeThrowsEx();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
