package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IntegerNodeCreator implements NodeCreator<Integer> {

    @Override
    public JsonNode createNode(String path, Integer integer) {
        return new ObjectMapper().createObjectNode().put(path, integer);
    }

}
