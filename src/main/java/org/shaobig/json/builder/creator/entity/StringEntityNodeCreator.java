package org.shaobig.json.builder.creator.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.function.Supplier;

public class StringEntityNodeCreator extends EntityNodeCreator<String> {

    public StringEntityNodeCreator(Supplier<ObjectNode> objectNodeSupplier) {
        super(objectNodeSupplier);
    }

    @Override
    public JsonNode createNode(String path, String object) {
        return getObjectNodeSupplier().get().put(path, object);
    }

}
