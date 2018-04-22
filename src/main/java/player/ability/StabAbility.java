package player.ability;

import combatmap.Column;
import combatmap.Row;
import player.ability.effect.DamageEffect;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StabAbility extends Ability {


    public StabAbility(List<Object> arguments) {
        this(Integer.parseInt((String) arguments.get(0)));
    }


    public StabAbility(int strength) {
        super(
                "Stab",
                Collections.singletonList(Row.FRONT),
                Arrays.asList(Row.FRONT, Row.MIDDLE),
                Column.getAll(),
                Column.getAll(),
                Collections.singletonList(new DamageEffect(strength))
        );
    }


}
