package org.shaobig.json.builder.reader.parent;

import org.shaobig.json.builder.reader.PathReader;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChildPathReader implements PathReader<String> {

    @Override
    public String readPath(String path) {
        String[] keyList = path.split("\\.");
        return Stream.of(keyList)
                .skip(keyList.length - 1)
                .collect(Collectors.joining("."));
    }

}
