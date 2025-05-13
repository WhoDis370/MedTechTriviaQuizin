public class SavedPlayers {
    int savedScore;
    String savedName;
    int savedSize;
    int savedRounds;

    public SavedPlayers(int savedScore, String savedName, int savedSize, int savedRounds) {
        this.savedScore = savedScore;
        this.savedName = savedName;
        this.savedSize = savedSize;
        this.savedRounds = savedRounds;
    }

    public int getSavedScore() { return savedScore; }
    public String getSavedName() { return savedName; }
    public int getSavedSize() { return savedSize; }
    public int getSavedRounds() { return savedRounds; }
}
