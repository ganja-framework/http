package ganja.component.http.common

trait ServletRequestParserTrait {

    void readFrom(def servletRequest) {

        servletRequest.getHeaderNames().each { String key ->
            setHeader(key, servletRequest.getHeader(key))
        }

        port = servletRequest.getServerPort()
        scheme = servletRequest.getScheme()
        method = servletRequest.getMethod()
        host = servletRequest.getRequestURL().toString().toURL().getHost()

        servletRequest.getParameterMap().each {
            if(it.value) {
                setParameter(it.key, (it.value.size() == 1) ? it.value.first() : it.value)
            }
        }
    }
}
