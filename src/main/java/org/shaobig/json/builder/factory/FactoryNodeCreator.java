package org.shaobig.json.builder.factory;

import org.shaobig.json.builder.creator.NodeCreator;

public abstract class FactoryNodeCreator<T> implements NodeCreator<T> {

    private EntityFactory<NodeCreator<T>> nodeCreatorEntityFactory;

    public FactoryNodeCreator(EntityFactory<NodeCreator<T>> nodeCreatorEntityFactory) {
        this.nodeCreatorEntityFactory = nodeCreatorEntityFactory;
    }

    public EntityFactory<NodeCreator<T>> getNodeCreatorEntityFactory() {
        return nodeCreatorEntityFactory;
    }

    public void setNodeCreatorEntityFactory(EntityFactory<NodeCreator<T>> nodeCreatorEntityFactory) {
        this.nodeCreatorEntityFactory = nodeCreatorEntityFactory;
    }

}
