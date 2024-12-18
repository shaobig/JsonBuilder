package io.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.shaobig.json.builder.creator.merger.stream.SpliteratorSupplier;

import java.util.Map;
import java.util.stream.StreamSupport;

public class CopyNodeMerger implements NodeMerger<ObjectNode> {

    private static final boolean IS_PARALLEL = false;

    private SpliteratorSupplier<Map.Entry<String, JsonNode>> spliteratorSupplier;

    public CopyNodeMerger(SpliteratorSupplier<Map.Entry<String, JsonNode>> spliteratorSupplier) {
        this.spliteratorSupplier = spliteratorSupplier;
    }

    @Override
    public ObjectNode mergeValue(ObjectNode parentNode, JsonNode childNode) {
        return StreamSupport.stream(getSplititeratorSupplier().getSpliterator(childNode.fields()), IS_PARALLEL)
                .reduce(parentNode, (objectNode, entry) -> objectNode.set(entry.getKey(), entry.getValue()), (objectNode, objectNode2) -> objectNode);
    }

    public SpliteratorSupplier<Map.Entry<String, JsonNode>> getSplititeratorSupplier() {
        return spliteratorSupplier;
    }

    public void setSplititeratorSupplier(SpliteratorSupplier<Map.Entry<String, JsonNode>> spliteratorSupplier) {
        this.spliteratorSupplier = spliteratorSupplier;
    }

}
