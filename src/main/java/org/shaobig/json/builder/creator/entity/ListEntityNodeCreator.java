package org.shaobig.json.builder.creator.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.shaobig.json.builder.creator.NodeSupplier;

import java.util.List;

public class ListEntityNodeCreator<T> extends EntityNodeCreator<List<T>, ArrayNode> {

    public ListEntityNodeCreator(NodeSupplier<ArrayNode> objectNodeSupplier) {
        super(objectNodeSupplier);
    }

    @Override
    public JsonNode createNode(String path, List<T> list) {
        return list.stream().reduce(getNodeSupplier().supplyNode(), ArrayNode::addPOJO, (jsonNodes, jsonNodes2) -> jsonNodes);
    }

}
