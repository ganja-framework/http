package ganja.component.http.event

import ganja.component.event.Event
import ganja.component.http.Request
import ganja.component.http.Response

class EngineRequestEvent extends Event {

    Request request
    Response response
}
