package player.ability.effect;

import player.unit.Unit;

import java.util.Optional;

public interface Effect {

    public Effect applyEffect(Unit target);

}
