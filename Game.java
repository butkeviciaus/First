/*-----How to?-----
Insertig links
What's better: to declare methods in beggining and keep base code separated,
or type code just after method declaration 


Importing pokemon ASCII art
1. Download them as text files
2. Import using method to replace / with // and so on

-----To do------


*/
import java.io.*;
import java.util.*;
import java.util.Random;

public class Game {
    public static void main(String[] args) throws IOException {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      
     

    //---------------------First Part-----------------------------------//
    //+++++++++++++++++++++Getting user's name+++++++++++++++++++++++++++//

      
/*    write(
         "<<<<<QUEST GAME.PART 1>>>>>\n"+
         "Player, tell your name, please: "
      );
      String plrName1 = input.readLine();
      testNameLength(plrName1);
      
    
    //---------------------Second Part-----------------------------------//
    //+++++++++++++++++++++Rolling dice++++++++++++++++++++++++++++++++++//
      write(
         "<<<<<PART 2>>>>>\n"+
         "Time to test your luck and roll the dice\n"+
         "Enter your guess (1,2,3,4,5,6)"
      );
      String diceValueGuess = input.readLine();
      diceGame(diceValueGuess);
      
    //---------------------Third Part-----------------------------------//
    //+++++++++++++++++++++Choosing pokemon+++++++++++++++++++++++++++++//

      write(
           "\n<<<<<PART 3>>>>>\n" +
           "Now it's time to choose your pokemon, who will it be ?\n" + 
           "Press 1 for Ratatta, \n" +
           "press 2 for Charmander, \n"+
           "press 3 for Pikachu."
      );
      String pokemonChoice = input.readLine();
      pokemonGame(pokemonChoice);
     //---------------------Fourth Part-----------------------------------//
    //+++++++++++++++++++++Fighting pokemon+++++++++++++++++++++++++++++++//
    */
      pokemonFight1();
     
   
          //---------------------Fifth Part-----------------------------------//
    //+++++++++++++++++++++Pokemon in the box++++++++++++++++++++++++++++//


      pokemonBox();            
   }            
               
           
    //Method that checks if the name is too short or too long
    public static void testNameLength (String name) throws IOException {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         int x = name.length();
           if (x < 3){
               write(
                  "Your name looks too short, only " + x + " letters. Can you enter your full name?\n"
               );
                String newName = input.readLine();
                write(
                  "Hi " + newName + "\n"
                );
           } 
           else if (x > 9){
               write(
                  "Your name looks too long, freaking " + x + " letters. Can you enter your short name?\n"
               );
               String newName = input.readLine();
               write(
                  "Hi " + newName + "\n"
               );
           } 
           else {
              String shortName = name.substring(0, 2);
              String shortName2 = (shortName + shortName);
              write(
                  "Look.... I don't want to offend you, but  " + name + " sounds boring  \n"+
                  "Can I just call you  " + shortName2 +  "?\n(Y/N):"
              );
              String answer = input.readLine();
                  if (answer.equals("Y") || answer.equals("y") ){
                     write(
                        "Thanks, I'll just call you " + shortName2 + " then.\n"
                     );
                  }
                  else if (answer.equals("N") || answer.equals("n")){
                      write(
                        "Well..ok..." + name.toUpperCase() + "\n"
                      );
                  } 
           }  
         }  
   
   //Method that rolls a dice and player tries to guess the value   
   public static void diceGame (String dice) throws IOException {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         int diceValueGuess = Integer.parseInt(dice);
           if ( diceValueGuess >6 || diceValueGuess <1 ){
               write ("Hey, you had one job! Try again and enter a valid number? (1-6)");
           
           }else{
               Random r = new Random();
               int randomNumber = r.nextInt(5) + 1;
                     if (diceValueGuess != randomNumber){
                           write("No luck, try again next time");

                      } else {
                           write("Greta job, you are totally good in guessing");
                           }
                      }
   }
   
