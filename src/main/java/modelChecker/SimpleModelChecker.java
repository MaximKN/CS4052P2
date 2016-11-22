package modelChecker;

import formula.stateFormula.*;
import model.Model;


public class SimpleModelChecker implements ModelChecker {

    @Override
    public boolean check(Model model, StateFormula constraint, StateFormula query) {
     
     //begin traversing asCTL query and first first state propostion 
     // figure out which state type it is 
        if(query instanceof ForAll){ 
            //call ForAll check
            return query.check(model); 
        }

        else if(query instanceof And){
            //call And check

        }
        else if(query instanceof AtomicProp){
            //call AtomicProp check

        }
        else if(query instanceof BoolProp){
              //call BoolProp check 

        }
        else if(query instanceof Not){
            //call Not check 

        }
        else if(query instanceof Or){
            //call Or check 
        }
        else if(query instanceof ThereExists){
            //call ThereExists check 
        }

        return false;        
    }

    //return all paths 
    @Override
    public String[] getTrace() {
       
        return null;
    }

}
