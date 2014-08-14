package ganja.component.http

import ganja.component.http.common.ServletResponseWriterTrait

class Response implements ServletResponseWriterTrait {

    String content
    Integer statusCode = 200
    String contentType

}
