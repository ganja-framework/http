package ganja.component.http.event

import ganja.component.event.Event
import ganja.component.http.Request
import ganja.component.http.Response
import spock.lang.Specification

class EngineExceptionEventSpec extends Specification {

    void "it can be initialized"() {

        given:
        def event = new EngineExceptionEvent()

        expect:
        event instanceof EngineExceptionEvent
        event instanceof Event
    }

    void "it can transport request object"() {

        given:
        def request = Mock(Request)
        def event = new EngineExceptionEvent(request: request)

        expect:
        event.request == request
    }

    void "it can transport response object"() {

        given:
        def response = Mock(Response)
        def event = new EngineExceptionEvent(response: response)

        expect:
        event.response == response
    }

    void "it can transport exception object"() {

        given:
        def exception = Mock(Exception)
        def event = new EngineExceptionEvent(exception: exception)

        expect:
        event.exception == exception
    }
}