package dh.bigdata.monitor.flume.service.serviceimpl;

import dh.bigdata.monitor.flume.mapper.FlumeMetricsDao;
import dh.bigdata.monitor.flume.model.FlumeAgent;
import dh.bigdata.monitor.flume.service.flumeMetricsServiceI;
import dh.bigdata.monitor.flume.task.FlumeMetricsTask;
import dh.bigdata.monitor.flume.tool.conf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class flumeMetricsService implements flumeMetricsServiceI {

    @Value("${flume.clustor}")
    private String flumeClustor;

    @Autowired
    private FlumeMetricsDao flumeMetricsDao;

    private static final Logger logger = LoggerFactory.getLogger(flumeMetricsService.class);

    /** 同步时间间隔 */
    private static final int syncInterval = 60;

    /** 线程池用于执行获取所有flume节点指标任务 */
    static private final int threadNum = 5;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(threadNum);

    private static volatile int flumeClustorLoadFlag = 0;

    /**
     * 定时器
     * 每隔固定的时间向线程池提交获取所有flume节点指标的任务
     */
    @Scheduled(fixedDelay=syncInterval*1000)
    public void submitGetFlumeMetricsTask() {
        List<FlumeAgent> flumeAgentList = conf.getFlumeAgentList(flumeClustor);

        // 第一次时重新载入flume集群信息
        if (flumeClustorLoadFlag == 0) {
            flumeMetricsDao.deleteFlumeClustor();
            for (FlumeAgent flumeAgent : flumeAgentList) {
                String[] sourceList = flumeAgent.getSources().split(",");
                for (String source : sourceList) {
                    flumeMetricsDao.insertFlumeClustor(flumeAgent.getHost(), flumeAgent.getAgent(), "source", source);
                }
                String[] channelList = flumeAgent.getChannels().split(",");
                for (String channel : channelList) {
                    flumeMetricsDao.insertFlumeClustor(flumeAgent.getHost(), flumeAgent.getAgent(), "channel", channel);
                }
                String[] sinkList = flumeAgent.getSinks().split(",");
                for (String sink : sinkList) {
                    flumeMetricsDao.insertFlumeClustor(flumeAgent.getHost(), flumeAgent.getAgent(), "sink", sink);
                }
            }
            flumeClustorLoadFlag += 1;
            logger.info("成功加载flume集群信息");
        }

        for (FlumeAgent flumeAgent : flumeAgentList) {
            FlumeMetricsTask flumeMetricsTask = new FlumeMetricsTask();
            flumeMetricsTask.setFlumeMetricsDao(flumeMetricsDao);
            flumeMetricsTask.setFlumeAgent(flumeAgent);
            flumeMetricsTask.setCurTime(System.currentTimeMillis());
            threadPool.execute(flumeMetricsTask);
        }
        logger.info("提交获取所有flume节点指标任务到线程池");
    }
}
