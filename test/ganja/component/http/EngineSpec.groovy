package ganja.component.http

import spock.lang.Specification

class EngineSpec extends Specification {

    void "it can be initialized"() {

        given:
        def engine = new Engine()

        expect:
        engine instanceof Engine
    }
}