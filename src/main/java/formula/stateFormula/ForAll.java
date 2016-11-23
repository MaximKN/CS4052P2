package formula.stateFormula;

import formula.*;
import model.*;
import formula.pathFormula.*;

public class ForAll extends StateFormula {

    public final PathFormula pathFormula;

    public ForAll(PathFormula pathFormula) {
        this.pathFormula = pathFormula;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {

        buffer.append("(");
        buffer.append(FormulaParser.FORALL_TOKEN);
        pathFormula.writeToBuffer(buffer);
        buffer.append(")");
    }
    
//******************** New Code ******************************

    //check method to see if for all quantifier exists 
    public boolean check (Model model) { 
<<<<<<< HEAD
        if(this.pathFormula instanceof Always){
            return this.pathFormula.check(model); 
        }
        else if(this.pathFormula instanceof Eventually){
            return this.pathFormula.check(model); 
        }
        else if(this.pathFormula instanceof Next){ 
            return this.pathFormula.check(model);   
        }
        else if(this.pathFormula instanceof Until){
            return this.pathFormula.check(model); 
=======

        if( this.pathFormula instanceof Always || this.pathFormula instanceof Eventually || this.pathFormula instanceof Next){

            boolean contains = true;
            //get all of the states within the model 
            State[] allStates = model.getStates(); 
            //traverse all the states and make sure all states always contain 
            for(State s : allStates){

                if(!this.pathFormula.check(model,s)){
                    contains = false; 
                }

            }
            return contains;
        }
        else if( this.pathFormula instanceof Until){
            State[] allStates = model.getStates(); 
            return this.pathFormula.check(model, allStates.get(0)); 
>>>>>>> 8f39788c26875c364cb0d39032b1ebe925193f3c
        }
        else{
         return false; 
        }
    }
}
