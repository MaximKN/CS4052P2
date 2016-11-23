package formula.pathFormula;

import model.*;

public abstract class PathFormula {
    public abstract void writeToBuffer(StringBuilder buffer);
    public abstract boolean check(Model model);
}
