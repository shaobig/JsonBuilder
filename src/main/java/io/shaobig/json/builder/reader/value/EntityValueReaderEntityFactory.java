package io.shaobig.json.builder.reader.value;

import com.fasterxml.jackson.databind.JsonNode;
import io.shaobig.json.builder.EntityFactory;
import io.shaobig.json.builder.reader.path.NestedJsonPathReader;
import io.shaobig.json.builder.reader.value.object.reader.EntityObjectReaderSupplier;

public class EntityValueReaderEntityFactory implements EntityFactory<EntityObjectReader> {

    private JsonNode jsonNode;

    public EntityValueReaderEntityFactory(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public EntityObjectReader createEntity() {
        return new EntityObjectReader(new EntityObjectReaderSupplier(),  new NestedJsonPathReader(getJsonNode()));
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
