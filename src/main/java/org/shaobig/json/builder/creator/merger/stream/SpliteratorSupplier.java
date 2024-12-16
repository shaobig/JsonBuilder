package org.shaobig.json.builder.creator.merger.stream;

import java.util.Iterator;
import java.util.Spliterator;

public interface SpliteratorSupplier<T> {

    Spliterator<T> getSpliterator(Iterator<T> iterator);

}
