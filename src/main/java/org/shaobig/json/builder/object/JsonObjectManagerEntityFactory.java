package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.merger.MergerNodeCreator;
import org.shaobig.json.builder.reader.GenericPathReader;

class JsonObjectManagerEntityFactory implements EntityFactory<JsonObjectManager> {

    private EntityFactory<JsonNode> jsonNodeEntityFactory;
    private EntityFactory<MergerNodeCreator<Object>> objectNodeCreatorEntityFactory;
    private EntityFactory<GenericPathReader<String>> stringGenericPathReader;

    public JsonObjectManagerEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory, EntityFactory<MergerNodeCreator<Object>> objectNodeCreatorEntityFactory, EntityFactory<GenericPathReader<String>> stringGenericPathReader) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
        this.objectNodeCreatorEntityFactory = objectNodeCreatorEntityFactory;
        this.stringGenericPathReader = stringGenericPathReader;
    }

    @Override
    public JsonObjectManager createEntity() {
        return new JsonObjectManager(getJsonNodeEntityFactory().createEntity(), getObjectNodeCreatorEntityFactory().createEntity(), getStringGenericPathReader().createEntity());
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


    public EntityFactory<GenericPathReader<String>> getStringGenericPathReader() {
        return stringGenericPathReader;
    }

    public void setStringGenericPathReader(EntityFactory<GenericPathReader<String>> stringGenericPathReader) {
        this.stringGenericPathReader = stringGenericPathReader;
    }

}
