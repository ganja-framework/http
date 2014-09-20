package ganja.component.http.common

trait ServletResponseWriterTrait {

    void writeTo(def servletResponse) {

        servletResponse.setContentType(contentType)
        servletResponse.setStatus(statusCode)
        servletResponse.setCharacterEncoding(encoding)
        servletResponse.getWriter().write(content)
    }
}
