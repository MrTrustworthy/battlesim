package combatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Column {
    LEFT, CENTER, RIGHT;

    public static List<Column> getAll() {
        return Arrays.asList(LEFT, CENTER, RIGHT);
    }
}
