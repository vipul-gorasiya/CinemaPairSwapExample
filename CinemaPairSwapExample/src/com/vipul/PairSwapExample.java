package com.vipul;

import java.util.Scanner;

public class PairSwapExample {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please provide Number of couples:");
			int noOfCouples = scanner.nextInt();
			// 2 Ints for each couple, 2 for ticket numbers
			int[][] coupleTickets = new int[noOfCouples][2];
			int minSwaps = 0;
			System.out.println(
					"Please provide " + noOfCouples * 2 + " different seat numbers(press Enter after each number):");
			// Assign tickets to 0th and 1st index of array. 2nd remain 0 for swap count
			for (int i = 0; i < noOfCouples; i++) {
				coupleTickets[i][0] = scanner.nextInt();
				coupleTickets[i][1] = scanner.nextInt();
			}
			System.out.println("INPUT:");
			for (int firstIndx = 0; firstIndx < noOfCouples; firstIndx++) {
				System.out.println("{" + coupleTickets[firstIndx][0] + ", " + coupleTickets[firstIndx][1]
						+ "}");
			}
			
			for (int firstIndx = 0; firstIndx < noOfCouples; firstIndx++) {
				int firstTicket = coupleTickets[firstIndx][0];
				int secondTicket = coupleTickets[firstIndx][1];
				int ticketToFind;
				int replacableTicketIndex;
				int nonReplacableTicketIndex;
				// If tickets are already next to each other continue;
				if ((firstTicket - secondTicket == 1 && firstTicket % 2 == 0)
						|| (firstTicket - secondTicket == -1 && secondTicket % 2 == 0)) {
					continue;
				}
				if (firstTicket < secondTicket) {
					replacableTicketIndex = 1;
					nonReplacableTicketIndex = 0;
				} else {
					replacableTicketIndex = 0;
					nonReplacableTicketIndex = 1;
				}
				if (coupleTickets[firstIndx][nonReplacableTicketIndex] % 2 != 0) {
					ticketToFind = coupleTickets[firstIndx][nonReplacableTicketIndex] + 1;
				} else {
					ticketToFind = coupleTickets[firstIndx][nonReplacableTicketIndex] - 1;
				}

				for (int secondIndx = firstIndx + 1; secondIndx < noOfCouples; secondIndx++) {
					if (coupleTickets[secondIndx][0] == ticketToFind) {
						coupleTickets[secondIndx][0] = coupleTickets[firstIndx][replacableTicketIndex];
						coupleTickets[firstIndx][replacableTicketIndex] = ticketToFind;
						// increase swap count
						minSwaps++;
					} else if (coupleTickets[secondIndx][1] == ticketToFind) {
						coupleTickets[secondIndx][1] = coupleTickets[firstIndx][replacableTicketIndex];
						coupleTickets[firstIndx][replacableTicketIndex] = ticketToFind;
						// increase swap count
						minSwaps++;
					}
				}
			}
			System.out.println("OUTPUT:");
			for (int firstIndx = 0; firstIndx < noOfCouples; firstIndx++) {
				System.out.println("{" + coupleTickets[firstIndx][0] + ", " + coupleTickets[firstIndx][1]
						+ "}");
			}
			System.out.println("Minimum Number of Swaps: " + minSwaps);
			System.out.println("Thank you!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Could not get I/O resource.");
		}

	}
}
