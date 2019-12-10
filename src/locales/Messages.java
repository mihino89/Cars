package locales;

import java.util.HashMap;
import java.util.Map;

public class Messages {
    private static Map<String, String> languages = new HashMap<String, String>() {{
        put("test", "TOTO JE TEST");
        put("test2", "toto je test 2");
    }};

    public static Map<String, String> getLanguages() {
        return languages;
    }

    private String[] messagesArray = new String[] {
        "Invalidný vstup.",
        "Prosím zadajte názov auta ktoré chcete vymazať.",
        "Prosím zadajte názov auta ktoré chcete kúpit.",
        "Prosím zadajte názov auta ktoré chcete upravovať.",
        "Vozidlo nebolo nájdene v zozname."
    };

    public String test(String id) {
        languages.put("test", "TOTO JE TEST");
        languages.put("Test2", "toto je test 2");

        return languages.get(id);
    }

    public String getMessages(int id){
        if(id >= messagesArray.length){
            return null;
        }

        return messagesArray[id];
    }
}
