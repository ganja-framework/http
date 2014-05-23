package ganja.component.http.controller

import ganja.component.http.Request
import java.util.concurrent.Callable

class ControllerResolver implements ControllerResolverInterface {

    @Override
    Callable getController(Request request) {
        return null
    }

    @Override
    List getArguments(Request request, Callable controller) {
        return null
    }
}
