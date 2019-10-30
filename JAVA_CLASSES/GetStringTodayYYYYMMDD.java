package del.rename.move;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetStringTodayYYYYMMDD 
{
	public static String GetStringTodayYYYYMMDD()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date dateFile = new Date();
		return dateFormat.format(dateFile);
	}
}
