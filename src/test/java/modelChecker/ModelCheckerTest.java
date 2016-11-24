package modelChecker;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import formula.FormulaParser;
import formula.stateFormula.StateFormula;
import modelChecker.ModelChecker;
import modelChecker.SimpleModelChecker;
import model.Model;

public class ModelCheckerTest {


    @Test
    public void checkForAllAlways() {
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula query = new FormulaParser("src/test/resources/ctlForAllAlways.json").parse();
            ModelChecker mc = new SimpleModelChecker();

            assertFalse(mc.check(model, query, query));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void checkForAllEventually() {
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula query = new FormulaParser("src/test/resources/ctlForAllEventially.json").parse();
            ModelChecker mc = new SimpleModelChecker();

            assertTrue(mc.check(model, query, query));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void checkNext() {
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula query = new FormulaParser("src/test/resources/ctlNext.json").parse();
            ModelChecker mc = new SimpleModelChecker();

            assertTrue(mc.check(model, query, query));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void checkUntil() {
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula query = new FormulaParser("src/test/resources/ctlUntil.json").parse();
            ModelChecker mc = new SimpleModelChecker();

            assertTrue(mc.check(model, query, query));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }


    @Test
    public void checkThereExists() {
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula query = new FormulaParser("src/test/resources/ctlThereExists.json").parse();
            ModelChecker mc = new SimpleModelChecker();

            assertTrue(mc.check(model, query, query));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void checkForAllAlwaysConstrain() {
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula query = new FormulaParser("src/test/resources/ctlForAllAlways.json").parse();
            StateFormula constrain = new FormulaParser("src/test/resources/constraint1.json").parse();

            ModelChecker mc = new SimpleModelChecker();

            assertFalse(mc.check(model, constrain, query));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }

    }

    @Test
    public void checkForAllEventuallyConstrain() {
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula query = new FormulaParser("src/test/resources/ctlForAllEventially.json").parse();
            ModelChecker mc = new SimpleModelChecker();
            StateFormula constrain = new FormulaParser("src/test/resources/constraint1.json").parse();

            assertFalse(mc.check(model, constrain, query));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void checkNextConstrain() {
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula query = new FormulaParser("src/test/resources/ctlNext.json").parse();
            ModelChecker mc = new SimpleModelChecker();
            StateFormula constrain = new FormulaParser("src/test/resources/constraint1.json").parse();

            assertFalse(mc.check(model, constrain, query));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void checkUntilConstrain() {
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula query = new FormulaParser("src/test/resources/ctlUntil.json").parse();
            ModelChecker mc = new SimpleModelChecker();
            StateFormula constrain = new FormulaParser("src/test/resources/constraint1.json").parse();

            assertFalse(mc.check(model, constrain, query));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }


    @Test
    public void checkThereExistsConstrain() {
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula constrain = new FormulaParser("src/test/resources/ctlThereExists.json").parse();
            StateFormula query = new FormulaParser("src/test/resources/ctlThereExists.json").parse();
            ModelChecker mc = new SimpleModelChecker();
            assertTrue(mc.check(model, constrain, query));
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

    @Test
    public void checkGetTrace(){
        try {
            Model model = Model.parseModel("src/test/resources/simpleModel1.json");
            StateFormula constrain = new FormulaParser("src/test/resources/constraint1.json").parse();
            StateFormula query = new FormulaParser("src/test/resources/ctlThereExists.json").parse();
            ModelChecker mc = new SimpleModelChecker();
            assertTrue(mc.check(model, constrain, query));

        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }

}
