package ganja.component.http

import spock.lang.Specification

class RequestSpec extends Specification {

    void "it is initializable"() {

        given:
        def request = new Request()

        expect:
        request instanceof Request
    }

}