package javafromkotlin.nullability;

import org.jetbrains.annotations.Nullable;

public class StringWrapper {

    private String value;

    public StringWrapper(@Nullable String value) {
        this.value = value;
    }

    @Nullable
    public String getValue() {
        return value;
    }
}
