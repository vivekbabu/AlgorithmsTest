package in.algorithms.json;

import java.util.Map;

public class JObj extends JSON {
    public final Map<String, JSON> bindings;
    public JObj(Map<String, JSON> bindings) { this.bindings = bindings; }
}
