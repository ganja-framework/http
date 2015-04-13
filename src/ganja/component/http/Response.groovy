package ganja.component.http

import ganja.common.http.ResponseInterface
import ganja.component.http.common.ServletResponseWriterTrait

class Response implements ResponseInterface, ServletResponseWriterTrait {

    String content
    Integer statusCode = 200
    String contentType = 'text/html; charset=UTF-8'
    String encoding = 'UTF-8'
}
