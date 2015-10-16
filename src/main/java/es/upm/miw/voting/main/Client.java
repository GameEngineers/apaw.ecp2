package es.upm.miw.voting.main;

import es.upm.miw.voting.web.http.*;

public class Client {

    public HttpResponse send(HttpRequest request) {
        return new Server().send(request);
    }

}
