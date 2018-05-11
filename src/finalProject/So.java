package finalProject;

//package BattleShip;

import java.util.Random;
import java.util.Scanner;

//============================================================================
// Name        : Lab15_YA.cpp
// Author      : Yuval Amitay
// Block       : A
// Date        : May 13 2017
// Description : Battleship Game
//============================================================================

//include <iostream>
//#include <vector>
//using namespace std;

//saved  battle ship
public class So{
	public static Random rand = new Random();
	public static int[][] ocean = new int[8][8];
	public static int firstX, firstY;
	public static int direction;		//1=up, 2=right 3=down 4=left
	public static int bullets = 15, shipHit = 0;
	
	public static Scanner read = new Scanner(System.in);
	
 public static void main(String[] args) {

	//srand(time(0));

	getDirection();
	ShipPlacement();

	do{
		Display();
		Input();

	}while(bullets > 0 && shipHit < 4);

	if (shipHit == 4)
		System.out.print("Wohoo! You are a true winner :)\n");
	else if (bullets == 0)
		System.out.print("No more torpedos! Game over.\n");

}

public static void getDirection()
{
	firstX = rand.nextInt(8);
	firstY = rand.nextInt(8);

	/*   find a random direction   */
	if (firstX < 3)
	{
		if (firstY < 3)			//checks for limitations- a ship can't be going left
		{						//if it is too close to the left boundary of the border.
			do {
				direction = rand.nextInt(4) + 1;
			}while (direction != 2 || direction != 3);
		}

		else if (firstY > 4)
		{
			do {
				direction = rand.nextInt(4) + 1;
			}while (direction != 2 || direction != 1);
		}

		else
		{
			do {
				direction = rand.nextInt(4) + 1;
			}while (direction == 4);
		}
	}

	else if (firstX > 4)
	{
		if (firstY < 3)
		{
			do {
				direction = rand.nextInt(4) + 1;
			}while (direction == 1 || direction == 2);
		}

		else if (firstY > 4)
		{
			do {
				direction = rand.nextInt(4) + 1;
			}while (direction == 3 || direction == 2);
		}

		else
		{
			do {
				direction = rand.nextInt(4) + 1;
			}while (direction == 2);
		}
	}

	else if (firstX < 5 && firstX > 2)
	{
		if (firstY < 3)
		{
			do {
				direction = rand.nextInt(4) + 1;
			}while (direction == 1);
		}

		else if (firstY > 4)
		{
			do {
				direction = rand.nextInt(4) + 1;
			}while (direction == 3);
		}

		else
			direction = rand.nextInt(4) + 1;


	}
}

public static void ShipPlacement ()
{
	/*	creating a 8*8 ocean full of 0's	*/
	//for(int x=0; x< ocean.length; x++)
		//ocean[x].resize(8);

	for(int y = 0; y<ocean.length; y++)
		for (int x = 0; x<ocean[y].length; x++)
			ocean[y][x] = 0;

	/*	placing the battleship	*/
	ocean[firstY][firstX] = 1;
	for (int i=1; i <= 3; i++)
	{
		if (direction == 1)		//direction 1 = up
			ocean[firstY-i][firstX] = 1;

		else if (direction == 2)	//direction 2 = right
			ocean[firstY][firstX+i] = 1;

		else if (direction == 3)	//direction 3 = down
			ocean[firstY+i][firstX] = 1;

		else if (direction == 4)	//direction 4 = left
			ocean[firstY][firstX-i] = 1;
	}
}

public static void Display() {	/*(0 = empty, no fire; 1 = contains ship, no fire;
 	 2 = empty, fired upon; 3 = contains ship, fired upon). */

	for (int y=0; y < 8; y++)
	{
		for (int x=0; x<8; x++)
		{
			if (ocean[y][x] == 0 || ocean[y][x] == 1)
				System.out.print(". ");

			else if (ocean[y][x] == 2)
				System.out.print("0 ");

			else if (ocean[y][x] == 3)
				System.out.print("x ");
		}
		System.out.println();
	}
}

public static void Input()
{
	int firedX, firedY;
	do
	{
		System.out.print("\n" + bullets + " torpedoes remain.  Fire where? ");
		firedX = read.nextInt();
		firedY = read.nextInt();

		firedX--;			//to adjust the input from the user, to vector that starts from "0"
		firedY--;			// (because users give input between 1-8, instead of 0-7.)
		bullets-- ;

		if (firedX > 7 || firedX < 0 || firedY > 7 || firedY < 0)
			System.out.print("You lost a torpedo for trying to fire outside of the boundaries. try again.\n");

	} while(firedX > 7 || firedX < 0 || firedY > 7 || firedY < 0);

	if (ocean[firedY][firedX] == 0 || ocean[firedY][firedX] == 2)
		{
		ocean[firedY][firedX] = 2;
		System.out.print("Miss!\n");
		}

	else if (ocean[firedY][firedX] == 3)
		System.out.print("You had already fired on this part of the ship.\n");

	else if (ocean[firedY][firedX] == 1)
			{
			ocean[firedY][firedX] = 3;
			System.out.print("Hit!\n\n");
			shipHit++ ;

			}
}
}
