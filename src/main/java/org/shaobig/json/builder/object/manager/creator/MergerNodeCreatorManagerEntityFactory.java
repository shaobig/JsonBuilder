package org.shaobig.json.builder.object.manager.creator;

import org.shaobig.json.builder.EntityFactory;
import org.shaobig.json.builder.creator.MergerNodeCreator;

import java.util.List;

public class MergerNodeCreatorManagerEntityFactory implements EntityFactory<MergerNodeCreatorManager> {

    private EntityFactory<MergerNodeCreator<String>> stringMergerNodeCreatorEntityFactory;
    private EntityFactory<MergerNodeCreator<Integer>> integerMergerNodeCreatorEntityFactory;
    private EntityFactory<MergerNodeCreator<List<?>>> listMergerNodeCreatorEntityFactory;

    public MergerNodeCreatorManagerEntityFactory(EntityFactory<MergerNodeCreator<String>> stringMergerNodeCreatorEntityFactory, EntityFactory<MergerNodeCreator<Integer>> integerMergerNodeCreatorEntityFactory, EntityFactory<MergerNodeCreator<List<?>>> listMergerNodeCreatorEntityFactory) {
        this.stringMergerNodeCreatorEntityFactory = stringMergerNodeCreatorEntityFactory;
        this.integerMergerNodeCreatorEntityFactory = integerMergerNodeCreatorEntityFactory;
        this.listMergerNodeCreatorEntityFactory = listMergerNodeCreatorEntityFactory;
    }

    @Override
    public MergerNodeCreatorManager createEntity() {
        return new MergerNodeCreatorManager(getStringMergerNodeCreatorEntityFactory().createEntity(), getIntegerMergerNodeCreatorEntityFactory().createEntity(), getListMergerNodeCreatorEntityFactory().createEntity());
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

    public EntityFactory<MergerNodeCreator<List<?>>> getListMergerNodeCreatorEntityFactory() {
        return listMergerNodeCreatorEntityFactory;
    }

    public void setListMergerNodeCreatorEntityFactory(EntityFactory<MergerNodeCreator<List<?>>> listMergerNodeCreatorEntityFactory) {
        this.listMergerNodeCreatorEntityFactory = listMergerNodeCreatorEntityFactory;
    }

}
