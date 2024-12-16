package org.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.JsonNodeCreatorEntityFactory;
import org.shaobig.json.builder.creator.NewObjectNodeSupplier;
import org.shaobig.json.builder.reader.value.EntityListValueReaderEntityFactory;
import org.shaobig.json.builder.reader.value.EntityValueReaderEntityFactory;

public class JsonObjectManagerEntityFactory implements EntityFactory<JsonObjectManager> {

    @Override
    public JsonObjectManager createEntity() {
        JsonNode jsonNode = new NewObjectNodeSupplier().supplyNode();
        return new JsonObjectManager(jsonNode, new ObjectCreatorManager(new JsonNodeCreatorEntityFactory(jsonNode).createEntity()), new ObjectReaderManager(new EntityValueReaderEntityFactory(jsonNode).createEntity(), new EntityListValueReaderEntityFactory(jsonNode).createEntity()));
    }

}
