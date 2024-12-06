package org.shaobig.json.builder.creator.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.NodeSupplier;

public class StringEntityNodeCreator extends EntityNodeCreator<String, ObjectNode> {

    public StringEntityNodeCreator(NodeSupplier<ObjectNode> objectNodeSupplier) {
        super(objectNodeSupplier);
    }

    @Override
    public JsonNode createNode(String path, String object) {
        return getNodeSupplier().supplyNode().put(path, object);
    }

}
