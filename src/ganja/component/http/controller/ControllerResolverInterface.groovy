package ganja.component.http.controller

import ganja.component.http.Request

import java.util.concurrent.Callable

public interface ControllerResolverInterface {

    Callable getController(Request request)

    List getArguments(Request request, Callable controller)
}