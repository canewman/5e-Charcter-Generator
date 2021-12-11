import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Race extends Character{

    String raceName;

    String speed;
    String[] ageRange;
    String[] abilityBonuses;
    String[] normalAlignment;
    String size;
    String[] startingProficiencies;
    String[] startingProficienciesOptions;
    String[] languages;
    String[] traits;


    public Race (String race){

        this.raceName = race;

    }

    public void setRaceData(){

        BufferedReader br = null;
        try {
            switch(this.raceName) {
                case "Dwarf": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\dwarfRace.csv")); break;
                case "Elf": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\elfRace.csv")); break;
                case "Halfling": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\halflingRace.csv")); break;
                case "Human": br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\humanRace.csv")); break;
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

            switch(count){

                case 0: break;
                case 1: speed = currentLine[0]; break;
                case 2: abilityBonuses = currentLine; break;
                case 3: normalAlignment = currentLine; break;
                case 4: ageRange = currentLine; break;
                case 5: size = currentLine[0]; break;
                case 6: startingProficiencies = currentLine; break;
                case 7: startingProficienciesOptions = currentLine; break;
                case 8: languages = currentLine; break;
                case 9: traits = currentLine; break;
                default: System.out.println("Index out of bounds while storing information from file.");
            }
            count++;
        }

        System.out.println("Race Name: " + this.raceName);
        System.out.println("Base speed: " + speed);
        System.out.println("Ability Bonuses: " + Arrays.toString(abilityBonuses));
        System.out.println("Normal Alignment: " + Arrays.toString(normalAlignment));
        System.out.println("Age Range: " + Arrays.toString(ageRange));
        System.out.println("Size: " + size);
        System.out.println("Starting Proficiencies: " + Arrays.toString(startingProficiencies));
        System.out.println("Starting Proficiencies Options: " + Arrays.toString(startingProficienciesOptions));
        System.out.println("Languages: " + Arrays.toString(languages));
        System.out.println("Traits: " + Arrays.toString(traits));

    }
}
