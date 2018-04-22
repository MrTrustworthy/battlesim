package combatmap;

import player.unit.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grid {

    private ArrayList<GridPoint> points;
    private HashMap<GridPoint, Unit> playerPositions;

    public Grid() {

        this.points = this.getCleanGrid();
        this.playerPositions = this.initPlayerPositions();

    }

    private ArrayList<GridPoint> getCleanGrid(){
        ArrayList<GridPoint> points = new ArrayList<GridPoint>();
        for (Row r : Row.values()) {
            for (Column c : Column.values()) {
                points.add(new GridPoint(r, c));
            }
        }
        return points;
    }

    private HashMap<GridPoint, Unit> initPlayerPositions(){
        assert this.points != null : "Must initialize points before calling this function!";
        HashMap<GridPoint, Unit> positions = new HashMap<>();
        this.points.forEach(p -> positions.put(p, null));
        return positions;
    }


}
