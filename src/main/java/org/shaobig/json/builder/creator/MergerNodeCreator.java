package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.merger.NodeMerger;

public class MergerNodeCreator<T> implements NodeCreator<T> {

    private JsonNode jsonNode;
    private NodeMerger<JsonNode> nodeMerger;
    private NodeCreator<T> nestedNodeCreator;

    public MergerNodeCreator(JsonNode jsonNode, NodeMerger<JsonNode> nodeMerger, NodeCreator<T> nestedNodeCreator) {
        this.jsonNode = jsonNode;
        this.nodeMerger = nodeMerger;
        this.nestedNodeCreator = nestedNodeCreator;
    }

    @Override
    public JsonNode createNode(String path, T object) {
        return getNodeMerger().mergeValue(getJsonNode(), getNestedNodeCreator().createNode(path, object));
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public NodeMerger<JsonNode> getNodeMerger() {
        return nodeMerger;
    }

    public void setNodeMerger(NodeMerger<JsonNode> nodeMerger) {
        this.nodeMerger = nodeMerger;
    }

    public NodeCreator<T> getNestedNodeCreator() {
        return nestedNodeCreator;
    }

    public void setNestedNodeCreator(NodeCreator<T> nestedNodeCreator) {
        this.nestedNodeCreator = nestedNodeCreator;
    }

}
