package ganja.component.http.event

import ganja.component.event.Event
import spock.lang.Specification

class KernelExceptionEventSpec extends Specification {

    void "it can be initialized"() {

        given:
        def event = new KernelExceptionEvent()

        expect:
        event instanceof KernelExceptionEvent
        event instanceof Event
    }

}