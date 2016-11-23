package formula.stateFormula;

import formula.FormulaParser;
import formula.pathFormula.PathFormula;
import model.*;

public class ThereExists extends StateFormula {
    public final PathFormula pathFormula;

    public ThereExists(PathFormula pathFormula) {
        this.pathFormula = pathFormula;
    }

    public boolean check(Model model){
        return false;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append("(");
        buffer.append(FormulaParser.THEREEXISTS_TOKEN);
        pathFormula.writeToBuffer(buffer);
        buffer.append(")");
    }

    public boolean check(Model model){
        
    }

    public boolean check (Model model) { 
        if(this.pathFormula instanceof Always){
            return this.pathFormula.check(model); 
        }
        else if(this.pathFormula instanceof Eventually){
            State[] states = model.getStates();

            for (State s : states){
                if (this.pathFormula.check(model){
                    return true;
                } 
            }

            return false;
        }
        else if(this.pathFormula instanceof Next){ 
            return this.pathFormula.check(model);   
        }
        else if(this.pathFormula instanceof Until){
            return this.pathFormula.check(model); 
        }
        else{
        }
        return false;      
    }

}
