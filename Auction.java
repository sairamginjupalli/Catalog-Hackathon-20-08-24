class Auction {
    private String itemName;
    private double startingPrice;
    private double highestBid;
    private User highestBidder;
    private boolean isClosed;

    public Auction(String itemName, double startingPrice) {
        this.itemName = itemName;
        this.startingPrice = startingPrice;
        this.highestBid = 0.0;
        this.isClosed = false;
    }

    public String getItemName() {
        return itemName;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public User getHighestBidder() {
        return highestBidder;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void placeBid(User bidder, double bidAmount) {
        if (isClosed) {
            System.out.println("Auction is closed.");
            return;
        }
        if (bidAmount > highestBid && bidAmount >= startingPrice) {
            highestBid = bidAmount;
            highestBidder = bidder;
            System.out.println("Bid placed successfully by " + bidder.getUsername());
        } else {
            System.out.println("Bid amount is too low.");
        }
    }

    public void closeAuction() {
        isClosed = true;
        System.out.println("Auction closed for item: " + itemName);
    }
}
