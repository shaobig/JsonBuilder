package org.shaobig.json.builder.creator.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shaobig.json.builder.creator.NodeCreator;

public class IntegerNodeCreator implements NodeCreator<Integer> {

    @Override
    public JsonNode createNode(String path, Integer integer) {
        return new ObjectMapper().createObjectNode().put(path, integer);
    }

}
