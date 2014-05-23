package ganja.component.http.common

trait ParameterTrait {

    Map<String, Object> parameters = [:]

    def getParameter(String key) {

        parameters[key]
    }

    void setParameter(String key, Object value) {

        parameters[key] = value
    }
}
