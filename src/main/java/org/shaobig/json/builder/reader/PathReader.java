package org.shaobig.json.builder.reader;

public interface PathReader<T> {

    T readPath(String path);

}
