/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_1901040060;

import utils.AttrRef;

/**
 *
 *@overview 
 * A factory to create PC objects
 */
public class PCFactory {
   /**
     * a single object of this class
     */
    private static PCFactory instance;
    /**
     * @effect private static PCFactory instance;
     */
    private PCFactory(){
        
    }
    /**
     * @effect if instance = null
     * initialise it
     * return instance
     */
    public static PCFactory getInstance(){
        if(instance==null){
            instance = new PCFactory();
        }
        return instance;
    }
    /**
     * @effects
     * create and return new PC:<model, year, manufacturer, comps>
     */
    public PC createPC(@AttrRef("model") String model,@AttrRef("year") int year,@AttrRef("manufacturer") String manufacturer,@AttrRef("comps") Set<String> comps){
        PC pc = new PC(model,year,manufacturer,comps);
        return pc;
    }
}
