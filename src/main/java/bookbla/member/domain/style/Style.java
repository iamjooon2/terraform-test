package bookbla.member.domain.style;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
@Getter
public class Style {

    @Enumerated(EnumType.STRING)
    private SmokeType smokeType;

    @Enumerated(EnumType.STRING)
    private DrinkType drinkType;

    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @Enumerated(EnumType.STRING)
    private DateStyleType dateStyleType;

    @Enumerated(EnumType.STRING)
    private DateCostType dateCostType;

    @Enumerated(EnumType.STRING)
    private JustFriendType justFriendType;

    @Enumerated(EnumType.STRING)
    private Mbti mbti;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof final Style style)) return false;
        return smokeType == style.smokeType && drinkType == style.drinkType && contactType == style.contactType && dateStyleType == style.dateStyleType && dateCostType == style.dateCostType && justFriendType == style.justFriendType && mbti == style.mbti;
    }

    @Override
    public int hashCode() {
        return Objects.hash(smokeType, drinkType, contactType, dateStyleType, dateCostType, justFriendType, mbti);
    }
}
