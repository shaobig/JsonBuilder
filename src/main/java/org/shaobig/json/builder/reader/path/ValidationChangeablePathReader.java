package org.shaobig.json.builder.reader.path;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.exception.JsonValueNotFoundException;

import java.util.Optional;

public class ValidationChangeablePathReader implements ChangeablePathReader<JsonNode> {

    private ChangeablePathReader<JsonNode> jsonNodePathReader;

    public ValidationChangeablePathReader(ChangeablePathReader<JsonNode> jsonNodePathReader) {
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

    public ChangeablePathReader<JsonNode> getJsonNodePathReader() {
        return jsonNodePathReader;
    }

    public void setJsonNodePathReader(ChangeablePathReader<JsonNode> jsonNodePathReader) {
        this.jsonNodePathReader = jsonNodePathReader;
    }

}
