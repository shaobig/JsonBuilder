package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.nested.NestedNodeCreator;

public class GenericObjectNodeMergerNodeCreator<T> extends ObjectNodeMergerNodeCreator<T> {

    public GenericObjectNodeMergerNodeCreator(NodeMerger nodeMerger, NestedNodeCreator<T> nestedNodeCreator, ObjectNode objectNode) {
        super(nodeMerger, nestedNodeCreator, objectNode);
    }

    @Override
    public ObjectNode createNode(String path, T object) {
        ObjectNode objectNode = getNodeMerger().mergeValue(getObjectNode(), getNestedNodeCreator().createNode(path, object));
        setObjectNode(objectNode);
        return objectNode;
    }

}
