package ganja.component.http

import ganja.component.event.DispatcherInterface
import ganja.component.event.EventInterface
import ganja.component.http.event.EngineControllerEvent
import ganja.component.http.event.EngineEvents
import ganja.component.http.event.EngineExceptionEvent
import ganja.component.http.event.EngineRequestEvent
import ganja.component.http.event.EngineResponseEvent
import ganja.component.http.exception.ControllerNotFoundException

class Engine implements EngineInterface {

    DispatcherInterface dispatcher

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

        EventInterface event = new EngineRequestEvent(dispatcher: dispatcher, request: request)

        dispatcher.dispatch(EngineEvents.REQUEST, event)

        if(event.getResponse()) {
            return filter(event.getResponse(), request)
        }

        event = new EngineControllerEvent(dispatcher: dispatcher, request: request)

        dispatcher.dispatch(EngineEvents.CONTROLLER, event)

        def controller = event.controller

        if( ! controller) {
            throw new ControllerNotFoundException('Unable to find relevant controller callable')
        }

        Response response = controller(request)

        filter(request, response)
    }

    Response filter(Request request, Response response = null, Exception exception = null) {

        EventInterface event = new EngineResponseEvent(
                dispatcher: dispatcher,
                request: request,
                response: response,
                exception: exception
        )

        dispatcher.dispatch(EngineEvents.RESPONSE, event)

        event.getResponse()
    }

    Response handleException(Exception e, Request request) {

        EventInterface event = new EngineExceptionEvent(
                dispatcher: dispatcher,
                request: request,
                exception: e
        )

        dispatcher.dispatch(EngineEvents.EXCEPTION, event)

        filter(request, event.getResponse(), e)
    }
}
