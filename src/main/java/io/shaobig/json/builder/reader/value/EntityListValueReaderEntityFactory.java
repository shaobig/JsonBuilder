package io.shaobig.json.builder.reader.value;

import com.fasterxml.jackson.databind.JsonNode;
import io.shaobig.json.builder.EntityFactory;
import io.shaobig.json.builder.reader.path.NestedJsonPathReader;
import io.shaobig.json.builder.reader.value.object.reader.ListObjectReaderSupplier;

public class EntityListValueReaderEntityFactory implements EntityFactory<EntityListObjectReader> {

    private JsonNode jsonNode;

    public EntityListValueReaderEntityFactory(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public EntityListObjectReader createEntity() {
        return new EntityListObjectReader(new ListObjectReaderSupplier(),  new NestedJsonPathReader(getJsonNode()));
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
