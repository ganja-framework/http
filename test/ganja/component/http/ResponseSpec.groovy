package ganja.component.http

import spock.lang.Specification

class ResponseSpec extends Specification {

    void "it is initializable"() {

        given:
        def response = new Response()

        expect:
        response instanceof Response
    }

    void "it has a content"() {

        given:
        def response = new Response()

        when:
        response.setContent('Hello World!')

        then:
        response.content == 'Hello World!'
    }

    void "it can write to ServletResponse"() {

        given:
        def response = new Response()

        expect:
        response.metaClass.respondsTo(response, 'writeTo')
    }
}