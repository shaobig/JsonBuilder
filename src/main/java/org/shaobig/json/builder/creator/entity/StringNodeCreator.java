package org.shaobig.json.builder.creator.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shaobig.json.builder.creator.NodeCreator;

public class StringNodeCreator implements NodeCreator<String> {

    @Override
    public JsonNode createNode(String path, String object) {
        return new ObjectMapper().createObjectNode().put(path, object);
    }

}
