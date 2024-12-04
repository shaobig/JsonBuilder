package org.shaobig.json.builder.reader.value;

import com.fasterxml.jackson.databind.JsonNode;

public interface ValueReader<T> {

    T readValue(JsonNode objectNode);

}
