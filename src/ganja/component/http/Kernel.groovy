package ganja.component.http

import ganja.component.event.DispatcherInterface
import ganja.component.event.EventInterface
import ganja.component.http.controller.ControllerResolverInterface
import ganja.component.http.event.KernelControllerEvent
import ganja.component.http.event.KernelEvents
import ganja.component.http.event.KernelExceptionEvent
import ganja.component.http.event.KernelRequestEvent
import ganja.component.http.event.KernelResponseEvent
import ganja.component.http.exception.ControllerNotFoundException

import java.util.concurrent.Callable

class Kernel implements KernelInterface {

    DispatcherInterface dispatcher
    ControllerResolverInterface resolver

    @Override
    Response handle(Request request, Boolean catchException) {

        try {

            return doHandle(request)
        }
        catch (Exception e) {

            if(catchException) {

                return handleException(e, request)
            }
            else {

                throw e
            }
        }
    }

    Response doHandle(Request request) {

        EventInterface event = new KernelRequestEvent(dispatcher: dispatcher, request: request)

        dispatcher.dispatch(KernelEvents.REQUEST, event)

        if(event.getResponse()) {
            return filter(event.getResponse(), request)
        }

        Callable controller = resolver.getController(request)

        if( ! controller) {
            throw new ControllerNotFoundException('Unable to find relevant controller callable')
        }

        event = new KernelControllerEvent(
                dispatcher: dispatcher,
                controller: controller,
                request: request
        )

        dispatcher.dispatch(KernelEvents.CONTROLLER, event)

        controller = event.controller

        List arguments = resolver.getArguments(request, controller)

        Response response = controller(*arguments)

        filter(response, request)
    }

    Response filter(Response response, Request request) {

        EventInterface event = new KernelResponseEvent(
                dispatcher: dispatcher,
                request: request,
                response: response
        )

        dispatcher.dispatch(KernelEvents.RESPONSE, event)

        event.getResponse()
    }

    Response handleException(Exception e, Request request) {

        EventInterface event = new KernelExceptionEvent(
                dispatcher: dispatcher,
                request: request,
                exception: e
        )

        dispatcher.dispatch(KernelEvents.EXCEPTION, event)

        event.getResponse()
    }
}
