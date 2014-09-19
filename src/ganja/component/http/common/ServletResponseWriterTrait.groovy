package ganja.component.http.common

trait ServletResponseWriterTrait {

    void writeTo(def servletResponse) {

        servletResponse.getWriter().write(content)
        servletResponse.setContentType(contentType)
        servletResponse.setStatus(statusCode)
        servletResponse.setCharacterEncoding(encoding)
    }
}
