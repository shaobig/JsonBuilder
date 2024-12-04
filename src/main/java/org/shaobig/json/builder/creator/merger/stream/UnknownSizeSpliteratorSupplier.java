package org.shaobig.json.builder.creator.merger.stream;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

public class UnknownSizeSpliteratorSupplier<T> implements SpliteratorSupplier<T> {

    private static final int SPLIT_ITERATOR_CHARACTERISTICS = 0;

    @Override
    public Spliterator<T> getSpliterator(Iterator<T> iterator) {
        return Spliterators.spliteratorUnknownSize(iterator, SPLIT_ITERATOR_CHARACTERISTICS);
    }

}
