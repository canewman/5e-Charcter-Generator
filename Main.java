import org.json.*;


public class Main {



    public static void main(String[] args) {
        String jsonString = "..." ;
        System.out.println(jsonString);


        Race race = new Race("Dwarf");
        Race race1 = new Race("Elf");
        Race race2 = new Race("Halfling");
        Race race3 = new Race("Human");

        race.setRaceData();
        System.out.println();
        race1.setRaceData();
        System.out.println();
        race2.setRaceData();
        System.out.println();
        race3.setRaceData();


    }
}

