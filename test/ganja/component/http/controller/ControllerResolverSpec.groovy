package ganja.component.http.controller

import spock.lang.Specification

class ControllerResolverSpec extends Specification {

    void "it can be initialized"() {

        given:
        def resolver = new ControllerResolver()

        expect:
        resolver instanceof ControllerResolver
        resolver instanceof ControllerResolverInterface
    }

}