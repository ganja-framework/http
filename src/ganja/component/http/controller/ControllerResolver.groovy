package ganja.component.http.controller

import ganja.component.http.Request
import java.util.concurrent.Callable
import org.slf4j.Logger

class ControllerResolver implements ControllerResolverInterface {

    Logger logger
    def container

    @Override
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

    @Override
    List getArguments(Request request, Callable controller) {
        return null
    }
}
