package formula.stateFormula;

import model.*;
import formula.FormulaParser;

public class Not extends StateFormula {
    public final StateFormula stateFormula;

    public Not(StateFormula stateFormula) {
        this.stateFormula = stateFormula;
    }

    public boolean check(Model model){}

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append(FormulaParser.NOT_TOKEN);
        buffer.append("(");
        stateFormula.writeToBuffer(buffer);
        buffer.append(")");
    }

}
