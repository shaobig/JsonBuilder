package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EntityNodeCreator implements NodeCreator {

    private NodeSupplier objectNodeSupplier;

    public EntityNodeCreator(NodeSupplier objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

    @Override
    public JsonNode createNode(String path, Object object) {
        return new ObjectMapper().createObjectNode().putPOJO(path, object);
    }

    public NodeSupplier getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(NodeSupplier objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

}
