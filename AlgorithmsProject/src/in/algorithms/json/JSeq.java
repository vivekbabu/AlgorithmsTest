package in.algorithms.json;

import java.util.List;

public class JSeq implements JSON {
    public final List<JSON> elems;
    public JSeq(List<JSON> elems) { this.elems = elems; }
}
