import java.util.Random;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) {

        System.out.println("Generating \n............\n............\n");

            Character character = new Character("Barbarian", 5);
/*
        String randomLevel = ""; //Y or N
        String randomClass = ""; //Y or N

        String characterClass = "random class";
        int level = 1; //if they want a certain level

        Scanner in = new Scanner(System.in);

        boolean check = true;
        while(check) {
            System.out.println("Do you want to choose your character level? (Y/N)\n(note: default is level 1)\n");
            randomLevel = in.nextLine();

            switch (randomLevel) {
                case "Y":
                case "y":
                    check = false;
                    break;
                case "N":
                case "n":
                    check = false;
                    break;
                default:
                    System.out.println("\nIncorrect input\n");
            }
        }

        check = true;
        while(check) {
            System.out.println("\nDo you to choose your Class? (Y/N)");
            randomClass = in.nextLine();
            switch (randomLevel) {
                case "Y":
                case "y":
                    check = false;
                    break;
                case "N":
                case "n":
                    check = false;
                    break;
                default:
                    System.out.println("\nIncorrect input\n");
            }
        }
        check = true;
        if(randomLevel.equals("y") || randomLevel.equals("Y")){
            try{
                while(check){
                System.out.println("\nPlease enter a level between 1 and 20\n");
                level = in.nextInt();
                if(level >= 1 && level <= 20){check = false;}
                else{System.out.println("Invalid level\n");}
                }
            }catch(Exception e){System.out.println("invalid input, please type a number between 1 and 20\n...\nexiting program");}
        }
        int choice = 0;
        if(randomClass.equals("y") || randomClass.equals("Y")){
            System.out.println("Please choose a class: \n");
            System.out.println("1: Barbarian \n2: Bard \n3: Cleric \n4: Druid \n5: Fighter \n6: Monk \n7: Paladin \n8: Ranger \n9: Rogue \n10: Sorcerer \n11: Warlock \n12: Wizard\n");
            try {
                choice = in.nextInt();
            }catch(Exception e){System.out.println("Invalid input...please choose a number\nclosing program"); System.exit(0);}

            switch(choice){
                case 1: characterClass = "Barbarian"; break;
                case 2: characterClass = "Bard"; break;
                case 3: characterClass = "Cleric"; break;
                case 4: characterClass = "Druid"; break;
                case 5: characterClass = "Fighter"; break;
                case 6: characterClass = "Monk"; break;
                case 7: characterClass = "Paladin"; break;
                case 8: characterClass = "Ranger"; break;
                case 9: characterClass = "Rogue"; break;
                case 10: characterClass = "Sorcerer"; break;
                case 11: characterClass = "Warlock"; break;
                case 12: characterClass = "Wizard"; break;
                default: System.out.println("Error with choice of class");
            }
        }

        System.out.println("Generating a level " + level + " " + characterClass + "\n............\n............\n");

        Character character = new Character(characterClass, level);
        character.displayCharacter();
        System.out.println("\n\n");*/
    }
}

