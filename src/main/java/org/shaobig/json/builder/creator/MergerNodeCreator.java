package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.merger.NodeMerger;

public class MergerNodeCreator<T> implements NodeCreator<T> {

    private JsonNode jsonNode;
    private NodeMerger<JsonNode> nodeMerger;
    private NodeCreator<T> nodeCreator;

    public MergerNodeCreator(JsonNode jsonNode, NodeMerger<JsonNode> nodeMerger, NodeCreator<T> nodeCreator) {
        this.jsonNode = jsonNode;
        this.nodeMerger = nodeMerger;
        this.nodeCreator = nodeCreator;
    }

    @Override
    public JsonNode createNode(String path, T object) {
        return getNodeMerger().mergeValue(getJsonNode(), getNodeCreator().createNode(path, object));
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

    public NodeCreator<T> getNodeCreator() {
        return nodeCreator;
    }

    public void setNodeCreator(NodeCreator<T> nodeCreator) {
        this.nodeCreator = nodeCreator;
    }

}
