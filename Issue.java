public class Issue {
    private String ID = "";
    private int voteCount;
    private int votesFor;
    private int votesAgainst;

    private int votesProxied;
    public Issue(String id){
        if (ID.isBlank()) {
            this.ID = id;
            System.out.println("here " + ID);
        }
    }

    public String Issue(){
        return ID;
    }
    public void displayVotes(){
        System.out.println();
        System.out.println("----For Issue \"" + this.Issue() + "\":  \nVotes For  " + votesFor + "\n" +
                            "Votes Against  " + votesAgainst + " \n" +
                            "Proxied Votes " + votesProxied + "\n" +
                            "Total Votes "+ voteCount + "\n");
    }
    public void addDefaultVote(){
        votesProxied++;
    }
    public void voted(boolean vote){
        voteCount+=1;
        if (vote){
            votesFor+=1;
        }
        else{
            votesAgainst+=1;
        }
    }
}
