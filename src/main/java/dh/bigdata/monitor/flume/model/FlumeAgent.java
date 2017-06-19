package dh.bigdata.monitor.flume.model;

public class FlumeAgent {

    private String host;
    private String port;
    private String agent;
    private String sources;
    private String channels;
    private String sinks;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getSinks() {
        return sinks;
    }

    public void setSinks(String sinks) {
        this.sinks = sinks;
    }
}
