package org.shaobig.json.builder.object;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.entity.IntegerNodeCreator;
import org.shaobig.json.builder.creator.entity.StringNodeCreator;
import org.shaobig.json.builder.creator.merger.MergerNodeCreatorEntityFactory;
import org.shaobig.json.builder.creator.merger.RecursiveNodeMerger;
import org.shaobig.json.builder.reader.GenericPathReaderEntityFactory;
import org.shaobig.json.builder.reader.entity.IntegerValueReader;
import org.shaobig.json.builder.reader.entity.StringValueReader;

class ProxyJsonObjectManagerEntityFactory implements EntityFactory<JsonObjectManager> {

    private EntityFactory<JsonNode> jsonNodeEntityFactory;

    public ProxyJsonObjectManagerEntityFactory() {
        this.jsonNodeEntityFactory = new JsonNodeEntityFactory();
    }

    public ProxyJsonObjectManagerEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
    }

    @Override
    public JsonObjectManager createEntity() {
        JsonNode jsonNode = getJsonNodeEntityFactory().createEntity();;
        MergerNodeCreatorManagerEntityFactory mergerNodeCreatorManagerEntityFactory = new MergerNodeCreatorManagerEntityFactory(new MergerNodeCreatorEntityFactory<>(jsonNode, new RecursiveNodeMerger(), new StringNodeCreator()), new MergerNodeCreatorEntityFactory<>(jsonNode, new RecursiveNodeMerger(), new IntegerNodeCreator()));
        GenericPathReaderManagerEntityFactory genericPathReaderManagerEntityFactory = new GenericPathReaderManagerEntityFactory(new GenericPathReaderEntityFactory<>(jsonNode, new StringValueReader()), new GenericPathReaderEntityFactory<>(jsonNode, new IntegerValueReader()));
        return new JsonObjectManagerEntityFactory(() -> jsonNode, mergerNodeCreatorManagerEntityFactory, genericPathReaderManagerEntityFactory).createEntity();
    }

    public EntityFactory<JsonNode> getJsonNodeEntityFactory() {
        return jsonNodeEntityFactory;
    }

    public void setJsonNodeEntityFactory(EntityFactory<JsonNode> jsonNodeEntityFactory) {
        this.jsonNodeEntityFactory = jsonNodeEntityFactory;
    }

}
