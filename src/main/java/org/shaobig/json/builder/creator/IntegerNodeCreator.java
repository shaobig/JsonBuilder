package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class IntegerNodeCreator implements NodeCreator<Integer> {

    @Override
    public ObjectNode createNode(String path, Integer integer) {
        return new ObjectMapper().createObjectNode().put(path, integer);
    }

}
