package ganja.component.http.common

trait AttributeTrait {

    Map<String, String> attributes = [:]

    String getAttribute(String key) {

        attributes[key]
    }

    void setAttribute(String key, String value) {

        attributes.put(key, value)
    }
}
