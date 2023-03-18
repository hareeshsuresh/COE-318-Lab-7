package coe318.lab7;

public class VoltageSource
{

    private double voltage; //Stores the voltage of the source in volts
    private Node node1; //Stores node 1
    private Node node2; //Stores node 2
    private int id; //Stores voltage source ID
    private static int voltage_id_counter = 1; //ID of next available voltage source

    public VoltageSource(double voltage, Node node1, Node node2)
    {
        if(node1 == null || node2 == null)
            throw new IllegalArgumentException(); //Throw error if the resistor has no resistance value
        else
        {
            if(voltage < 0) //Check if voltage is negative 
            {
                this.voltage = voltage * -1.0; //Store absolute value of voltage
                //Swap nodes
                this.node1 = node2;
                this.node2 = node1;
            }
            else
            {
                this.voltage = voltage; //Store given voltage
                
                //Assign nodes
                this.node1 = node1;
                this.node2 = node2;
            }
        
            this.id = voltage_id_counter; //Assign voltage source ID
            voltage_id_counter++; //Increment next available ID
        }
        
    }

    public Node[] getNodes()
    {
        Node[] nodes = new Node[2]; //Create array of two voltage sources 
        
        //Assign nodes
        nodes[0] = this.node1;
        nodes[1] = this.node2;
        
        return nodes; //Return voltage source array
    }

    //Return string version of voltage source
    public String toString()
    {
        //Format is:
        //V[Voltage Source ID] [node1] [node2] [voltage]
        return "V" + this.id + "\t" + this.node1 + "\t" + this.node2 + "\tDC " + this.voltage;
    }
}