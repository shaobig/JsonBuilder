package org.shaobig.json.builder.creator.entity.list;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.NodeSupplier;
import org.shaobig.json.builder.creator.entity.EntityNodeCreator;

import java.util.List;

public class ListEntityNodeCreator extends EntityNodeCreator<List<?>, ArrayNode> {

    private NodeSupplier<ObjectNode> objectNodeSupplier;

    public ListEntityNodeCreator(NodeSupplier<ArrayNode> nodeSupplier, NodeSupplier<ObjectNode> objectNodeSupplier) {
        super(nodeSupplier);
        this.objectNodeSupplier = objectNodeSupplier;
    }

    @Override
    public JsonNode createNode(String path, List<?> list) {
        return getObjectNodeSupplier().supplyNode().set(path, list.stream().reduce(getNodeSupplier().supplyNode(), ArrayNode::addPOJO, (jsonNodes, jsonNodes2) -> jsonNodes));
    }

    public NodeSupplier<ObjectNode> getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(NodeSupplier<ObjectNode> objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

}
