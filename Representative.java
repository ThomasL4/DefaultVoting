import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class Representative {

    private int ID;
    private HashMap<Issue,Boolean> Votes = new HashMap();
    Representative(int id){
        ID = id;
    }
    public void showVotes(){
        for (Issue key : Votes.keySet()){
//            System.out.println(getID() + ": " + key.Issue() + " " + Votes.get(key));
        }
    }

    public void recieveIssues(Stack<Issue> issues){ //boolean vote system. could easily implement numerical votes.
        Random rand = new Random();
        for (int i = 0; i < issues.size(); i++){
            Issue issue = issues.get(i);
            if (!Votes.containsKey(issue)) { //this needs voter logic. random should do for now

                boolean v = rand.nextBoolean();
                Votes.put(issue, v);
//            System.out.println(issue);
            }
        }

    }
    public int getID() {return ID;}

    public boolean vote(Issue i) {return Votes.get(i); }

}
