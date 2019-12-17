package locales;

import java.util.HashMap;
import java.util.Map;

public class Messages {
    private static Map<String, String> languages = new HashMap<String, String>() {{
        put("invalid", "Invalidný vstup.");
        put("car_delete", "Prosím zadajte názov auta ktoré chcete vymazať.");
        put("car_buy", "Prosím zadajte názov auta ktoré chcete kúpiť.");
        put("car_edit", "Prosím zadajte názov auta ktoré chcete upravovať.");
        put("car_404", "Vozidlo nebolo nájdene v zozname.");
    }};

    public static Map<String, String> getLanguages() {
        return languages;
    }
}
