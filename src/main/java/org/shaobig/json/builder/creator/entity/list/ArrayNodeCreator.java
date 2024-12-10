package org.shaobig.json.builder.creator.entity.list;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.NodeSupplier;
import org.shaobig.json.builder.creator.entity.EntityNodeCreator;

import java.util.List;

public class ArrayNodeCreator extends EntityNodeCreator<List<?>, ArrayNode> {

    private NodeSupplier<ObjectNode> objectNodeSupplier;

    public ArrayNodeCreator(NodeSupplier<ArrayNode> nodeSupplier) {
        super(nodeSupplier);
    }

    @Override
    public JsonNode createNode(String path, List<?> list) {
        return list.stream().reduce(getNodeSupplier().supplyNode(), ArrayNode::addPOJO, (jsonNodes, jsonNodes2) -> jsonNodes);
    }

    public NodeSupplier<ObjectNode> getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(NodeSupplier<ObjectNode> objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

}
