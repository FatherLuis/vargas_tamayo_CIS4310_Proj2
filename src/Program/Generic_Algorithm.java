/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fathe
 */
public class Generic_Algorithm 
{
    private ArrayList CityList;
    private ArrayList CityPort;
    private HashTable HT;
    
    public Generic_Algorithm(ArrayList cityList, ArrayList cityPort, HashTable HT)
    {
        this.CityList = cityList;
        this.CityPort = cityPort;
        this.HT = HT;
    }
    
    
    public void Calculate()
    {
        ArrayList<Entity> curPopulation = new ArrayList();
        
        int numGenerations = 1000;
        int numChildren = 10000;
        
        Random rand = new Random();
        int probability = 0;
        
        
        for(int i=0; i < numGenerations ; i++)
        {
            probability = rand.nextInt(100);
            
            System.out.println("Generation " + i);
            for(int k = 0; k < numChildren; k++)
            {
                
                curPopulation.add(new Entity(CityPort, HT)); 
                
                if(probability >= 80)
                {
                    curPopulation.get(k).mutate();
                    //System.out.println("Mutation");
                }
                
                
            }
            //System.out.println("Generation " + i + "  No more kids" );
            
            curPopulation = genSelection(curPopulation);
            
            //System.out.println("Population size: " + curPopulation.size());
            
            
            
            
            
            if(i != numGenerations - 1)
            {
                if(probability > 75)
                {
                    int size = curPopulation.size();
                    //System.out.println("New Kids Coming");
                    for(int x =0; x < size -1; x++)
                    {
                        //System.out.println(" Kid #" + x);
                        curPopulation.add(new Entity(CityPort, HT, curPopulation.get(x), curPopulation.get(x+1))); 
                    }
                }      
            }
            
            
        }
        
        System.out.println("End of Generation");
        curPopulation = genSelection(curPopulation);
        
        
        
        
        
        
        
        for(int i =0; i < curPopulation.size();i++)
        {
            for(int k =0; k < curPopulation.get(i).getSet().size(); k++)
            {
                System.out.print(curPopulation.get(i).getSet().get(k) + " ");
            }
            System.out.print(" " + curPopulation.get(i).getMiles() + "\n");
        
        }
        
        
    }
    
    private ArrayList genSelection(ArrayList<Entity> curGen)
    {
        ArrayList<Entity> chosenList = new ArrayList();
        
        for(int i=0; i < 6;i++)
        {
            chosenList.add(curGen.get(i));
        }
        
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
    
    

    
    
    
    
}
