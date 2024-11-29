package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.merger.MergerNodeCreator;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.reader.PathReader;

class JsonObjectManagerEntityFactory implements EntityFactory<JsonObjectManager> {

    private EntityFactory<JsonNode> jsonNodeEntityFactory;
    private EntityFactory<MergerNodeCreator<Object>> objectNodeCreatorEntityFactory;
    private EntityFactory<PathReader<String>> stringPathReaderEntityFactory;

    public JsonObjectManagerEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory, EntityFactory<MergerNodeCreator<Object>> objectNodeCreatorEntityFactory, EntityFactory<PathReader<String>> stringPathReaderEntityFactory) {
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

    public EntityFactory<PathReader<String>> getStringPathReaderEntityFactory() {
        return stringPathReaderEntityFactory;
    }

    public void setStringPathReaderEntityFactory(EntityFactory<PathReader<String>> stringPathReaderEntityFactory) {
        this.stringPathReaderEntityFactory = stringPathReaderEntityFactory;
    }

}
