package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;

public class GenericPathReader<T> implements PathReader<T> {

    private PathReader<JsonNode> jsonNodePathReader;
    private ValueReader<T> valueReader;

    public GenericPathReader(PathReader<JsonNode> jsonNodePathReader, ValueReader<T> valueReader) {
        this.jsonNodePathReader = jsonNodePathReader;
        this.valueReader = valueReader;
    }

    @Override
    public T readPath(String path) {
        return getValueReader().readValue(getJsonNodePathReader().readPath(path));
    }

    public PathReader<JsonNode> getJsonNodePathReader() {
        return jsonNodePathReader;
    }

    public void setJsonNodePathReader(PathReader<JsonNode> jsonNodePathReader) {
        this.jsonNodePathReader = jsonNodePathReader;
    }

    public ValueReader<T> getValueReader() {
        return valueReader;
    }

    public void setValueReader(ValueReader<T> valueReader) {
        this.valueReader = valueReader;
    }

}
