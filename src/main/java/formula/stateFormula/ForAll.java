package formula.stateFormula;

import formula.*;
import model.*;
import formula.pathFormula.*;

public class ForAll extends StateFormula {

    public final PathFormula pathFormula;

    public ForAll(PathFormula pathFormula) {
        this.pathFormula = pathFormula;
    }

    public boolean check(Model model, State s){
        return true;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {

        buffer.append("(");
        buffer.append(FormulaParser.FORALL_TOKEN);
        pathFormula.writeToBuffer(buffer);
        buffer.append(")");
    }
    
//******************** New Code ******************************

    private String trace = "";

    //check method to see if for all quantifier exists 
    public boolean check (Model model) { 
        if( this.pathFormula instanceof Always || this.pathFormula instanceof Eventually || 
            this.pathFormula instanceof Next || this.pathFormula instanceof Until){
            boolean contains = true;
            //get all of the states within the model 
            State[] allStates = model.getStates(); 
            //traverse all the states and make sure all states always contain 
            for(State s : allStates){
                if(!this.pathFormula.check(model,s)){
                    trace = this.pathFormula.toString();
                    contains = false; 
                }
            }
            return contains;
        }

        return false;
    }

    public String getTrace(){
        return trace;
    }
}
