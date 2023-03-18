package coe318.lab7;

public class Resistor
{
    private double resistance; //Stores resistor value on ohms
    private Node node1; //Stores node 1
    private Node node2; //Stores node 2
    private int id; //Stores current ID
    private static int resistor_id_counter = 1; //ID of next available resisor

    //Constructor
    public Resistor(double resistance, Node node1, Node node2)
    {
        if(resistance <= 0 || (node1 == null || node2 == null))
            throw new IllegalArgumentException(); //Throw error if the resistor has no resistance value

        this.resistance = resistance; //Assign resistance
        
        //Assign nodes
        this.node1 = node1;
        this.node2 = node2;
        
        this.id = resistor_id_counter; //Assign resistor ID
        resistor_id_counter++; //Increment next available ID
    }

    //Get array of nodes
    public Node[] getNodes()
    {
        Node[] nodes = new Node[2]; //Create array of two nodes
        
        //Assign nodes
        nodes[0] = this.node1;
        nodes[1] = this.node2;
        
        return nodes; //Return node array
    }

    //Return string version of resistor
    public String toString()
    {
        //Format is:
        //R[Resistor ID] [node1] [node2] [resistance]
        return "R" + this.id + "\t" + this.node1 + "\t" + this.node2 + "\t" + this.resistance;
    }
}