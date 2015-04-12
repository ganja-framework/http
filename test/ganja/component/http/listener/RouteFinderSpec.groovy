package ganja.component.http.listener

import ganja.component.http.Request
import ganja.component.http.event.EngineRequestEvent
import spock.lang.Specification

class RouteFinderSpec extends Specification {

    void "it is initialisable"() {

        given:
        def subject = new RouteFinder()

        expect:
        subject instanceof RouteFinder
    }

    void "it has event handler that can find the controller for request"() {

        given:
        def matcher = GroovyMock(Object)
        matcher._(*_) >> { [ controller: 'homepage' ] }
        RouteFinder subject = new RouteFinder(matcher: matcher)
        Request request = new Request(path: '/')
        EngineRequestEvent event = new EngineRequestEvent(request: request)

        when:
        subject.onRequest(event)

        then:
        event.request.getAttribute('controller') == 'homepage'
    }

    void "it sets all defaults except controller as parameters"() {

        given:
        def matcher = GroovyMock(Object)
        matcher._(*_) >> { [ controller: 'homepage', requestId: 15 ] }
        RouteFinder subject = new RouteFinder(matcher: matcher)
        Request request = new Request(path: '/')
        EngineRequestEvent event = new EngineRequestEvent(request: request)

        when:
        subject.onRequest(event)

        then:
        event.request.getParameter('requestId') == 15
    }
}
