import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Attributes {

    String race;
    JSONObject attributes = new JSONObject();//need to store as JSONObject so that it can be saved and used later

    public Attributes (String race){

        int[] scores = new int[5];
        int[] modifiers = new int[5];

        this.race = race;
    }

    public void getRaceAtt(){//did return int[]

        JSONParser jsonParser = new JSONParser();
        File file = new File("C:\\Users\\aaron\\IdeaProjects\\5e Character Generator\\src\\5e-SRD-Races.json");
        try (FileReader reader = new FileReader(file)) {//collect json data for race

            Object obj = jsonParser.parse(reader);//parse data read
            JSONArray races = (JSONArray) obj;//create array of data read
            System.out.println(races);//print data read


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int[] raceMods = new int[5];
        for(int i=0; i<raceMods.length; i++){//set default values to zero
            raceMods[i] = 0;
        }



        //return raceMods;
    }
}
