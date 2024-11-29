package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringNodeCreator implements NodeCreator<String> {

    @Override
    public JsonNode createNode(String path, String object) {
        return new ObjectMapper().createObjectNode().put(path, object);
    }

}