   //Method that let's user choose his pokemon and displays it in ASCII art. Links should be added    
   public static void pokemonGame (String pokemon) throws IOException {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         int pokemonChoice = Integer.parseInt(pokemon);
           if (pokemonChoice == 1){
            write(
               "Here's your Ratatta \n" +
               ""
               //http://www.fiikus.net/asciiart/pokemon/019.txt
            );
         }
      
         else if(pokemonChoice == 2){
            write(
               "Here's your Charmander \n" +
               ""
               //http://www.fiikus.net/asciiart/pokemon/004.txt
            );
         }
         else if(pokemonChoice == 3){
            write(
               "Here's your Pikachu \n" +
               ""
               //http://www.fiikus.net/asciiart/pokemon/025.txt
            );
          }
          else {
            write(
               "What do you mean by " + pokemonChoice + "? Ahhh, let's just get to next step"
            );
          }
   }
   
   
   //Method that starts pokemon fight
   //Both user and computer chose where they want to attact and defend (Head, body or legs)
   //Computers choices are randomized
   //If attack is succesfull defneding player loses 2 lives, if attack is defended nothing happens
   //First player to reach 0 lives looses  
   public static void pokemonFight1 () throws IOException {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      int playersHealth = 10;
      int computersHealth = 10;
        write(
           "\n<<<<<PART 4>>>>>\n" +
           "Battle time! Get ready to fight with other pokomons?\n" + 
           "You gonna have to make 2 decision: where to attack and where to defend.\n" +
           "Press enter to continue \n"
        );
           for (int i = 1; i <= 10; i++) {
                write(
                   "Round: " + i + "\n"
                );
                //Player attacks, computer defends
                String attack = read(
                    "\n Where todo want to attack?  Head (1), Body (2) or Legs (3) \n"
                );
                int attackChoice = Integer.parseInt(attack);

                Random a = new Random();
                int randomDefence = a.nextInt(3)+1;
                //Attack part is better then defence, because it protecs player from entering unvalid number (4-...)
                     if (attackChoice != 1  && attackChoice != 2  && attackChoice != 3){
                           write(
                                "I can only choose between Head (1) body (2) and legs (3). Try next time"
                              );
                     } 
                     else if (attackChoice == randomDefence){
                        write(
                              "No luck, pokemon defended \n"
                        );

                     } 
                     else {
                        computersHealth = computersHealth - 2;
                            write(
                               "Greta job, you damaged your opponent \n"+
                               "His pokemon lost 2 lives, " + computersHealth + " lives left"
                            );
                            if (computersHealth == 0){
                                 write(
                                   "############################\n" + 
                                   "########### YOU WON ########\n" +
                                   "############################"  
                                 );
                                 endGame();
                            }
                     }
                                                   
                      
                //Player defends, computer attacks
                String defend = read(
                  "Where todo want to defend? Head (1), Body (2) or Legs (3) \n"
                );
                
                int defenceChoice = Integer.parseInt(defend);
                Random d = new Random();
                int randomAttack = d.nextInt(3)+1;
                
                     if (defenceChoice == randomAttack){
                           write(
                              "Great job, you have defended \n"
                           );

                           } 
                           else if (defenceChoice != randomAttack) {
                              playersHealth = playersHealth - 2;
                              write(
                                 "Uuuuh, it hurts, opponent just injured you \n" +
                                 "You lost 2 lives, " + playersHealth + " lives left"
                              );
                                 if (playersHealth == 0){
                                    write(
                                        "----------------------------\n"+
                                        "----------YOU LOST----------\n"+
                                        "----------------------------"
                                    );
                                    endGame();
                                 }
 
                           }
                           else{
                              write(
                                "I can only choose between Head (1) body (2) and legs (3). Try next time"
                              );
                           }
                     }


           }
   //Method to draw a box for keeping pokemon
   //Player chooses size ot the box and box is printed out
   public static void pokemonBox()throws IOException{
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

      String boxWidth = read(
          "\n Time to put your pokemon in a box. \n Choose hight of the box (1,2,3, ...) \n"
      );
      int x = Integer.parseInt(boxWidth);

      String boxHeight = read(
          "\n Choose hight of the box (1,2,3, ...) \n"
      );
      int y = Integer.parseInt(boxHeight);
      
      box(x,y);//Calling method box with values x and y
      }
      
      public static void box (int width, int height){ 
      //Value x here is parameter width of type int and
      //value y here is parameter height of type int 
         System.out.print("\n");
         line (width);//Calling method 'line' with value (width) 
      
         for (int line=1; line <= height -2; line++){
             System.out.print("*");
                for (int space =1; space<= width*1.5 -2; space++){
                System.out.print(" ");
             }
             System.out.println("*");
         }
         line(width);//Calling method 'line' with value (width) 
         write(
            "\n Here's a perfect box for storing you pokemon");
      }
      
      public static void line (int count){
      //Value width is handled as 
         for (int i=1; i <= (count*1.5); i++){           //1.5 is needed to adapt line spacing
             System.out.print("*");                      // so figure looks more square
      }
      System.out.println();
      }
   
     
      public static String read(String line) {
         Console console = System.console();
         return console.readLine(line + "\n");
      }
                                             //Method overloading
      public static void write(Object line) {//Two methods are called 'line'
                                             //No Error is shown becuase their values are of diferent type?
         System.out.println(line);
      }


      public static void endGame() {
         write(
           "!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n" +
           "!!!!!!!!!!GAME OVER!!!!!!!!! \n" +
           "!!!!!!!!!!!!!!!!!!!!!!!!!!!!" 
         );
      System.exit(0);
      }
}
