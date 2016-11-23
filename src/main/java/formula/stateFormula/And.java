package formula.stateFormula;

import model.*;

public class And extends StateFormula {
    public final StateFormula left;
    public final StateFormula right;

    public And(StateFormula left, StateFormula right) {
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
        buffer.append(" && ");
        right.writeToBuffer(buffer);
        buffer.append(")");
    }


    //************************************* New Code ******************************

    public boolean check (Model model) { 

        if( this.left instanceof AtomicProp && this.right instanceof AtomicProp ||
            this.left instanceof ForAll && this.right instanceof ForAll||
            this.left instanceof ThereExist && this.right instanceof ThereExist ||
            this.left instanceof Not && this.right instanceof Not){

            if (this.left.check(model) && this.right.check(model)){
                return true;
            } else {
                return false;
            }
    
        }
        else if (this.left instanceof BoolProp && this.right instanceof BoolProp ){
         if (this.left.value && this.right.value){
                return true;
            } else {
                return false;
            }
        }
        else{
            return false; 
        }
    
   }

}
