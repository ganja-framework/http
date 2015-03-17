package ganja.component.http.profiler

class Profiler {

    Profile collect(def request, def response, Exception exeption) {

        return new Profile(token: '123456')
    }
}
