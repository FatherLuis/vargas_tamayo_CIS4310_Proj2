package Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*******************************************************************************
***CLASS NAME: File_IO
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: READ CVS FILE AND COLLECT INFORMATION
********************************************************************************
***DATE: 13 OCTOBER, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
***
*******************************************************************************/
public class File_IO 
{
    
    private ArrayList<String> CityList;
    private ArrayList CityOperation;
    private HashTable HT;
    
    /***************************************************************************
    ***METHOD NAME: File_IO()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/    
    public File_IO()
    {
        CityList = new ArrayList();
        CityOperation = new ArrayList();
        HT = new HashTable();
    }
    
    /***************************************************************************
    ***METHOD NAME: ReadFile()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: READS CVS FILE, COLLECTS INFORMATION, AND STORES
    ***METHOD USED: SetUp()
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/    
    public void ReadFile()
    {
        
        String csvFile = "src\\Program\\Data\\City Distance.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {

            while ((line = br.readLine()) != null) 
            {

                // use comma as separator
                String[] arr = line.split(cvsSplitBy);

                SetUp(arr[0],arr[1],arr[2]);
            }
            
            for(int i = 0; i <  this.CityList.size(); i++)
            {
                this.CityOperation.add(true);
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    /***************************************************************************
    ***METHOD NAME: SetUp()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: ANALYZE RAW DATA AND COLLECT WHAT IS NEEDED
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: STRING, STRING, STRING
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/    
    private void SetUp(String C1, String C2, String Weight)
    {
        if(!isList(C1))
        {
            this.CityList.add(C1);
        }
        
        if(!isList(C2))
        {
            this.CityList.add(C2);
        }
        
        HT.NewData(GetIndex(C1), GetIndex(C2), Double.parseDouble(Weight));  
    }
    
    /***************************************************************************
    ***METHOD NAME: isList()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CHECKS IF STRING IS IN THE ARRALIST
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: STRING
    ***RETURN VALUE: BOOLEAN
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/    
    private boolean isList(String X)
    {
        for(int i =0; i < this.CityList.size(); i++)
        {
            if(X.equals(this.CityList.get(i)))
            {
                return true;
            }
        }
        return false;   
    }
    
    /***************************************************************************
    ***METHOD NAME: GetIndex()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: GET THE INDEX OF A STRING FOUND IN THE ARRAYLIST
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: STRING
    ***RETURN VALUE: INT
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/    
    private int GetIndex(String X)
    {
        int j = 0;
        
        for(int i =0; i < this.CityList.size(); i++)
        {
            if(X.equals(this.CityList.get(i)))
            {
                return i;
            }
        }
        return j; 
    }
    
    /***************************************************************************
    ***METHOD NAME: getCityList()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN VARIABLE CITYLIST
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/
    public ArrayList getCityList(){return this.CityList;}
        
    /***************************************************************************
    ***METHOD NAME: getCityOperation()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN VARIABLE CITYOPERATION
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/
    public ArrayList getCityOperation(){return this.CityOperation;}
        
    /***************************************************************************
    ***METHOD NAME: getHashTable()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: RETURN HASHTABLE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/
    public HashTable getHashTable(){return HT;}
    
}
