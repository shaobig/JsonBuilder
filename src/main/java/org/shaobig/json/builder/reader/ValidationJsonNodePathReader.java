package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.exception.JsonValueNotFoundException;

import java.util.Optional;

public class ValidationJsonNodePathReader implements JsonNodePathReader {

    private JsonNodePathReader jsonNodePathReader;

    public ValidationJsonNodePathReader(JsonNodePathReader jsonNodePathReader) {
        this.jsonNodePathReader = jsonNodePathReader;
    }

    @Override
    public JsonNode readPath(String path) {
        return Optional.ofNullable(getJsonNodePathReader().readPath(path))
                .orElseThrow(() -> new JsonValueNotFoundException(String.format("Can't find the JSON value in: '%s'", path)));
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        getJsonNodePathReader().setJsonNode(jsonNode);
    }

    public JsonNodePathReader getJsonNodePathReader() {
        return jsonNodePathReader;
    }

    public void setJsonNodePathReader(JsonNodePathReader jsonNodePathReader) {
        this.jsonNodePathReader = jsonNodePathReader;
    }

}
