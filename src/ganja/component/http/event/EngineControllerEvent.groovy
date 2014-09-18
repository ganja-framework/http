package ganja.component.http.event

import ganja.component.event.Event
import ganja.component.http.Request

import java.util.concurrent.Callable

class EngineControllerEvent extends Event {

    Request request
    Callable controller
    List arguments
}
