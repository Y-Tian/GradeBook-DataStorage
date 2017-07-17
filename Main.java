/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebook2;

import java.util.Scanner;

/**
 *
 * @author tony.tian
 */
public class Main {

    private static boolean r;
    private static int amount;
    
    private static void viewAll(Gradebook g, String s, String str)
    {
        System.out.println("Please enter the student ID: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        
        System.out.println("This student has " + g.info(id, s) + str);           
    }
     
    private static void recordLates(Gradebook g)
    {
        System.out.println("Please enter the student ID: ");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        
        g.incLates(id);
        System.out.println("This student was recorded to be late.");
    }
    
    private static void recordAbsences(Gradebook g)
    {
        System.out.println("Please enter the student ID: ");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        
        g.incAbsences(id);
        System.out.println("This student was recorded to be absent.");       
    }
    
    private static void gradeUpdate(Gradebook g)
    {
        System.out.println("Please enter the student ID: ");
        Scanner in = new Scanner(System.in);
        int id = in.nextInt();
        System.out.println("Please enter the new grade: ");
        Scanner sc = new Scanner(System.in);
        double i = sc.nextDouble();
        
        g.updateGrade(id, i);
        System.out.println("You have updated the grade of this student."); 
        updateAgain(g);
    }
    
    private static void maxGrade(Gradebook g)
    {
        System.out.println("The highest grade is currently: " + g.getHighestGrade() + "%.");       
    }
    
    private static void minGrade(Gradebook g)
    {
        System.out.println("The lowest grade is currently: " + g.getLowestGrade() + "%.");       
    }
    
    private static void aveGrade(Gradebook g)
    {
        System.out.println("The average grade is currently: " + g.getAverageGrade() + "%.");
    }
    
    private static void updateAgain(Gradebook g)
    {
        System.out.println("Would you like to update another grade? [y/n]");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        if(s.equals("y"))
        {
            gradeUpdate(g);
        }
        else if(s.equals("n"))
        {
            mainMenu(g, amount);
        }
    }
    
    public static void chart(Gradebook g, int amount)
    {
        System.out.println("Student ID....." + "Lates....." + "Percentage.....\n");
        for(int n = 0; n < amount; n++)
        {
            System.out.println(n + "..............." + g.getLates(n) + "..........." + g.getPercentageGrade(n) + ".....\n");
        }
    }
    
    public static void mainMenu(Gradebook g, int amount)
    {
        System.out.println("***********************************************\n"
                + "                * Main Menu *\n"
                + "                * Commands *\n"
                + "* Query Lates: ql *\n"
                + "* Percentage Grade: pg *\n"
                + "* Letter Grade: lg *\n"
                + "* Query Absences: qa *\n"
                + "* Record Late: rl *\n"
                + "* Record Absence: ra *\n"
                + "* Update Grade: ug *\n"
                + "* Max Grade: max *\n"
                + "* Min Grade: min *\n"
                + "* Average Grade: ave *\n"
                + "* Chart: chart *\n"
                + "* Exit: ex *\n"
                + "***********************************************\n"
                + "Enter a command: ");
        
        Scanner sd = new Scanner(System.in);
        String command = sd.next();
        String str = new String();
        
        if(command.equals("ql"))
        {
            str = " lates.";
            viewAll(g, command, str);
        }
        else if(command.equals("pg"))
        {
            str = " percent.";
            viewAll(g, command, str);
        }
        else if(command.equals("lg"))
        {
            str = ".";
            viewAll(g, command, str);
        }
        else if(command.equals("qa"))
        {
            str = " absences.";
            viewAll(g, command, str);
        }
        else if(command.equals("rl"))
        {
            recordLates(g);
        }
        else if(command.equals("ra"))
        {
            recordAbsences(g);
        }
        else if(command.equals("ug"))
        {
            gradeUpdate(g);
        }
        else if(command.equals("max"))
        {
            maxGrade(g);
        }
        else if(command.equals("min"))
        {
            minGrade(g);
        }
        else if(command.equals("ave"))
        {
            aveGrade(g);
        }
        else if(command.equals("chart"))
        {
            chart(g, amount);
        }
        else if(command.equals("ex"))
        {
            r = false;
        }
    }   
    
    public static void main(String[] args) {
        System.out.println("*********************************************\n"
                + "* Totally Awesome High Budget Software Corp \n*"
                + "* Presents: Gradebook v1.0 *\n"
                + "*********************************************\n"
                + "How many students are in your class?");
        
        Scanner sc = new Scanner(System.in);
        amount = sc.nextInt();
        
        System.out.println("New grade book created with " + amount + " students");
        Gradebook gb = new Gradebook(amount);
        
        r = true;
        
        while(r == true)
        {
            mainMenu(gb, amount);
            System.out.println("\n"
                    + "\n"
                    + "\n"
                    + "\n");
        }
    }
}
