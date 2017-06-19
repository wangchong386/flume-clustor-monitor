package dh.bigdata.monitor.flume.model;

public class FlumeSource {

    private String host;
    private String agent;
    private String role;
    private Long eventReceivedCount;
    private String type;
    private Long appendBatchAcceptedCount;
    private Long eventAcceptedCount;
    private Long appendReceivedCount;
    private String startTime;
    private Long appendAcceptedCount;
    private Long openConnectionCount;
    private Long appendBatchReceivedCount;
    private String stopTime;
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

    public Long getEventReceivedCount() {
        return eventReceivedCount;
    }

    public void setEventReceivedCount(Long eventReceivedCount) {
        this.eventReceivedCount = eventReceivedCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAppendBatchAcceptedCount() {
        return appendBatchAcceptedCount;
    }

    public void setAppendBatchAcceptedCount(Long appendBatchAcceptedCount) {
        this.appendBatchAcceptedCount = appendBatchAcceptedCount;
    }

    public Long getEventAcceptedCount() {
        return eventAcceptedCount;
    }

    public void setEventAcceptedCount(Long eventAcceptedCount) {
        this.eventAcceptedCount = eventAcceptedCount;
    }

    public Long getAppendReceivedCount() {
        return appendReceivedCount;
    }

    public void setAppendReceivedCount(Long appendReceivedCount) {
        this.appendReceivedCount = appendReceivedCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Long getAppendAcceptedCount() {
        return appendAcceptedCount;
    }

    public void setAppendAcceptedCount(Long appendAcceptedCount) {
        this.appendAcceptedCount = appendAcceptedCount;
    }

    public Long getOpenConnectionCount() {
        return openConnectionCount;
    }

    public void setOpenConnectionCount(Long openConnectionCount) {
        this.openConnectionCount = openConnectionCount;
    }

    public Long getAppendBatchReceivedCount() {
        return appendBatchReceivedCount;
    }

    public void setAppendBatchReceivedCount(Long appendBatchReceivedCount) {
        this.appendBatchReceivedCount = appendBatchReceivedCount;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }
}
