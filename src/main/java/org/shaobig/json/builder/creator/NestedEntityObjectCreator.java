package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class NestedEntityObjectCreator implements ObjectCreator {

    private static final String KEY_DELIMITER_REG_EXP = "\\.";

    private NodeSupplier objectNodeSupplier;
    private ObjectCreator objectCreator;

    public NestedEntityObjectCreator(NodeSupplier objectNodeSupplier, ObjectCreator objectCreator) {
        this.objectNodeSupplier = objectNodeSupplier;
        this.objectCreator = objectCreator;
    }

    @Override
    public JsonNode createObject(String path, Object object) {
        List<String> keyList = List.of(path.split(KEY_DELIMITER_REG_EXP));
        int lastKeyIndex = keyList.size() - 1;
        return keyList.subList(0, lastKeyIndex).stream()
                .sorted((o1, o2) -> keyList.indexOf(o2) - keyList.indexOf(o1))
                .reduce(getNodeCreator().createObject(keyList.get(lastKeyIndex), object), (objectNode, key) -> getObjectNodeSupplier().supplyNode().set(key, objectNode), (objectNode, objectNode2) -> objectNode);

    }

    public NodeSupplier getObjectNodeSupplier() {
        return objectNodeSupplier;
    }

    public void setObjectNodeSupplier(NodeSupplier objectNodeSupplier) {
        this.objectNodeSupplier = objectNodeSupplier;
    }

    public ObjectCreator getNodeCreator() {
        return objectCreator;
    }

    public void setNodeCreator(ObjectCreator objectCreator) {
        this.objectCreator = objectCreator;
    }

}
