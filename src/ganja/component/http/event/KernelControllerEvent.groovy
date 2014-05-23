package ganja.component.http.event

import ganja.component.event.Event
import ganja.component.http.Request

import java.util.concurrent.Callable

class KernelControllerEvent extends Event {

    Request request
    Callable controller
}
