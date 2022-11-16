package testVagrant.testCases;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import testVagrant.models.TeamRCBPayload;
import testVagrant.utils.TestUtil;

import java.io.IOException;


public class ForeignPlayers {

    @Test
    public void validateForeignPlayers() throws IOException, ParseException {

        JSONObject payload = TestUtil.getTeamRCBPayload();
        byte[] jsonData = payload.toString().getBytes();
        ObjectMapper mapper = new ObjectMapper();
        TeamRCBPayload rcbPayload = mapper.readValue(jsonData, TeamRCBPayload.class);
        // get count of foreign players
        int cnt = (int) rcbPayload.getPlayer().stream()
                .filter(p->!p.getCountry().equalsIgnoreCase("India")).count();

        Assert.assertEquals(4, cnt);
    }
}
