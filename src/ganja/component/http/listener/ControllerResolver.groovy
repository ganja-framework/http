package ganja.component.http.listener

import ganja.component.http.Request
import java.util.concurrent.Callable
import org.slf4j.Logger

class ControllerResolver {

    Logger logger
    def container

    Callable getController(Request request) {

        String controller = request.getAttribute('listener')

        if( ! controller) {

            logger?.warn('Unable to workout listener. Missing "listener" attribute on request object')

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

    List getArguments(Request request, Callable controller) {
        return null
    }
}
