package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CopyNodeMerger implements NodeMerger<ObjectNode> {

    @Override
    public ObjectNode mergeValue(ObjectNode parentNode, JsonNode childNode) {
        childNode.fields().forEachRemaining(entry -> parentNode.set(entry.getKey(), entry.getValue()));
        return parentNode;
    }

}
