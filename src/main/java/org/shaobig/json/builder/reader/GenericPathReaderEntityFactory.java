package org.shaobig.json.builder.reader;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;

public class GenericPathReaderEntityFactory<T> implements EntityFactory<PathReader<T>> {

    private JsonNode jsonNode;
    private ValueReader<T> valueReader;
    private String path;

    public GenericPathReaderEntityFactory(JsonNode jsonNode, ValueReader<T> valueReader, String path) {
        this.jsonNode = jsonNode;
        this.valueReader = valueReader;
        this.path = path;
    }

    @Override
    public GenericPathReader<T> createEntity() {
        return new GenericPathReader<>(new JsonNodePathReader(new NodePathReader(getJsonNode()), new ParentPathReader(new ChildPathReader())), getValueReader());
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public ValueReader<T> getValueReader() {
        return valueReader;
    }

    public void setValueReader(ValueReader<T> valueReader) {
        this.valueReader = valueReader;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
