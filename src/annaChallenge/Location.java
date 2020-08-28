package annaChallenge;

public class Location
	{
		int i;
		int j;
		
		public Location(int i, int j)
		{
			this.i=i;
			this.j=j;
		}

		public String toString()
		{
			return "( " +i + " , "+ j+ " )";
		}

		public boolean equals (Object obj)
		{
			if (obj==null)
				return false;
			
			if (this==obj)
				return true;
			
			if (this.getClass()!=obj.getClass())
				return false;
			Location other= (Location) obj;
			
			if ((this.i== other.i) && (this.j==other.j))
				return true;
			return false;
		}
	}
