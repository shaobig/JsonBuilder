package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.merger.MergerNodeCreator;
import org.shaobig.json.builder.reader.GenericPathReader;

class JsonObjectManagerEntityFactory implements EntityFactory<JsonObjectManager> {

    private EntityFactory<JsonNode> jsonNodeEntityFactory;
    private EntityFactory<MergerNodeCreator<Object>> objectNodeCreatorEntityFactory;
    private EntityFactory<GenericPathReader<String>> stringPathReaderEntityFactory;

    public JsonObjectManagerEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory, EntityFactory<MergerNodeCreator<Object>> objectNodeCreatorEntityFactory, EntityFactory<GenericPathReader<String>> stringPathReaderEntityFactory) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
        this.objectNodeCreatorEntityFactory = objectNodeCreatorEntityFactory;
        this.stringPathReaderEntityFactory = stringPathReaderEntityFactory;
    }

    @Override
    public JsonObjectManager createEntity() {
        return new JsonObjectManager(getJsonNodeEntityFactory().createEntity(), getObjectNodeCreatorEntityFactory().createEntity(), getStringPathReaderEntityFactory().createEntity());
    }

    public EntityFactory<JsonNode> getJsonNodeEntityFactory() {
        return jsonNodeEntityFactory;
    }

    public void setJsonNodeEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
    }

    public EntityFactory<MergerNodeCreator<Object>> getObjectNodeCreatorEntityFactory() {
        return objectNodeCreatorEntityFactory;
    }

    public void setObjectNodeCreatorEntityFactory(EntityFactory<MergerNodeCreator<Object>> objectNodeCreatorEntityFactory) {
        this.objectNodeCreatorEntityFactory = objectNodeCreatorEntityFactory;
    }

    public EntityFactory<GenericPathReader<String>> getStringPathReaderEntityFactory() {
        return stringPathReaderEntityFactory;
    }

    public void setStringPathReaderEntityFactory(EntityFactory<GenericPathReader<String>> stringPathReaderEntityFactory) {
        this.stringPathReaderEntityFactory = stringPathReaderEntityFactory;
    }

}
