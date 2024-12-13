package org.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.JsonNodeSetter;
import org.shaobig.json.builder.reader.value.EntityListValueReader;
import org.shaobig.json.builder.reader.value.EntityValueReader;
import org.shaobig.json.builder.reader.value.ListValueReader;
import org.shaobig.json.builder.reader.value.ValueReader;

import java.util.List;

public class ValueReaderManager implements ValueReader, ListValueReader, JsonNodeSetter {

    private EntityValueReader entityValueReader;
    private EntityListValueReader entityListValueReader;

    public ValueReaderManager(EntityValueReader entityValueReader, EntityListValueReader entityListValueReader) {
        this.entityValueReader = entityValueReader;
        this.entityListValueReader = entityListValueReader;
    }

    @Override
    public <T> T readValue(String path, Class<T> valueType) {
        return getEntityValueReader().readValue(path, valueType);
    }

    @Override
    public <T> List<T> readList(String path, Class<T> valueType) {
        return getEntityListValueReader().readList(path, valueType);
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        getEntityValueReader().setJsonNode(jsonNode);
        getEntityListValueReader().setJsonNode(jsonNode);
    }

    public EntityValueReader getEntityValueReader() {
        return entityValueReader;
    }

    public void setEntityValueReader(EntityValueReader entityValueReader) {
        this.entityValueReader = entityValueReader;
    }

    public EntityListValueReader getEntityListValueReader() {
        return entityListValueReader;
    }

    public void setEntityListValueReader(EntityListValueReader entityListValueReader) {
        this.entityListValueReader = entityListValueReader;
    }

}
