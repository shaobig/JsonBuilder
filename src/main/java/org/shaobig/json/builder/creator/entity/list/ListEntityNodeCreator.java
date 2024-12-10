package org.shaobig.json.builder.creator.entity.list;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.creator.NodeSupplier;
import org.shaobig.json.builder.creator.entity.EntityNodeCreator;

import java.util.List;

public class ListEntityNodeCreator extends EntityNodeCreator<List<?>, ObjectNode> {

    private NodeCreator<List<?>> listNodeCreator;

    public ListEntityNodeCreator(NodeSupplier<ObjectNode> nodeSupplier, NodeCreator<List<?>> listNodeCreator) {
        super(nodeSupplier);
        this.listNodeCreator = listNodeCreator;
    }

    @Override
    public JsonNode createNode(String path, List<?> list) {
        return getNodeSupplier().supplyNode().set(path, getListNodeCreator().createNode(path, list));
    }

    public NodeCreator<List<?>> getListNodeCreator() {
        return listNodeCreator;
    }

    public void setListNodeCreator(NodeCreator<List<?>> listNodeCreator) {
        this.listNodeCreator = listNodeCreator;
    }

}
