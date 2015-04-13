package ganja.component.http

import ganja.common.http.RequestInterface
import ganja.component.http.common.AttributeTrait
import ganja.component.http.common.ParameterTrait
import ganja.component.http.common.ServletRequestParserTrait

class Request implements RequestInterface, AttributeTrait, ParameterTrait, ServletRequestParserTrait {

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
