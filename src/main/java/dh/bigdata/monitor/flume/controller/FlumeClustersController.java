package dh.bigdata.monitor.flume.controller;

import dh.bigdata.monitor.flume.model.FlumeAgent;
import dh.bigdata.monitor.flume.tool.conf;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by liujiawen on 2017/6/9.
 */
@Controller
public class FlumeClustersController {
    @Value("${flume.clustor}")
    private String flumeClustor;
    @RequestMapping(value = "/clusters", method = RequestMethod.GET)
    public JSONObject listClusters(){
        List<FlumeAgent> agents = conf.getFlumeAgentList(flumeClustor);
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(FlumeAgent agent:agents){
            JSONObject flumeJson = JSONObject.fromObject(agent);
            flumeJson.put("","");
            flumeJson.put("","");
            jsonArray.add(flumeJson);
        }
        json.put("agents:",jsonArray);
        return json;
    }
}