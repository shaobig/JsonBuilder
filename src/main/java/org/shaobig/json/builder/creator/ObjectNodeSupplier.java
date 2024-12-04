package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.function.Supplier;

public class ObjectNodeSupplier implements Supplier<ObjectNode> {

    @Override
    public ObjectNode get() {
        return new ObjectMapper().createObjectNode();
    }

}
