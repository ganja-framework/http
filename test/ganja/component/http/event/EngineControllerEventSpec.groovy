package ganja.component.http.event

import ganja.component.event.Event
import ganja.component.http.Request
import spock.lang.Specification

import java.util.concurrent.Callable

class EngineControllerEventSpec extends Specification {

    void "it can be initialized"() {

        given:
        def event = new EngineControllerEvent()

        expect:
        event instanceof EngineControllerEvent
        event instanceof Event
    }

    void "it can transport request object"() {

        given:
        def request = Mock(Request)
        def event = new EngineControllerEvent(request: request)

        expect:
        event.request == request
    }

    void "it can transport controller object"() {

        given:
        def controller = Mock(Callable)
        def event = new EngineControllerEvent(controller: controller)

        expect:
        event.controller == controller
    }
}