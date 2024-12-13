package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;

public interface NodeCreator {

    JsonNode createNode(String path, Object object);

}
