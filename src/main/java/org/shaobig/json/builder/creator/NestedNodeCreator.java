package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public class NestedNodeCreator<T> implements NodeCreator<T> {

    private static final String KEY_DELIMITER_REG_EXP = "\\.";

    private NodeCreator<T> nodeCreator;
    private NodeSupplier<ObjectNode> objectNodeSupplier;

    public NestedNodeCreator(NodeCreator<T> nodeCreator, NodeSupplier<ObjectNode> objectNodeSupplier) {
        this.nodeCreator = nodeCreator;
        this.objectNodeSupplier = objectNodeSupplier;
    }

    @Override
    public JsonNode createNode(String path, T object) {
        List<String> keyList = List.of(path.split(KEY_DELIMITER_REG_EXP));
        int lastKeyIndex = keyList.size() - 1;
        return keyList.subList(0, lastKeyIndex).stream()
                .sorted((o1, o2) -> keyList.indexOf(o2) - keyList.indexOf(o1))
                .reduce(getNodeCreator().createNode(keyList.get(lastKeyIndex), object), (objectNode, key) -> getObjectNodeSupplier().supplyNode().set(key, objectNode), (objectNode, objectNode2) -> objectNode);
    }

    public NodeCreator<T> getNodeCreator() {
        return nodeCreator;
    }

    public void setNodeCreator(NodeCreator<T> nodeCreator) {
        this.nodeCreator = nodeCreator;
    }

    public NodeSupplier<ObjectNode> getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(NodeSupplier<ObjectNode> objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

}
