package car;

public class CarTypes {
    private String[] brand = new String[]{
        "Saab",
        "Ford",
        "Jeep"
    };

    private String[] saab = new String[]{
        "Aero-X",
        "9-5",
        "PhoeniX"
    };

    private String[] ford = new String[]{
        "Fiesta",
        "Focus",
        "C-MAX",
        "Kuga",
        "Mondeo"
    };

    private String[] jeep = new String[]{
        "Cherokee",
        "Wrangler",
        "Compass",
        "Renegade"
    };


    private String[] recognizeCarBrand(String carBrand){
        switch (carBrand){
            case "Ford":
                return ford;
            case "Saab":
                return saab;
            case "Jeep":
                return jeep;
        }
        return null;
    }

    protected void printModelsOfCarBrand(String selectedBrand){
        String[] arr;

        arr = recognizeCarBrand(selectedBrand);

        for(int i = 0; i < arr.length; i++){
            System.out.println(i + ". " + arr[i]);
        }
    }
}
