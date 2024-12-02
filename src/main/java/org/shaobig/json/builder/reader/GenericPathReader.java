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
        return getValueReader().readValue(getNodePathReader().readPath(path));
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        getNodePathReader().setJsonNode(jsonNode);
    }

    public JsonNodePathReader getNodePathReader() {
        return jsonNodePathReader;
    }

    public void setNodePathReader(JsonNodePathReader jsonNodePathReader) {
        this.jsonNodePathReader = jsonNodePathReader;
    }

    public ValueReader<T> getValueReader() {
        return valueReader;
    }

    public void setValueReader(ValueReader<T> valueReader) {
        this.valueReader = valueReader;
    }

}
