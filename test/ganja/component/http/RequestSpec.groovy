package ganja.component.http

import spock.lang.Specification

class RequestSpec extends Specification {

    void "it is initializable"() {

        given:
        def request = new Request()

        expect:
        request instanceof Request
    }

    void "it can have attributes"() {

        given:
        def request = new Request()

        when:
        request.setAttribute('test','value')

        then:
        request.getAttribute('test') == 'value'
    }

    void "it can have parameters"() {

        given:
        def request = new Request()
        def value = [:]

        when:
        request.setParameter('test','value')
        request.setParameter('complex', value)

        then:
        request.getParameter('test') == 'value'
        request.getParameter('complex') == value
    }

    void "it can have headers"() {

        given:
        def request = new Request()

        when:
        request.setHeader('Content-Type','application/json')

        then:
        request.getHeader('Content-Type') == 'application/json'
    }

    void "it knows its method, port, scheme and host"() {

        given:
        def request = new Request()

        when:
        request.setMethod('POST')
        request.setPort(80)
        request.setScheme('http')
        request.setHost('localhost')

        then:
        request.getMethod() == 'POST'
        request.getPort() == 80
        request.getScheme() == 'http'
        request.getHost() == 'localhost'
    }

    void "it can read from ServletRequest"() {

        given:
        def request = new Request()

        expect:
        request.metaClass.respondsTo(request, 'readFrom')
    }
}