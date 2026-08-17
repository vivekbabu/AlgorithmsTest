package in.algorithms.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONOperations {
    public static String show(JSON json) {
        if (json instanceof JStr) {
            return "\"" + ((JStr) json).str + "\"";
        } else if (json instanceof JNum) {
            return String.valueOf(((JNum) json).num);
        } else if (json instanceof JBool) {
            return String.valueOf(((JBool) json).b);
        } else if (json instanceof JNull) {
            return "null";
        } else if (json instanceof JSeq) {
            List<String> parts = new ArrayList<>();
            for (JSON elem : ((JSeq) json).elems) {
                parts.add(show(elem));
            }
            return "[" + String.join(", ", parts) + "]";
        } else if (json instanceof JObj) {
            List<String> parts = new ArrayList<>();
            for (Map.Entry<String, JSON> entry : ((JObj) json).bindings.entrySet()) {
                parts.add("\"" + entry.getKey() + "\": " + show(entry.getValue()));
            }
            return "{" + String.join(", ", parts) + "}";
        }
        return "";
    }
}
