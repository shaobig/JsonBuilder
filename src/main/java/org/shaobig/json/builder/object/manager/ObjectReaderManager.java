package org.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.object.JsonNodeSetter;
import org.shaobig.json.builder.reader.value.EntityListObjectReader;
import org.shaobig.json.builder.reader.value.EntityObjectReader;
import org.shaobig.json.builder.reader.value.ListObjectReader;
import org.shaobig.json.builder.reader.value.ObjectReader;

import java.util.List;

public class ObjectReaderManager implements ObjectReader, ListObjectReader, JsonNodeSetter {

    private EntityObjectReader entityObjectReader;
    private EntityListObjectReader entityListObjectReader;

    public ObjectReaderManager(EntityObjectReader entityObjectReader, EntityListObjectReader entityListObjectReader) {
        this.entityObjectReader = entityObjectReader;
        this.entityListObjectReader = entityListObjectReader;
    }

    @Override
    public <T> T readObject(String path, Class<T> valueType) {
        return getEntityObjectReader().readObject(path, valueType);
    }

    @Override
    public <T> List<T> readList(String path, Class<T> valueType) {
        return getEntityListObjectReader().readList(path, valueType);
    }

    @Override
    public void setJsonNode(JsonNode jsonNode) {
        getEntityObjectReader().setJsonNode(jsonNode);
        getEntityListObjectReader().setJsonNode(jsonNode);
    }

    public EntityObjectReader getEntityObjectReader() {
        return entityObjectReader;
    }

    public void setEntityObjectReader(EntityObjectReader entityObjectReader) {
        this.entityObjectReader = entityObjectReader;
    }

    public EntityListObjectReader getEntityListObjectReader() {
        return entityListObjectReader;
    }

    public void setEntityListObjectReader(EntityListObjectReader entityListObjectReader) {
        this.entityListObjectReader = entityListObjectReader;
    }

}
