package org.shaobig.json.builder.object.manager.creator;

import com.fasterxml.jackson.databind.JsonNode;

public interface StringNodeCreator {

    JsonNode createString(String path, String string);

}
