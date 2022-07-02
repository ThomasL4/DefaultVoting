import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class Voter {
    private Representative representative;
    private String name;
    private String dob;
    private String SSN;
    private boolean validVoter;

    private HashMap<Issue,Boolean> Votes = new HashMap();

    Voter (String name,Representative representative, String dob, String SSN, boolean validVoter){
        this.name = name;
        this.representative = representative;
        this.dob = dob;
        this.SSN = SSN;
        this.validVoter = validVoter;
    }

    public boolean getRepresentativeVote(Issue issue){
        return representative.vote(issue);
    }
    public void recieveIssues(Stack<Issue> issues){ //boolean vote system. could easily implement numerical votes.
        for (int i = 0; i < issues.size(); i++){
            if (!Votes.containsKey(issues.get(i))) { //this needs voter logic. random should do for now
                Random rand = new Random();
                int v = rand.nextInt(3);
                if (v == 2){
                    issues.get(i).addDefaultVote();
                    Votes.put(issues.get(i), getRepresentativeVote(issues.get(i)));
                    issues.get(i).voted(Votes.get(issues.get(i)));
                } else if (v == 1) {
                    Votes.put(issues.get(i), true);
                    issues.get(i).voted(Votes.get(issues.get(i)));
                } else{
                    Votes.put(issues.get(i), false);
                    issues.get(i).voted(Votes.get(issues.get(i)));
                }
            }
        }
    }
}
