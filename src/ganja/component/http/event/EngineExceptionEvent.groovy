package ganja.component.http.event

import ganja.component.event.Event
import ganja.component.http.Request
import ganja.component.http.Response

class EngineExceptionEvent extends Event {

    Request request
    Response response
    Exception exception
}
