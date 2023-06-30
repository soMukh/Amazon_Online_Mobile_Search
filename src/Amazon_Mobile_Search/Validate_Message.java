package Amazon_Mobile_Search;
public class Validate_Message 
{
	//Method used for validating the message displayed by the application is correct
	//on searching mobile smartphones under 30000
	public static boolean validate_Message(String str)
	{
		try
		{
			String message1="1-16 of over 5,000 results for\"mobile smartphones under 30000\"";
			//Validating the message displayed by the application after searching
			//mobile smartphones under 30000 is correct
			if(!message1.equals(str))
				return false;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return true;
	}
}	