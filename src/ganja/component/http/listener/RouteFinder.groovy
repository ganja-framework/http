package ganja.component.http.listener

import ganja.component.http.Request
import ganja.component.http.event.EngineRequestEvent

class RouteFinder {

    def matcher
    def logger

    void onRequest(EngineRequestEvent event) {

        Request request = event.request

        def options = matcher.match(request.getPath(), request.getMethod())

        logger?.debug("Found controller '${options?.controller}' for path '${request.getPath()}'")

        request.setAttribute('controller', options?.controller)
    }
}
