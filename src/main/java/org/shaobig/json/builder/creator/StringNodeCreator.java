package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class StringNodeCreator implements NodeCreator<String> {

    @Override
    public ObjectNode createNode(String path, String object) {
        return new ObjectMapper().createObjectNode().put(path, object);
    }

}
