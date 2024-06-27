package bookbla.member.domain;

import bookbla.common.domain.BaseEntity;
import bookbla.member.domain.policy.Policy;
import bookbla.member.domain.profile.Profile;
import bookbla.member.domain.style.Style;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Embedded
    private Profile profile = new Profile();

    @Embedded
    private Policy policy = new Policy();

    @Embedded
    private Style style = new Style();

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private MemberStatus memberStatus = MemberStatus.PROFILE;

    @Builder.Default
    private int payBookmarkCount = 0;

    @Builder.Default
    private int freeBookmarkCount = 1;

}
