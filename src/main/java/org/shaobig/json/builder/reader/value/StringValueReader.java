package org.shaobig.json.builder.reader.value;

import com.fasterxml.jackson.databind.JsonNode;

public class StringValueReader implements ValueReader<String> {

    @Override
    public String readValue(JsonNode jsonNode) {
        return jsonNode.asText();
    }

}
