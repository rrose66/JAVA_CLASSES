package dev.misc;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class FormatingStrings {

	public static void main(String[] args) {
		String strInput=null;
		strInput="Line1";
		strInput = strInput+"\nLine2\n";
		strInput = strInput+"\tLine3 with \nOne Line\nTab\n";
		int intDialogButton=JOptionPane.YES_NO_CANCEL_OPTION;
		System.out.print(strInput);
		SimpleDateFormat dateTimeToday = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		System.out.println("");
		Date dateToday = new Date();
		String strDateTimeNow = dateTimeToday.format(dateToday.getTime());
		System.out.println(strDateTimeNow);
		System.out.println(strDateTimeNow);
		System.out.println(strDateTimeNow);
		intDialogButton=JOptionPane.showConfirmDialog(null, strInput,"This is the ITIL process for work time tracking.",intDialogButton);
		dateToday = new Date();
		strDateTimeNow = dateTimeToday.format(dateToday.getTime());
		System.out.println(strDateTimeNow);
		System.out.println(strDateTimeNow);
		System.out.println(strDateTimeNow);
		System.out.println(strDateTimeNow);
	}

}
