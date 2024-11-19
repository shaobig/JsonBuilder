package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface NodeMerger {

    ObjectNode mergeValue(ObjectNode parentNode, ObjectNode childNode);

}
