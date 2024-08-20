import java.util.ArrayList;
import java.util.List;

class User {
    private String username;
    private boolean isAuctioneer;
    private List<Auction> myAuctions;

    public User(String username, boolean isAuctioneer) {
        this.username = username;
        this.isAuctioneer = isAuctioneer;
        this.myAuctions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean isAuctioneer() {
        return isAuctioneer;
    }

    public List<Auction> getMyAuctions() {
        return myAuctions;
    }

    public void addAuction(Auction auction) {
        myAuctions.add(auction);
    }
}
