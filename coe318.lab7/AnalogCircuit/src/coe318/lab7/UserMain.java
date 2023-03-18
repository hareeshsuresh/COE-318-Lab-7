package coe318.lab7;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Hareesh Suresh
 * @date Nov. 13, 2022
 */

public class UserMain
{

	public static void main(String[] args)
	{
		String userInput; //Stores the user input
		Circuit circuit = Circuit.getInstance(); //Create the circuit
		Scanner keyboard = new Scanner(System.in); //Initialize scanner for keyboard input
		
		System.out.println("Enter your input:"); //Prompt user to enter input
		
		while(true) //Loop until program breaks
		{
			userInput = keyboard.nextLine().trim(); //Get user input
			
			if(userInput.equalsIgnoreCase("end")) //Check if user wants to terminate program
			{
				System.out.println("All Done"); //Print ending message
				break; //Terminate program
			}
			else if(userInput.equalsIgnoreCase("spice")) //Check if user wants to view the circuit
			{
				System.out.println(circuit); //Print the circuit
			}
			else //User has entered a new circuit element
			{
				String[] input = userInput.split(" "); //Split user input into separate strings based on space character
				
				if(input.length != 4) //Check if 4 parameters for the circuit component were specified
					throw new IllegalArgumentException(); //Throw error if there is not 4 arguments
				else
				{
					Node node1 = new Node(); //Create node 1
					Node node2 = new Node(); //Create node 2
					node1.id = Integer.parseInt(input[1]); //Use second parameter to assign node ID 1
					node2.id = Integer.parseInt(input[2]); //Use third parameter to assign node ID 2
					double value = Double.parseDouble(input[3]); //Get resistance or voltage from fourth parameter
					
					if(userInput.toLowerCase().startsWith("v")) //Check if a voltage source was specified in the user input
					{
						VoltageSource v = new VoltageSource(value, node1, node2); //Create voltage source
						circuit.add(v); //Add voltage source to the circuit
					}
					else if (userInput.toLowerCase().startsWith("r")) //Check if a resistor was specified in the user input
					{
						Resistor r = new Resistor(value, node1, node2); //Create resistor
						circuit.add(r); //Add resistor to the circuit
					}
				}
			}
		}
	}
}