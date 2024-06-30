package bookbla.member.domain.profile;


import bookbla.member.domain.Email;
import bookbla.member.domain.EmailAttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
@Getter
public class Profile {

    @Column(unique = true)
    private String nickname;

    @Convert(converter = EmailAttributeConverter.class)
    private Email schoolEmail;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String profileImageUrl;

    private String studentIdImageUrl;

    @Enumerated(EnumType.STRING)
    private ProfileImageUrlStatus profileImageUrlStatus;

    @Enumerated(EnumType.STRING)
    private StudentIdImageUrlStatus studentIdImageUrlStatus;

    public String getBlindName() {
        String familyName = nickname.split("")[0];
        return familyName + "OO";
    }

}
