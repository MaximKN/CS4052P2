package formula.stateFormula;

import model.*;
import formula.FormulaParser;

public class Not extends StateFormula {
    public final StateFormula stateFormula;

    public Not(StateFormula stateFormula) {
        this.stateFormula = stateFormula;
    }

    public boolean check(Model model, State s){
        return false;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append(FormulaParser.NOT_TOKEN);
        buffer.append("(");
        stateFormula.writeToBuffer(buffer);
        buffer.append(")");
    }

    //************************************ New Code **************************
    
    private String trace = "";

    public boolean check (Model model) { 
       if(this.stateFormula instanceof ForAll || this.stateFormula instanceof ThereExists){

            if (!this.stateFormula.check(model)){
                return true;
            } else {
                trace = this.stateFormula.toString();
                return false;
            }
    
        }
        else{
            return false; 
        }
     
    }
   
    public String getTrace(){
        return trace;
    }


}
