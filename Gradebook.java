/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebook2;

/**
 *
 * @author tony.tian
 */
public class Gradebook {
    
    private int[] lates;
    private int[] absences;
    private double[] percentage;

    public Gradebook(int students)
    {
        lates = new int[students];
        absences = new int[students];
        percentage = new double[students];
    }
    
    public int getLates(int id)
    {
        return lates[id];
    }    
            
    public int getAbsences(int id)
    {
        return absences[id];
    }
    
    public double getPercentageGrade(int id)
    {
        return percentage[id];
    }
    
    public String getLetterGrade(int id)
    {              
        double percent = getPercentageGrade(id);
        
        if(percent >= 86)
            return "A";
        else if (percent >= 73 && percent <= 85)
            return "B";
        else if (percent >= 50 && percent <= 72)
            return "C";
        else 
            return "I";    
    }
    
    public void incLates(int id)
    {
        lates[id]++;
    }

    public void incAbsences(int id)
    {
        absences[id]++;
    }
    
    public void updateGrade(int id, double newGrade)
    {
        percentage[id] = newGrade;
    }

    public double getHighestGrade()
    {
        double highestGrade = 0;
        
        for(int n = 0; n < percentage.length; n++)
        {
            if(percentage[n] > highestGrade)
            {
                highestGrade = percentage[n];
            }
        }   
        return highestGrade;
    }
    
    public double getLowestGrade()
    {
        double lowestGrade = percentage[0];
        
        for(int n = 0; n < percentage.length; n++)
        {
            if(percentage[n] < lowestGrade)
            {
                lowestGrade = percentage[n];
            }
        }    
        return lowestGrade;
    }
    
    public double getAverageGrade()
    {
        double totalGrade = percentage[0];
        double avrgGrade = 0;
        int a = 0;
        if(percentage[0] > 0)
        {
            a++;
        }
        
        for(int n = 1; n < percentage.length && percentage[n] > 0; n++)
        {
            if(percentage[n] > 0)
            {
                a++;
            }
            totalGrade = totalGrade + percentage[n];
        }      
        avrgGrade = totalGrade/a;
        
        return avrgGrade;
    }    
    
    public String info(int id, String s)
    {
        if(s.equals("ql"))
        {
            return Integer.toString(getLates(id));
        }
        else if(s.equals("pg"))
        {
            return Double.toString(getPercentageGrade(id));
        }
        else if(s.equals("lg"))
        {
            return getLetterGrade(id);
        }
        else if(s.equals("qa"))
        {
            return Integer.toString(getAbsences(id));
        }
        else
        {
            return "Error";
        }
    }
}
