package org.shaobig.json.builder.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.shaobig.json.builder.builder.JsonBuilderManager;
import org.shaobig.json.builder.creator.merger.GenericObjectNodeMergerNodeCreator;
import org.shaobig.json.builder.creator.merger.RecursiveNodeMerger;
import org.shaobig.json.builder.creator.nested.ReversedNestedNodeCreator;

public class JsonBuilderManagerEntityFactory implements EntityFactory<JsonBuilderManager> {

    @Override
    public JsonBuilderManager createEntity() {
        return new JsonBuilderManager(new GenericObjectNodeMergerNodeCreator<>(new RecursiveNodeMerger(), new ReversedNestedNodeCreator<>(new GenericFactoryNodeCreator<>(new ClassNodeCreatorEntityFactory<>(Object.class))), new ObjectMapper().createObjectNode()));
    }

}
