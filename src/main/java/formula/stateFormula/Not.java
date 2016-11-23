package formula.stateFormula;

import model.*;
import formula.FormulaParser;

public class Not extends StateFormula {
    public final StateFormula stateFormula;

    public Not(StateFormula stateFormula) {
        this.stateFormula = stateFormula;
    }

    public boolean check(Model model){
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

    public boolean check (Model model) { 
       if(this.stateFormula instanceof ForAll || this.stateFormula instanceof ThereExists){

            if (!this.stateFormula.check(model)){
                return true;
            } else {
                return false;
            }
    
        }
        else if (this.stateFormula instanceof BoolProp){
           if (!this.stateFormula.value){
                return true;
            } else {
                return false;
            }

        else{
            return false; 
        }
     
    }

}
