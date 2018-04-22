package player.ability;

import combatmap.Column;
import combatmap.GridPoint;
import combatmap.Row;
import player.ability.effect.Effect;
import player.ability.exceptions.AbilityException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public abstract class Ability {

    private String name;
    private List<Row> fromRowsConstraint, toRowsConstraint;
    private List<Column> fromColumnsConstraint, toColumnsConstraint;
    private boolean targetsOwnGrid;
    private List<Effect> effects;

    protected static HashMap<String, Class> subclasses;

    protected Ability(List<Object> arguments) {
    }


    Ability(String name, List<Row> fromRowsConstraint, List<Row> toRowsConstraint,
            List<Column> fromColumnsConstraint, List<Column> toColumnsConstraint,
            List<Effect> effects) {
        this(name, fromRowsConstraint, toRowsConstraint, fromColumnsConstraint, toColumnsConstraint, effects, false);
    }


    private Ability(String name, List<Row> fromRowsConstraint, List<Row> toRowsConstraint,
                    List<Column> fromColumnsConstraint, List<Column> toColumnsConstraint,
                    List<Effect> effects, boolean targetsOwnGrid) {

        // Implementing classes should not put nulls here - empty lists should be used otherwise
        assert name != null && fromRowsConstraint != null
                && toRowsConstraint != null && fromColumnsConstraint != null
                && toColumnsConstraint != null && effects != null;

        this.name = name;
        this.fromRowsConstraint = fromRowsConstraint;
        this.toRowsConstraint = toRowsConstraint;
        this.fromColumnsConstraint = fromColumnsConstraint;
        this.toColumnsConstraint = toColumnsConstraint;
        this.targetsOwnGrid = targetsOwnGrid;
        this.effects = effects;
    }

    public static Ability INSTANTIATE_FROM_STRING(String name, List<Object> arguments) {
        try {
            Class<?> clazz = Class.forName("player.ability." + name);
            Constructor<?> constructor = clazz.getDeclaredConstructor(List.class);
            return (Ability) constructor.newInstance(arguments);
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            return null;
        }

    }

    /* Getter and setter */
    public List<Row> getToRowsConstraint() {
        return toRowsConstraint;
    }

    public List<Row> getFromRowsConstraint() {
        return fromRowsConstraint;
    }


    public List<Column> getFromColumnsConstraint() {
        return fromColumnsConstraint;
    }


    public List<Column> getToColumnsConstraint() {
        return toColumnsConstraint;
    }


    public List<Effect> getEffects() {
        return effects;
    }

    public String getName() {
        return name;
    }

    /* Validate execution */

    public boolean canBeUsedFrom(GridPoint point) {
        return this.getFromRowsConstraint().contains(point.getRow()) &&
                this.getFromColumnsConstraint().contains(point.getColumn());

    }

    public boolean canBeUsedAgainst(GridPoint point) {
        return this.getToRowsConstraint().contains(point.getRow()) &&
                this.getToColumnsConstraint().contains(point.getColumn());
    }
}

