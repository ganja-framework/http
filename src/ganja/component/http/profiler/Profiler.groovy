package ganja.component.http.profiler

class Profiler {

    ProfilerStorageInterface storage
    List<DataCollectorInterface> collectors

    void collect(def request, def response, Exception exception) {

        // create and save profile
        def profile = new Profile()

        collectors.each({ DataCollectorInterface collector ->
            profile.put(collector.name, collector.collect(request, response, exception))
        })

        storage.save(profile)
    }
}
