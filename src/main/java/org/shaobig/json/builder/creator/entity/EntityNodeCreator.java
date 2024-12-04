package org.shaobig.json.builder.creator.entity;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.NodeCreator;

import java.util.function.Supplier;

public abstract class EntityNodeCreator<T> implements NodeCreator<T> {

    private Supplier<ObjectNode> objectNodeSupplier;

    public EntityNodeCreator(Supplier<ObjectNode> objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

    public Supplier<ObjectNode> getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(Supplier<ObjectNode> objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

}
