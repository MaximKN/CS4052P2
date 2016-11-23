package formula.pathFormula;

import formula.FormulaParser;
import formula.stateFormula.*;
import java.util.*;
import model.*;

public class Eventually extends PathFormula {
    public final StateFormula stateFormula;
    private Set<String> leftActions;
    private Set<String> rightActions;

    public Eventually(StateFormula stateFormula, Set<String> leftActions, Set<String> rightActions) {
        super();
        this.stateFormula = stateFormula;
        this.leftActions = leftActions;
        this.rightActions = rightActions;
    }

    public Set<String> getLeftActions() {
        return leftActions;
    }

    public Set<String> getRightActions() {
        return rightActions;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append(FormulaParser.EVENTUALLY_TOKEN);
        stateFormula.writeToBuffer(buffer);
        ;
    }

    //********************************* New Code ***********************************



    //check method for eventually 
    public boolean check(Model model, State s){ 
        
        if (this.stateFormula instanceof AtomicProp){
            AtomicProp a = (AtomicProp) this.stateFormula;
            String[] labels = s.getLabel();

            for(String l : labels){ 
                if(l.equals(a.label)){
                    return true; 
                }
            }
        } 
        return false;
    }

}
