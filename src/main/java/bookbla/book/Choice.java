package bookbla.book;

import jakarta.persistence.Entity;
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

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberBook memberBook;

    private String contents;

    private boolean isCorrect;

    public static Choice createCorrectAnswer(MemberBook memberBook, String contents) {
        return of(memberBook, contents, true);
    }

    public static Choice createWrongAnswer(MemberBook memberBook, String contents) {
        return of(memberBook, contents, false);
    }

    private static Choice of(MemberBook memberBook, String contents, boolean isCorrect) {
        return Choice.builder()
                .memberBook(memberBook)
                .contents(contents)
                .isCorrect(isCorrect)
                .build();
    }

}
