package savegames;

import combatmap.Column;
import combatmap.GridPoint;
import combatmap.Row;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import player.ability.Ability;
import player.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class PlayerSavegameReader extends SavegameReader {

    public static Unit loadUnitFromSave(String saveName, String characterName) {
        Document doc = PlayerSavegameReader.readSaveGameFile(saveName, characterName);
        String name = PlayerSavegameReader.deserializeName(doc);
        HealthPool health = PlayerSavegameReader.deserializeHealthPool(doc);
        GridPoint point = PlayerSavegameReader.deserializeGridPoint(doc);
        List<Ability> abilities = PlayerSavegameReader.deserializeAbilities(doc);

        return new Unit(name, health, abilities, point);
    }

    protected static HealthPool deserializeHealthPool(Document doc) {
        Element hp = (Element) doc.getElementsByTagName("HealthPool").item(0);
        int current = Integer.parseInt(hp.getElementsByTagName("currentHealth").item(0).getTextContent());
        int max = Integer.parseInt(hp.getElementsByTagName("maxHealth").item(0).getTextContent());
        int shield = Integer.parseInt(hp.getElementsByTagName("shielding").item(0).getTextContent());
        return new HealthPool(max, current, shield);
    }

    protected static GridPoint deserializeGridPoint(Document doc) {
        Element point = (Element) doc.getElementsByTagName("GridPoint").item(0);
        String row = point.getElementsByTagName("Row").item(0).getTextContent();
        String column = point.getElementsByTagName("Column").item(0).getTextContent();
        return new GridPoint(Row.valueOf(row), Column.valueOf(column));
    }

    protected static List<Ability> deserializeAbilities(Document doc) {
        List<Ability> abilities = new ArrayList<>();
        Element point = (Element) doc.getElementsByTagName("Abilities").item(0);
        NodeList nodes = point.getElementsByTagName("Ability");
        for (int i = 0; i < nodes.getLength(); i++) {
            abilities.add(PlayerSavegameReader.deserializeAbility((Element) nodes.item(i)));
        }
        return abilities;
    }

    private static String deserializeName(Document doc) {
        return doc.getElementsByTagName("Abilities").item(0).getTextContent();

    }

    private static Ability deserializeAbility(Element el) {
        String className = el.getElementsByTagName("Name").item(0).getTextContent();
        List<Object> arguments = new ArrayList<>();
        NodeList argumentNodes = ((Element) el.getElementsByTagName("Arguments").item(0)).getElementsByTagName("arg");
        for (int i = 0; i < argumentNodes.getLength(); i++) {
            arguments.add(argumentNodes.item(i).getTextContent());
        }
        return Ability.INSTANTIATE_FROM_STRING(className, arguments);
    }
}
