package domain.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ladder.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RequestHeightTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사다리의 높이를 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyHeight(String height) {
        // given & when & then
        assertThatThrownBy(() -> new RequestHeight(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 공백이 아니어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "다섯"})
    @DisplayName("사다리의 높이를 숫자가 아닌 다른 값을 입력했을 경우 예외가 발생한다.")
    void shouldThrowException_whenNonIntegerValue(String height) {
        // given & when & then
        assertThatThrownBy(() -> new RequestHeight(height).toHeight())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("유효한 사다리의 높이를 입력했을 경우 객체가 정상적으로 생성된다.")
    void shouldCreateHeight_whenValidValue() {
        // given
        String value = "5";
        RequestHeight height = new RequestHeight(value);

        // when & then
        assertThat(height.toHeight()).isEqualTo(Height.from(5));
    }
}
