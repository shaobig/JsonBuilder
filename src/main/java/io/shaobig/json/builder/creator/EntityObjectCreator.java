package io.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;

public class EntityObjectCreator implements ObjectCreator {

    private NodeSupplier objectNodeSupplier;

    public EntityObjectCreator(NodeSupplier objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

    @Override
    public JsonNode createObject(String path, Object object) {
        return getObjectNodeSupplier().supplyNode().putPOJO(path, object);
    }

    public NodeSupplier getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(NodeSupplier objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

}
