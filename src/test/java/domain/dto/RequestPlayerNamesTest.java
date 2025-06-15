package domain.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class RequestPlayerNamesTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("플레이어들의 이름을 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyPlayerNames(String playerNames) {
        // given & when & then
        assertThatThrownBy(() -> new RequestPlayerNames(playerNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 공백이 아니어야 합니다.");
    }
}
