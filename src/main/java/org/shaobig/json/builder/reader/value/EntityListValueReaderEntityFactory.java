package org.shaobig.json.builder.reader.value;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.reader.path.NestedJsonPathReader;
import org.shaobig.json.builder.reader.value.object.reader.ListObjectReaderSupplier;

public class EntityListValueReaderEntityFactory implements EntityFactory<EntityListValueReader> {

    private JsonNode jsonNode;

    public EntityListValueReaderEntityFactory(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public EntityListValueReader createEntity() {
        return new EntityListValueReader(new ListObjectReaderSupplier(),  new NestedJsonPathReader(getJsonNode()));
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
