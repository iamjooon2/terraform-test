package bookbla.postcard;

import java.util.Arrays;

public enum PostcardStatus {

    PENDING,
    READ,
    ACCEPT,
    REFUSED,
    ALL_WRONG,
    ;

    public static PostcardStatus from(String status) {
        return Arrays.stream(values())
                .filter(it -> it.name().equalsIgnoreCase(status))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
