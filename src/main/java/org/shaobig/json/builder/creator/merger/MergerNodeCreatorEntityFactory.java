package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.ClassNodeCreatorEntityFactory;
import org.shaobig.json.builder.creator.FactoryNodeCreator;
import org.shaobig.json.builder.creator.NestedNodeCreator;

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
