package bookbla.member.domain;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MemberStatus {

    PROFILE("p", "회원 정보 입력이 필요"),
    APPROVAL("a", "회원 승인이 필요"),
    STYLE("s", "스타일 입력이 필요"),
    BOOK("bo", "서재 입력이 필요"),
    COMPLETED("c", "회원 가입 모두 완료"),
    DELETED("d", "회원 탈퇴 상태"),
    BLOCKED("bl", "차단된 회원"),
    MATCHING_DISABLED("mb", "매칭 비활성화 회원"),
    REPORTED("r", "신고당한 회원"),
    ;

    private final String value;
    private final String description;

    public static MemberStatus from(String name) {
        return Arrays.stream(values())
                .filter(it -> it.value.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
