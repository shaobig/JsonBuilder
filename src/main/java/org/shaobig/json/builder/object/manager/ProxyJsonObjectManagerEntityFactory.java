package org.shaobig.json.builder.object.manager;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.MergerNodeCreatorEntityFactory;
import org.shaobig.json.builder.creator.ObjectNodeSupplier;
import org.shaobig.json.builder.creator.entity.IntegerEntityNodeCreator;
import org.shaobig.json.builder.creator.entity.StringEntityNodeCreator;
import org.shaobig.json.builder.creator.merger.RecursiveNodeMerger;
import org.shaobig.json.builder.object.JsonNodeEntityFactory;
import org.shaobig.json.builder.object.manager.creator.MergerNodeCreatorManagerEntityFactory;
import org.shaobig.json.builder.object.manager.reader.GenericPathReaderManagerEntityFactory;
import org.shaobig.json.builder.reader.path.GenericPathReaderEntityFactory;
import org.shaobig.json.builder.reader.value.IntegerValueReader;
import org.shaobig.json.builder.reader.value.StringValueReader;

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
        JsonNode jsonNode = getJsonNodeEntityFactory().createEntity();;
        MergerNodeCreatorManagerEntityFactory mergerNodeCreatorManagerEntityFactory = new MergerNodeCreatorManagerEntityFactory(new MergerNodeCreatorEntityFactory<>(jsonNode, new RecursiveNodeMerger(), new StringEntityNodeCreator(new ObjectNodeSupplier())), new MergerNodeCreatorEntityFactory<>(jsonNode, new RecursiveNodeMerger(), new IntegerEntityNodeCreator(new ObjectNodeSupplier())));
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
