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
    
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append("(");
        left.writeToBuffer(buffer);
        buffer.append(" && ");
        right.writeToBuffer(buffer);
        buffer.append(")");
    }

}
