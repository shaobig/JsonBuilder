package org.shaobig.json.builder.factory;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.FactoryNodeCreator;
import org.shaobig.json.builder.creator.NestedNodeCreator;
import org.shaobig.json.builder.creator.merger.GenericMergerNodeCreator;
import org.shaobig.json.builder.creator.merger.MergerNodeCreator;
import org.shaobig.json.builder.creator.merger.RecursiveNodeMerger;

public class MergerNodeCreatorEntityFactory<T> implements EntityFactory<MergerNodeCreator<Object>> {

    private JsonNode jsonNode;

    public MergerNodeCreatorEntityFactory(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public MergerNodeCreator<Object> createEntity() {
        return new GenericMergerNodeCreator<>(getJsonNode(), new RecursiveNodeMerger(), new NestedNodeCreator<>(new FactoryNodeCreator<>(new ClassNodeCreatorEntityFactory<>(Object.class))));
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
