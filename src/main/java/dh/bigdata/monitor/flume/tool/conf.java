package dh.bigdata.monitor.flume.tool;

import dh.bigdata.monitor.flume.model.FlumeAgent;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class conf {

    static public List<FlumeAgent> getFlumeAgentList(String flumeClustor) {
        List<FlumeAgent> flumeAgentList = new ArrayList<>();
        JSONObject json = JSONObject.fromObject(flumeClustor);
        JSONArray flumeArray = json.getJSONArray("clustor");
        for (int i = 0; i < flumeArray.size(); i++) {
            JSONObject flumeJson = flumeArray.getJSONObject(i);
            FlumeAgent flumeAgent = (FlumeAgent)JSONObject.toBean(flumeJson,FlumeAgent.class);
            flumeAgentList.add(flumeAgent);
        }
        return flumeAgentList;
    }

}
