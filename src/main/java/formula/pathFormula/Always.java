package formula.pathFormula;

import formula.FormulaParser;
import formula.stateFormula.*;
import java.util.*;
import model.*;

public class Always extends PathFormula {
    public final StateFormula stateFormula;
    private Set<String> actions = new HashSet<String>();

    public Always(StateFormula stateFormula, Set<String> actions) {
        this.stateFormula = stateFormula;
        this.actions = actions;
    }

    public Set<String> getActions() {
        return actions;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append(FormulaParser.ALWAYS_TOKEn);
        stateFormula.writeToBuffer(buffer);
        ;

    }


    //********************************* New Code ********************************

    //check method always 
    public boolean check(Model model){ 

        if (this.stateFormula instanceof AtomicProp){
            State[] allStates = model.getStates(); 

            for(State s : allStates){

                String[] labels = s.getLabel();
                boolean contains = false;

                for(String l : labels){ 
                    if(l.equals(this.stateFormula.label)){
                        contains = true; 
                    }
                }

                if( !contains){
                    return false;
                }

            }
            return true; 
        }


    }

}
