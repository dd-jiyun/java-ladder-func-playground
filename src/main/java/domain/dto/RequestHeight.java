package domain.dto;

import domain.ladder.Height;

public class RequestHeight extends RequestInput {

    public RequestHeight(final String value) {
        super(value);
    }

    public Height toHeight() {
        try {
            return new Height(Integer.parseInt(value.strip()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리의 높이는 숫자여야 합니다.");
        }
    }
}
