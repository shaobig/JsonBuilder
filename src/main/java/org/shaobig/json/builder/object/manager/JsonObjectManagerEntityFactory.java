package org.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.object.GenericPathReaderManager;
import org.shaobig.json.builder.object.MergerNodeCreatorManager;

public class JsonObjectManagerEntityFactory implements EntityFactory<JsonObjectManager> {

    private EntityFactory<JsonNode> jsonNodeEntityFactory;
    private EntityFactory<MergerNodeCreatorManager> mergerNodeCreatorManagerEntityFactory;
    private EntityFactory<GenericPathReaderManager> genericPathReaderManagerEntityFactory;

    public JsonObjectManagerEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory, EntityFactory<MergerNodeCreatorManager> mergerNodeCreatorManagerEntityFactory, EntityFactory<GenericPathReaderManager> genericPathReaderManagerEntityFactory) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
        this.mergerNodeCreatorManagerEntityFactory = mergerNodeCreatorManagerEntityFactory;
        this.genericPathReaderManagerEntityFactory = genericPathReaderManagerEntityFactory;
    }

    @Override
    public JsonObjectManager createEntity() {
        return new JsonObjectManager(getJsonNodeEntityFactory().createEntity(), getMergerNodeCreatorManagerEntityFactory().createEntity(), getGenericPathReaderManagerEntityFactory().createEntity());
    }

    public EntityFactory<JsonNode> getJsonNodeEntityFactory() {
        return jsonNodeEntityFactory;
    }

    public void setJsonNodeEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
    }

    public EntityFactory<MergerNodeCreatorManager> getMergerNodeCreatorManagerEntityFactory() {
        return mergerNodeCreatorManagerEntityFactory;
    }

    public void setMergerNodeCreatorManagerEntityFactory(EntityFactory<MergerNodeCreatorManager> mergerNodeCreatorManagerEntityFactory) {
        this.mergerNodeCreatorManagerEntityFactory = mergerNodeCreatorManagerEntityFactory;
    }

    public EntityFactory<GenericPathReaderManager> getGenericPathReaderManagerEntityFactory() {
        return genericPathReaderManagerEntityFactory;
    }

    public void setGenericPathReaderManagerEntityFactory(EntityFactory<GenericPathReaderManager> genericPathReaderManagerEntityFactory) {
        this.genericPathReaderManagerEntityFactory = genericPathReaderManagerEntityFactory;
    }

}
