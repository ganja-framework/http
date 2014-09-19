package ganja.component.http.common

trait ServletResponseWriterTrait {

    void writeTo(def servletResponse) {

        servletResponse.getWriter().write(content.getBytes(encoding))
        servletResponse.setContentType(contentType)
        servletResponse.setStatus(statusCode)
    }
}
