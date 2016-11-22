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


        
    }

    //return all paths 
    @Override
    public String[] getTrace() {
       
        return null;
    }


    // constraint must be applied to the model 
    //the checker will only take into account the paths that satisfy c 
    //c is the constraint 
    private void applyConstraint(Model m, State c) {
        
        labelModel(m, c, null);

        for (lsv.god.model.State st : m.getStates()) {
            if (st.labeledWith.contains(c.toString())) {
                st.labeledWith.clear();
                st.fair = true;
                st.labeledWith.add("True");
            }
        }
    }

}
