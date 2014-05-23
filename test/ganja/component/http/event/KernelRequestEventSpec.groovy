package ganja.component.http.event

import ganja.component.event.Event
import spock.lang.Specification

class KernelRequestEventSpec extends Specification {

    void "it can be initialized"() {

        given:
        def event = new KernelRequestEvent()

        expect:
        event instanceof KernelRequestEvent
        event instanceof Event
    }
}