package formula.stateFormula;

import model.*;

public class AtomicProp extends StateFormula {
    public final String label;

    public AtomicProp(String label) {
        this.label = label;
    }

    public boolean check(Model model){}

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append(" " + label + " ");
    }

}
