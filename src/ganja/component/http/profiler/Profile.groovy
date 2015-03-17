package ganja.component.http.profiler

class Profile {

    String token
    Date time
    String ipAddress
    String method

    @Delegate Map<String,Object> data
}
