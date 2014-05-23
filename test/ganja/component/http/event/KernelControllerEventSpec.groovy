package ganja.component.http.event

import ganja.component.event.Event
import spock.lang.Specification

class KernelControllerEventSpec extends Specification {

    void "it can be initialized"() {

        given:
        def event = new KernelControllerEvent()

        expect:
        event instanceof KernelControllerEvent
        event instanceof Event
    }
}