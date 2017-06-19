package dh.bigdata.monitor.flume.model;

public class FlumeSink {

    private String host;
    private String agent;
    private String role;
    private Long connectionCreatedCount;
    private String type;
    private Long connectionClosedCount;
    private Long batchCompleteCount;
    private Long batchEmptyCount;
    private Long eventDrainAttemptCount;
    private String startTime;
    private Long eventDrainSuccessCount;
    private Long batchUnderflowCount;
    private String stopTime;
    private Long connectionFailedCount;
    private Long curTime;

    public Long getCurTime() {
        return curTime;
    }

    public void setCurTime(Long curTime) {
        this.curTime = curTime;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getConnectionCreatedCount() {
        return connectionCreatedCount;
    }

    public void setConnectionCreatedCount(Long connectionCreatedCount) {
        this.connectionCreatedCount = connectionCreatedCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getConnectionClosedCount() {
        return connectionClosedCount;
    }

    public void setConnectionClosedCount(Long connectionClosedCount) {
        this.connectionClosedCount = connectionClosedCount;
    }

    public Long getBatchCompleteCount() {
        return batchCompleteCount;
    }

    public void setBatchCompleteCount(Long batchCompleteCount) {
        this.batchCompleteCount = batchCompleteCount;
    }

    public Long getBatchEmptyCount() {
        return batchEmptyCount;
    }

    public void setBatchEmptyCount(Long batchEmptyCount) {
        this.batchEmptyCount = batchEmptyCount;
    }

    public Long getEventDrainAttemptCount() {
        return eventDrainAttemptCount;
    }

    public void setEventDrainAttemptCount(Long eventDrainAttemptCount) {
        this.eventDrainAttemptCount = eventDrainAttemptCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Long getEventDrainSuccessCount() {
        return eventDrainSuccessCount;
    }

    public void setEventDrainSuccessCount(Long eventDrainSuccessCount) {
        this.eventDrainSuccessCount = eventDrainSuccessCount;
    }

    public Long getBatchUnderflowCount() {
        return batchUnderflowCount;
    }

    public void setBatchUnderflowCount(Long batchUnderflowCount) {
        this.batchUnderflowCount = batchUnderflowCount;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public Long getConnectionFailedCount() {
        return connectionFailedCount;
    }

    public void setConnectionFailedCount(Long connectionFailedCount) {
        this.connectionFailedCount = connectionFailedCount;
    }
}
