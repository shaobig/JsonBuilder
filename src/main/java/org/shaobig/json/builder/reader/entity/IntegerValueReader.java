package org.shaobig.json.builder.reader.entity;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.reader.ValueReader;

public class IntegerValueReader implements ValueReader<Integer> {

    @Override
    public Integer readValue(JsonNode jsonNode) {
        return jsonNode.asInt();
    }

}
