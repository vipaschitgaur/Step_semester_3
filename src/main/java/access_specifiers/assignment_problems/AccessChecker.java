package access_specifiers.assignment_problems;
public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier)) {
            return "ALLOWED";
        }
        if ("private".equals(fieldModifier)) {
            return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        }
        if ("default".equals(fieldModifier)) {
            return ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)) ? "ALLOWED" : "DENIED";
        }
        if ("protected".equals(fieldModifier)) {
            if ("SAME_CLASS".equals(accessorContext) || 
                "SAME_PACKAGE".equals(accessorContext) || 
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        int privA = 0, privD = 0;
        int defA = 0, defD = 0;
        int protA = 0, protD = 0;
        int pubA = 0, pubD = 0;

        for (String[] attempt : attempts) {
            if (attempt != null && attempt.length == 2) {
                String mod = attempt[0];
                String res = classifyAccess(mod, attempt[1]);
                boolean allowed = "ALLOWED".equals(res);

                switch (mod) {
                    case "private": if (allowed) privA++; else privD++; break;
                    case "default": if (allowed) defA++; else defD++; break;
                    case "protected": if (allowed) protA++; else protD++; break;
                    case "public": if (allowed) pubA++; else pubD++; break;
                }
            }
        }
        
        return String.format("private: %d allowed / %d denied | default: %d allowed / %d denied | protected: %d allowed / %d denied | public: %d allowed / %d denied",
                privA, privD, defA, defD, protA, protD, pubA, pubD);
    }

    public static String describeContext(String accessorContext) {
        if (accessorContext == null || accessorContext.isEmpty()) {
            return "";
        }
        String[] words = accessorContext.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Testing AccessChecker ---");
        String[][] attempts = {
            {"public", "OTHER_PACKAGE"},
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"default", "SAME_PACKAGE"},
            {"default", "OTHER_PACKAGE"}
        };
        for (String[] attempt : attempts) {
            System.out.println("Access (" + attempt[0] + ", " + attempt[1] + "): " 
                + classifyAccess(attempt[0], attempt[1]));
        }
        System.out.println("Summary: " + summarizeByModifier(attempts));
        System.out.println("Described Context: " + describeContext("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
    }
}
