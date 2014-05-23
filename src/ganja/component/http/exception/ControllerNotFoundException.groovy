package ganja.component.http.exception

class ControllerNotFoundException extends GroovyRuntimeException {

    ControllerNotFoundException(String message) {
        super(message)
    }
}
