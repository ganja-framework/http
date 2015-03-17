package ganja.component.http.listener

import ganja.component.http.Request
import ganja.component.http.event.EngineControllerEvent

import java.util.concurrent.Callable
import org.slf4j.Logger

class ControllerResolver {

    Logger logger
    def container

    void onController(EngineControllerEvent event) {

        event.controller = getController(event.request)
    }

    Callable getController(Request request) {

        String controller = request.getAttribute('controller')

        if( ! controller) {

            logger?.warn('Unable to workout controller. Missing "controller" attribute on request object')

            return null
        }

        return getCallable(controller)
    }

    Callable getCallable(String controller) {

        if(controller.contains(':')) {
            List items = controller.split(/:/)
            def obj = container.get(items[0])
            return obj.&"${items[1]}"
        }
    }
}
