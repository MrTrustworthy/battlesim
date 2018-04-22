package savegames;

import combatmap.Column;
import combatmap.GridPoint;
import combatmap.Row;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import player.ability.Ability;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SavegameReader {

    public static Document readSaveGameFile(String savename, String filename) {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            String filepath = "/saves/" + savename + "/" + filename + ".xml";
            InputStream file = SavegameReader.class.getClass().getResourceAsStream(filepath);
            Document doc = docBuilderFactory.newDocumentBuilder().parse(file);
            assert doc != null;
            // normalize text representation
            doc.getDocumentElement().normalize();
            return doc;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return null;
        }
    }

}
