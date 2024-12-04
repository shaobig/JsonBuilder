package org.shaobig.json.builder.reader.path;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.reader.value.ValueReader;

public class GenericPathReader<T> implements ChangeablePathReader<T> {

    private ChangeablePathReader<JsonNode> jsonNodePathReader;
    private ValueReader<T> valueReader;

    public GenericPathReader(ChangeablePathReader<JsonNode> jsonNodePathReader, ValueReader<T> valueReader) {
        this.jsonNodePathReader = jsonNodePathReader;
        this.valueReader = valueReader;
    }

    @Override
    public T readPath(String path) {
        return getValueReader().readValue(getJsonNodePathReader().readPath(path));
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

    public ValueReader<T> getValueReader() {
        return valueReader;
    }

    public void setValueReader(ValueReader<T> valueReader) {
        this.valueReader = valueReader;
    }

}
