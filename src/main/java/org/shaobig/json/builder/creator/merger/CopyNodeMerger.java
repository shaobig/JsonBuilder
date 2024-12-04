package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.function.Supplier;

public class CopyNodeMerger implements NodeMerger<ObjectNode> {

    private Supplier<ObjectNode> objectNodeSupplier;

    public CopyNodeMerger(Supplier<ObjectNode> objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

    @Override
    public ObjectNode mergeValue(JsonNode parentNode, JsonNode childNode) {
        ObjectNode mergedNode = getObjectNodeSupplier().get();
        parentNode.fields().forEachRemaining(entry -> mergedNode.set(entry.getKey(), entry.getValue()));
        return mergedNode;
    }

    public Supplier<ObjectNode> getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(Supplier<ObjectNode> objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

}
