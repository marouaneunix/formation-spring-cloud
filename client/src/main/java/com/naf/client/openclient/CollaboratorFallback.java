package com.naf.client.openclient;

import com.naf.client.resource.CollaboratorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class CollaboratorFallback implements CollaboratorClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CollaboratorFallback.class);

    private final Throwable cause;

    public CollaboratorFallback(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public List<CollaboratorDTO> findAll() {
        LOGGER.error(this.cause.getMessage());
        return Collections.emptyList();
    }

    @Override
    public CollaboratorDTO findById(Long id) {
        LOGGER.error(this.cause.getMessage());
        return null;
    }

    @Override
    public List<CollaboratorDTO> findByProjectId(Long projectId) {
        LOGGER.error(this.cause.getMessage());
        return Collections.emptyList();
    }
}
