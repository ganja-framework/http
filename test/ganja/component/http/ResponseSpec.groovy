package ganja.component.http

import ganja.common.http.ResponseInterface
import spock.lang.Specification

class ResponseSpec extends Specification {

    void "it is initializable"() {

        given:
        def response = new Response()

        expect:
        response instanceof Response
        response instanceof ResponseInterface
    }

    void "it has some properties"() {

        given:
        def response = new Response()

        expect: 'Default values'
        response.getStatusCode() == 200
        response.content == null
        response.getContentType() == 'text/html; charset=UTF-8'

        when: 'Set values'
        response.setContent('Hello World!')
        response.setContentType('text/html')
        response.setStatusCode(201)

        then: 'Verify values'
        response.content == 'Hello World!'
        response.getContentType() == 'text/html'
        response.getStatusCode() == 201
    }

    void "it can write to ServletResponse"() {

        given:
        def response = new Response()

        expect:
        response.metaClass.respondsTo(response, 'writeTo')
    }
}