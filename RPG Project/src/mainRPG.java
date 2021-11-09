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
				PlayerAL.playerAF();
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
		public static void menu()
		{
			System.out.println("You are fighting the " + EnemyList.enemies.get(number).getName() + "." );
			System.out.println("--------");
			System.out.println("ATTACK");
			System.out.println("BLOCK");
			System.out.println("CHECK");
			System.out.println("ITEM");
		}
		public static void enemyTurn()
		{
			int enemyChoice = (int)(Math.random()*2);
			if (enemyChoice == 1)
				{
					//if(block==false)
						{
					PlayerAL.playerset.get(0).setHealth(PlayerAL.playerset.get(0).getHealth() - EnemyList.enemies.get(number).getDamage());
					System.out.println(EnemyList.enemies.get(number).getName()+ " uses " + EnemyList.enemies.get(number).getAttack() 
							+ "! Your health is reduced to " + PlayerAL.playerset.get(0).getHealth() + ".");
				}
		}
		}
		public static void battle()
		{
			Scanner userStringInput = new Scanner(System.in);
			menu();
			String menu = userStringInput.nextLine();
			if(menu.equals("attack"))
				{
					int hitprob = (int)(Math.random()*100) + 1;
					if(hitprob < PlayerAL.playerset.get(0).getHitprob())
						{
						EnemyList.enemies.get(number).setHealth(EnemyList.enemies.get(number).getHealth() - PlayerAL.playerset.get(0).getAttack());
						System.out.println("You attack the " + EnemyList.enemies.get(number).getName() + ", dealing " + PlayerAL.playerset.get(0).getAttack() + " damage. The "
						+ EnemyList.enemies.get(number).getName() + "'s health is now " + EnemyList.enemies.get(number).getHealth() + "!" );
						}else
							{
								System.out.println("You missed!");
								enemyTurn();
							}
					if(EnemyList.enemies.get(number).getHealth() <= 0)
						{
							System.out.println("You win!");
						}
					enemyTurn();
				} else if(menu.equals("block")) 
					{
						Boolean block = true;
						System.out.println("You brace for impact!");
						enemyTurn();
				} else if(menu.equals("check"))
					{
						System.out.println( EnemyList.enemies.get(number).getName() + ", " + "ATK " + EnemyList.enemies.get(number).getDamage());
					} else if(menu.equals("item"))
						{
							
						}else 
							{
							System.out.println("Please select one of the options below");
							menu();
						}
			
		}
	
	}
