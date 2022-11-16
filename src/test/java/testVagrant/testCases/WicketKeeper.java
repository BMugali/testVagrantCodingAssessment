package testVagrant.testCases;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import testVagrant.models.Player;
import testVagrant.models.TeamRCBPayload;
import testVagrant.utils.TestUtil;

import java.io.IOException;
import java.util.Optional;

public class WicketKeeper {

    @Test
    public void validateWicketKeeper() throws IOException, ParseException {
        JSONObject payload = TestUtil.getTeamRCBPayload();
        byte[] jsonData = payload.toString().getBytes();
        ObjectMapper mapper = new ObjectMapper();
        TeamRCBPayload rcbPayload = mapper.readValue(jsonData, TeamRCBPayload.class);

        //get count of wicket keeper
        int wicketKeeperCount = (int) rcbPayload.getPlayer().stream()
                .filter(w -> w.getRole().contains("Wicket-keeper")).count();
        if(wicketKeeperCount >= 1){
            System.out.println("Count of wicket keeper is "+ wicketKeeperCount+": Test Passed");
        }else {
            System.out.println("Count of wicket keeper is "+ wicketKeeperCount+": Test Failed");
        }
    }
}
