package org.shaobig.json.builder.creator.merger;

import org.shaobig.json.builder.creator.NodeCreator;
import org.shaobig.json.builder.creator.nested.NestedNodeCreator;

public abstract class MergerNodeCreator<T> implements NodeCreator<T> {

    private NodeMerger nodeMerger;
    private NestedNodeCreator<T> nestedNodeCreator;

    public MergerNodeCreator(NodeMerger nodeMerger, NestedNodeCreator<T> nestedNodeCreator) {
        this.nodeMerger = nodeMerger;
        this.nestedNodeCreator = nestedNodeCreator;
    }

    public NodeMerger getNodeMerger() {
        return nodeMerger;
    }

    public void setNodeMerger(NodeMerger nodeMerger) {
        this.nodeMerger = nodeMerger;
    }

    public NestedNodeCreator<T> getNestedNodeCreator() {
        return nestedNodeCreator;
    }

    public void setNestedNodeCreator(NestedNodeCreator<T> nestedNodeCreator) {
        this.nestedNodeCreator = nestedNodeCreator;
    }

}
