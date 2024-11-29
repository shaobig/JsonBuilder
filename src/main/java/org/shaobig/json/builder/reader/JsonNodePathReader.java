package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonNodePathReader implements PathReader<JsonNode> {

    private PathReader<JsonNode> jsonNodeValueReader;
    private PathReader<String> stringPathReader;

    public JsonNodePathReader(PathReader<JsonNode> jsonNodeValueReader, PathReader<String> stringPathReader) {
        this.jsonNodeValueReader = jsonNodeValueReader;
        this.stringPathReader = stringPathReader;
    }

    @Override
    public JsonNode readPath(String path) {
        return getJsonNodeValueReader().readPath(getStringPathReader().readPath(path));
    }

    public PathReader<JsonNode> getJsonNodeValueReader() {
        return jsonNodeValueReader;
    }

    public void setJsonNodeValueReader(PathReader<JsonNode> jsonNodeValueReader) {
        this.jsonNodeValueReader = jsonNodeValueReader;
    }

    public PathReader<String> getStringPathReader() {
        return stringPathReader;
    }

    public void setStringPathReader(PathReader<String> stringPathReader) {
        this.stringPathReader = stringPathReader;
    }

}
