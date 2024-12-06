package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;

public interface NodeSupplier<T extends JsonNode> {

    T supplyNode();

}
