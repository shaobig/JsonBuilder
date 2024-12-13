package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.merger.NodeMerger;

public class MergeJsonNodeCreator extends JsonNodeCreator {

    private NodeMerger<JsonNode> nodeMerger;
    private NodeCreator nodeCreator;

    public MergeJsonNodeCreator(JsonNode jsonNode, NodeMerger<JsonNode> nodeMerger, NodeCreator nodeCreator) {
        super(jsonNode);
        this.nodeMerger = nodeMerger;
        this.nodeCreator = nodeCreator;
    }

    @Override
    public JsonNode createNode(String path, Object object) {
        return getNodeMerger().mergeValue(getJsonNode(), getNodeCreator().createNode(path, object));
    }

    public NodeMerger<JsonNode> getNodeMerger() {
        return nodeMerger;
    }

    public void setNodeMerger(NodeMerger<JsonNode> nodeMerger) {
        this.nodeMerger = nodeMerger;
    }

    public NodeCreator getNodeCreator() {
        return nodeCreator;
    }

    public void setNodeCreator(NodeCreator nodeCreator) {
        this.nodeCreator = nodeCreator;
    }

}
