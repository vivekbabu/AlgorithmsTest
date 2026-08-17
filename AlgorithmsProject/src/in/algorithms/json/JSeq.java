package in.algorithms.json;

import java.util.List;

public class JSeq extends JSON {
    public final List<JSON> elems;
    public JSeq(List<JSON> elems) { this.elems = elems; }
}
