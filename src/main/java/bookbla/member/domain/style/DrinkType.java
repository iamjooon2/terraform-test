package bookbla.member.domain.style;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DrinkType {

    NONE("X"),
    ONCE_A_MONTH("월 1~2회"),
    ONCE_A_WEEK("주 1회"),
    OVER_TWICE_A_WEEK("주 2회 이상"),
    EVERYDAY("매일"),
    ;

    private final String value;

    public static List<String> getValues() {
        return Arrays.stream(values())
                .map(it -> it.value)
                .toList();
    }

    public static DrinkType from(String name) {
        return Arrays.stream(values())
                .filter(it -> it.value.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
