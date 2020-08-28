package annaChallenge;
import java.util.ArrayList;

public class SolveTheRiddle
	{
		public static ArrayList<ArrayList<Piece>> board= new ArrayList<ArrayList<Piece>>();
		
		public static Location[] cornerLocations=new Location[4];

		public static ArrayList<Location> edgeLocations= new ArrayList<Location>();
		
		public static String[] splitInput;
		
		
		public static void initSplitInput()
		{
			String str= "0,[5, 14, 9, 7]; 1,[15, 14, 2, 13]; 2,[7, 16, 5, 0]; 3,[14, 5, 0, 6];" + 
					"4,[10, 18, 9, 12]; 5,[16, 9, 7, 20]; 6,[9, 18, 18, 14]; 7,[0, 14, 7, 19];" + 
					"8,[15, 1, 16, 7]; 9,[17, 19, 3, 10]; 10,[7, 12, 2, 19]; 11,[7, 0, 14, 2];" + 
					"12,[7, 18, 8, 9]; 13,[0, 5, 17, 20]; 14,[20, 3, 0, 0]; 15,[14, 16, 3, 18];" + 
					"16,[5, 9, 5, 7]; 17,[19, 1, 0, 3]; 18,[9, 11, 0, 5]; 19,[12, 1, 12, 18];" + 
					"20,[7, 14, 1, 6]; 21,[20, 15, 20, 8]; 22,[14, 14, 5, 9]; 23,[4, 5, 13, 0];" + 
					"24,[12, 15, 14, 14]; 25,[9, 5, 20, 17]; 26,[14, 12, 13, 17]; 27,[15, 0, 19,\r\n" + 
					"19]; 28,[12, 0, 3, 7]; 29,[1, 14, 18, 12]; 30,[4, 17, 7, 18]; 31,[2, 18, 5,\r\n" + 
					"1]; 32,[8, 11, 0, 4]; 33,[16, 4, 8, 5]; 34,[19, 9, 11, 0]; 35,[19, 0, 0,\r\n" + 
					"11]; 36,[17, 4, 0, 8]; 37,[17, 18, 18, 7]; 38,[2, 17, 1, 12]; 39,[14, 7,\r\n" + 
					"10, 6]; 40,[9, 10, 18, 20]; 41,[17, 20, 9, 3]; 42,[5, 0, 18, 19]; 43,[18,\r\n" + 
					"14, 7, 20]; 44,[9, 12, 16, 9]; 45,[6, 6, 9, 0]; 46,[12, 17, 17, 10]; 47,[6,\r\n" + 
					"3, 13, 10]; 48,[9, 2, 8, 17]; 49,[18, 9, 0, 11]; 50,[4, 19, 4, 8]; 51,[0,\r\n" + 
					"1, 3, 4]; 52,[0, 7, 11, 6]; 53,[7, 20, 8, 4]; 54,[12, 5, 1, 5]; 55,[16, 7,\r\n" + 
					"20, 5]; 56,[20, 7, 6, 0]; 57,[6, 13, 10, 6]; 58,[9, 18, 16, 18]; 59,[13, 2,\r\n" + 
					"8, 0]; 60,[3, 7, 7, 4]; 61,[19, 19, 1, 2]; 62,[7, 2, 12, 20]; 63,[4, 5, 7,\r\n" + 
					"14]; 64,[12, 5, 16, 12]; 65,[7, 3, 0, 12]; 66,[20, 14, 10, 5]; 67,[12, 0,\r\n" + 
					"1, 13]; 68,[12, 8, 9, 2]; 69,[8, 17, 5, 9]; 70,[17, 8, 16, 1]; 71,[20, 9,\r\n" + 
					"12, 5]; 72,[5, 2, 19, 3]; 73,[9, 0, 0, 15]; 74,[14, 0, 10, 5]; 75,[20, 2,\r\n" + 
					"1, 8]; 76,[9, 2, 1, 0]; 77,[20, 9, 2, 5]; 78,[18, 16, 11, 7]; 79,[5, 12, 1,\r\n" + 
					"0]; 80,[2, 7, 17, 17]; 81,[13, 19, 5, 7]; 82,[1, 15, 19, 8]; 83,[19, 12, 4,\r\n" + 
					"9]; 84,[0, 9, 14, 4]; 85,[13, 16, 12, 20]; 86,[9, 3, 19, 0]; 87,[7, 15, 18,\r\n" + 
					"19]; 88,[14, 20, 0, 1]; 89,[12, 14, 8, 9]; 90,[8, 0, 12, 8]; 91,[0, 4, 18,\r\n" + 
					"0]; 92,[4, 13, 1, 17]; 93,[11, 14, 0, 8]; 94,[8, 16, 13, 8]; 95,[11, 4, 16,\r\n" + 
					"12]; 96,[7, 0, 11, 14]; 97,[13, 10, 0, 19]; 98,[19, 17, 5, 5]; 99,[20, 7,\r\n" + 
					"12, 2]";
			
				str=str.replaceAll("\\r\\n", "");
				splitInput= str.split(";",100);
		}
		
		public static void initCornerLocations()
		{
			//
			int lastIndex=board.size()-1;
			cornerLocations[0]= new Location(0,0);
			cornerLocations[1]= new Location(0,lastIndex);
			cornerLocations[2]= new Location(lastIndex,0);
			cornerLocations[3]= new Location(lastIndex,lastIndex);
		}

		public static void initEdgeLocations()
		{	
			//storing locations of the top edge.
			for (int i=1; i<board.size()-1; i++)
				{
					edgeLocations.add(new Location(0,i));
				}
			
			//storing location of the left and right edge.
			for (int i=1; i<board.size()-1;i++)
				{
					for (int j=0; j<board.size(); j+=board.size()-1)
						{
							edgeLocations.add(new Location (i,j));
						}
				}
			
			//storing the locations of the bottom edge.
			for (int i=1; i<board.size()-1;i++)
				{
					edgeLocations.add(new Location (board.size()-1,i));
				}
		}
		
		public static void fillBoard()
		{
			int splitIndex=0;
			for (int i=0; i<10; i++)
				{
					board.add(new ArrayList<Piece>());
					for (int j=0; j<10; j++)
						{
							
							board.get(i).add(new Piece(splitInput[splitIndex]));
							//initialBoard[i][j]= new Piece(splitInput[splitIndex]);
							splitIndex++;
						}
				}
		}

		public static int countOccurences(String str, char character)
		{
			int counter=0;
			
			for(int i=0; i<str.length(); i++)
				{
					if (str.charAt(i)==character)
						counter++;
				}
			
			return counter;
		}
	
		public static void printBoard()
			{
				for(int i=0; i<10; i++)
					{
						for(int j=0; j<10; j++)
							{
								board.get(i).get(j).drawLine1();
							//	initialBoard[i][j].drawLine1();
								System.out.print("\t");
							}
						System.out.println();
						
						for(int j=0; j<10; j++)
							{
								board.get(i).get(j).drawLine2();
							//	initialBoard[i][j].drawLine2();
								System.out.print("\t");
							}
						System.out.println();
						
						for(int j=0; j<10; j++)
							{
								board.get(i).get(j).drawLine3();
								//initialBoard[i][j].drawLine3();
								System.out.print("\t");
							}
						System.out.println();
						
						for(int j=0; j<10; j++)
							{
								board.get(i).get(j).drawLine4();
								//initialBoard[i][j].drawLine4();
								System.out.print("\t");
							}
						System.out.println();
						System.out.println("==============================================================================================================================================================");
						System.out.println();
						
					}
			}
	
		public static void placeCornerPieces()
		{
			int currentCorner=0;
			for (int i = 0; i < board.size(); i++)
				{
					for (int j = 0; j < board.get(i).size(); j++)
						{						
							if (board.get(i).get(j).pieceType().equals("corner"))
								{	
									if (!board.get(i).get(j).positionedCorrectly)
										{
											int cornerI=cornerLocations[currentCorner].i;
											int cornerJ=cornerLocations[currentCorner].j;

								
												Piece temp = new Piece(board.get(i).get(j));
												
												board.get(i).set(j, new Piece(board.get(cornerI).get(cornerJ)));
												
												board.get(cornerI).set(cornerJ, new Piece(temp));
												board.get(cornerI).get(cornerJ).positionedCorrectly=true;

												currentCorner++;
										}
									
						
								
								}
						}
				}
		}
	
		public static void placeEdgePieces()
		{
			int edgeCounter=0;
			
			for (int i=0; i<board.size(); i++)
				{
					for (int j=0;j<board.size();j++)
						{
							if (board.get(i).get(j).pieceType().equals("edge"))
								{
									if (!board.get(i).get(j).positionedCorrectly)
										{
											int edgeI= edgeLocations.get(edgeCounter).i;
											int edgeJ= edgeLocations.get(edgeCounter).j;
											
										//	System.out.println("examining Piece at: " + new Location(i,j));
										//	System.out.println("moving it to: " +edgeLocations.get(edgeCounter));
									
											
											Piece temp  = new Piece(board.get(i).get(j));
											board.get(i).set(j, new Piece(board.get(edgeI).get(edgeJ)));
											board.get(edgeI).set(edgeJ, new Piece(temp));
											board.get(i).get(j).positionedCorrectly=true;
											board.get(edgeI).get(edgeJ).positionedCorrectly=true;
											
											edgeCounter++;
											//countEdgePieces();
											System.out.println();
											System.out.println();
											System.out.println();
											System.out.println();
										}
								}
						}
				}
			
			
			
			
			
			
			
		}
	
		public static void rotateEdgePieces()
		{
			
		}
		
		public static void countEdgePieces()
		{
			for (int i = 0; i < board.size(); i++)
				{
					for (int j = 0; j < board.size(); j++)
						{
							if (board.get(i).get(j).pieceType().contentEquals("edge"))
								System.out.println("edge piece at: " + "( " +i+ " , " + j + " )" + ", positioned correctly: " + board.get(i).get(j).positionedCorrectly);
						}
				}
		}
		
		public static void scanForCorrectEdges()
		{
			int correctlyPositioned=0;
			for (int i=0; i<board.size(); i++)
				{
				for (int j=0; j<board.size(); j++)
					{
						if (board.get(i).get(j).pieceType().equals("edge"))
							{
								Location current= new Location(i,j);
								for (int k=0; k<edgeLocations.size();k++)
									{
										
										if (current.equals(edgeLocations.get(k)))
											{
												board.get(i).get(j).positionedCorrectly=true;
												System.out.println("Piece at location " +current +" is positioned correctly.");
												System.out.println("removing location: " +edgeLocations.get(k) + " from list.");
												System.out.println(edgeLocations.size());
												System.out.println();
												edgeLocations.remove(k);
												correctlyPositioned++;
											}	
									}
							}
					}
				}
			System.out.println("number of correctly positioned edge pieces: " + correctlyPositioned);
		}
		
		public static void countCornerPieces()
		{
			for (int i = 0; i < board.size(); i++)
				{
					for (int j = 0; j < board.size(); j++)
						{
							if (board.get(i).get(j).pieceType().contentEquals("corner"))
								System.out.println("corner piece at: " + "( " +i+ " , " + j + " )" + "positioned correctly: " + board.get(i).get(j).positionedCorrectly);
						}
				}
		}
		
		public static void main(String[] args)
			{

				initSplitInput();
				fillBoard();
				initCornerLocations();
				initEdgeLocations();
				placeCornerPieces();
				scanForCorrectEdges();
				placeEdgePieces();

				printBoard();
			}
	}