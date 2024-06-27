package bookbla.member.domain.policy;


import java.time.LocalDateTime;

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
public class Policy {

    @Builder.Default
    private boolean hasAdvertisementAgree = false;

    private LocalDateTime advertisementAgreedAt;

}
