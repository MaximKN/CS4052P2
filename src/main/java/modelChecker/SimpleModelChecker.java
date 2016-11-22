package modelChecker;

import formula.stateFormula.StateFormula;
import model.*;
import java.util.*;


public class SimpleModelChecker implements ModelChecker {

    @Override
    public boolean check(Model model, StateFormula constraint, StateFormula query) {
        System.out.println(model.toString());
        System.out.println(query.toString());        
        return true;
    }

    @Override
    public String[] getTrace() {
        // TODO Auto-generated method stub
        return null;
    }

}
