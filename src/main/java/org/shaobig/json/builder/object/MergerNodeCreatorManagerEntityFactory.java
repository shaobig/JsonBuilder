package org.shaobig.json.builder.object;

import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.MergerNodeCreator;

public class MergerNodeCreatorManagerEntityFactory implements EntityFactory<MergerNodeCreatorManager> {

    private EntityFactory<MergerNodeCreator<String>> stringMergerNodeCreatorEntityFactory;
    private EntityFactory<MergerNodeCreator<Integer>> integerMergerNodeCreatorEntityFactory;

    public MergerNodeCreatorManagerEntityFactory(EntityFactory<MergerNodeCreator<String>> stringMergerNodeCreatorEntityFactory, EntityFactory<MergerNodeCreator<Integer>> integerMergerNodeCreatorEntityFactory) {
        this.stringMergerNodeCreatorEntityFactory = stringMergerNodeCreatorEntityFactory;
        this.integerMergerNodeCreatorEntityFactory = integerMergerNodeCreatorEntityFactory;
    }

    @Override
    public MergerNodeCreatorManager createEntity() {
        return new MergerNodeCreatorManager(getStringMergerNodeCreatorEntityFactory().createEntity(), getIntegerMergerNodeCreatorEntityFactory().createEntity());
    }

    public EntityFactory<MergerNodeCreator<String>> getStringMergerNodeCreatorEntityFactory() {
        return stringMergerNodeCreatorEntityFactory;
    }

    public void setStringMergerNodeCreatorEntityFactory(EntityFactory<MergerNodeCreator<String>> stringMergerNodeCreatorEntityFactory) {
        this.stringMergerNodeCreatorEntityFactory = stringMergerNodeCreatorEntityFactory;
    }

    public EntityFactory<MergerNodeCreator<Integer>> getIntegerMergerNodeCreatorEntityFactory() {
        return integerMergerNodeCreatorEntityFactory;
    }

    public void setIntegerMergerNodeCreatorEntityFactory(EntityFactory<MergerNodeCreator<Integer>> integerMergerNodeCreatorEntityFactory) {
        this.integerMergerNodeCreatorEntityFactory = integerMergerNodeCreatorEntityFactory;
    }

}
