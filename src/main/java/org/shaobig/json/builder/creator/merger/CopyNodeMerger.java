package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Spliterators;
import java.util.stream.StreamSupport;

public class CopyNodeMerger implements NodeMerger<ObjectNode> {

    @Override
    public ObjectNode mergeValue(ObjectNode parentNode, JsonNode childNode) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(childNode.fields(), 0), false)
                .reduce(parentNode, (objectNode, entry) -> objectNode.set(entry.getKey(), entry.getValue()), (objectNode, objectNode2) -> objectNode);
    }

}
