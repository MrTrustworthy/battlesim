package player.unit;

import combatmap.Faction;
import combatmap.GridPoint;

import java.util.ArrayList;
import java.util.HashMap;

public class UnitGroup {


    private ArrayList<Unit> units;

    public UnitGroup() {
        this.units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        assert !this.units.contains(unit) : "This unit is already in this combat group";
        this.units.add(unit);
    }


    public ArrayList<Unit> getUnits() {
        return units;
    }
}
