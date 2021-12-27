package io.github.rothschil.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="https://github.com/rothschil">Sam</a>
 * @date 2021/12/27 - 15:39
 * @since 1.0.0
 */
@NoArgsConstructor
@Data
public class AccLog {

    @JsonProperty("args")
    private String args;
    @JsonProperty("cleanUp")
    private String cleanUp;
    @JsonProperty("host")
    private String host;
    @JsonProperty("httpHost")
    private String httpHost;
    @JsonProperty("httpXForwardedFor")
    private String httpXForwardedFor;
    @JsonProperty("isArgs")
    private String isArgs;
    @JsonProperty("logId")
    private String logId;
    @JsonProperty("nginxVersion")
    private String nginxVersion;
    @JsonProperty("proxyaddxforwardedFor")
    private String proxyaddxforwardedFor;
    @JsonProperty("referer")
    private String referer;
    @JsonProperty("request")
    private String request;
    @JsonProperty("requestBody")
    private String requestBody;
    @JsonProperty("requestMethod")
    private String requestMethod;
    @JsonProperty("requestTime")
    private String requestTime;
    @JsonProperty("requestUri")
    private String requestUri;
    @JsonProperty("rule")
    private String rule;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("sysCode")
    private String sysCode;
    @JsonProperty("sysName")
    private String sysName;
    @JsonProperty("time")
    private String time;
    @JsonProperty("ua")
    private String ua;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("upstreamAddr")
    private String upstreamAddr;
    @JsonProperty("upstreamResponseTime")
    private String upstreamResponseTime;
    @JsonProperty("uri")
    private String uri;
}
