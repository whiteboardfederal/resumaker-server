package com.whiteboardfederal.resumaker.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityMissingException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EntityMissingException(final String entity) {
    super(entity + " not found.");
  }

  public EntityMissingException(final String entity, final String entityId) {
    super(entity + " with id " + entityId + " not found");
  }
  
  public EntityMissingException(final String entity, final long entityId) {
    super(entity + " with id " + entityId + " not found");
  }

}