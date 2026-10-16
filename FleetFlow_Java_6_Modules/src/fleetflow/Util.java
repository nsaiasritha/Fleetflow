package fleetflow;
import java.util.*;
public class Util {
 public static String readLine(Scanner sc,String prompt){System.out.print(prompt);return sc.nextLine();}
 public static int readInt(Scanner sc,String prompt){while(true){System.out.print(prompt);String s=sc.nextLine().trim();try{return Integer.parseInt(s);}catch(Exception e){System.out.println("Please enter a whole number.");}}}
 public static long readLong(Scanner sc,String prompt){while(true){System.out.print(prompt);String s=sc.nextLine().trim();try{return Long.parseLong(s);}catch(Exception e){System.out.println("Please enter an integer.");}}}
}
