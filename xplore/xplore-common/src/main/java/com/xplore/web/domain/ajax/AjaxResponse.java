package com.xplore.web.domain.ajax;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by damen on 2014/11/3.
 */
@JsonPropertyOrder({"respCode", "msg", "params"})
public class AjaxResponse<T> {

    @JsonProperty("respCode")
    private String respCode = "00";
    @JsonProperty("msg")
    private String msg = "";

    @JsonProperty("params")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private T domain;

    public T getDomain() {
        return domain;
    }

    public void setDomain(T domain) {
        this.domain = domain;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
}