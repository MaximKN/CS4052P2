package formula.stateFormula;

import model.*;

public class Or extends StateFormula {
    public final StateFormula left;
    public final StateFormula right;

    public Or(StateFormula left, StateFormula right) {
        this.left = left;
        this.right = right;
    }

    public boolean check(Model model, State s){
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
    private String trace = "";

    public String getTrace(){
        return trace;
    }

    public boolean check (Model model) { 
    
        if( this.left instanceof AtomicProp && this.right instanceof AtomicProp ||
            this.left instanceof ForAll && this.right instanceof ForAll||
            this.left instanceof ThereExists && this.right instanceof ThereExists ||
            this.left instanceof Not && this.right instanceof Not){

            if (!this.left.check(model) || !this.right.check(model)){
                trace = this.left.toString() + " " + this.right.toString();
                return false;
            } else {
                return true;
            }
        }
        else{
            return false; 
        }
    }
}
