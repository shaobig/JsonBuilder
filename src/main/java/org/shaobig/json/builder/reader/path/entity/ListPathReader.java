package org.shaobig.json.builder.reader.path.entity;

import java.util.List;

public interface ListPathReader {

    <T> List<T> readList(String path, Class<T> classType);

}
