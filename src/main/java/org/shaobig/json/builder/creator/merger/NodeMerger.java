package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;

public interface NodeMerger<T extends JsonNode> {

    T mergeValue(JsonNode parentNode, JsonNode childNode);

}
