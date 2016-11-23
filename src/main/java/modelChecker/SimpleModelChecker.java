package modelChecker;

import formula.stateFormula.*;
import model.Model;


public class SimpleModelChecker implements ModelChecker {

    @Override
    public boolean check(Model model, StateFormula constraint, StateFormula query) {
     
     //begin traversing asCTL query and first first state propostion 
     // figure out which state type it is 

    //parse the fairness constraints and then make an intersection between asCTL and Fairness

        if (constraint instanceof AtomicProp && query instanceof AtomicProp ||
            constraint instanceof ForAll && query instanceof ForAll||
            constraint instanceof ThereExist && query instanceof ThereExist ||
            constraint instanceof Not && query instanceof Not)){

            return constraint.check(model) && query.check(model);
            
        } else {

        }
    }

    //return all paths 
    @Override
    public String[] getTrace() {
       
        return null;
    }

}
