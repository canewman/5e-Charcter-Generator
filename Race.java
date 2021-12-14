import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Race{

    String raceName;

    String speed;
    String[] ageRange = {};
    String[] abilityBonuses = {};
    String[] normalAlignment = {};
    String size;
    String[] startingProficiencies = {};
    String[] startingProficienciesOptions = {};
    String[] languages = {};
    String[] traits = {};
    String[] languageOptions = {};

    public Race (){

        this.raceName = this.rollRaceName();
        setRaceData();

    }

    public String getRaceName(){return this.raceName;}

    public String getSpeed(){return this.speed;}

    public String[] getAgeRange(){return this.ageRange;}

    public String[] getAbilityBonuses(){return this.abilityBonuses;}

    public String[] getNormalAlignment(){return this.normalAlignment;}

    public String getSize(){return this.size;}

    public String[] getStartingProficiencies(){return this.startingProficiencies;}

    public String[] getStartingProficienciesOptions(){return this.startingProficienciesOptions;}

    public String[] getLanguages(){return this.languages;}

    public String[] getTraits(){return this.traits;}

    public String[] getLanguageOptions(){return this.languageOptions;}




    public static String rollRaceName(){

        String race;

        Random random = new Random();

        switch(random.nextInt(9)){

            case 0: race = "Dwarf"; break;
            case 1: race = "Elf"; break;
            case 2: race = "Halfling"; break;
            case 3: race = "Human"; break;
            case 4: race = "Dragonborn"; break;
            case 5: race = "Gnome"; break;
            case 6: race = "Half-Elf"; break;
            case 7: race = "Half-Orc"; break;
            case 8: race = "Tiefling"; break;
            default: race = "error"; System.out.println("Out of bounds error while rolling random race"); break;
        }

        return race;
    }

    public void setRaceData(){

        BufferedReader br = null;
        try {
            switch(this.raceName) {
                case "Dwarf": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\dwarfRace.csv")); break;
                case "Elf": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\elfRace.csv")); break;
                case "Halfling": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\halflingRace.csv")); break;
                case "Human": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\humanRace.csv")); break;
                case "Dragonborn": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\dragonbornRace.csv")); break;
                case "Gnome": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\gnomeRace.csv")); break;
                case "Half-Elf": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\halfelfRace.csv")); break;
                case "Half-Orc": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\halforcRace.csv")); break;
                case "Tiefling": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\tieflingRace.csv")); break;



                default: System.out.println("Invalid race entered");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        String splitBy = ",";

        int count = 0;
        while (true)
        {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] currentLine = line.split(splitBy);

            if(this.raceName.equals("Half-Elf")){
                switch(count){

                    case 0: break;
                    case 1: this.speed = currentLine[0]; break;
                    case 2: this.abilityBonuses = currentLine; break;
                    case 3: this.normalAlignment = currentLine; break;
                    case 4: this.ageRange = currentLine; break;
                    case 5: this.size = currentLine[0]; break;
                    case 6: this.startingProficiencies = currentLine; break;
                    case 7: this.startingProficienciesOptions = currentLine; break;
                    case 8: this.languages = currentLine; break;
                    case 9: this.languageOptions = currentLine; break;
                    case 10: this.traits = currentLine; break;
                    default: System.out.println("Index out of bounds while storing information from file.");
                }
            }
            else if(this.raceName.equals("Human")){
                switch (count) {

                    case 0: break;
                    case 1: this.speed = currentLine[0]; break;
                    case 2: this.abilityBonuses = currentLine; break;
                    case 3: this.normalAlignment = currentLine; break;
                    case 4: this.ageRange = currentLine; break;
                    case 5: this.size = currentLine[0]; break;
                    case 6: this.startingProficiencies = currentLine; break;
                    case 7: this.languageOptions = currentLine; break;
                    case 8: this.languages = currentLine; break;
                    case 9: this.traits = currentLine; break;
                    default: System.out.println("Index out of bounds while storing information from file.");
                }
            }
            else {
                switch (count) {

                    case 0: break;
                    case 1: this.speed = currentLine[0]; break;
                    case 2: this.abilityBonuses = currentLine; break;
                    case 3: this.normalAlignment = currentLine; break;
                    case 4: this.ageRange = currentLine; break;
                    case 5: this.size = currentLine[0]; break;
                    case 6: this.startingProficiencies = currentLine; break;
                    case 7: this.startingProficienciesOptions = currentLine; break;
                    case 8: this.languages = currentLine; break;
                    case 9: this.traits = currentLine; break;
                    default: System.out.println("Index out of bounds while storing information from file.");
                }
            }
            count++;
        }
    }
}
