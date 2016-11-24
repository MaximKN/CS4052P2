package modelChecker;

import formula.stateFormula.*;
import model.Model;
import java.util.ArrayList;

public class SimpleModelChecker implements ModelChecker {

    ArrayList<String> trace = new ArrayList<String>();

    @Override
    public boolean check(Model model, StateFormula constraint, StateFormula query) {
     
     //begin traversing asCTL query and first first state propostion 
     // figure out which state type it is 

    //parse the fairness constraints and then make an intersection between asCTL and Fairness

        if (constraint instanceof AtomicProp && query instanceof AtomicProp ||
            constraint instanceof ForAll && query instanceof ForAll||
            constraint instanceof ThereExists && query instanceof ThereExists ||
            constraint instanceof Not && query instanceof Not){
            return constraint.check(model) && query.check(model);
        } else {
            trace.add(constraint.toString());
            trace.add(String.valueOf(constraint.check(model)));
            
            if (!constraint.check(model)){
                
            }
            
            trace.add(query.toString());
            trace.add(String.valueOf(query.check(model)));
            
            if (!query.check(model)){
                 
            }

            return false;
        }
    }

    //return all paths 
    @Override
    public String[] getTrace() {
        return trace.toArray(new String[trace.size()]);
    }
}
