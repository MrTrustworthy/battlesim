package player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import combatmap.Column;
import combatmap.GridPoint;
import combatmap.Row;
import org.junit.jupiter.api.Test;
import player.ability.Ability;
import player.ability.AbilityExecutor;
import player.ability.StabAbility;
import player.ability.exceptions.AbilityException;
import savegames.HealthPool;
import player.unit.Unit;

import java.util.Collections;
import java.util.List;


class AbilityTest {

    @Test()
    void twoPlayersHitting() throws AbilityException {
        Unit u1 = this.getDummyUnit("A");
        u1.getPosition().setRow(Row.FRONT);
        Unit u2 = this.getDummyUnit("B");
        AbilityExecutor executor = new AbilityExecutor(u1, "Stab", u2);
        executor.executeAction();
        assertEquals(100, u1.getHealthPool().getCurrentHealth());
        assertEquals(90, u2.getHealthPool().getCurrentHealth());
    }

    @Test()
    void HittingFromWrongPosition() throws AbilityException {
        Unit u1 = this.getDummyUnit("A");
        Unit u2 = this.getDummyUnit("B");
        AbilityExecutor executor = new AbilityExecutor(u1, "Stab", u2);
        try {
            executor.executeAction();
            assertFalse(true);
        } catch (AbilityException e) {
            assertTrue(true);
        }

        assertEquals(100, u1.getHealthPool().getCurrentHealth());
        assertEquals(100, u2.getHealthPool().getCurrentHealth());
    }

    Unit getDummyUnit(String name) {
        HealthPool health = new HealthPool(100);
        List<Ability> baseAbility = Collections.singletonList(new StabAbility(10));
        GridPoint position = new GridPoint(Row.MIDDLE, Column.CENTER);
        return new Unit("Unit " + name, health, baseAbility, position);
    }
}


