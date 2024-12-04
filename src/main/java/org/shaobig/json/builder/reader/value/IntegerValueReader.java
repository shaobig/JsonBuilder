package org.shaobig.json.builder.reader.value;

import com.fasterxml.jackson.databind.JsonNode;

public class IntegerValueReader implements ValueReader<Integer> {

    @Override
    public Integer readValue(JsonNode jsonNode) {
        return jsonNode.asInt();
    }

}
