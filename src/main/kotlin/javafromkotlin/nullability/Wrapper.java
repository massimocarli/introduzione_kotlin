package javafromkotlin.nullability;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Wrapper<T> {

    private T value;

    public Wrapper(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    /*
    public static <@NotNull T, @Nullable R extends @NotNull T> Wrapper<@Nullable R> from(@Nullable Wrapper<@NotNull T> wrapper) {
        return new Wrapper(wrapper.value);
    }


    List<? super @NotNull Number> number;
    */
}
