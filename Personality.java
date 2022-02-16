import java.io.*;
import java.util.*;

public class Personality{
   public static final int dimension = 4;
   
   public static void main(String[] args) throws FileNotFoundException{
      Scanner console = new Scanner(System.in);
      intro();
      System.out.print("input file name? ");
      Scanner inputFile = new Scanner(new File(console.next()));
      //read the given input file
      System.out.print("output file name? ");
      PrintStream stream = new PrintStream(new File(console.next()));
      //print results to specified output file
      while(inputFile.hasNextLine()){ //read in the file
         stream.print(inputFile.nextLine() + ": ");
         String answer = inputFile.next().toUpperCase();
         String[] result = readLine(answer);
         int[] countAnswer = calculate(result);
         int[] percentB = percentageB(countAnswer);
         String type = ("IENSFTPJ");
         String report = personality(percentB, type);
         stream.println(Arrays.toString(percentB) + " = " + report);
         //print percent and personality result to specified output file
		   inputFile.nextLine();
      }
   }
   
   //short introduction of the program
   public static void intro(){
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   //read each corresponding answer in file and store in an array
   //return answers for each dimension
   //parameter needed:
   //String answer = answers in file
   public static String[] readLine(String answer){
      String[] result = new String[dimension];
      for(int i = 0; i < answer.length()/7; i++){
         for(int j = 0; j < 7; j++){
            result[(j + 1)/ 2] += answer.charAt(i * 7 + j);
         } 
      }
      return result;
   }
   
   //read and determine whether answer is A or B
   //collect total numbers of B for each dimension and store at each even index array
   //store total numbers of A for each dimension at every odd index in given array
   //return total numbers of A and B for each dimension
   //parameter needed:
   //String[] result = store answers for each dimension
   public static int[] calculate(String[] result){
      int[] countAnswer = new int[dimension * 2];
      int index = 0;
      for(int i = 0; i < result.length; i++){
         for(int j = 0; j < result[i].length(); j++){
            if(result[i].charAt(j) == 'B'){
               countAnswer[index]++;
            }else if(result[i].charAt(j) == 'A'){
               countAnswer[index + 1]++;
            }
         }
         index += 2;
      }
      return countAnswer;
   }
   
   //determine the percentage of responses the   
   //person gave for each dimension that were "B"
   //return this percentage to console
   //parameter needed:
   //int[] countAnswer = the number of answers A and B for each dimensions
   public static int[] percentageB(int[] countAnswer){
      int[] percentB = new int[dimension];
      for(int i = 0; i < percentB.length; i++){
         percentB[i] = (int)Math.round((double)countAnswer[i * 2]/ (countAnswer[i * 2] 
                              + countAnswer[i * 2 + 1]) * 100);
      }
      return percentB;
   }
   
   //Program will assign the person to one side 
   //or the other of the dimension based on the percentage of "B"
   //parameter needed:
   //int[] percentB = percentage of answer "B"
   //String type = all dimensions provided
   public static String personality(int[] percentB, String type){
      String report = "";
      for(int i = 0; i < percentB.length; i++){
         if(percentB[i] > 50){
            report += type.charAt(i * 2);
         }else if(percentB[i] < 50){
            report += type.charAt(i * 2 + 1);
         }else{//percent[i] == 50
            report += "X";
         }
      }
      return report;
   }  
}