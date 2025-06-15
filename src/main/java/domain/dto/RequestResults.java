package domain.dto;

import domain.runningResult.Results;
import java.util.List;
import java.util.stream.Stream;

public class RequestResults extends RequestInput {

    private static final String INPUT_DELIMITER = ",";

    public RequestResults(final String value) {
        super(value);
    }

    public Results toResults(final int playerCount) {
        List<String> results = Stream.of(value.split(INPUT_DELIMITER))
                .map(String::strip)
                .toList();
        validatePlayerCountEqualsResultsCount(playerCount, results);
        return Results.from(results);
    }

    private void validatePlayerCountEqualsResultsCount(final int playerCount, final List<String> results) {
        if (playerCount != results.size()) {
            throw new IllegalArgumentException("실행 결과 수는 플레이어 수와 동일해야 합니다.");
        }
    }
}
