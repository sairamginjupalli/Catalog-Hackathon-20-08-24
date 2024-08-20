import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuctionSystem auctionSystem = new AuctionSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Online Auction System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Are you an auctioneer? (yes/no): ");
                String role = scanner.nextLine();
                boolean isAuctioneer = role.equalsIgnoreCase("yes");
                auctionSystem.registerUser(username, isAuctioneer);
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                User user = auctionSystem.loginUser(username);
                if (user != null) {
                    userMenu(user, auctionSystem, scanner);
                }
            } else if (choice == 3) {
                System.out.println("Exiting the system.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    public static void userMenu(User user, AuctionSystem auctionSystem, Scanner scanner) {
        while (true) {
            System.out.println("\n--- User Menu ---");
            if (user.isAuctioneer()) {
                System.out.println("1. Create Auction");
            }
            System.out.println("2. List Auctions");
            System.out.println("3. Bid on Auction");
            System.out.println("4. Close Auction (Auctioneer only)");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1 && user.isAuctioneer()) {
                System.out.print("Enter item name: ");
                String itemName = scanner.nextLine();
                System.out.print("Enter starting price: ");
                double startingPrice = scanner.nextDouble();
                scanner.nextLine();  // Consume newline
                auctionSystem.createAuction(user, itemName, startingPrice);
            } else if (choice == 2) {
                auctionSystem.listAuctions();
            } else if (choice == 3) {
                auctionSystem.listAuctions();
                System.out.print("Enter auction index to bid on: ");
                int index = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                Auction auction = auctionSystem.getAuction(index - 1);
                if (auction != null) {
                    System.out.print("Enter bid amount: ");
                    double bidAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    auction.placeBid(user, bidAmount);
                }
            } else if (choice == 4 && user.isAuctioneer()) {
                auctionSystem.listAuctions();
                System.out.print("Enter auction index to close: ");
                int index = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                Auction auction = auctionSystem.getAuction(index - 1);
                if (auction != null) {
                    auction.closeAuction();
                }
            } else if (choice == 5) {
                System.out.println("Logging out.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
