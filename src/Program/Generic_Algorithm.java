package Program;

import java.util.ArrayList;
import java.util.Random;

/*******************************************************************************
***CLASS NAME: Generic_Algorithm
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: Used to manage generic algorithm
********************************************************************************
***DATE: 13 OCTOBER, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: NONE
********************************************************************************
***SPECIAL NOTES: NONE
*** 
*******************************************************************************/
public class Generic_Algorithm 
{
    private ArrayList CityList;
    private ArrayList CityPort;
    private HashTable HT;
    
    private int firstCity;
    
    private String results;
    
    public Generic_Algorithm(ArrayList cityList, ArrayList cityPort, HashTable HT)
    {
        this.CityList = cityList;
        this.CityPort = cityPort;
        this.HT = HT;
    }
    
    /***************************************************************************
    ***METHOD NAME: Calculate*()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: main drive for the program, Creates children and
    *                         finds best solution through genetics
    ***METHOD USED: genSelection()
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/     
    public void Calculate()
    {
        ArrayList<Entity> curPopulation = new ArrayList();
        
        int numGenerations = 1000;
        int numChildren = 10000;
        
        Random rand = new Random();
        int probability = 0;
        
        //ITERATES BY THE NUMBER OF GENERATIONS WANTED
        for(int i=0; i < numGenerations ; i++)
        {
            probability = rand.nextInt(100);
            
            //ITERATE BY THE NUMBER OF CHILDREN WANTED
            for(int k = 0; k < numChildren; k++)
            {
                //CREATES A NEW CHILD
                curPopulation.add(new Entity(CityPort, HT,this.firstCity)); 
                
                //IF PROBABILITY IS HIGHER THAN 80, THEN MUTATE CHILD
                if(probability >= 80)
                {
                    curPopulation.get(k).mutate();
                }
            }

            //GET THE BEST 6 CHILDREN (LEAST MILES)
            curPopulation = genSelection(curPopulation);

            //IF THIS IS NOT THE LAST GENERATION
            if(i != numGenerations - 1)
            {
                //IF PROBABILITY IS GREATER THAN 75, THEN CREATE SOME CHILDREN FROM PARENT
                if(probability > 75)
                {
                    int size = curPopulation.size();
                    
                    //CREATES FIVE CHILDREN FROM THE SIX PARENTS
                    for(int x =0; x < size -1; x++)
                    {
                        //CREATES CHILDREN BASED ON PARENTS DNA
                        curPopulation.add(new Entity(CityPort, HT, curPopulation.get(x), curPopulation.get(x+1), this.firstCity)); 
                    }
                }   
                
                //GETS THE BEST 6 CHILDREN
                curPopulation = genSelection(curPopulation);
            }
 
        }
        

        this.results = "";
        
         //SHOW RESULTS
        for(int i =0; i < curPopulation.size();i++)
        {
            this.results += "\n----------------------------------------------------------";
            this.results +=  "\nSolution " + i +": "  + String.format("%1$,.2f", curPopulation.get(i).getMiles())  + " miles \n";
            
            for(int k =0; k < curPopulation.get(i).getSet().size(); k++)
            {               
                this.results += "\n"+k + ". "+this.CityList.get((int)curPopulation.get(i).getSet().get(k));
            }
            
            
        
        } 
        //System.out.println(this.results);
    }
 
    /***************************************************************************
    ***METHOD NAME: genSelection()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: From a large selection of children, 
    *                         method picks best 6
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/     
    private ArrayList genSelection(ArrayList<Entity> curGen)
    {
        ArrayList<Entity> chosenList = new ArrayList();
        
        //GET THE FIRST SIX CHILDREN
        for(int i=0; i < 6;i++)
        {
            chosenList.add(curGen.get(i));
        }
        
        //COMPARE THE POPULATION TO THE 6 CHILDREN, IF THEY'RE BETTER, REPPLACE
        //THE CHILDREN FOR THEM
        for(int i=chosenList.size(); i < curGen.size();i++)
        {            
            for(int k=0; k < chosenList.size(); k++)
            {
                if(curGen.get(i).getMiles() < chosenList.get(k).getMiles())
                {
                    chosenList.set(k, curGen.get(i));                   
                    break;
                }
            }

        }
        
        return chosenList;
        
    }
 
    public void setFirstCity(int city)
    {
        this.firstCity = city;
    }
    
    public String getResults(){return this.results;};
    
}
