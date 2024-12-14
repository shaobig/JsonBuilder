package org.shaobig.json.builder.creator;

import com.fasterxml.jackson.databind.JsonNode;
import org.shaobig.json.builder.creator.merger.NodeMerger;

public class MergeJsonObjectCreator extends JsonObjectCreator {

    private NodeMerger<JsonNode> nodeMerger;
    private ObjectCreator objectCreator;

    public MergeJsonObjectCreator(JsonNode jsonNode, NodeMerger<JsonNode> nodeMerger, ObjectCreator objectCreator) {
        super(jsonNode);
        this.nodeMerger = nodeMerger;
        this.objectCreator = objectCreator;
    }

    @Override
    public JsonNode createObject(String path, Object object) {
        return getNodeMerger().mergeValue(getJsonNode(), getNodeCreator().createObject(path, object));
    }

    public NodeMerger<JsonNode> getNodeMerger() {
        return nodeMerger;
    }

    public void setNodeMerger(NodeMerger<JsonNode> nodeMerger) {
        this.nodeMerger = nodeMerger;
    }

    public ObjectCreator getNodeCreator() {
        return objectCreator;
    }

    public void setNodeCreator(ObjectCreator objectCreator) {
        this.objectCreator = objectCreator;
    }

}
