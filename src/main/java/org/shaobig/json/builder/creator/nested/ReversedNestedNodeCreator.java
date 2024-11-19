package org.shaobig.json.builder.creator.nested;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.shaobig.json.builder.factory.FactoryNodeCreator;

import java.util.List;

public class ReversedNestedNodeCreator<T> extends NestedNodeCreator<T> {

    private static final String KEY_DELIMITER_REG_EXP = "\\.";

    public ReversedNestedNodeCreator(FactoryNodeCreator<T> valueCreator) {
        super(valueCreator);
    }

    @Override
    public ObjectNode createNode(String path, T object) {
        List<String> keyList = List.of(path.split(KEY_DELIMITER_REG_EXP));
        int lastKeyIndex = keyList.size() - 1;
        return keyList.subList(0, lastKeyIndex).stream()
                .sorted((o1, o2) -> keyList.indexOf(o2) - keyList.indexOf(o1))
                .reduce(getValueCreator().createNode(keyList.get(lastKeyIndex), object), (objectNode, key) -> new ObjectMapper().createObjectNode().set(key, objectNode), (objectNode, objectNode2) -> objectNode);
    }

}
