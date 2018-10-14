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
public class Entity 
{
    
    private ArrayList CityPorts;
    private HashTable HT;
    
    private int AvailablePorts;
    
    private ArrayList seqSet;
    
    private double mileage;
    
    public Entity(ArrayList cityPort, HashTable HT)
    {
        this.CityPorts = (ArrayList) cityPort.clone();
        this.AvailablePorts = CityPorts.size();
        this.HT = HT;
        seqSet = new ArrayList();
        seqSet.add(4);
        CityPorts.set(4, false);
        
        
        createSet();
        calMileage();
    }
    
    public Entity(ArrayList cityPort, HashTable HT, Entity Set1, Entity Set2)
    {
        this.CityPorts = (ArrayList) cityPort.clone();
        this.AvailablePorts = CityPorts.size();
        this.HT = HT;
        seqSet = new ArrayList();
        seqSet.add(4);
        CityPorts.set(4, false);
        
        
        merge(Set1,Set2);
        calMileage();
    }    
    
    
    
    
    private void createSet()
    {
        Random rand = new Random();
        int r = 0;
        
        
        
        for(int i=1; i < this.CityPorts.size();i++)
        {
            //System.out.println("     "+this.AvailablePorts + " \n");
            while(AvailablePorts > 0)
            {
                r = rand.nextInt(this.CityPorts.size());
                //System.out.println("rand  " + r);
                
                if((boolean)this.CityPorts.get(r) != false)
                {
                    
                    seqSet.add(r);
                    this.CityPorts.set(r, false);
                    AvailablePorts --;
                    //System.out.println("Available ports " + AvailablePorts);
                    break;
                }
            }
        }
        
        for(int i =0; i< this.seqSet.size(); i++)
        {
            System.out.print(this.seqSet.get(i) + "  ");
        }
        //System.out.println("\n");

        
        
        
    
    
    }
    
    private void calMileage()
    {       
        this.mileage = 0;
        
        for(int i=0; i < this.seqSet.size() - 1; i++)
        {
            this.mileage += HT.getMiles((int)this.seqSet.get(i), (int)this.seqSet.get(i+1));
        
        }
        
        this.mileage += HT.getMiles((int)this.seqSet.get(0), (int)this.seqSet.get(this.seqSet.size() - 1));
        
        System.out.print(" " +this.mileage + "\n"); 
    }
    
    
    public double getMiles()
    {
        return this.mileage;
    }
    
    public ArrayList getSet(){return seqSet;};
    
    
    private void merge(Entity Child1, Entity Child2)
    {
        int k =0;
        
        for(int i=0; i < this.CityPorts.size();i++)
        {
            
            if(i==0)
            {
                //this.seqSet.add(Child1.getSet().get(i));
                //this.CityPorts.set(4, false);
                this.AvailablePorts--;
                continue;
            }
            else if(i % 2 == 1)
            {
                //System.out.println("IN THE ODD (Child2) "+i);
                k=i;
                while(true)
                {
                    if((boolean)this.CityPorts.get((int)Child2.getSet().get(k)) != false)
                    {
                        this.seqSet.add(Child2.getSet().get(k));
                        //System.out.println("     " +(int)Child2.getSet().get(k));
                        this.CityPorts.set((int)Child2.getSet().get(k), false);
                        this.AvailablePorts--;
                        break;                       
                    }
                    k++;
                    
                    if(k >= this.CityPorts.size())
                    {
                        break;
                    }
                }
            }
            else if(i % 2 == 0)
            {
                //System.out.println("IN THE EVEN (Child1) "+i);
                k=i;
                while(true)
                {
                    if((boolean)this.CityPorts.get((int)Child1.getSet().get(k)) != false)
                    {
                        this.seqSet.add(Child1.getSet().get(k));
                        //System.out.println("     " +(int)Child1.getSet().get(k));
                        this.CityPorts.set((int)Child1.getSet().get(k), false);
                        this.AvailablePorts--;
                        break;                       
                    }
                    k++;
                    
                    if(k >= this.CityPorts.size())
                    {
                        break;
                    }
                }
            }            
        }
        
        if(AvailablePorts >0)
        {
            for(int i=0; i < this.CityPorts.size();i++)
            {
                Random rand = new Random();
                int r = 0;
                
                if((boolean)this.CityPorts.get(i))
                {
                    while(true)
                    {
                        r = rand.nextInt(this.CityPorts.size());
                        //System.out.println("rand  " + r);

                        if((boolean)this.CityPorts.get(r) != false)
                        {

                            seqSet.add(r);
                            this.CityPorts.set(r, false);
                            AvailablePorts --;
                            //System.out.println("Available ports " + AvailablePorts);
                            break;
                        }
                    }
                }

            }
        }
        
        
        
        
        
        for(int i=0; i < this.seqSet.size(); i++)
        {
            System.out.print(this.seqSet.get(i) + "  ");
        }
    
    
    }
    
    
    public void mutate()
    {
        Random rand = new Random();
      
        int r = 0;   
        int temp1 = 0;
        int temp2 = 0;
                
        do{
            temp1 = rand.nextInt(this.seqSet.size());    
        }
        while(temp1 == 0); 
        
        
        
        do
        {
            temp2 = rand.nextInt(this.seqSet.size());
        }
        while(temp2 == temp1 || temp2 == 0); 
        
        int v1 = (int)this.seqSet.get(temp1);
        int v2 = (int)this.seqSet.get(temp2);
        
        this.seqSet.set(temp1, v2);
        this.seqSet.set(temp2, v1);
        
        for(int i=0; i < this.seqSet.size(); i++)
        {
            System.out.print(this.seqSet.get(i) + "  ");
        }

        this.calMileage();
        
        
        
        
        
    }
}
