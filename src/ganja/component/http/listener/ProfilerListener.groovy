package ganja.component.http.listener

import ganja.component.http.event.EngineExceptionEvent
import ganja.component.http.event.EngineResponseEvent
import ganja.component.http.profiler.Profile
import ganja.component.http.profiler.Profiler

class ProfilerListener {

    Exception exception

    void onException(EngineExceptionEvent event) {

        exception = event.exception
    }

    void onResponse(EngineResponseEvent event) {

        def profiler = new Profiler()

        Profile profile = profiler.collect(event.request, event.response, exception)

        exception = null
    }
}
