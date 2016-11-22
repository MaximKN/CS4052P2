package formula.pathFormula;

import formula.FormulaParser;
import formula.stateFormula.*;
import java.util.Set;
import model.Model;

public class Next extends PathFormula {
    public final StateFormula stateFormula;
    private Set<String> actions;

    public Next(StateFormula stateFormula, Set<String> actions) {
        this.stateFormula = stateFormula;
        this.actions = actions;
    }

    public Set<String> getActions() {
        return actions;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append(FormulaParser.NEXT_TOKEN);
        stateFormula.writeToBuffer(buffer);
        ;
    }
    //********************************* New Code ****************************


    //passes in an extra parameter in order to find the state we are looking at to find next state
    public boolean check(Model model, State originalState){ 

        if (this.stateFormula instanceof AtomicProp){
         State[] allStates = model.getStates(); 
         for(State s : allStates){

         }

        }
    }

}
