package bookbla.member.domain.style;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SmokeType {

    SMOKE("흡연"),
    NON_SMOKE("비흡연"),
    SOMETIMES("가끔"),
    ;

    private final String value;

    public static List<String> getValues() {
        return Arrays.stream(values())
                .map(it -> it.value)
                .toList();
    }

    public static SmokeType from(String other) {
        return Arrays.stream(values())
                .filter(it -> it.value.equalsIgnoreCase(other))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
