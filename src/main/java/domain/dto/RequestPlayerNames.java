package domain.dto;

import domain.player.Players;
import java.util.List;
import java.util.stream.Stream;

public class RequestPlayerNames extends RequestInput {

    private static final String INPUT_DELIMITER = ",";

    public RequestPlayerNames(final String value) {
        super(value);
    }

    public Players toPlayers() {
        List<String> names = Stream.of(value.split(INPUT_DELIMITER))
                .map(String::strip)
                .toList();
        return Players.from(names);
    }
}
