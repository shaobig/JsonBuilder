package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RecursiveNodeMerger implements NodeMerger {

    @Override
    public ObjectNode mergeValue(ObjectNode parentNode, ObjectNode childNode) {
        ObjectNode mergedNode = new ObjectMapper().createObjectNode().setAll(parentNode);
        childNode.fields().forEachRemaining(entry -> {
            String key = entry.getKey();
            if (mergedNode.has(key) && mergedNode.get(key).isObject() && entry.getValue().isObject()) {
                ObjectNode subNodeOne = (ObjectNode) mergedNode.get(key);
                ObjectNode subNodeTwo = (ObjectNode) entry.getValue();
                mergedNode.set(key, mergeValue(subNodeOne, subNodeTwo));
            } else {
                mergedNode.set(key, entry.getValue());
            }
        });
        return mergedNode;
    }

}
