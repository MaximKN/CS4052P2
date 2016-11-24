package formula.stateFormula;

import model.*;

public class AtomicProp extends StateFormula {
    
    public final String label;

    public AtomicProp(String label) {
        this.label = label;
    }

    public boolean check(Model model){
        return true;
    }

    public boolean check(Model model, State s){
        return true;
    }

    public String getLabel(){
        return this.label;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append(label + " ");
    }

}


