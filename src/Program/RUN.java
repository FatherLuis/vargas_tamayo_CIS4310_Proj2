package Program;

/*******************************************************************************
***CLASS NAME: RUN
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: Runs the program
********************************************************************************
***DATE: 13 OCTOBER, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class RUN 
{
    
    /***************************************************************************
    ***METHOD NAME: main()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/   
    public static void main(String[] args)
    {
        //CREATES A FILE_IO OBJECT THAT READS A CVS FILE AND COLLECTS INFORMATION
        File_IO FI = new File_IO();
        
        //READS THE CVS FILE
        FI.ReadFile();
        
        //CREATE THE GENETIC ALGORITHM WITH THE COLLECTED INFORMATION
        Generic_Algorithm GA = new Generic_Algorithm(FI.getCityList(),FI.getCityOperation(),FI.getHashTable());
        //START THE GENETIC ALGORITHM
        
        GUI mainGUI = new GUI();
        mainGUI.setGeneticAlgorithm(GA);
        mainGUI.setVisible(true);
        
        //GA.Calculate();
    
    }
    
}
