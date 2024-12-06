package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ObjectNodeSupplier implements NodeSupplier<ObjectNode> {

    @Override
    public ObjectNode supplyNode() {
        return new ObjectMapper().createObjectNode();
    }

}
