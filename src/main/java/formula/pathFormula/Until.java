package formula.pathFormula;

import formula.*;
import formula.stateFormula.*;
import java.util.Set;
import model.*;
import java.util.*;

public class Until extends PathFormula {
    public final StateFormula left;
    public final StateFormula right;
    private Set<String> leftActions;
    private Set<String> rightActions;

    public Until(StateFormula left, StateFormula right, Set<String> leftActions, Set<String> rightActions) {
        super();
        this.left = left;
        this.right = right;
        this.leftActions = leftActions;
        this.rightActions = rightActions;
    }

    public Set<String> getLeftActions() {
        return leftActions;
    }

    public Set<String> getRightActions() {
        return rightActions;
    }

    @Override
    public void writeToBuffer(StringBuilder buffer) {
        buffer.append("(");
        left.writeToBuffer(buffer);
        buffer.append(" " + FormulaParser.UNTIL_TOKEN + " ");
        right.writeToBuffer(buffer);
        buffer.append(")");
    }

    //**************************** New Code ************************

    public boolean check(Model model){ 
            AtomicProp a = (AtomicProp) this.left;
            State[] allStates = model.getStates(); 
            State initial = null; 

            for(State s : allStates){
                if(s.isInit()){
                    initial = s; 
                    break; 
                 }
            }
             //checks the next states to see if they contain correct paths 
             Transition[] allTrans = model.getTransitions(); 
             ArrayList<State> neighbors = new ArrayList<State>();
             neighbors.add(initial);
             boolean contains = false; 

             // BFS breadth first search implemenation 
            while(!neighbors.isEmpty()){
                for(Transition t : allTrans){
                    if(t.getSource().equals(neighbors.get(0).getLabel())){
                        for(State s : allStates){
                            if(s.getName().equals(t.getTarget())){
                                neighbors.add(s);
                            }
                        }
                     }
                }

                String[] nodeLabels = neighbors.get(0).getLabel();
                for(String l : nodeLabels){
                    if(l.equals(a.label)){
                        contains = true; 
                    }
                }
                if(!contains){
                    return false; 
                }
                //remove state and continue to next state
                neighbors.remove(0);

                //now check the next states to see if they contain correct labels
                //change while to until
            }
            return contains; 
        }
    
}
