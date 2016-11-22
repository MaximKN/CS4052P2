package formula.stateFormula;

import model.*;

public class BoolProp extends StateFormula {
    public final boolean value;

    public BoolProp(boolean value) {
        this.value = value;
    }

    public boolean check(Model model){}

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        String stringValue = (value) ? "True" : "False";
        buffer.append(" " + stringValue + " ");
    }

}
