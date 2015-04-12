package ganja.component.http.listener

import ganja.component.http.Request
import ganja.component.http.event.EngineRequestEvent

class RouteFinder {

    def matcher
    def logger

    void onRequest(EngineRequestEvent event) {

        Request request = event.request

        def defaults = matcher.match(request.getPath(), request.getMethod())

        logger?.debug("Found controller '${defaults?.controller}' for path '${request.getPath()}'")

        request.setAttribute('controller', defaults?.controller)

        defaults.each({
            if(it.key != 'controller') {
                request.setParameter(it.key, it.value)
            }
        })
    }
}
