package ganja.component.http.listener

import ganja.component.http.Request
import ganja.component.http.event.EngineRequestEvent

class RouteFinder {

    def matcher

    void onRequest(EngineRequestEvent event) {

        Request request = event.request

        def options = matcher.match(request)

        request.setAttribute('controller', options?.controller)
    }
}
