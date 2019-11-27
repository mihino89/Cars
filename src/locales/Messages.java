package locales;

public class Messages {
    private static String[] messagesArray = new String[] {
        "Invalidný vstup.",
        "Prosím zadajte názov auta ktoré chcete vymazať.",
        "Prosím zadajte názov auta ktoré chcete kúpit.",
        "Prosím zadajte názov auta ktoré chcete upravovať.",
        "Vozidlo nebolo nájdene v zozname."
    };

    public static String getMessages(int id){
        if(id >= messagesArray.length){
            return null;
        }

        return messagesArray[id];
    }
}