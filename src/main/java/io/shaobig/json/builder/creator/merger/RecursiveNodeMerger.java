package io.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.shaobig.json.builder.creator.NodeSupplier;

public class RecursiveNodeMerger implements NodeMerger<JsonNode> {

    private NodeSupplier objectNodeSupplier;
    private NodeMerger<ObjectNode> objectNodeNodeMerger;

    public RecursiveNodeMerger(NodeSupplier objectNodeSupplier, NodeMerger<ObjectNode> objectNodeNodeMerger) {
        this.objectNodeSupplier = objectNodeSupplier;
        this.objectNodeNodeMerger = objectNodeNodeMerger;
    }

    @Override
    public JsonNode mergeValue(JsonNode parentNode, JsonNode childNode) {
        ObjectNode mergedNode = getObjectNodeNodeMerger().mergeValue(getObjectNodeSupplier().supplyNode(), parentNode);
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

    public NodeSupplier getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(NodeSupplier objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

    public NodeMerger<ObjectNode> getObjectNodeNodeMerger() {
        return objectNodeNodeMerger;
    }

    public void setObjectNodeNodeMerger(NodeMerger<ObjectNode> objectNodeNodeMerger) {
        this.objectNodeNodeMerger = objectNodeNodeMerger;
    }

}
