import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AuctionSystem {
    private List<User> users;
    private List<Auction> auctions;

    public AuctionSystem() {
        users = new ArrayList<>();
        auctions = new ArrayList<>();
    }

    public void registerUser(String username, boolean isAuctioneer) {
        User user = new User(username, isAuctioneer);
        users.add(user);
        System.out.println("User " + username + " registered successfully.");
    }

    public User loginUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("User " + username + " logged in successfully.");
                return user;
            }
        }
        System.out.println("User not found.");
        return null;
    }

    public void createAuction(User auctioneer, String itemName, double startingPrice) {
        if (!auctioneer.isAuctioneer()) {
            System.out.println("Only auctioneers can create auctions.");
            return;
        }
        Auction auction = new Auction(itemName, startingPrice);
        auctions.add(auction);
        auctioneer.addAuction(auction);
        System.out.println("Auction created for item: " + itemName);
    }

    public void listAuctions() {
        if (auctions.isEmpty()) {
            System.out.println("No auctions available.");
            return;
        }
        for (int i = 0; i < auctions.size(); i++) {
            Auction auction = auctions.get(i);
            System.out.println((i + 1) + ". " + auction.getItemName() + " - Highest Bid: $" + auction.getHighestBid());
        }
    }

    public Auction getAuction(int index) {
        if (index >= 0 && index < auctions.size()) {
            return auctions.get(index);
        }
        System.out.println("Invalid auction index.");
        return null;
    }
}
