package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.merger.CopyNodeMerger;
import org.shaobig.json.builder.creator.merger.RecursiveNodeMerger;
import org.shaobig.json.builder.creator.merger.stream.UnknownSizeSpliteratorSupplier;

public class JsonNodeCreatorEntityFactory implements EntityFactory<JsonObjectCreator> {

    private JsonNode jsonNode;

    public JsonNodeCreatorEntityFactory(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public JsonObjectCreator createEntity() {
        NodeSupplier nodeSupplier = new NewObjectNodeSupplier();
        return new MergeJsonObjectCreator(getJsonNode(), new RecursiveNodeMerger(nodeSupplier, new CopyNodeMerger(new UnknownSizeSpliteratorSupplier<>())), new NestedEntityObjectCreator(nodeSupplier, new EntityObjectCreator(nodeSupplier)));
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
