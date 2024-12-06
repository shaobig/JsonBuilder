package org.shaobig.json.builder.creator.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.NodeSupplier;

public class IntegerEntityNodeCreator extends EntityNodeCreator<Integer> {

    public IntegerEntityNodeCreator(NodeSupplier<ObjectNode> objectNodeSupplier) {
        super(objectNodeSupplier);
    }

    @Override
    public JsonNode createNode(String path, Integer integer) {
        return getObjectNodeSupplier().supplyNode().put(path, integer);
    }

}
