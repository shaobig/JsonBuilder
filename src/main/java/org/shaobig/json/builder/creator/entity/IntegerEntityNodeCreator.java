package org.shaobig.json.builder.creator.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.function.Supplier;

public class IntegerEntityNodeCreator extends EntityNodeCreator<Integer> {

    public IntegerEntityNodeCreator(Supplier<ObjectNode> objectNodeSupplier) {
        super(objectNodeSupplier);
    }

    @Override
    public JsonNode createNode(String path, Integer integer) {
        return getObjectNodeSupplier().get().put(path, integer);
    }

}
