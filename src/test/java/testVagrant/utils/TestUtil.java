package testVagrant.utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TestUtil {

    public static JSONObject getTeamRCBPayload() throws IOException, ParseException {
        JSONObject payload = (JSONObject) new JSONParser().parse(new FileReader("src/test/resources/Payloads/teamRCB.json"));

        return payload;
    }
}
