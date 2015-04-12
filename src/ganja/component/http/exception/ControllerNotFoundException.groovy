package ganja.component.http.exception

class ControllerNotFoundException extends RuntimeException {

    ControllerNotFoundException(String message) {
        super(message)
    }
}
