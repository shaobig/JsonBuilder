package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.nested.NestedNodeCreator;

public abstract class ObjectNodeMergerNodeCreator<T> extends MergerNodeCreator<T> {

    private ObjectNode objectNode;

    public ObjectNodeMergerNodeCreator(NodeMerger nodeMerger, NestedNodeCreator<T> nestedNodeCreator, ObjectNode objectNode) {
        super(nodeMerger, nestedNodeCreator);
        this.objectNode = objectNode;
    }

    public ObjectNode getObjectNode() {
        return objectNode;
    }

    public void setObjectNode(ObjectNode objectNode) {
        this.objectNode = objectNode;
    }

}
