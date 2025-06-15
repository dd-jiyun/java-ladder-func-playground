package domain.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class RequestResultsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("실행 결과를 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyRunningResults(String runningResults) {
        // given & when & then
        assertThatThrownBy(() -> new RequestResults(runningResults))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 공백이 아니어야 합니다.");
    }

    @Test
    @DisplayName("실행 결과 수와 플레이어 수가 동일하지 않을 경우 예외가 발생한다.")
    void shouldThrowException_whenNotEqualsSize() {
        // given
        List<String> playerNames = List.of("neo", "brown", "brie", "tommy");
        String runningResults = "꽝,5000,꽝";
        RequestResults results = new RequestResults(runningResults);

        // when & then
        assertThatThrownBy(() -> results.toResults(playerNames.size()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과 수는 플레이어 수와 동일해야 합니다.");
    }

}
