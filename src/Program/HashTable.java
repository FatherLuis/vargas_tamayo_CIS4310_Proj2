/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

/*******************************************************************************
***CLASS NAME: HashTable
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: Used to store miles between two cities
********************************************************************************
***DATE: 13 OCTOBER, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
***
*******************************************************************************/
public class HashTable 
{
    
    double[][] table;
    
    /***************************************************************************
    ***METHOD NAME: HashTable()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/     
    public HashTable()
    {
        table = new double[100][100];
    }

    /***************************************************************************
    ***METHOD NAME: NewData()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: add data to HashTable
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: int, int, double
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/       
    public void NewData(int C1, int C2, double Weight)
    {
        table[C1][C2] = Weight;
    }
   
    /***************************************************************************
    ***METHOD NAME: getMiles
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: get the miles from two cities
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: double
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/      
    public double getMiles(int C1, int C2)
    {
        return table[C1][C2];
    
    }



    
}
