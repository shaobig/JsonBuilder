package org.shaobig.json.builder.creator.entity.list;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.creator.NodeSupplier;

import java.util.List;

public class ListEntityNodeCreator<T> implements NodeCreator<List<T>> {

    private NodeSupplier<ArrayNode> arrayNodeSupplier;

    public ListEntityNodeCreator(NodeSupplier<ArrayNode> arrayNodeSupplier) {
        this.arrayNodeSupplier = arrayNodeSupplier;
    }

    @Override
    public JsonNode createNode(String path, List<T> list) {
        return list.stream().reduce(getArrayNodeSupplier().supplyNode(), ArrayNode::addPOJO, (jsonNodes, jsonNodes2) -> jsonNodes);
    }

    public NodeSupplier<ArrayNode> getArrayNodeSupplier() {
        return arrayNodeSupplier;
    }

    public void setArrayNodeSupplier(NodeSupplier<ArrayNode> arrayNodeSupplier) {
        this.arrayNodeSupplier = arrayNodeSupplier;
    }

}
