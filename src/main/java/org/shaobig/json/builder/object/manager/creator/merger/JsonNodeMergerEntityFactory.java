package org.shaobig.json.builder.object.manager.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.ObjectNodeSupplier;
import org.shaobig.json.builder.creator.merger.CopyNodeMerger;
import org.shaobig.json.builder.creator.merger.NodeMerger;
import org.shaobig.json.builder.creator.merger.RecursiveNodeMerger;
import org.shaobig.json.builder.creator.merger.stream.UnknownSizeSpliteratorSupplier;

public class JsonNodeMergerEntityFactory implements EntityFactory<NodeMerger<JsonNode>> {

    @Override
    public NodeMerger<JsonNode> createEntity() {
        return new RecursiveNodeMerger(new ObjectNodeSupplier(), new CopyNodeMerger(new UnknownSizeSpliteratorSupplier<>()));
    }

}
