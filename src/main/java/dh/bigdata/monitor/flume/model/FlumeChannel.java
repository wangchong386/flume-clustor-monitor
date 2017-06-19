package dh.bigdata.monitor.flume.model;

public class FlumeChannel {

    private String host;
    private String agent;
    private String role;
    private Long channelCapacity;
    private Double channelFillPercentage;
    private String type;
    private Long channelSize;
    private Long eventTakeSuccessCount;
    private Long eventTakeAttemptCount;
    private String startTime;
    private Long eventPutAttemptCount;
    private Long eventPutSuccessCount;
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

    public Long getChannelCapacity() {
        return channelCapacity;
    }

    public void setChannelCapacity(Long channelCapacity) {
        this.channelCapacity = channelCapacity;
    }

    public Double getChannelFillPercentage() {
        return channelFillPercentage;
    }

    public void setChannelFillPercentage(Double channelFillPercentage) {
        this.channelFillPercentage = channelFillPercentage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getChannelSize() {
        return channelSize;
    }

    public void setChannelSize(Long channelSize) {
        this.channelSize = channelSize;
    }

    public Long getEventTakeSuccessCount() {
        return eventTakeSuccessCount;
    }

    public void setEventTakeSuccessCount(Long eventTakeSuccessCount) {
        this.eventTakeSuccessCount = eventTakeSuccessCount;
    }

    public Long getEventTakeAttemptCount() {
        return eventTakeAttemptCount;
    }

    public void setEventTakeAttemptCount(Long eventTakeAttemptCount) {
        this.eventTakeAttemptCount = eventTakeAttemptCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Long getEventPutAttemptCount() {
        return eventPutAttemptCount;
    }

    public void setEventPutAttemptCount(Long eventPutAttemptCount) {
        this.eventPutAttemptCount = eventPutAttemptCount;
    }

    public Long getEventPutSuccessCount() {
        return eventPutSuccessCount;
    }

    public void setEventPutSuccessCount(Long eventPutSuccessCount) {
        this.eventPutSuccessCount = eventPutSuccessCount;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }
}
