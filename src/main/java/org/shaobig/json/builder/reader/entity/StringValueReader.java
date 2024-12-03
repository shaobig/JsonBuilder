package org.shaobig.json.builder.reader.entity;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.reader.ValueReader;

public class StringValueReader implements ValueReader<String> {

    @Override
    public String readValue(JsonNode jsonNode) {
        return jsonNode.asText();
    }

}
