package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.NodeCreator;

public class GenericMergerNodeCreator<T> extends MergerNodeCreator<T> {

    public GenericMergerNodeCreator(JsonNode jsonNode, NodeMerger nodeMerger, NodeCreator<T> nestedNodeCreator) {
        super(jsonNode, nodeMerger, nestedNodeCreator);
    }

    @Override
    public JsonNode createNode(String path, T object) {
        return getNodeMerger().mergeValue(getJsonNode(), getNestedNodeCreator().createNode(path, object));
    }

}
