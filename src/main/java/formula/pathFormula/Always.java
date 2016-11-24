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

    public boolean check(Model model){
        return true;
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
    public boolean check(Model model, State s){ 

        if (this.stateFormula instanceof AtomicProp){
            AtomicProp a = (AtomicProp) this.stateFormula;

            String[] labels = s.getLabel();
            boolean contains = false;

            for(String l : labels){
                if(l.equals(a.label)){
                    contains = true; 
                }
            }

            if( !contains){
                return false;
            }

            return contains; 
        }
        
        return false;

    }

}
