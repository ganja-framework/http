package ganja.component.http.event

import ganja.component.event.Event
import ganja.component.http.Request
import ganja.component.http.Response
import spock.lang.Specification

class EngineResponseEventSpec extends Specification {

    void "it can be initialized"() {

        given:
        def event = new EngineResponseEvent()

        expect:
        event instanceof EngineResponseEvent
        event instanceof Event
    }

    void "it can transport request object"() {

        given:
        def request = Mock(Request)
        def event = new EngineResponseEvent(request: request)

        expect:
        event.request == request
    }

    void "it can transport response object"() {

        given:
        def response = Mock(Response)
        def event = new EngineResponseEvent(response: response)

        expect:
        event.response == response
    }
}