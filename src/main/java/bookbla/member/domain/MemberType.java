package bookbla.member.domain;

import java.util.Arrays;

public enum MemberType {

    KAKAO,
    APPLE,
    ;

    public static MemberType from(String type) {
        return Arrays.stream(values())
                .filter(it -> type.equalsIgnoreCase(it.name()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);

    }

}
