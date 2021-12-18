import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Race{

    String raceName;
    String speed;
    String size;

    String[] ageRange = {};
    String[] abilityBonuses = {};
    String[] normalAlignment = {};
    String[] startingProficienciesOptions = {};
    String[] traits = {};
    String[] languageOptions = {};

    ArrayList<String> startingProficiencies = new ArrayList<>();
    ArrayList<String> languages = new ArrayList<>();

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

    public ArrayList<String> getStartingProficiencies(){return this.startingProficiencies;}

    public String[] getStartingProficienciesOptions(){return this.startingProficienciesOptions;}

    public ArrayList<String> getLanguages(){return this.languages;}

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
                case "Dwarf": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\dwarfRace.csv")); break;
                case "Elf": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\elfRace.csv")); break;
                case "Halfling": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\halflingRace.csv")); break;
                case "Human": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\humanRace.csv")); break;
                case "Dragonborn": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\dragonbornRace.csv")); break;
                case "Gnome": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\gnomeRace.csv")); break;
                case "Half-Elf": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\halfelfRace.csv")); break;
                case "Half-Orc": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\halforcRace.csv")); break;
                case "Tiefling": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\tieflingRace.csv")); break;



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
                Random random = new Random();
                switch(count){

                    case 0: break;
                    case 1: this.speed = currentLine[0]; break;
                    case 2: this.abilityBonuses = currentLine; break;
                    case 3: this.normalAlignment = currentLine; break;
                    case 4: this.ageRange = currentLine; break;
                    case 5: this.size = currentLine[0]; break;
                    case 6: this.startingProficiencies.addAll(Arrays.asList(currentLine)); break;
                    case 7: this.startingProficienciesOptions = currentLine;
                        String previousChoice = "";
                        for(int i = 0; i < Integer.parseInt(currentLine[0]); i++){
                            int pickAnOption = random.nextInt(currentLine.length - 1) + 1;
                            if(previousChoice.equals(currentLine[pickAnOption])){i--;}
                            else{
                                previousChoice = currentLine[pickAnOption];
                                startingProficiencies.add(currentLine[pickAnOption]);
                            }
                        }
                        break;
                    case 8: this.languages.addAll(Arrays.asList(currentLine)); break;
                    case 9:
                        previousChoice = "";
                        for(int i = 0; i < Integer.parseInt(currentLine[0]); i++){
                            int pickAnOption = random.nextInt(currentLine.length - 1) + 1;
                            if(previousChoice.equals(currentLine[pickAnOption])){i--;}
                            else{
                                previousChoice = currentLine[pickAnOption];
                                languages.add(currentLine[pickAnOption]);
                            }
                        }
                        this.languageOptions = currentLine;
                        break;
                    case 10: this.traits = currentLine; break;
                    default: System.out.println("Index out of bounds while storing information from file.");
                }
            }
            else if(this.raceName.equals("Human")){
                Random random = new Random();
                switch (count) {

                    case 0: break;
                    case 1: this.speed = currentLine[0]; break;
                    case 2: this.abilityBonuses = currentLine; break;
                    case 3: this.normalAlignment = currentLine; break;
                    case 4: this.ageRange = currentLine; break;
                    case 5: this.size = currentLine[0]; break;
                    case 6: this.startingProficiencies.addAll(Arrays.asList(currentLine)); break;
                    case 7:
                        this.languageOptions = currentLine;
                        String previousChoice = "";
                        for(int i = 0; i < Integer.parseInt(currentLine[0]); i++){
                            int pickAnOption = random.nextInt(currentLine.length - 1) + 1;
                            if(previousChoice.equals(currentLine[pickAnOption])){i--;}
                            else{
                                previousChoice = currentLine[pickAnOption];
                                languages.add(currentLine[pickAnOption]);
                            }
                        }
                        break;
                    case 8: this.languages.addAll(Arrays.asList(currentLine)); break;
                    case 9: this.traits = currentLine; break;
                    default: System.out.println("Index out of bounds while storing information from file.");
                }
            }
            else {
                Random random = new Random();

                switch (count) {

                    case 0: break;
                    case 1: this.speed = currentLine[0]; break;
                    case 2: this.abilityBonuses = currentLine; break;
                    case 3: this.normalAlignment = currentLine; break;
                    case 4: this.ageRange = currentLine; break;
                    case 5: this.size = currentLine[0]; break;
                    case 6: this.startingProficiencies.addAll(Arrays.asList(currentLine)); break;
                    case 7:
                        this.startingProficienciesOptions = currentLine;
                        String previousChoice = "";
                        for(int i = 0; i < 1; i++){
                            int pickAnOption = random.nextInt(currentLine.length - 1) + 1;
                            if(previousChoice.equals(currentLine[pickAnOption])){i--;}
                            else{
                                previousChoice = currentLine[pickAnOption];
                                startingProficiencies.add(currentLine[pickAnOption]);
                            }
                        }
                        break;
                    case 8: this.languages.addAll(Arrays.asList(currentLine)); break;
                    case 9: this.traits = currentLine; break;
                    default: System.out.println("Index out of bounds while storing information from file.");
                }
            }
            count++;
        }

        switch(this.raceName) {
            case "Dwarf":

                break;
            case "Elf": break;
            case "Halfling": break;
            case "Human": break;
            case "Dragonborn": break;
            case "Gnome": break;
            case "Half-Elf": break;
            case "Half-Orc": break;
            case "Tiefling": break;
        }
    }
}
