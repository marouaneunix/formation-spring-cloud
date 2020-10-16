package com.naf.client.openclient;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CollaboratorFallbackFactory implements FallbackFactory<CollaboratorClient> {

    @Override

    public CollaboratorClient create(Throwable cause) {
        return new CollaboratorFallback(cause);
    }

}
