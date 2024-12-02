package org.shaobig.json.builder.reader.parent;

import org.shaobig.json.builder.reader.PathReader;

public class ParentPathReader implements PathReader<String> {

    private static final String DELIMITER_SYMBOL = ".";
    private static final String EMPTY_STRING = "";

    private PathReader<String> childPathReader;

    public ParentPathReader(PathReader<String> childPathReader) {
        this.childPathReader = childPathReader;
    }

    @Override
    public String readPath(String path) {
        return path.replace(DELIMITER_SYMBOL.concat(getChildPathReader().readPath(path)), EMPTY_STRING);
    }

    public PathReader<String> getChildPathReader() {
        return childPathReader;
    }

    public void setChildPathReader(PathReader<String> childPathReader) {
        this.childPathReader = childPathReader;
    }

}
