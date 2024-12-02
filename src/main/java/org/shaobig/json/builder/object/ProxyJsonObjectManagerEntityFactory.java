package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.merger.MergerNodeCreatorEntityFactory;
import org.shaobig.json.builder.reader.GenericPathReaderEntityFactory;
import org.shaobig.json.builder.reader.StringValueReader;

public class ProxyJsonObjectManagerEntityFactory implements EntityFactory<JsonObjectManager> {

    private EntityFactory<JsonNode> jsonNodeEntityFactory;

    public ProxyJsonObjectManagerEntityFactory() {
        this.jsonNodeEntityFactory = new JsonNodeEntityFactory();
    }

    public ProxyJsonObjectManagerEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
    }

    @Override
    public JsonObjectManager createEntity() {
        JsonNode jsonNode = getJsonNodeEntityFactory().createEntity();
        return new JsonObjectManagerEntityFactory(() -> jsonNode, new MergerNodeCreatorEntityFactory<>(jsonNode), new GenericPathReaderEntityFactory<>(jsonNode, new StringValueReader())).createEntity();
    }

    public EntityFactory<JsonNode> getJsonNodeEntityFactory() {
        return jsonNodeEntityFactory;
    }

    public void setJsonNodeEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
    }

}
