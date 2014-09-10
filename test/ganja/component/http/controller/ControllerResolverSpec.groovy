package ganja.component.http.controller

import ganja.component.http.Request
import ganja.component.http.Response
import ganja.component.http.common.ContainerInterface
import org.slf4j.Logger
import spock.lang.Specification

import java.util.concurrent.Callable

class ControllerResolverSpec extends Specification {

    void "it can be initialized"() {

        given:
        def resolver = new ControllerResolver()

        expect:
        resolver instanceof ControllerResolver
        resolver instanceof ControllerResolverInterface
    }

    void "it returns null if request doesn't contain 'controller' attribute"() {

        given:
        Logger logger = Mock()
        ControllerResolverInterface resolver = new ControllerResolver(logger: logger)
        Request request = Mock()

        when:
        def result = resolver.getController(request)

        then:
        null == result
        1 * logger.warn(_)
    }

    void "it returns callable if request knows what controller is assigned"() {

        given:
        ContainerInterface container = Mock()
        container.get(_) >> obj
        ControllerResolverInterface resolver = new ControllerResolver(container: container)

        when:
        Request request = Mock()

        request.getAttribute('controller') >> input
        def result = resolver.getController(request)

        then:
        result instanceof Callable
        result != null

        where:
        input                                      | obj
        'ganja.component.http.Response:getContent' | new Response()
        'java.util.Date:getTime'                   | new Date()
    }
}