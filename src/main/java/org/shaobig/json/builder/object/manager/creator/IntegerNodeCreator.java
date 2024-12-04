package org.shaobig.json.builder.object.manager.creator;

import com.fasterxml.jackson.databind.JsonNode;

public interface IntegerNodeCreator {

    JsonNode createInteger(String path, Integer integer);

}
