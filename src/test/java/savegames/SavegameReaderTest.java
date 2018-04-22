package savegames;

import combatmap.Column;
import combatmap.GridPoint;
import combatmap.Row;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import player.ability.Ability;
import player.unit.Unit;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

class SavegameReaderTest {

    @Test
    void readIndividualPlayerGameFiles() {

        Document doc = PlayerSavegameReader.readSaveGameFile("testsave_init", "character_0");
        assertNotNull(doc);

        HealthPool health = PlayerSavegameReader.deserializeHealthPool(doc);
        assertTrue(health.getCurrentHealth() == 95 && health.getMaxHealth() == 100 && health.getShielding() == 0);

        GridPoint point = PlayerSavegameReader.deserializeGridPoint(doc);
        assertTrue(point.getRow() == Row.FRONT && point.getColumn() == Column.CENTER);

        List<Ability> abilities = PlayerSavegameReader.deserializeAbilities(doc);
        assertTrue(abilities.size() == 1
                && abilities.get(0).getName().equals("Stab")
                && abilities.get(0).getEffects().size() == 1);
    }


    @Test
    void readUnit() {

        Unit unit = PlayerSavegameReader.loadUnitFromSave("testsave_init", "character_0");
        assertNotNull(unit);

        HealthPool health = unit.getHealthPool();
        assertTrue(health.getCurrentHealth() == 95 && health.getMaxHealth() == 100 && health.getShielding() == 0);

        GridPoint point = unit.getPosition();
        assertTrue(point.getRow() == Row.FRONT && point.getColumn() == Column.CENTER);

        List<Ability> abilities = unit.getAbilities();
        assertTrue(abilities.size() == 1
                && abilities.get(0).getName().equals("Stab")
                && abilities.get(0).getEffects().size() == 1);
    }
}