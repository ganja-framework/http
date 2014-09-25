package ganja.component.http

import ganja.component.http.common.AttributeTrait
import ganja.component.http.common.ParameterTrait
import ganja.component.http.common.ServletRequestParserTrait

class Request implements AttributeTrait, ParameterTrait, ServletRequestParserTrait {

    String method
    Integer port
    String scheme
    String host
    String path

    Map<String, String> headers = [:]

    String getHeader(String key) {

        headers[key]
    }

    void setHeader(String key, String value) {

        headers[key] = value
    }
}
