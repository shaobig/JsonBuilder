package io.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class NewObjectNodeSupplier implements NodeSupplier {

    @Override
    public ObjectNode supplyNode() {
        return new ObjectMapper().createObjectNode();
    }

}
