/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

/**
 *
 * @author fathe
 */
public class HashTable 
{
    
    double[][] table;
    
    public HashTable()
    {
        table = new double[100][100];
    }
    
    public void NewData(int C1, int C2, double Weight)
    {
        table[C1][C2] = Weight;
    }
    
    public double getMiles(int C1, int C2)
    {
        return table[C1][C2];
    
    }



    
}
