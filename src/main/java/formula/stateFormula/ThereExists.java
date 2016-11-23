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
//************************** New Code **************************
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