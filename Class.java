import java.util.ArrayList;

public class Class {
    int hitDie;
    int level;
    int proficiencyBonus;
    int cantripsKnown;
    int spellsKnown;
    int firstLevelSpellSlots;
    int secondLevelSpellSlots;
    int thirdLevelSpellSlots;
    int fourthLevelSpellSlots;
    int fifthLevelSpellSlots;
    int sixthLevelSpellSlots;
    int seventhLevelSpellSlots;
    int eighthLevelSpellSlots;
    int ninthLevelSpellSlots;

    String className;

    ArrayList<String> classFeatures = new ArrayList();
    ArrayList<String> armorProficiencies = new ArrayList();
    ArrayList<String> weaponProficiencies = new ArrayList();
    ArrayList<String> toolProficiencies = new ArrayList();
    ArrayList<String> skills = new ArrayList();
    ArrayList<String> startingEquipment = new ArrayList();
    ArrayList<String> savingThrows = new ArrayList<>();

    public Class(){

    }
    public Class(int level, String Class){

        this.level = level;
        this.className = Class;
    }

    public void displayClassData(){}

    public ArrayList<String> getClassFeatures(){return this.classFeatures;}

    public ArrayList<String> getArmorProficiencies(){return this.armorProficiencies;}

    public ArrayList<String> getWeaponProficiencies(){return this.weaponProficiencies;}

    public ArrayList<String> getToolProficiencies(){return this.toolProficiencies;}

    public ArrayList<String> getSkills(){return this.skills;}

    public ArrayList<String> getStartingEquipment(){return this.startingEquipment;}

    public int getHitDie(){return this.hitDie;}

    public int getLevel(){return this.level;}

    public int getproficiencyBonus(){return this.proficiencyBonus;}

    public int getcantripsKnown(){return this.cantripsKnown;}

    public int getspellsKnown(){return this.spellsKnown;}

    public int getfirstLevelSpellSlots(){return this.firstLevelSpellSlots;}

    public int getsecondLevelSpellSlots(){return this.secondLevelSpellSlots;}

    public int getthirdLevelSpellSlots(){return this.thirdLevelSpellSlots;}

    public int getfourthLevelSpellSlots(){return this.fourthLevelSpellSlots;}

    public int getfifthLevelSpellSlots(){return this.fifthLevelSpellSlots;}

    public int getsixthLevelSpellSlots(){return this.sixthLevelSpellSlots;}

    public int getseventhLevelSpellSlots(){return this.seventhLevelSpellSlots;}

    public int geteighthLevelSpellSlots(){return this.eighthLevelSpellSlots;}

    public int getninthLevelSpellSlots(){return this.ninthLevelSpellSlots;}

}
