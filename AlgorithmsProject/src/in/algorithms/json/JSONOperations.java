package in.algorithms.json;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JSONOperations {
    public static String show(JSON json) {
        if (json instanceof JSeq) {
            JSeq seq = (JSeq) json;
            return "[" + seq.elems.stream().map(JSONOperations::show).collect(Collectors.joining(", ")) + "]";
        } else if (json instanceof JObj) {
            JObj obj = (JObj) json;
            return "{" + obj.bindings.entrySet().stream()
                    .map(e -> "\"" + e.getKey() + "\": " + show(e.getValue()))
                    .collect(Collectors.joining(", ")) + "}";
        } else if (json instanceof JStr) {
            return "\"" + ((JStr) json).str + "\"";
        } else if (json instanceof JNum) {
            return String.valueOf(((JNum) json).num);
        } else if (json instanceof JBool) {
            return String.valueOf(((JBool) json).b);
        } else if (json instanceof JNull) {
            return "null";
        }
        return "";
    }

    public static void main(String[] args) {
        JSeq jsonArray = new JSeq(Arrays.asList(new JStr("Java"), new JNum(42.0)));
        System.out.println("Rendered JSON: " + show(jsonArray));
    }
}
