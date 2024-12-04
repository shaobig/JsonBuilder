package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RecursiveNodeMerger implements NodeMerger<JsonNode> {

    private NodeMerger<ObjectNode> objectNodeNodeMerger;

    public RecursiveNodeMerger(NodeMerger<ObjectNode> objectNodeNodeMerger) {
        this.objectNodeNodeMerger = objectNodeNodeMerger;
    }

    @Override
    public JsonNode mergeValue(JsonNode parentNode, JsonNode childNode) {;
        ObjectNode mergedNode = getObjectNodeNodeMerger().mergeValue(parentNode, childNode);
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

    public NodeMerger<ObjectNode> getObjectNodeNodeMerger() {
        return objectNodeNodeMerger;
    }

    public void setObjectNodeNodeMerger(NodeMerger<ObjectNode> objectNodeNodeMerger) {
        this.objectNodeNodeMerger = objectNodeNodeMerger;
    }

}
