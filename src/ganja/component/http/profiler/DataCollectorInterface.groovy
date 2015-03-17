package ganja.component.http.profiler

interface DataCollectorInterface {

    def collect(def request, def response, Exception exception)

    String getName()
}