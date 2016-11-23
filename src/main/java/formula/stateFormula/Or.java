package formula.stateFormula;

import model.*;

public class Or extends StateFormula {
    public final StateFormula left;
    public final StateFormula right;

    public Or(StateFormula left, StateFormula right) {
        this.left = left;
        this.right = right;
    }

    public boolean check(Model model){
        return false;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append("(");
        left.writeToBuffer(buffer);
        buffer.append(" || ");
        right.writeToBuffer(buffer);
        buffer.append(")");
    }

//************************************** New Code **********************************

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
