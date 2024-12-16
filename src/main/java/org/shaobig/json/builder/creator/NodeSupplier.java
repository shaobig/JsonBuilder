package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface NodeSupplier {

    ObjectNode supplyNode();

}
