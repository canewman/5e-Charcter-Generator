import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Barbarian extends Class{

    String ragesPerDay;
    int rageDamage;
    String pathChoice;
    String totemChoice;
    ArrayList<String> pathFeats = new ArrayList<>();

    Random rn = new Random();

    public Barbarian(){

        setClassData();
    }
    public Barbarian(int enteredLevel, String enteredName){
        level = enteredLevel;
        className = enteredName;

        setClassData();
    }

    public void setClassData(){

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\barbarianClass.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        String splitBy = ",";

        int count = 0;

        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] currentLine = line.split(splitBy);

            if(count <= 19){//level 1-20
                if(count +1 == Integer.parseInt(currentLine[1])){
                    proficiencyBonus = Integer.parseInt(currentLine[3]);
                    for(int i = 0; i < currentLine.length; i++){
                        if(i == currentLine.length - 4){//rages per day
                            ragesPerDay = currentLine[i + 1];
                        } else if(i == currentLine.length - 3){

                        } else if(i == currentLine.length - 2){//rage damage
                            rageDamage = Integer.parseInt(currentLine[i + 1]);
                        } else if(i == currentLine.length - 1){

                        } else if(i > 4){
                            classFeatures.add(currentLine[i]);
                        }
                    }
                }
            }
            else{
                switch(count) {
                    case 20://hit die
                        hitDie = Integer.parseInt(currentLine[1]);
                        break;
                    case 22://armor proficiencies
                        for (int i = 0; i < currentLine.length; i++) {
                            if (i > 0) {
                                armorProficiencies.add(currentLine[i]);
                            }
                        }
                        break;
                    case 23://weapon proficiencies
                        for (int i = 0; i < currentLine.length; i++) {
                            if (i > 0) {
                                weaponProficiencies.add(currentLine[i]);
                            }
                        }
                        break;
                    case 24://tool proficiencies
                        for (int i = 0; i < currentLine.length; i++) {
                            if (i > 0) {
                                toolProficiencies.add(currentLine[i]);
                            }
                        }
                        break;
                    case 25://saving throws
                        for (int i = 0; i < currentLine.length; i++) {
                            if (i > 0) {
                                savingThrows.add(currentLine[i]);
                            }
                        }
                        break;
                    case 26://class skills
                        boolean check = true;
                        ArrayList<String> tempSkills = new ArrayList<>();
                        String previousSkillChosen = "";

                        while (check) {
                            int choose = Integer.parseInt(currentLine[1]);
                            int random = rn.nextInt(6) + 2;


                            if(!currentLine[random].equals(previousSkillChosen)){
                                    tempSkills.add(currentLine[random]);
                                    previousSkillChosen = currentLine[random];
                            }
                            if(choose == tempSkills.size()){check = false;}
                        }
                        skills.addAll(tempSkills);
                        break;
                    case 27:

                        int coinFlip = rn.nextInt(2);//great axe or martial weapon
                        BufferedReader martialWeaponReader = null;
                        if(coinFlip == 1){
                            startingEquipment.add("Greataxe: 30 gp - 1d12 slashing - 7 lb - Heavy / Two Handed");
                        }
                        else {
                            ArrayList<String> martialWeapons = new ArrayList<>();
                            try {
                             martialWeaponReader = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\martialMeleeWeapons.csv"));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            String martialWeaponLine = "";

                            while (true) {
                                try {
                                    if (!((martialWeaponLine = martialWeaponReader.readLine()) != null)) break;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                String[] martialWeaponCurrentLine = martialWeaponLine.split(splitBy);
                                martialWeapons.add(martialWeaponCurrentLine[0] + ": " + martialWeaponCurrentLine[1]);
                            }
                            int randomMartialWeapon = rn.nextInt(martialWeapons.size());
                            startingEquipment.add(martialWeapons.get(randomMartialWeapon));
                        }

                        coinFlip = rn.nextInt(2);//Two Handaxes or Simple weapon
                        if(coinFlip == 1){
                            startingEquipment.add("Handaxe: 5 gp - 1d6 slashing - 2 lb - Light / Thrown (range 20 to 60)");
                            startingEquipment.add("Handaxe: 5 gp - 1d6 slashing - 2 lb - Light / Thrown (range 20 to 60)");
                        }
                        else {
                            BufferedReader simpleMeleeReader = null;
                            BufferedReader simpleRangedReader = null;

                            ArrayList<String> simpleWeapons = new ArrayList<>();

                            try {
                                simpleMeleeReader = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\simpleMeleeWeapons.csv"));
                                simpleRangedReader = new BufferedReader(new FileReader("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\csv files\\simpleRangedWeapons.csv"));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            String weaponLine = "";

                            while (true) {
                                try {
                                    if (!((weaponLine = simpleMeleeReader.readLine()) != null)) break;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                String[] martialWeaponCurrentLine = weaponLine.split(splitBy);
                                simpleWeapons.add(martialWeaponCurrentLine[0] + ": " + martialWeaponCurrentLine[1]);
                            }
                            while (true) {
                                try {
                                    if (!((weaponLine = simpleRangedReader.readLine()) != null)) break;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                String[] martialWeaponCurrentLine = weaponLine.split(splitBy);
                                simpleWeapons.add(martialWeaponCurrentLine[0] + ": " + martialWeaponCurrentLine[1]);
                            }
                            int randomSimpleWeapon = rn.nextInt(simpleWeapons.size());
                            startingEquipment.add(simpleWeapons.get(randomSimpleWeapon));

                        }
                        startingEquipment.add("Explorer's Pack");
                        startingEquipment.add("four Javelins");
                        break;//equipment

                    case 28:
                        if(level >= 3) {
                            coinFlip = rn.nextInt(2);
                            if (coinFlip == 1) {
                                pathChoice = "Berserker";
                            } else {
                                pathChoice = "Totem";
                            }
                        }
                        break;//path choice
                    case 30:
                        if(level >= 3) {
                            if (pathChoice.equals("Berserker")) {
                                if (level >= 14) {
                                    for (int i = 0; i < currentLine.length; i++) {
                                        if (i % 2 == 1) {
                                            pathFeats.add(currentLine[i]);
                                        }
                                    }
                                } else if (level >= 10) {
                                    for (int i = 0; i < currentLine.length; i++) {
                                        if (currentLine[i].equals("14")) {
                                            break;
                                        } else if (i % 2 == 1) {
                                            pathFeats.add(currentLine[i]);
                                        }
                                    }
                                } else if (level >= 6) {
                                    for (int i = 0; i < currentLine.length; i++) {
                                        if (currentLine[i].equals("10")) {
                                            break;
                                        } else if (i % 2 == 1) {
                                            pathFeats.add(currentLine[i]);
                                        }
                                    }
                                } else if (level >= 3) {
                                    for (int i = 0; i < currentLine.length; i++) {
                                        if (currentLine[i].equals("6")) {
                                            break;
                                        } else if (i % 2 == 1) {
                                            pathFeats.add(currentLine[i]);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 32://totem choice
                        if(level >= 3){
                            if(pathChoice.equals("Totem")){
                                coinFlip = rn.nextInt(3);
                                switch(coinFlip){
                                    case 1: totemChoice = "Bear"; break;
                                    case 2: totemChoice = "Eagle"; break;
                                    default: totemChoice = "Wolf"; break;
                                }
                            }
                        }
                        break;
                    case 33:
                        if(level >= 3) {
                            if (pathChoice.equals("Totem")) {
                                if (level >= 14) {
                                    for (int i = 0; i < currentLine.length; i++) {
                                        if (i % 2 == 1) {
                                            if(i > 1){
                                                pathFeats.add(currentLine[i] + " (" + totemChoice + ") benefits");
                                            }
                                            else {
                                                pathFeats.add(currentLine[i]);
                                            }                                        }
                                    }
                                } else if (level >= 10) {
                                    for (int i = 0; i < currentLine.length; i++) {
                                        if (currentLine[i].equals("14")) {
                                            break;
                                        } else if (i % 2 == 1) {
                                            if(i > 1){
                                                pathFeats.add(currentLine[i] + " (" + totemChoice + ") benefits");
                                            }
                                            else {
                                                pathFeats.add(currentLine[i]);
                                            }
                                        }
                                    }
                                } else if (level >= 6) {
                                    for (int i = 0; i < currentLine.length; i++) {
                                        if (currentLine[i].equals("10")) {
                                            break;
                                        } else if (i % 2 == 1) {
                                            if(i > 1){
                                                pathFeats.add(currentLine[i] + " (" + totemChoice + ") benefits");
                                            }
                                            else {
                                                pathFeats.add(currentLine[i]);
                                            }
                                        }
                                    }
                                } else if (level >= 3) {
                                    for (int i = 0; i < currentLine.length; i++) {
                                        if (currentLine[i].equals("6")) {
                                            break;
                                        } else if (i % 2 == 1) {
                                            if(i > 1){
                                                pathFeats.add(currentLine[i] + " (" + totemChoice + ") benefits");
                                            }
                                            else {
                                                pathFeats.add(currentLine[i]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;//Totem feats
                }

            }
            count++;
        }
    }

    public void displayClassData(){
        System.out.println("Rages per day: " + ragesPerDay + "          Rage Damage: " + rageDamage);
        System.out.println("Path choice: " + pathChoice);
        if(pathChoice.equals("Totem")){
            System.out.println("Totem animal choice: " + totemChoice);
        }
        System.out.print("Path Feats: ");
        for(int i = 0; i < pathFeats.size(); i++){
            System.out.print(pathFeats.get(i) + ", ");
        }
        System.out.println("");
        System.out.println("------------------------------------------End Class Data------------------------------------------");

    }
}
