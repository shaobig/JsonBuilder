package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.JsonNodeSetter;

public class GenericPathReader<T> implements PathReader<T>, JsonNodeSetter {

    private JsonNodePathReader jsonNodePathReader;
    private ValueReader<T> valueReader;

    public GenericPathReader(JsonNodePathReader jsonNodePathReader, ValueReader<T> valueReader) {
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

    public JsonNodePathReader getJsonNodePathReader() {
        return jsonNodePathReader;
    }

    public void setJsonNodePathReader(JsonNodePathReader jsonNodePathReader) {
        this.jsonNodePathReader = jsonNodePathReader;
    }

    public ValueReader<T> getValueReader() {
        return valueReader;
    }

    public void setValueReader(ValueReader<T> valueReader) {
        this.valueReader = valueReader;
    }

}
