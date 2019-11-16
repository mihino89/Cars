package Locales;

public class Messages {
    protected static String[] messagesArray = new String[] {
        "Invalidny vstup",
        "Prosim zadajte nazov auta ktore chcete vymazat"
    };

    public static String getMessages(int id){
        if(id >= messagesArray.length){
            return null;
        }

        return messagesArray[id];
    }
}
