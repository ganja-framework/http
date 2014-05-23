package ganja.component.http

class Request {

    String method
    Integer port
    String scheme
    String host

    Map<String, String> attributes = [:]
    Map<String, Object> parameters = [:]
    Map<String, String> headers = [:]

    String getAttribute(String key) {

        attributes[key]
    }

    void setAttribute(String key, String value) {

        attributes.put(key, value)
    }

    def getParameter(String key) {

        parameters[key]
    }

    void setParameter(String key, Object value) {

        parameters[key] = value
    }

    String getHeader(String key) {

        headers[key]
    }

    void setHeader(String key, String value) {

        headers[key] = value
    }
}
