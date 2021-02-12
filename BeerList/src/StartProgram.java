import java.util.List;
import java.util.Scanner;

import controller.BeerListHelper;
import model.BeerItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static BeerListHelper bih = new BeerListHelper();

		private static void addBeer() {
			// TODO Auto-generated method stub
			System.out.print("Enter a brewery: ");
			String brewery = in.nextLine();
			System.out.print("Enter an name: ");
			String beerName = in.nextLine();
			System.out.print("Enter an type (IPA, Cider, Wheat, etc.): ");
			String beerType = in.nextLine();
			
			BeerItem toAdd = new BeerItem(brewery, beerName, beerType);
			bih.insertBeer(toAdd);
		}

		private static void deleteBeer() {
			// TODO Auto-generated method stub
			System.out.print("Enter the brewery to delete: ");
			String brewery = in.nextLine();
			System.out.print("Enter the name to delete: ");
			String beerName = in.nextLine();
			System.out.print("Enter the type to delete: ");
			String beerType = in.nextLine();
			
			BeerItem toDelete = new BeerItem(brewery, beerName, beerType);
			bih.deleteBeer(toDelete);
		}

		private static void editBeer() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Brewery");
			System.out.println("2 : Search by Name");
			System.out.println("3 : Search by Type");
			int searchBy = in.nextInt();
			in.nextLine();
			List<BeerItem> foundBeers;
			if (searchBy == 1) {
				System.out.print("Enter the brewery name: ");
				String brewery = in.nextLine();
				foundBeers = bih.searchForBeerByBrewery(brewery);
			} else if (searchBy == 2) {
				System.out.print("Enter the name: ");
				String beerName = in.nextLine();
				foundBeers = bih.searchForBeerByBeerName(beerName);
			} else {
				System.out.print("Enter the type: ");
				String beerType = in.nextLine();
				foundBeers = bih.searchForBeerByBeerType(beerType);
			}

			if (!foundBeers.isEmpty()) {
				System.out.println("Found Results.");
				for (BeerItem l : foundBeers) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				BeerItem toEdit = bih.searchForBeerById(idToEdit);
				System.out.println("Retrieved " + toEdit.getBeerName() + " from " + toEdit.getBrewery() + " (" + toEdit.getBeerType() + ").");
				System.out.println("1 : Update Brewery");
				System.out.println("2 : Update Name");
				System.out.println("3 : Update Type");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Brewery: ");
					String newBrewery = in.nextLine();
					toEdit.setBrewery(newBrewery);
				} else if (update == 2) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setBeerName(newName);
				} else if (update == 3) {
					System.out.println("New Type: ");
					String newType = in.nextLine();
					toEdit.setBeerType(newType);
				}

				bih.updateBeer(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select a beer:");
				System.out.println("*  1 -- Add a beer");
				System.out.println("*  2 -- Edit a beer");
				System.out.println("*  3 -- Delete a beer");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addBeer();
				} else if (selection == 2) {
					editBeer();
				} else if (selection == 3) {
					deleteBeer();
				} else if (selection == 4) {
					viewTheBeerList();
				} else {
					bih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheBeerList() {
			// TODO Auto-generated method stub
			List<BeerItem> allBeers = bih.showAllBeers();
			for (BeerItem singleBeer: allBeers) {
				System.out.println(singleBeer.returnBeerItemDetails());
			}

		}

	}