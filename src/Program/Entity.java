package Program;

import java.util.ArrayList;
import java.util.Random;

/*******************************************************************************
***CLASS NAME: Entity
***CLASS AUTHOR: LUIS E VARGAS TAMAYO
********************************************************************************
***PURPOSE OF CLASS: CREATE AN OBJECT CHILD FOR THE GENETIC ALGORITHM
********************************************************************************
***DATE: 13 OCTOBER, 2018
********************************************************************************
***LIST OF CHANGES WITH DATES: N/A
********************************************************************************
***SPECIAL NOTES: N/A
*** 
*******************************************************************************/
public class Entity 
{
    
    private ArrayList CityPorts;
    
    private HashTable HT;
    
    private int AvailablePorts;
    
    private ArrayList seqSet;
    
    private double mileage;
    
    /***************************************************************************
    ***METHOD NAME: Entity()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CONSTRUCTOR
    ***METHOD USED: CREATESET(), CALMILEAGE()
    ***METHOD PARAMETERS: ARRAYLIST, HASHTABLE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER 2018
    ***************************************************************************/    
    public Entity(ArrayList cityPort, HashTable HT, int firstCity)
    {
        this.CityPorts = (ArrayList) cityPort.clone();
        this.AvailablePorts = CityPorts.size();
        this.HT = HT;
        seqSet = new ArrayList();
        
        seqSet.add(firstCity);
        CityPorts.set(firstCity, false);
        this.AvailablePorts--;
        
        //CALLS METHODS TO DO THEIR WORK
        createSet();
        calMileage();
    }

    /***************************************************************************
    ***METHOD NAME: Entity()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: SECOND CONSTRUCTOR
    ***METHOD USED: MERGE(), CALMILEAGE()
    ***METHOD PARAMETERS:ARRAYLIST, HASHTABLE, ENTITY,ENTITY
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/
    public Entity(ArrayList cityPort, HashTable HT, Entity Set1, Entity Set2, int firstCity)
    {
        this.CityPorts = (ArrayList) cityPort.clone();
        this.AvailablePorts = CityPorts.size();
        this.HT = HT;
        seqSet = new ArrayList();
        
        seqSet.add(firstCity);
        CityPorts.set(firstCity, false);
        this.AvailablePorts--;
        
        //CALLS METHODS TO DO THEIR WORK
        merge(Set1,Set2);
        calMileage();
    }    
   
    /***************************************************************************
    ***METHOD NAME: createSet()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CREATE A SET OF RANDOM NUMBERS BETWEEN O - 9
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER 2018
    ***************************************************************************/
    private void createSet()
    {
        Random rand = new Random();
        int r = 0;
        
            while(AvailablePorts > 0)
            {
                r = rand.nextInt(this.CityPorts.size());

                if((boolean)this.CityPorts.get(r) != false)
                {
                    seqSet.add(r);
                    this.CityPorts.set(r, false);
                    AvailablePorts --;

                }
            }

    }
    /***************************************************************************
    ***METHOD NAME: calMileage()
    ***METHOD AUTHOR: LUIS E. VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CALCULATE THE MILES TRAVELED
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER 2018
    ***************************************************************************/   
    private void calMileage()
    {       
        this.mileage = 0;
        
        for(int i=0; i < this.seqSet.size() - 1; i++)
        {
            this.mileage += HT.getMiles((int)this.seqSet.get(i), (int)this.seqSet.get(i+1));
        
        }
        
        this.mileage += HT.getMiles((int)this.seqSet.get(0), (int)this.seqSet.get(this.seqSet.size() - 1));
        
        //System.out.print(" " +this.mileage + "\n"); 
    }
    
    
    public double getMiles()
    {
        return this.mileage;
    }
    
    public ArrayList getSet(){return seqSet;};
    
    /***************************************************************************
    ***METHOD NAME: merge()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: MERGE TO ENTITY'S SETS TO CREATE ONE
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: ENTITY, ENTITY
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/    
    private void merge(Entity Child1, Entity Child2)
    {
        int k =0;
        
        for(int i=0; i < this.CityPorts.size();i++)
        {
            try
            {
                if(i==0)
                {
                    //this.seqSet.add(Child1.getSet().get(i));
                    //this.CityPorts.set(4, false);
                    //this.AvailablePorts--;
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
            catch(Exception ex){}
        }
        //System.out.println("            Available ports " + this.AvailablePorts);
        if(AvailablePorts >0)
        {
            Random rand = new Random();
            int r = 0;

            while(AvailablePorts > 0)
            {
                r = rand.nextInt(this.CityPorts.size());
                //System.out.println("rand  " + r);
                
                if((boolean)this.CityPorts.get(r) != false)
                {
                    
                    seqSet.add(r);
                    this.CityPorts.set(r, false);
                    AvailablePorts --;
                    //System.out.println("value:"+r +"   Available ports " + AvailablePorts);
                    //break;
                }
            }
        }
        
        //System.out.println("                CHILD SIZE " + this.seqSet.size());
        
        
        
        
        
//        for(int i=0; i < this.seqSet.size(); i++)
//        {
//            System.out.print(this.seqSet.get(i) + "  ");
//        }
    
    
    }
    
    /***************************************************************************
    ***METHOD NAME: mutate()
    ***METHOD AUTHOR: LUIS E VARGAS TAMAYO
    ****************************************************************************
    ***PURPOSE OF THE METHOD: CHANGE THE VALUE OF TWO INDEXES IN A SET
    ***METHOD USED: NONE
    ***METHOD PARAMETERS: NONE
    ***RETURN VALUE: NONE
    ****************************************************************************
    ***DATE: 13 OCTOBER, 2018
    ***************************************************************************/    
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
        
//        for(int i=0; i < this.seqSet.size(); i++)
//        {
//            System.out.print(this.seqSet.get(i) + "  ");
//        }

        this.calMileage();
        
        
        
        
        
    }
}
