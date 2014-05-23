package ganja.component.http

import spock.lang.Specification

class ResponseSpec extends Specification {

    void "it is initializable"() {

        given:
        def response = new Response()

        expect:
        response instanceof Response
    }
}