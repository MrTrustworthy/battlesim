package player.unit;

import combatmap.GridPoint;
import player.ability.Ability;
import player.ability.exceptions.AbilityException;
import savegames.HealthPool;

import java.util.List;
import java.util.stream.Collectors;

public class Unit {

    private HealthPool healthPool;
    private List<Ability> abilities;
    private String name;
    private GridPoint position;

    public Unit(String name, HealthPool healthPool, List<Ability> abilities, GridPoint position) {
        this.name = name;
        this.healthPool = healthPool;
        this.abilities = abilities;
        this.position = position;
    }

    public Ability getAbilityByName(String name) throws AbilityException {
        try {
            return this.abilities
                    .stream()
                    .filter(a -> a.getName().equals(name))
                    .collect(Collectors.toList())
                    .get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new AbilityException("Ability " + name + " does not exist on this character");
        }
    }


    public HealthPool getHealthPool() {
        return healthPool;
    }

    public String getName() {
        return name;
    }

    public GridPoint getPosition() {
        return position;
    }

        public List<Ability> getAbilities() {
        return abilities;
    }
}
