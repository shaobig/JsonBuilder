package io.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;

public interface ObjectCreator {

    JsonNode createObject(String path, Object object);

}
