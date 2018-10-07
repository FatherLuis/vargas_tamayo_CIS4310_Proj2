package Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class File_IO 
{
    
    private ArrayList<String> CityList;
    private ArrayList CityOperation;
    private HashTable HT;
    
    
    public File_IO()
    {
        CityList = new ArrayList();
        CityOperation = new ArrayList();
        HT = new HashTable();
    }
    
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
    
    
    public ArrayList getCityList(){return this.CityList;}
    
    public ArrayList getCityOperation(){return this.CityOperation;}
    
}
