package dh.bigdata.monitor.flume.mapper;

import dh.bigdata.monitor.flume.model.FlumeAgent;
import dh.bigdata.monitor.flume.model.FlumeChannel;
import dh.bigdata.monitor.flume.model.FlumeSink;
import dh.bigdata.monitor.flume.model.FlumeSource;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlumeMetricsDao {

    @Delete("DELETE FROM flumeClustor")
    void deleteFlumeClustor();

    @Delete("truncate flumeSource")
    void deleteFlumeSource();

    @Delete("truncate flumeChannel")
    void deleteFlumeChannel();

    @Delete("truncate flumeSink")
    void  deleteFlumeSinks();

    @Insert("INSERT INTO flumeClustor(host,agent,role,roleName)" +
            " VALUES(#{host}, #{agent}, #{role}, #{roleName})")
    void insertFlumeClustor(@Param("host")String host, @Param("agent")String agent, @Param("role")String role,@Param("roleName")String roleName);

    @Insert("INSERT INTO flumeSource(host,agent,role,eventReceivedCount, type, appendBatchAcceptedCount, eventAcceptedCount, appendReceivedCount,\n" +
            "        startTime, appendAcceptedCount, openConnectionCount, appendBatchReceivedCount, stopTime,curTime)\n" +
            "        VALUES(#{host}, #{agent}, #{role}, #{eventReceivedCount}, #{type}, #{appendBatchAcceptedCount}, #{eventAcceptedCount}, #{appendReceivedCount},\n" +
            "        #{startTime}, #{appendAcceptedCount}, #{openConnectionCount}, #{appendBatchReceivedCount}, #{stopTime}, #{curTime})")
   void insertFlumeSource(FlumeSource flumeSource);

    @Insert("INSERT INTO flumeChannel(host,agent,role,channelCapacity,channelFillPercentage,type,channelSize,eventTakeSuccessCount,\n" +
            "        eventTakeAttemptCount,startTime,eventPutAttemptCount,eventPutSuccessCount,stopTime,curTime)\n" +
            "        VALUES(#{host}, #{agent}, #{role}, #{channelCapacity},#{channelFillPercentage},#{type},#{channelSize},#{eventTakeSuccessCount},\n" +
            "        #{eventTakeAttemptCount},#{startTime},#{eventPutAttemptCount},#{eventPutSuccessCount},#{stopTime}, #{curTime})")
    void insertFlumeChannel(FlumeChannel flumeChannel);

    @Insert("INSERT INTO flumeSink(host,agent,role,connectionCreatedCount,type,connectionClosedCount,batchCompleteCount,batchEmptyCount,\n" +
            "        eventDrainAttemptCount,startTime,eventDrainSuccessCount,batchUnderflowCount,stopTime,connectionFailedCount,curTime)\n" +
            "        VALUES(#{host}, #{agent}, #{role}, #{connectionCreatedCount},#{type},#{connectionClosedCount},#{batchCompleteCount},#{batchEmptyCount},\n" +
            "        #{eventDrainAttemptCount},#{startTime},#{eventDrainSuccessCount},#{batchUnderflowCount},#{stopTime},#{connectionFailedCount}, #{curTime})")
    void insertFlumeSink(FlumeSink flumeSink);
}
