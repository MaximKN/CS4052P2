package formula.pathFormula;

import formula.*;
import formula.stateFormula.*;
import java.util.Set;
import model.Model;

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

         if (this.stateFormula instanceof AtomicProp){
            AtomicProp a = (AtomicProp) this.stateFormula;
            State[] allStates = model.getStates(); 
            State initial = null; 

            for(State s : allStates){

                if(s.isInit){

                    initial = s; 
                    break; 
                 }
            }
            //checks the initial state and if it contains the correct path 
            String[] labels = initial.getLabels)();
            boolean contains = false; 
            for(String l : labels){
                if(l.equals(a.label)){
                    contains = true; 
                }
            }
            if(!contains){
                return false; 
            }

             //checks the next states to see if they contain correct paths 
             Trasition[] allTrans = model.getTransitions(); 
             ArrayList<State> neighbors = new ArrayList<state>();
             neighbors.add(initial);

             // BFS breadth first search implemenation 
            while(!neighbors.isEmpty()){

                for(Transition t : allTrans){
                    if(t.getSource().equals(neighbors.get(0).getLabel()){
                        
                        neighbors.add(t.getTarget);
                     }
                 }
                //remove state and continue to next state
                neighbors.remove(0);

                //now check the next states to see if they contain correct labels
                //change while to until
             }
         return true; 

        }

    }


}
