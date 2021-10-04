package a3_1901040060;
import utils.DomainConstraint;
import utils.AttrRef;
import utils.DOpt;
import utils.NotPossibleException;
import utils.OptType;
/**
 * @overview PC is personal computer class
 * @attributes 
 *  model         String 
 *  year          Integer
 *  manufacturer  String
 *  comps         Set
 * @object A typical PC is <md , y , manu , c> where model(md) , year(y) , manufacturer(m) and comps(c)
 * @abstract_properties
 *   mutable(model)=true /\ optional(model)=false /\ length(model)=20 /\ 
 *   mutable(year)=false /\ optional(year)=false /\ min(year)=1940 /\ 
 *   mutable(manufacturer)=false /\ optional(manufacturer)=false /\ length(manufacturer)=20 /\ 
 *   mutable(comps)=true /\ optional(comps)=false 
 */
public class PC {	   
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 20)
     private String model;
	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1940)
     private int year;
	@DomainConstraint(type = "String", mutable = false, optional = false, length = 20)
     private String manufacturer;
	@DomainConstraint(type = "Set", mutable = true, optional = false)
     private Set<String> comps;	  
        // CONSTRUCTORS
	/**
	 * 	Construct a typical PC object
	 * 
	 * @effects <pre>
	 * if model, year, manufacturer, comps are valid
	 * 		initialise this as <model, year, manufacturer, comps>
	 * else
	 * 		initialise this as <> and print error
	 * </pre>
	 */
     public PC( @AttrRef("model")String model, @AttrRef("year")int year,
    		 @AttrRef("manufacturer")String manufacturer, @AttrRef("comps")Set<String> comps) {
		
    	 if (!validateModel(model)) {
		       throw new NotPossibleException("Employee.init: invalid model: " + model);		      
		    }
    	 if (!validateYear(year)) {
		      throw new NotPossibleException("Employee.init: invalid year: " + year);
		    }
    	 if (!validateManufacturer(manufacturer)) {
		      throw new NotPossibleException("Employee.init: invalid manufacturer: " + manufacturer);
		    }
    	 if (!validateComps(comps)) {
		      throw new NotPossibleException("Employee.init: invalid comps: " + comps);
		    } 
		this.model = model;
		this.year = year;
		this.manufacturer = manufacturer;
		this.comps = comps;
	}
     //setter
            /**
            * @modifies model
            * 
            * @effects 
            *  if model is valid
            *      set this.model = model
            *      return true
            *  else
            *      return false
            */       
     @DOpt(type=OptType.Mutator) @AttrRef("model")
 	public boolean setModel(String model) {
 		if (validateModel(model)) {
		      this.model = model;
		      return true;
		    } else {
		      return false;
		    }
 	}
            /**
            * @modifies comps
            * 
            * @effects 
            *  if comps is valid
            *      set this.comps = comps
            *      return true
            *  else
            *      return false
            */
     @DOpt(type=OptType.Mutator) @AttrRef("comps")
 	public boolean setComps(Set<String> comps) {
 		if (validateComps(comps)) {
		      this.comps = comps;
		      return true;
		    } else {
		      return false;
		    }
 	}
     //getter
        /**
        * @effects return model
        */
	@DOpt(type=OptType.Observer) @AttrRef("model")     
     public String getModel() {
 		return this.model;
 	}
        /**
        * @effects return year
        */  
 	@DOpt(type=OptType.Observer) @AttrRef("year")
 	public int getYear() {
 		return this.year;
 	}
 	/**
        * @effects return manufacturer
        */	
 	@DOpt(type=OptType.Observer) @AttrRef("manufacturer")
 	public String getManufacturer() {
 		return this.manufacturer;
 	}
	 /**
         * @effects return comps
         */
 	@DOpt(type=OptType.Observer) @AttrRef("comps")
 	public Set<String> getComps() {
 		return this.comps;
 	}
        
        
	/**
        * @effects 
        *  if model is valid 
        *      return true 
        *  else 
        *      return false
        */
        @DOpt(type = OptType.Helper)
 	private boolean validateModel(String model) {
	    return (model != null && model.length() > 0 && model.length() <= 20);
	  }
 	
	
        /**
        * @effects 
        *  if year is valid 
        *      return true 
        *  else 
        *      return false
        */
        @DOpt(type = OptType.Helper)
 	private boolean validateYear(int year) {
	    return (year >= 1940);
	  }
 	 /**
         * @effects 
         *  if manufacturer is valid 
         *      return true 
         *  else 
         *      return false
         */
        @DOpt(type = OptType.Helper)
 	private boolean validateManufacturer(String manufacturer) {
	    return (manufacturer != null && manufacturer.length() > 0 && manufacturer.length() <= 20);
        }
 	/**
        * @effects 
        *  if comps is valid 
        *      return true 
        *  else 
        *      return false
        */
        @DOpt(type = OptType.Helper)
 	private boolean validateComps(Set comps) {

	    return (comps != null);
	  }
 	
        @Override        
	  public String toString() {
            	    return "PC:<" + model + "," + year + "," + manufacturer + "," + comps.toString() + ">";
          
          }
 	/**
        * @effects 
        * 
        * if this is all valid with abstract properties
        * return true  
        * 
        */
 	public boolean repOK() {
		return validateModel(model) && validateYear(year)
				&& validateManufacturer(manufacturer) && validateComps(comps);
	}
}
