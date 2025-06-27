package org.saptarshi;


public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();  // Calls the external API (mocked in tests)
    }
}
