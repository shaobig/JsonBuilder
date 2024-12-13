package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class NestedEntityNodeCreator implements NodeCreator {

    private static final String KEY_DELIMITER_REG_EXP = "\\.";

    private NodeSupplier objectNodeSupplier;
    private NodeCreator nodeCreator;

    public NestedEntityNodeCreator(NodeSupplier objectNodeSupplier, NodeCreator nodeCreator) {
        this.objectNodeSupplier = objectNodeSupplier;
        this.nodeCreator = nodeCreator;
    }

    @Override
    public JsonNode createNode(String path, Object object) {
        List<String> keyList = List.of(path.split(KEY_DELIMITER_REG_EXP));
        int lastKeyIndex = keyList.size() - 1;
        return keyList.subList(0, lastKeyIndex).stream()
                .sorted((o1, o2) -> keyList.indexOf(o2) - keyList.indexOf(o1))
                .reduce(getNodeCreator().createNode(keyList.get(lastKeyIndex), object), (objectNode, key) -> getObjectNodeSupplier().supplyNode().set(key, objectNode), (objectNode, objectNode2) -> objectNode);

    }

    public NodeSupplier getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(NodeSupplier objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

    public NodeCreator getNodeCreator() {
        return nodeCreator;
    }

    public void setNodeCreator(NodeCreator nodeCreator) {
        this.nodeCreator = nodeCreator;
    }

}
