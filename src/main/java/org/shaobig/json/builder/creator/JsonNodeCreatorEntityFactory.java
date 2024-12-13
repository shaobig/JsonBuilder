package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.merger.CopyNodeMerger;
import org.shaobig.json.builder.creator.merger.RecursiveNodeMerger;
import org.shaobig.json.builder.creator.merger.stream.UnknownSizeSpliteratorSupplier;

public class JsonNodeCreatorEntityFactory implements EntityFactory<JsonNodeCreator> {

    private JsonNode jsonNode;

    public JsonNodeCreatorEntityFactory(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    @Override
    public JsonNodeCreator createEntity() {
        NodeSupplier nodeSupplier = new NewObjectNodeSupplier();
        return new MergeJsonNodeCreator(getJsonNode(), new RecursiveNodeMerger(nodeSupplier, new CopyNodeMerger(new UnknownSizeSpliteratorSupplier<>())), new NestedEntityNodeCreator(nodeSupplier, new EntityNodeCreator(nodeSupplier)));
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

}
