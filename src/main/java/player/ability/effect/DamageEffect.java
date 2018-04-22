package player.ability.effect;

import player.unit.Unit;

import java.util.Optional;

public class DamageEffect implements Effect{

    private int strength;

    public DamageEffect(int strength){
        this.strength = strength;
    }

    @Override
    public Effect applyEffect(Unit target) {
        target.getHealthPool().takeDamage(this.strength);
        return null;
    }
}
