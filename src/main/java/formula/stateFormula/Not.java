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
    
        if( this.pathFormula instanceof Always){

    
        }
        else if( this.pathFormula instanceof Eventually){
          
        }
        else if( this.pathFormula instanceof Next){ 
        
   
        }
        else if( this.pathFormula instanceof Until){

        }
        else{
            return false; 
        }
    }

}
