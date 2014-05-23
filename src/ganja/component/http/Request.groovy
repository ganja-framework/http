package ganja.component.http

import ganja.component.http.common.AttributeTrait
import ganja.component.http.common.ParameterTrait

class Request implements AttributeTrait, ParameterTrait {

    String method
    Integer port
    String scheme
    String host

    Map<String, String> headers = [:]

    String getHeader(String key) {

        headers[key]
    }

    void setHeader(String key, String value) {

        headers[key] = value
    }
}
