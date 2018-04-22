package player.ability.effect;

import combatmap.Column;
import combatmap.GridPoint;
import combatmap.Row;
import org.junit.jupiter.api.Test;
import player.ability.Ability;
import player.ability.StabAbility;
import savegames.HealthPool;
import player.unit.Unit;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

class EffectTest {

    @Test
    void applyEffect() {
        HealthPool health = new HealthPool(100);
        List<Ability> baseAbility = Collections.singletonList(new StabAbility(10));
        GridPoint position = new GridPoint(Row.MIDDLE, Column.CENTER);
        Unit player = new Unit("Unit: Effecttest", health, baseAbility, position);

        Effect dmg = new DamageEffect(10);
        dmg.applyEffect(player);
        assertEquals(90, player.getHealthPool().getCurrentHealth());
    }
}