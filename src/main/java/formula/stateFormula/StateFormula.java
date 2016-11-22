package formula.stateFormula;

import model.*;

public abstract class StateFormula {
    public abstract void writeToBuffer(StringBuilder buffer);
    
    // Added
    public abstract boolean check(Model model);

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        writeToBuffer(buffer);
        return buffer.toString();
    }
}
