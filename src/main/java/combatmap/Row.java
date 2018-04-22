package combatmap;

import java.util.Arrays;
import java.util.List;

public enum Row {
    FRONT, MIDDLE, BACK;

    public static List<Row> getAll() {
        return Arrays.asList(FRONT, MIDDLE, BACK);
    }
}

