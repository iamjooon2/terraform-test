package bookbla.book;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Choices {

    @OneToMany(fetch = FetchType.LAZY)
    private final List<Choice> values = new ArrayList<>();

    public void add(Choice choice) {
        this.values.add(choice);
    }

    public boolean isCorrect(Choice choice) {
        return values.stream()
                .filter(Choice::isCorrect)
                .anyMatch(answer -> answer.equals(choice));
    }

    public Choice getAnswer() {
        return values.stream()
                .filter(Choice::isCorrect)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

}
