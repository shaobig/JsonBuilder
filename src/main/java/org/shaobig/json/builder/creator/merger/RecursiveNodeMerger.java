package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.function.Supplier;

public class RecursiveNodeMerger implements NodeMerger<JsonNode> {

    private Supplier<ObjectNode> objectNodeSupplier;
    private NodeMerger<ObjectNode> objectNodeNodeMerger;

    public RecursiveNodeMerger(Supplier<ObjectNode> objectNodeSupplier, NodeMerger<ObjectNode> objectNodeNodeMerger) {
        this.objectNodeSupplier = objectNodeSupplier;
        this.objectNodeNodeMerger = objectNodeNodeMerger;
    }

    @Override
    public JsonNode mergeValue(JsonNode parentNode, JsonNode childNode) {;
        ObjectNode mergedNode = getObjectNodeNodeMerger().mergeValue(getObjectNodeSupplier().get(), parentNode);
        childNode.fields().forEachRemaining(childNodeEntry -> {
            String childKey = childNodeEntry.getKey();
            JsonNode childValue = childNodeEntry.getValue();
            if (mergedNode.has(childKey)) {
                JsonNode parentValue = mergedNode.get(childKey);
                if (parentValue.isObject() && childValue.isObject()) {
                    mergedNode.set(childKey, mergeValue(parentValue, childValue));
                } else {
                    mergedNode.set(childKey, childValue);
                }
            } else {
                mergedNode.set(childKey, childValue);
            }
        });
        return mergedNode;
    }

    public Supplier<ObjectNode> getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(Supplier<ObjectNode> objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

    public NodeMerger<ObjectNode> getObjectNodeNodeMerger() {
        return objectNodeNodeMerger;
    }

    public void setObjectNodeNodeMerger(NodeMerger<ObjectNode> objectNodeNodeMerger) {
        this.objectNodeNodeMerger = objectNodeNodeMerger;
    }

}
