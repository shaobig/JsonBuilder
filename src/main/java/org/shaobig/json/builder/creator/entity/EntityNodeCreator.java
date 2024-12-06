package org.shaobig.json.builder.creator.entity;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.creator.NodeSupplier;

public abstract class EntityNodeCreator<T> implements NodeCreator<T> {

    private NodeSupplier<ObjectNode> objectNodeSupplier;

    public EntityNodeCreator(NodeSupplier<ObjectNode> objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

    public NodeSupplier<ObjectNode> getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(NodeSupplier<ObjectNode> objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

}
