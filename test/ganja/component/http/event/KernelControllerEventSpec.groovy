package ganja.component.http.event

import ganja.component.event.Event
import ganja.component.http.Request
import spock.lang.Specification

import java.util.concurrent.Callable

class KernelControllerEventSpec extends Specification {

    void "it can be initialized"() {

        given:
        def event = new KernelControllerEvent()

        expect:
        event instanceof KernelControllerEvent
        event instanceof Event
    }

    void "it can transport request object"() {

        given:
        def request = Mock(Request)
        def event = new KernelControllerEvent(request: request)

        expect:
        event.request == request
    }

    void "it can transport controller object"() {

        given:
        def controller = Mock(Callable)
        def event = new KernelControllerEvent(controller: controller)

        expect:
        event.controller == controller
    }
}