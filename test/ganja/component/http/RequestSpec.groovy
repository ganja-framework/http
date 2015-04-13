package ganja.component.http

import ganja.common.http.RequestInterface
import ganja.component.http.common.ServletRequestParserTrait
import spock.lang.Specification

class RequestSpec extends Specification {

    void "it is initializable"() {

        given:
        def request = new Request()

        expect:
        request instanceof Request
        request instanceof RequestInterface
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
        request.setPath('/test/')

        then:
        request.getMethod() == 'POST'
        request.getPort() == 80
        request.getScheme() == 'http'
        request.getHost() == 'localhost'
        request.getPath() == '/test/'
    }

    void "it can read from ServletRequest"() {

        given:
        def request = new Request()

        expect:
        request.metaClass.respondsTo(request, 'readFrom')
        request instanceof ServletRequestParserTrait
        request instanceof Request
    }

    void "it can parse servletRequest parameter map"() {

        given:
        def request = new Request()

        when:
        Object servletRequest = GroovyMock() { getParameterMap() >> input; getRequestURL() >> 'http://example.com' }
        request.readFrom(servletRequest)

        then:
        request.getParameters() == expected

        where:
        expected                | input
        [a: 'b', c: ['a', 'b']] | [a: ['b'], c: ['a', 'b']]

    }
}