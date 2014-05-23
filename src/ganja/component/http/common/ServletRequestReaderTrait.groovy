package ganja.component.http.common

trait ServletRequestReaderTrait {

    void readFrom(def servletRequest) {

        servletRequest.getHeaderNames().each { String key ->
            setHeader(key, servletRequest.getHeader(key))
        }

        port = servletRequest.getServerPort()
        scheme = servletRequest.getScheme()
        method = servletRequest.getMethod()
        host = servletRequest.getRequestURL().toString().toURL().getHost()
    }
}
