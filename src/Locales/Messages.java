package Locales;

public class Messages {
    private static String[] messagesArray = new String[] {
        "Invalidny vstup.",
        "Prosim zadajte nazov auta ktore chcete vymazat.",
        "Prosim zadajte nazov auta ktore chcete kupit.",
        "Auto nebolo najdene v zozname."
    };

    public static String getMessages(int id){
        if(id >= messagesArray.length){
            return null;
        }

        return messagesArray[id];
    }
}
