package ganja.component.http.event

import ganja.component.event.Event
import spock.lang.Specification

class KernelResponseEventSpec extends Specification {

    void "it can be initialized"() {

        given:
        def event = new KernelResponseEvent()

        expect:
        event instanceof KernelResponseEvent
        event instanceof Event
    }
}