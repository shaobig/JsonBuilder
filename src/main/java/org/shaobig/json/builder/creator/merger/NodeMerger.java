package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;

public interface NodeMerger {

    JsonNode mergeValue(JsonNode parentNode, JsonNode childNode);

}
