package org.shaobig.json.builder.creator.merger;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.NodeCreator;

public abstract class MergerNodeCreator<T> implements NodeCreator<T> {

    private JsonNode jsonNode;
    private NodeMerger nodeMerger;
    private NodeCreator<T> nestedNodeCreator;

    public MergerNodeCreator(JsonNode jsonNode, NodeMerger nodeMerger, NodeCreator<T> nestedNodeCreator) {
        this.jsonNode = jsonNode;
        this.nodeMerger = nodeMerger;
        this.nestedNodeCreator = nestedNodeCreator;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public NodeMerger getNodeMerger() {
        return nodeMerger;
    }

    public void setNodeMerger(NodeMerger nodeMerger) {
        this.nodeMerger = nodeMerger;
    }

    public NodeCreator<T> getNestedNodeCreator() {
        return nestedNodeCreator;
    }

    public void setNestedNodeCreator(NodeCreator<T> nestedNodeCreator) {
        this.nestedNodeCreator = nestedNodeCreator;
    }

}
