package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface NodeCreator<T> {

    ObjectNode createNode(String path, T object);

}
