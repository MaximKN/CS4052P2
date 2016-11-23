package formula.stateFormula;

import formula.*;
import model.*;
import formula.pathFormula.*;

public class ForAll extends StateFormula {

    public final PathFormula pathFormula;

    public ForAll(PathFormula pathFormula) {
        this.pathFormula = pathFormula;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {

        buffer.append("(");
        buffer.append(FormulaParser.FORALL_TOKEN);
        pathFormula.writeToBuffer(buffer);
        buffer.append(")");
    }
    
//******************** New Code ******************************

    //check method to see if for all quantifier exists 
    public boolean check (Model model) { 
        if( this.pathFormula instanceof Always){
            return this.pathFormula.check(model); 
        }
        else if( this.pathFormula instanceof Eventually){
            return this.pathFormula.check(model); 
        }
        else if( this.pathFormula instanceof Next){ 
            return this.pathFormula.check(model);   
        }
        else if( this.pathFormula instanceof Until){
            return this.pathFormula.check(model); 
        }
        else{
        }

        return false; 
    }
}
