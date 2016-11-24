package formula.stateFormula;

import formula.FormulaParser;
import formula.pathFormula.*;
import model.*;

public class ThereExists extends StateFormula {
    public final PathFormula pathFormula;

    public ThereExists(PathFormula pathFormula) {
        this.pathFormula = pathFormula;
    }

    public boolean check(Model model, State s){
        return false;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append("(");
        buffer.append(FormulaParser.THEREEXISTS_TOKEN);
        pathFormula.writeToBuffer(buffer);
        buffer.append(")");
    }

    public boolean check (Model model) { 
        if(this.pathFormula instanceof Always || this.pathFormula instanceof Eventually || this.pathFormula instanceof Next){
            State[] states = model.getStates();

            for (State s : states){
                if (this.pathFormula.check(model)){
                    return true;
                } 
            }

            return false;
        }
        else if(this.pathFormula instanceof Until){
            State[] allStates = model.getStates(); 
            return this.pathFormula.check(model, allStates[0]); 
        }
        else{
            return false; 
        }
    }
}
