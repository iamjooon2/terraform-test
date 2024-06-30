package bookbla.member.domain;

import java.time.LocalDateTime;

import bookbla.common.domain.BaseEntity;
import bookbla.member.domain.policy.Policy;
import bookbla.member.domain.profile.Profile;
import bookbla.member.domain.style.Style;
import bookbla.school.School;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Convert(converter = EmailAttributeConverter.class)
    private Email oAuthEmail;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @ManyToOne(fetch = FetchType.LAZY)
    private School school;

    private String invitationCode;

    @Builder.Default
    @Embedded
    private Profile profile = new Profile();

    @Builder.Default
    @Embedded
    private Policy policy = new Policy();

    @Builder.Default
    @Embedded
    private Style style = new Style();

    @Builder.Default
    @Embedded
    private Bookmark bookmark = new Bookmark();

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private MemberStatus memberStatus = MemberStatus.PROFILE;

    private LocalDateTime statusModifiedAt;

}
