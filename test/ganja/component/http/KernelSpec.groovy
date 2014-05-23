package ganja.component.http

import spock.lang.Specification

class KernelSpec extends Specification {

    void "it can be initialized"() {

        given:
        def kernel = new Kernel()

        expect:
        kernel instanceof Kernel
    }
}