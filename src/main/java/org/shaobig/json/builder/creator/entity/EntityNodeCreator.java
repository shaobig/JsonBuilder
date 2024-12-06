package org.shaobig.json.builder.creator.entity;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.creator.NodeSupplier;

public abstract class EntityNodeCreator<T, N extends JsonNode> implements NodeCreator<T> {

    private NodeSupplier<N> nodeSupplier;

    public EntityNodeCreator(NodeSupplier<N> nodeSupplier) {
        this.nodeSupplier = nodeSupplier;
    }

    public NodeSupplier<N> getNodeSupplier() {
        return nodeSupplier;
    }

    public void setNodeSupplier(NodeSupplier<N> nodeSupplier) {
        this.nodeSupplier = nodeSupplier;
    }

}
