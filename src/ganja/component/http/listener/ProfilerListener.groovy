package ganja.component.http.listener

import ganja.component.http.event.EngineResponseEvent
import ganja.component.http.profiler.Profiler

class ProfilerListener {

    Profiler profiler

    void onResponse(EngineResponseEvent event) {

        profiler.collect(event.request, event.response, event.exception)
    }
}
