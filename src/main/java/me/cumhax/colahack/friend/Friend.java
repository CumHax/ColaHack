package  me.cumhax.colahack.friend;

public class Friend
{
	private final String name;

	public Friend(String name)
	{
		this.name = name;
	}

	public static boolean isFriend ( String name ) {
		return false;
	}

    public String getName()
	{
		return name;
	}
}
