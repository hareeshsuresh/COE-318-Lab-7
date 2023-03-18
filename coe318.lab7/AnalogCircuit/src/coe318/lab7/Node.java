package coe318.lab7;

public class Node
{
    public int id; //Node ID
    private static int node_id_counter = 0; //ID of next node
    
    //Constructor
    public Node()
    {
        this.id = node_id_counter; //Set current ID to the next available ID
        node_id_counter++; //Increment next available ID (since current one has now been used)    
    }
    
    //Return node ID as a string
    public String toString()
    {
        return "" + this.id; //Return current ID
    }
}