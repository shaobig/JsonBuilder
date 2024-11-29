package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RecursiveNodeMerger implements NodeMerger {

    @Override
    public JsonNode mergeValue(JsonNode parentNode, JsonNode childNode) {
        ObjectNode mergedNode = new ObjectMapper().createObjectNode();
        parentNode.fields().forEachRemaining(entry -> mergedNode.set(entry.getKey(), entry.getValue()));
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


}
