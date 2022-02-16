//Yifan Dai
//02/04/2020
//TA: Kendra Specht
// Assignment #4
//
/*This program will use of static, Scanner, if/else, return, and for loop methods, 
and printf statements to ask how much one user spend and save
, read in, comupte, and report a budget for one user */

import java.util.*;

public class Budgeter{
   public static final int MONTH = 31;
   
   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      intro();
      
      double income = income(console);
      double totalIncome = income;
      double expense = expense(console);
      double totalExpense = expense;
      
      calculate(totalIncome);
      report(totalExpense, totalIncome);
      
   }
   
   //prints out introduction to the program.
   public static void intro(){
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
   }
   
   /*Scanner uses for input
   read in and computes the total incomes for one user*/
   public static double income(Scanner console){
      double totalIncome = 0.0;
      System.out.print("How many categories of income? ");
      int categ = console.nextInt();//int categ = read in the number user type in
      for (int i = 1; i <= categ; i ++){// i = int categ
         System.out.print("    Next income amount? $");
         double income = console.nextDouble();//user type in income amount
         totalIncome += income;//sum up total income
      }
      System.out.println();
      return totalIncome;
   }
   
   /* read in and computes total expenses,
   averge expense for one user */
   public static double expense(Scanner console){
      double totalExpense = 0.0;
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int monthDaily = console.nextInt();//read in user type 1 or 2
      if (monthDaily == 1){
         System.out.print("How many categories of expense? ");
         int monthCateg = console.nextInt();
         for (int i = 1; i <= monthCateg; i ++){ //i is int monthCateg that user type in
            System.out.print("    Next expense amount? $");
            double expense = console.nextDouble();//read in each expense
            totalExpense += expense;//sum up total expenses
         }
         double averExpense = totalExpense / MONTH;
         System.out.println();
         //using printf to round up total and averge expenses to hundredth
         System.out.printf("Total expenses = $%.2f ($%.2f/day)", totalExpense, averExpense);
      }if (monthDaily == 2){
         System.out.print("How many categories of expense? ");
         int dailyCateg = console.nextInt();//read in integer number and call dailyCateg
         for (int i = 1; i <= dailyCateg; i ++){ //i = int dailyCateg
            System.out.print("    Next expense amount? $");
            double expense = console.nextDouble();
            totalExpense += MONTH * expense;//sums up the total expense
         }
         System.out.println();
         double averExpense = totalExpense / MONTH;//computes averge expense
         System.out.printf("Total expenses = $%.2f ($%.2f/day)", totalExpense, averExpense);
      }
      System.out.println();
      return totalExpense;
   }
   
   //computes and prints out averge income for one user.
   public static void calculate(double totalIncome){
      double averIncome = totalIncome / MONTH;
      System.out.printf("Total income = $%.2f ($%.2f/day)", totalIncome, averIncome);
      System.out.println();
      System.out.println();
   }
   
   /*computes difference between total income and total expense,
   using if/else method to report*/
   public static void report(double totalExpense, double totalIncome){
      double difference = totalIncome - totalExpense;
      if (difference > 250){
         //round up difference to hundredth digit using printf
         System.out.printf("You earned $%.2f more than you spent this month.", difference);
         System.out.println();
         System.out.println("You're a big saver.");
      }else if (difference <= 250 && difference > 0){
         System.out.printf("You earned $%.2f more than you spent this month.", difference);
         System.out.println();
         System.out.println("You're a saver.");
      }else if (difference <= 0 && difference > -250){
         System.out.printf("You spent $%.2f more than you earned this month.", Math.abs(difference));
         System.out.println();
         System.out.println("You're a spender.");
      }else{
         System.out.printf("You spent $%.2f more than you earned this month.", Math.abs(difference));
         System.out.println();
         System.out.println("You're a big spender.");
      }
   }
}