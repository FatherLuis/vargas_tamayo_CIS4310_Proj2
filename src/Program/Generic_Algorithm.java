/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.ArrayList;

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
        ArrayList<Entity> population = new ArrayList();
        
        for(int i=0; i < 20 ; i++)
        {
            population.add(new Entity(CityPort, HT));
            population.get(i).mutate();
            System.out.println("\n");
//            population.get(i).createSet();
//            population.get(i).calMileage();
        }
        
        
        //Entity newChild = new Entity(CityPort, HT, population.get(0), population.get(1));
        
//        double minimum = 0;
//        
//        ArrayList<Entity> nextGen = new ArrayList();
//        
//        for(int i = 0; i < population.size(); i++)
//        {
//            if(i ==0)
//            {
//                minimum = population.get(i).getMiles();
//                System.out.println("min: " + minimum);
//                nextGen.add(population.get(i));
//            }
//            else if(nextGen.size() < 10)
//            {
//                if(population.get(i).getMiles() < minimum)
//                {
//                    nextGen.add(population.get(i));
//                }
//            }
//        }
//        
//        for(int i=0; i < nextGen.size();i++)
//        {
//            System.out.println("nextGen Set " + i + ": " + nextGen.get(i).getMiles());
//        }
//        
//        
//        
//        System.out.println("DID I BREAK");
//        System.out.println("Size: " + nextGen.size());
//        
//        if(nextGen.size() < 10)
//        {
//            for(int i=nextGen.size(); i < 10; i++)
//            {
//                nextGen.add(new Entity(CityPort, HT));
////                System.out.println("CreateSet()");
////                nextGen.get(i).createSet();
////                System.out.println("CalMileage()");
////                nextGen.get(i).calMileage();
//                
//            }
//        }
//        
//        
//        for(int k =0; k < nextGen.size();k++)
//        {
//            System.out.println("nextGen " + k +": "+ nextGen.get(k).getMiles());
//        
//        }
//        
//        
//        
//        
    }
    
    
    
}
