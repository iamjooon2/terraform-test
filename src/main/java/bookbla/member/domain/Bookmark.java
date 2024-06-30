package bookbla.member.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
@Getter
public class Bookmark {

    @Builder.Default
    private int paymentCount = 0;

    @Builder.Default
    private int freeCount = 1;

}
