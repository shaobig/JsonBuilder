package io.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import io.shaobig.json.builder.EntityFactory;
import io.shaobig.json.builder.creator.JsonNodeCreatorEntityFactory;
import io.shaobig.json.builder.creator.NewObjectNodeSupplier;
import io.shaobig.json.builder.reader.value.EntityListValueReaderEntityFactory;
import io.shaobig.json.builder.reader.value.EntityValueReaderEntityFactory;

public class JsonObjectManagerEntityFactory implements EntityFactory<JsonObjectManager> {

    @Override
    public JsonObjectManager createEntity() {
        JsonNode jsonNode = new NewObjectNodeSupplier().supplyNode();
        return new JsonObjectManager(jsonNode, new ObjectCreatorManager(new JsonNodeCreatorEntityFactory(jsonNode).createEntity()), new ObjectReaderManager(new EntityValueReaderEntityFactory(jsonNode).createEntity(), new EntityListValueReaderEntityFactory(jsonNode).createEntity()));
    }

}
