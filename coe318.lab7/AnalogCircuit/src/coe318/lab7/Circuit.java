package coe318.lab7;
import java.util.ArrayList;

//Create singleton
public class Circuit
{
    private ArrayList<Object> circuitElements = new ArrayList<>(); //List of elements in the circuit
    private static Circuit instance = null; //Create null circuit object called instance
    
    //Constructor
    private Circuit() {} //Private constructor
    
    //Create instance 
    public static Circuit getInstance()
    {
        if(instance == null)
            instance = new Circuit(); //Create new circuit object if current object does not exist

        return instance; //Return circuit object if one has already been created
    }
    
    //Add resistor to ArrayList of resistors
    public void add(Resistor r)
    {
        circuitElements.add(r); //Add resistor to the end of array list
    }
    
    //Add voltage source to ArrayList of voltage sources
    public void add(VoltageSource v)
    {
        circuitElements.add(v); //Add voltage source to the end of array list
    }

    //Return string version of circuit
    public String toString()
    {
        String result = ""; //Start with blank string
        
        //Loop through list of circuit elements
        for(int i = 0; i < circuitElements.size(); i++)
            result += circuitElements.get(i) + "\n"; //Add each element on a new line
        
        return result; //Return string
    }
}