package domain.dto;

public abstract class RequestInput {

    protected final String value;

    protected RequestInput(final String value) {
        validateBlank(value);
        this.value = value;
    }

    private void validateBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("입력값은 공백이 아니어야 합니다.");
        }
    }
}
