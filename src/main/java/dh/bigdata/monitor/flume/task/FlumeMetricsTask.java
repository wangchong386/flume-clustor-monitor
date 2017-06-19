package dh.bigdata.monitor.flume.task;

import dh.bigdata.monitor.flume.mapper.FlumeMetricsDao;
import dh.bigdata.monitor.flume.model.FlumeAgent;
import dh.bigdata.monitor.flume.model.FlumeChannel;
import dh.bigdata.monitor.flume.model.FlumeSink;
import dh.bigdata.monitor.flume.model.FlumeSource;
import dh.bigdata.monitor.flume.tool.HttpTool;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlumeMetricsTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(FlumeMetricsTask.class);

    private FlumeMetricsDao flumeMetricsDao;
    private FlumeAgent flumeAgent;
    private Long curTime;

    public void setFlumeMetricsDao(FlumeMetricsDao flumeMetricsDao) {
        this.flumeMetricsDao =flumeMetricsDao;
    }
    public void setFlumeAgent(FlumeAgent flumeAgent) {
        this.flumeAgent = flumeAgent;
    }
    public void setCurTime(Long curTime) {
        this.curTime = curTime;
    }
    //add getter methods.
    public FlumeAgent getFlumeAgent(){
        return  this.flumeAgent;
    }

    @Override
    public void run() {
        String url = String.format("http://%s:%s/metrics", flumeAgent.getHost(), flumeAgent.getPort());
        String flumeMetricsString = HttpTool.sendGet(url, "");

        // source
        flumeMetricsString = flumeMetricsString.replace("EventReceivedCount", "eventReceivedCount");
        flumeMetricsString = flumeMetricsString.replace("Type", "type");
        flumeMetricsString = flumeMetricsString.replace("AppendBatchAcceptedCount", "appendBatchAcceptedCount");
        flumeMetricsString = flumeMetricsString.replace("EventAcceptedCount", "eventAcceptedCount");
        flumeMetricsString = flumeMetricsString.replace("AppendReceivedCount", "appendReceivedCount");
        flumeMetricsString = flumeMetricsString.replace("StartTime", "startTime");
        flumeMetricsString = flumeMetricsString.replace("AppendAcceptedCount", "appendAcceptedCount");
        flumeMetricsString = flumeMetricsString.replace("OpenConnectionCount", "openConnectionCount");
        flumeMetricsString = flumeMetricsString.replace("AppendBatchReceivedCount", "appendBatchReceivedCount");
        flumeMetricsString = flumeMetricsString.replace("StopTime", "stopTime");

        // channel
        flumeMetricsString = flumeMetricsString.replace("ChannelCapacity", "channelCapacity");
        flumeMetricsString = flumeMetricsString.replace("ChannelFillPercentage", "channelFillPercentage");
        flumeMetricsString = flumeMetricsString.replace("Type", "type");
        flumeMetricsString = flumeMetricsString.replace("ChannelSize", "channelSize");
        flumeMetricsString = flumeMetricsString.replace("EventTakeSuccessCount", "eventTakeSuccessCount");
        flumeMetricsString = flumeMetricsString.replace("EventTakeAttemptCount", "eventTakeAttemptCount");
        flumeMetricsString = flumeMetricsString.replace("StartTime", "startTime");
        flumeMetricsString = flumeMetricsString.replace("EventPutAttemptCount", "eventPutAttemptCount");
        flumeMetricsString = flumeMetricsString.replace("EventPutSuccessCount", "eventPutSuccessCount");
        flumeMetricsString = flumeMetricsString.replace("StopTime", "stopTime");

        // sink
        flumeMetricsString = flumeMetricsString.replace("ConnectionCreatedCount", "connectionCreatedCount");
        flumeMetricsString = flumeMetricsString.replace("Type", "type");
        flumeMetricsString = flumeMetricsString.replace("ConnectionClosedCount", "connectionClosedCount");
        flumeMetricsString = flumeMetricsString.replace("BatchCompleteCount", "batchCompleteCount");
        flumeMetricsString = flumeMetricsString.replace("BatchEmptyCount", "batchEmptyCount");
        flumeMetricsString = flumeMetricsString.replace("EventDrainAttemptCount", "eventDrainAttemptCount");
        flumeMetricsString = flumeMetricsString.replace("StartTime", "startTime");
        flumeMetricsString = flumeMetricsString.replace("EventDrainSuccessCount", "eventDrainSuccessCount");
        flumeMetricsString = flumeMetricsString.replace("BatchUnderflowCount", "batchUnderflowCount");
        flumeMetricsString = flumeMetricsString.replace("StopTime", "stopTime");
        flumeMetricsString = flumeMetricsString.replace("ConnectionFailedCount", "connectionFailedCount");
        JSONObject json = JSONObject.fromObject(flumeMetricsString);

        // 解析source
        String[] sourceList = flumeAgent.getSources().split(",");
        for (String source : sourceList) {
            JSONObject sourceJson = json.getJSONObject("SOURCE." + source);
            FlumeSource flumeSource = (FlumeSource)JSONObject.toBean(sourceJson,FlumeSource.class);
            flumeSource.setHost(flumeAgent.getHost());
            flumeSource.setAgent(flumeAgent.getAgent());
            flumeSource.setRole(source);
            flumeSource.setCurTime(curTime);
            flumeMetricsDao.insertFlumeSource(flumeSource);
        }

        // 解析channel
        String[] channelList = flumeAgent.getChannels().split(",");
        for (String channel : channelList) {
            JSONObject channelJson = json.getJSONObject("CHANNEL." + channel);
            FlumeChannel flumeChannel = (FlumeChannel)JSONObject.toBean(channelJson,FlumeChannel.class);
            flumeChannel.setHost(flumeAgent.getHost());
            flumeChannel.setAgent(flumeAgent.getAgent());
            flumeChannel.setRole(channel);
            flumeChannel.setCurTime(curTime);
            flumeMetricsDao.insertFlumeChannel(flumeChannel);
        }

        // 解析sink
        String[] sinkList = flumeAgent.getSinks().split(",");
        for (String sink : sinkList) {
            JSONObject sinkJson = json.getJSONObject("SINK." + sink);
            FlumeSink flumeSink = (FlumeSink)JSONObject.toBean(sinkJson,FlumeSink.class);
            flumeSink.setHost(flumeAgent.getHost());
            flumeSink.setAgent(flumeAgent.getAgent());
            flumeSink.setRole(sink);
            flumeSink.setCurTime(curTime);
            flumeMetricsDao.insertFlumeSink(flumeSink);
        }
        logger.info(String.format("获取flume %s 的状态完成", flumeAgent.getHost()));
    }
}
