package POJO.Response;

public class ShuffleCardsResponse {



    boolean success;
    String deck_id;
    String remaining;
    String shuffled;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public String getShuffled() {
        return shuffled;
    }

    public void setShuffled(String shuffled) {
        this.shuffled = shuffled;
    }
}
