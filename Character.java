import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Character {
    Random random = new Random();

    int HP = 0;
    int gold = 0;
    int PB = 0;
    int AC = 0;
    int age = 0;//pulled from race class
    int height = 0;
    int level = 1;
    int charisma = 0;
    int intelligence = 0;
    int strength = 0;
    int wisdom = 0;
    int dexterity = 0;
    int constitution = 0;

    String[] ageRange = {};
    String[] abilityBonuses = {};
    String[] normalAlignment = {};
    String[] startingProficienciesOptions = {};
    String[] traits = {};
    String[] languageOptions = {};

    String alignment;//pulled from race class
    String className;
    String name = "";
    String sex = "";
    String size;
    String raceName;
    String speed;


    ArrayList items = new ArrayList();
    ArrayList equipment = new ArrayList();

    StringBuilder weapons = new StringBuilder();
    StringBuilder clothing = new StringBuilder();

    Barbarian barb;

    ArrayList<String> languages = new ArrayList<>();
    ArrayList<String> startingProficiencies = new ArrayList<>();
    ArrayList classFeats = new ArrayList();//will be changed to be made a class
    ArrayList attributes = new ArrayList();//will be changed to be made a class
    ArrayList skills = new ArrayList();//will be changed to be made a class
    ArrayList spells = new ArrayList();//will be changed to be made a class
    ArrayList feats = new ArrayList();//will be changed to be made a class
    ArrayList proficiencies = new ArrayList();//pulled from race class

    StringBuilder background = new StringBuilder();//will be changed to be made a class
    StringBuilder deity = new StringBuilder();//will be changed to be made a class
    StringBuilder race = new StringBuilder();//will be changed to be made a class
    StringBuilder cClass = new StringBuilder();//will be changed to be made a class

    public Character (){

        createCharacter();
    }

    public Character(String characterClass, int level){

        this.level = level;
        this.className = characterClass;
        createCharacter();
        displayCharacter();
    }

    public void createCharacter(){
        setRaceData();
        setClass();

        switch(this.className){
            case "Barbarian":
                barb = new Barbarian(this.level, this.className);
                break;
            case "Bard":
                break;
        }
        setStats();
    }

    public void setClass(){

        if(this.className.equals("random class")) {
            int rn = random.nextInt(12);
            switch (rn) {
                case 0:
                    this.className = "Barbarian";
                    break;
                case 1:
                    this.className = "Bard";
                    break;
                case 2:
                    this.className = "Sorcerer";
                    break;
                case 3:
                    this.className = "Warlock";
                    break;
                case 4:
                    this.className = "Cleric";
                    break;
                case 5:
                    this.className = "Druid";
                    break;
                case 6:
                    this.className = "Fighter";
                    break;
                case 7:
                    this.className = "Ranger";
                    break;
                case 8:
                    this.className = "Monk";
                    break;
                case 9:
                    this.className = "Paladin";
                    break;
                case 10:
                    this.className = "Rogue";
                    break;
                case 11:
                    this.className = "Wizard";
                    break;

            }
        }
    }

    public void setRaceData(){
        Race race = new Race();//creates race data

        this.raceName = race.getRaceName();
        this.speed = race.getSpeed();
        this.ageRange = race.getAgeRange();
        this.abilityBonuses = race.getAbilityBonuses();
        this.normalAlignment = race.getNormalAlignment();
        this.size = race.getSize();

        this.startingProficiencies = race.getStartingProficiencies();
        this.startingProficiencies = stripNoneFromList(this.startingProficiencies);

        this.startingProficienciesOptions = race.getStartingProficienciesOptions();

        this.languages = race.getLanguages();
        this.languages = stripNoneFromList(this.languages);

        this.languageOptions = race.getLanguageOptions();
        this.traits = race.getTraits();
        this.languageOptions = race.getLanguageOptions();
    }

    public void setStats(){//needs HP and AC added later
        ArrayList<Integer> abilityScores = rollAbilityScores();//it's sorted from lowest to highest
        setStatsByClass(abilityScores, this.className);

        switch (this.className) {
            case "Barbarian":
                if(this.level == 1){//HP
                    HP = barb.getHitDie() + this.constitution;
                } else{
                    HP = barb.getHitDie() + (this.constitution - 10)/2;
                    int randomRoll = 0;
                    for(int i = 0; i < this.level; i++){
                        randomRoll = random.nextInt(12) + 1;
                        HP += (randomRoll + ((this.constitution - 10)/2));
                    }
                }
                PB = barb.getproficiencyBonus();
                if(equipment.size() == 0){
                    AC = 10 + ((this.dexterity - 10)/2) + ((this.constitution - 10)/2);
                }

//fighter and rogue don't follow the 4/8/12/16/19
                break;
            case "Bard":
                break;
            case "Sorcerer":
                break;
            case "Warlock":
                break;
            case "Cleric":
                break;
            case "Druid":
                break;
            case "Fighter":
                break;
            case "Ranger":
                break;
            case "Monk":
                break;
            case "Paladin":
                break;
            case "Rogue":
                break;
            case "Wizard":
                break;

        }
    }

    public void setStatsByClass(ArrayList<Integer> scores, String cn){
        int rn;

        switch(cn){//rolling base stats before leveling up
            case "Barbarian":
                this.strength = scores.get(5);
                this.constitution = scores.get(4);
                scores.set(5, 0);
                scores.set(4, 0);

                while(scores.get(0) != 0 || scores.get(1) != 0 || scores.get(2) != 0 || scores.get(3) != 0){

                    rn = random.nextInt(4);
                    if(scores.get(rn) != 0) {
                        if(this.intelligence == 0) {
                            this.intelligence = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.charisma ==0){
                            this.charisma = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.wisdom ==0){
                            this.wisdom = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.dexterity ==0){
                            this.dexterity = scores.get(rn);
                            scores.set(rn, 0);
                        }
                    }
                }

                break;
            case "Bard":
            case "Sorcerer":
            case "Warlock":
                this.charisma = scores.get(5);
                scores.set(5, 0);

                while(scores.get(0) != 0 || scores.get(1) != 0 || scores.get(2) != 0 || scores.get(3) != 0 || scores.get(4) != 0){

                    rn = random.nextInt(5);
                    if(scores.get(rn) != 0) {
                        if(this.intelligence == 0) {
                            this.intelligence = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.strength ==0){
                            this.strength = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.wisdom ==0){
                            this.wisdom = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.dexterity ==0){
                            this.dexterity = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.constitution == 0){
                            this.constitution = scores.get(rn);
                            scores.set(rn, 0);
                        }
                    }
                }
                break;
            case "Cleric"://both classes have same primary abilities
            case "Druid":
                this.wisdom = scores.get(5);
                scores.set(5, 0);

                while(scores.get(0) != 0 || scores.get(1) != 0 || scores.get(2) != 0 || scores.get(3) != 0 || scores.get(4) != 0){

                    rn = random.nextInt(5);
                    if(scores.get(rn) != 0) {
                        if(this.intelligence == 0) {
                            this.intelligence = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.strength ==0){
                            this.strength = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.charisma ==0){
                            this.charisma = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.dexterity ==0){
                            this.dexterity = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.constitution == 0){
                            this.constitution = scores.get(rn);
                            scores.set(rn, 0);
                        }
                    }
                }
                break;

            case "Fighter":
                rn = random.nextInt(2);
                switch(rn){//choosing main stat as either Strength or Dexterity
                    case 0:
                        this.strength = scores.get(5);
                        this.dexterity = scores.get(4);
                        break;
                    case 1:
                        this.dexterity = scores.get(5);
                        this.strength = scores.get(4);
                        break;
                }
                scores.set(5, 0);
                scores.set(4,0);

                while(scores.get(0) != 0 || scores.get(1) != 0 || scores.get(2) != 0 || scores.get(3) != 0){

                    rn = random.nextInt(5);
                    if(scores.get(rn) != 0) {
                        if(this.intelligence == 0) {
                            this.intelligence = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.charisma ==0){
                            this.charisma = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.wisdom ==0){
                            this.wisdom = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.constitution == 0){
                            this.constitution = scores.get(rn);
                            scores.set(rn, 0);
                        }
                    }
                }
                break;
            case "Ranger"://both classes have same primary abilities
            case "Monk":
                rn = random.nextInt(2);
                switch(rn){//choosing main stat as either Strength or Dexterity
                    case 0:
                        this.wisdom = scores.get(5);
                        this.dexterity = scores.get(4);
                        break;
                    case 1:
                        this.dexterity = scores.get(5);
                        this.wisdom = scores.get(4);
                        break;
                }
                scores.set(5, 0);
                scores.set(4,0);

                while(scores.get(0) != 0 || scores.get(1) != 0 || scores.get(2) != 0 || scores.get(3) != 0){

                    rn = random.nextInt(5);
                    if(scores.get(rn) != 0) {
                        if(this.intelligence == 0) {
                            this.intelligence = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.charisma ==0){
                            this.charisma = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.strength ==0){
                            this.strength = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.constitution == 0){
                            this.constitution = scores.get(rn);
                            scores.set(rn, 0);
                        }
                    }
                }
                break;
            case "Paladin":
                rn = random.nextInt(2);
                switch(rn){//choosing main stat as either Strength or Dexterity
                    case 0:
                        this.strength = scores.get(5);
                        this.charisma = scores.get(4);
                        break;
                    case 1:
                        this.charisma = scores.get(5);
                        this.strength = scores.get(4);
                        break;
                }
                scores.set(5, 0);
                scores.set(4,0);

                while(scores.get(0) != 0 || scores.get(1) != 0 || scores.get(2) != 0 || scores.get(3) != 0){

                    rn = random.nextInt(5);
                    if(scores.get(rn) != 0) {
                        if(this.intelligence == 0) {
                            this.intelligence = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.wisdom ==0){
                            this.wisdom = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.dexterity ==0){
                            this.dexterity = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.constitution == 0){
                            this.constitution = scores.get(rn);
                            scores.set(rn, 0);
                        }
                    }
                }
                break;
            case "Rogue":
                this.dexterity = scores.get(5);
                scores.set(5, 0);

                while(scores.get(0) != 0 || scores.get(1) != 0 || scores.get(2) != 0 || scores.get(3) != 0 || scores.get(4) != 0){

                    rn = random.nextInt(5);
                    if(scores.get(rn) != 0) {
                        if(this.intelligence == 0) {
                            this.intelligence = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.strength ==0){
                            this.strength = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.charisma ==0){
                            this.charisma = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.wisdom ==0){
                            this.wisdom = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.constitution == 0){
                            this.constitution = scores.get(rn);
                            scores.set(rn, 0);
                        }
                    }
                }
                break;

            case "Wizard":
                this.intelligence = scores.get(5);
                scores.set(5, 0);

                while(scores.get(0) != 0 || scores.get(1) != 0 || scores.get(2) != 0 || scores.get(3) != 0 || scores.get(4) != 0){

                    rn = random.nextInt(5);
                    if(scores.get(rn) != 0) {
                        if(this.wisdom == 0) {
                            this.wisdom = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.strength ==0){
                            this.strength = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.charisma ==0){
                            this.charisma = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.dexterity ==0){
                            this.dexterity = scores.get(rn);
                            scores.set(rn, 0);
                        }
                        else if(this.constitution == 0){
                            this.constitution = scores.get(rn);
                            scores.set(rn, 0);
                        }
                    }
                }
                break;

            default: System.out.println("Incorrect Race Name entered while setting stats by class"); break;


        }
        if(this.className.equals("Fighter")){//adding stats for the ability score improvements they get for leveling up
            if(this.level >= 19) {
                levelUpStats(7);
            } else if(this.level >= 16){
                levelUpStats(6);
            } else if(this.level >= 14){
                levelUpStats(5);
            } else if(this.level >= 12){
                levelUpStats(4);
            } else if(this.level >= 8){
                levelUpStats(3);
            } else if(this.level >= 6){
                levelUpStats(2);
            }else if(this.level >= 4){
                levelUpStats(1);
            }
        }else if(this.className.equals("Rogue")){
            if(this.level >= 19) {
                levelUpStats(6);
            } else if(this.level >= 16){
                levelUpStats(5);
            } else if(this.level >= 12){
                levelUpStats(4);
            } else if(this.level >= 10){
                levelUpStats(3);
            } else if(this.level >= 8){
                levelUpStats(2);
            } else if(this.level >= 4){
                levelUpStats(1);
            }
        }else{
            if(this.level >= 19) {
                levelUpStats(5);
            } else if(this.level >= 16){
                levelUpStats(4);
            } else if(this.level >= 12){
                levelUpStats(3);
            } else if(this.level >= 8){
                levelUpStats(2);
            } else if(this.level >= 4){
                levelUpStats(1);
            }
        }
        addModifiersToStats();
    }

    public void levelUpStats(int howManyIncreases){
        int rollToPickAStatToIncrease;

        for (int i = 0; i < howManyIncreases; i++){
            rollToPickAStatToIncrease = random.nextInt(6);
            switch (rollToPickAStatToIncrease) {
                case 0:
                    if(this.strength == 20){i--; break;}
                    this.strength += 2;
                    break;
                case 1:
                    if(this.wisdom == 20){i--; break;}
                    this.wisdom += 2;
                    break;
                case 2:
                    if(this.charisma == 20){i--; break;}
                    this.charisma += 2;
                    break;
                case 3:
                    if(this.dexterity == 20){i--; break;}
                    this.dexterity += 2;
                    break;
                case 4:
                    if(this.constitution == 20){i--; break;}
                    this.constitution += 2;
                    break;
                case 5:
                    if(this.intelligence == 20){i--; break;}
                    this.intelligence += 2;
                    break;
                default:
                    System.out.println("Out of bounds error while rolling to pick a stat to increase when adding ability score improvements for level");
            }
        }
    }

    public void addModifiersToStats(){
        for(int i = 0; i < abilityBonuses.length/2; i++){
            switch(abilityBonuses[i]){
                case "STR": this.strength = this.strength+Integer.parseInt(abilityBonuses[i+1]); break;
                case "DEX": this.dexterity = this.dexterity+Integer.parseInt(abilityBonuses[i+1]); break;
                case "CON": this.constitution = this.constitution+Integer.parseInt(abilityBonuses[i+1]); break;
                case "INT": this.intelligence = this.intelligence+Integer.parseInt(abilityBonuses[i+1]); break;
                case "WIS": this.wisdom = this.wisdom+Integer.parseInt(abilityBonuses[i+1]); break;
                case "CHA": this.charisma = this.charisma+Integer.parseInt(abilityBonuses[i+1]); break;
                case "STR/DEX/CON/INT/WIS":
                    switch(random.nextInt(5)){
                        case 0: this.strength = this.strength+Integer.parseInt(abilityBonuses[i+1]); break;
                        case 1: this.dexterity = this.dexterity+Integer.parseInt(abilityBonuses[i+1]); break;
                        case 2: this.constitution = this.constitution+Integer.parseInt(abilityBonuses[i+1]); break;
                        case 3: this.intelligence = this.intelligence+Integer.parseInt(abilityBonuses[i+1]); break;
                        case 4: this.wisdom = this.wisdom+Integer.parseInt(abilityBonuses[i+1]); break;
                    }
                    break;
            }
        }
    }

    public ArrayList<Integer> rollAbilityScores(){

        ArrayList<Integer> abilityScores = new ArrayList<Integer>();

        for(int i = 0; i < 6; i++){
            ArrayList<Integer> values = new ArrayList<>();

            for(int k = 0; k < 4; k++){
                values.add(random.nextInt(6)+1);
            }
            Collections.sort(values);
            values.remove(0);

            int sum = 0;
            for(int value : values){sum+=value;}

            abilityScores.add(sum);
        }
        Collections.sort(abilityScores);

        return abilityScores;
    }

    public void displayCharacter(){
        System.out.println("Race Name: " + raceName);
        System.out.println("Class Name: " + className);
        System.out.println("Level: " + level);
        System.out.println("\nHP: " + HP);
        System.out.println("PB: " + PB);
        System.out.println("AC: " + AC);
        System.out.println("Base speed: " + speed);
        System.out.println("\nStrength: " + strength);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Charisma: " + charisma);
        System.out.println("Constitution: " + constitution);
        System.out.println("Wisdom: " + wisdom);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("\nNormal Alignment: " + Arrays.toString(normalAlignment));
        System.out.println("Age Range: " + Arrays.toString(ageRange));
        System.out.println("Size: " + size);
        System.out.println("\nStarting Proficiencies: " + startingProficiencies.toString());
        System.out.println("Languages: " + languages.toString());
        System.out.println("Traits: " + Arrays.toString(traits));

        System.out.println("\n--------------------------------------------Class Data--------------------------------------------\n");

        switch(this.className){
            case "Barbarian":
                barb.displayClassData();
                break;
            case "Bard":
                break;
        }
    }

    public ArrayList<String> stripNoneFromList(ArrayList<String> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("none")){
                list.remove(i);
            }
        }
        return list;
    }

    public String getRaceName(){return this.raceName;}
    public void setRaceName(String race){this.raceName = race;};


    public String getSpeed(){return this.speed;}
    public void setSpeed(String speed){this.speed = speed;}

    public String getClassName(){return this.className;}
    public void setClassName(String name){this.className = name;}

    public String[] getAgeRange(){return this.ageRange;}

    public String[] getAbilityBonuses(){return this.abilityBonuses;}

    public String[] getNormalAlignment(){return this.normalAlignment;}

    public String getSize(){return this.size;}

    public ArrayList<String> getStartingProficiencies(){return this.startingProficiencies;}

    public String[] getStartingProficienciesOptions(){return this.startingProficienciesOptions;}

    public ArrayList<String> getLanguages(){return this.languages;}

    public String[] getTraits(){return this.traits;}

    public String[] getLanguageOptions(){return this.languageOptions;}

    public int getStrength(){return this.strength;}

    public int getDexterity(){return this.dexterity;}

    public int getIntelligence(){return this.intelligence;}

    public int getCharisma(){return this.charisma;}

    public int getConstitution(){return this.constitution;}

    public int getWisdom(){return this.wisdom;}


}
