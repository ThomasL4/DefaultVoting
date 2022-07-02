import java.util.LinkedList;
import java.util.Stack;

public class ItDoe {
    static Stack<Issue> issues = new Stack<>();

    public static void addIssues(int issueSize){
        for (int i = 0; i < issueSize; i++){
            System.out.println(i);
            issues.add(new Issue("Problem " + i + "_1"));
        }

//        issues.add(new Issue("Problem 2"));
//        issues.add(new Issue("Problem 3"));
        System.out.println("size " + issues.size());

    }

    public static void addIssue(Issue issue){
        issues.add(issue);
    }

    public static void main(String args[]) {
        Voter[] voterPool = new Voter[10000];
        Representative[] RepresentativePool = new Representative[200];

//        addIssue(new Issue("xx"));
        addIssues(200);


        int i = 0;
        for (Representative R : RepresentativePool) {

            R = new Representative(i);
            RepresentativePool[i] = R;
            R.recieveIssues(issues);

            R.showVotes();
            i++;
        }
//        System.out.println(voterPool[2]);
        int j = 0;
        for (Voter v : voterPool) {
            v = new Voter("h", RepresentativePool[j++% RepresentativePool.length], "b", "g", true);
            v.recieveIssues(issues);
        }
//        System.out.println("asd");
        do{
//            System.out.println(issues.size());
            issues.pop().displayVotes();
//            System.out.println(issues.size());
        }while(!issues.isEmpty());
//        theProblem.displayVotes();



    }
}
