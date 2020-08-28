package annaChallenge;

public class Piece
	{
		int id;
		int left;
		int top;
		int right;
		int bottom;
		boolean positionedCorrectly=false;
		boolean orientedCorrectly=false;
		
		public Piece(String str)
		{
			str= formatInput(str);
			splitAndStoreValues(str);
		}
	
		public Piece(Piece other)
		{
			this.id=other.id;
			this.top=other.top;
			this.right=other.right;
			this.bottom=other.bottom;
			this.left=other.left;
		}
		
		public String pieceType()
		{
			int zeroCounter=0;
			if (left==0)
				zeroCounter++;
			if (top==0)
				zeroCounter++;
			
			if(right==0)
				zeroCounter++;
			
			if(bottom==0)
				zeroCounter++;
			
			if(zeroCounter==1)
				return "edge";
			
			else if (zeroCounter==2)
				return "corner";
			
			else return "normal";
		}
		
		public Piece(int id, int left, int top, int right, int bottom)
		{
			this.id=id;
			this.left=left;
			this.right=right;
			this.top=top;
			this.bottom=bottom;
		}
		
		private String removeCharOccurences(char charToRemove ,String str)
		{
			String fixed=str;
			int i=0;
			
			while(fixed.indexOf(charToRemove)!=-1)
				{
					if (fixed.charAt(i)==charToRemove)
						{
							fixed=removeCharAt(i,fixed);
						}
					i++;
				}
			return fixed;
		}
		
		private String removeCharAt(int index, String str)
		{
			String fixed= str.substring(0,index) +str.substring(index+1,str.length());
			return fixed;
		}

		private String formatInput(String str)
		{
			str= removeCharOccurences('[',str);
			str=removeCharOccurences(']',str);
	//		str=removeCharOccurences(';',str);
			str=removeCharOccurences(' ',str);
			return str;
		}
		
		private String removeCharsUpToIndex(int index, String str)
		{
			str=str.substring(index+1);
			return str;
		}
		
		private void splitAndStoreValues(String str)
		{
			
			int index=str.indexOf(',');
			id= Integer.parseInt(str.substring(0, index));
			str= removeCharsUpToIndex(index,str);
			
			index= str.indexOf(',');
			top=Integer.parseInt(str.substring(0,index));
			str=removeCharsUpToIndex(index,str);
			
			index= str.indexOf(',');
			right=Integer.parseInt(str.substring(0,index));
			str=removeCharsUpToIndex(index,str);
			
			index= str.indexOf(',');
			bottom=Integer.parseInt(str.substring(0,index));
			str=removeCharsUpToIndex(index,str);
			
			left=Integer.parseInt(str);	
		}
	
		public void rotateClockwise()
		{
			int temp= top;
			top = left;
			left = bottom;
			bottom = right;
			right = temp;
		}
		
		public String toString()
			{
				return "id: " + id + "\ttop: " +top + "\tright: " +right + "\tbottom: "  +bottom +"\tleft: " +left;
			}
		
		public void drawPiece()
		{
			System.out.println("  \\  "+top + "  /");
			System.out.println(left + "  \\   /  " +right);
			System.out.println( "   /   \\");
			System.out.println("  /  " +bottom+ "  \\");
			
		}
		
		public void drawLine1()
		{ 	System.out.print("  \\  "+top + "  /");	}
		
		public void drawLine2()
		{ 	System.out.print(left + "  \\   /  " +right); }
		
		public void drawLine3()
		{	System.out.print( "   /   \\");	}
		
		public void drawLine4()
		{	System.out.print("  /  " +bottom+ "  \\");	}

		
		
	}
