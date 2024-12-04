package org.shaobig.json.builder.reader.path;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.reader.value.ValueReader;

public class GenericPathReaderEntityFactory<T> implements EntityFactory<GenericPathReader<T>> {

    private JsonNode jsonNode;
    private ValueReader<T> valueReader;

    public GenericPathReaderEntityFactory(JsonNode jsonNode, ValueReader<T> valueReader) {
        this.jsonNode = jsonNode;
        this.valueReader = valueReader;
    }

    @Override
    public GenericPathReader<T> createEntity() {
        return new GenericPathReader<>(new ValidationChangeablePathReader(new IterativeChangeablePathReader(getJsonNode())), getValueReader());
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

}
