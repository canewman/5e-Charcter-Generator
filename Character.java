import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Character {


    public Character (){

        int HP = 0;
        int gold = 0;
        int PB = 0;
        int AC = 0;
        int age = 0;//pulled from race class
        int height = 0;
        int size = 0;//pulled from race class
        int level = 1;

        String alignment;//pulled from race class

        String name = "";
        String sex = "";

        ArrayList languages = new ArrayList();

        ArrayList items = new ArrayList();
        ArrayList equipment = new ArrayList();

            StringBuilder weapons = new StringBuilder();
            StringBuilder clothing = new StringBuilder();
            equipment.add(weapons);
            equipment.add(clothing);

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
    }



    /*
    private JSONObject attributes = new JSONObject();

    this.attributes.put("Strength", 10);
    this.attributes.put("Intelligence", 10);
    this.attributes.put("Dexterity", 10);
    this.attributes.put("Charisma", 10);
    this.attributes.put("Constitution", 10);
    this.attributes.put("Wisdom", 10);

    public static JSONObject populateAtt() {

        JSONObject att = new JSONObject();


        return att;
    }



    //attributes=populateAtt();//populate default attributes to 10

     */
}
