import java.util.ArrayList;
import java.util.Scanner;
public class mainRPG
	{	
		public static void secstop() 
			{
				try
					{
						Thread.sleep(1000);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
		}
		public static void halfsecstop() 
			{
				try
					{
						Thread.sleep(500);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
		}

		public static void main(String[] args)
			{
				EnemyList.fillArray();
				welcomePlayer();
				enemySelect();
				secstop();
				clearConsole();
				battle();

			}

		public static void welcomePlayer()
		{
			Scanner userStringInput = new Scanner(System.in);
			System.out.println("Hello and welcome to the Java RPG!");
			secstop();
			System.out.println("You will be battling a random monster now");
			secstop();
			System.out.println("Press any key to generate battle");
			String begin = userStringInput.nextLine();
		}
		static int number = (int)(Math.random()*4);
		public static void enemySelect()
		{
			
			System.out.println("You will be fighting the " + EnemyList.enemies.get(number).getName() + ".");
			halfsecstop();
			System.out.println("Ready?");
			halfsecstop();
			System.out.println("[BATTLE START]");
		}
		public static void clearConsole()
		{
			for(int i = 0; i<3; i++) 
				{
				System.out.println("					");
			}
		}
		public static void battle()
		{
			Scanner userStringInput = new Scanner(System.in);
			System.out.println("You are fighting the " + EnemyList.enemies.get(number).getName() + "." );
			System.out.println("--------");
			System.out.println("ATTACK");
			System.out.println("BLOCK");
			System.out.println("CHECK");
			System.out.println("ITEM");
			String menu = userStringInput.nextLine();
			if(menu.equals("attack"))
				{
					
				} else if(menu.equals("block")) 
					{
					
				} else if(menu.equals("check"))
					{
						System.out.println( EnemyList.enemies.get(number).getName() + ", " + "ATK " + EnemyList.enemies.get(number).getDamage());
					}
			
		}
	
	}
