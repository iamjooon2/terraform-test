package bookbla.member.domain.style;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public enum ContactType {

    SLOW("느긋이"),
    FAST("칼답"),
    ;

    private final String value;

    public static ContactType from(String name) {
        return Arrays.stream(values())
                .filter(it -> it.value.equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<String> getValues() {
        return Arrays.stream(values())
                .map(it -> it.value)
                .toList();
    }
}
