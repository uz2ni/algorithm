package test;

import java.util.Calendar;

public class calendar {
	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();

		/******************************** 날짜 관련 정보 ********************************/

		//24시간 기준으로 시간을 구한다.
		System.out.println("Calendar.HOUR_OF_DAY...." + cal.get(Calendar.HOUR_OF_DAY));

		//12시간 기준으로 시간을 구한다
		System.out.println("Calendar.HOUR...." + cal.get(Calendar.HOUR));

		// 날짜를구함
		System.out.println("Calendar.DAY_OF_MONTH..." + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Calendar.DATE..." + cal.get(Calendar.DATE));

		//오늘이 이번주의 몇번째 날인지 구함. 일요일이 1, 월요일은 2..
		System.out.println("Calendar.DAY_OF_WEEK..." + cal.get(Calendar.DAY_OF_WEEK));

		//이번주의 요일이 이번달의 몇번째 요일인지 구함
		System.out.println("Calendar.DAY_OF_WEEK_IN_MONTH..." + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));

		//1년중에 오늘이 몇번째 날인지 구함
		System.out.println("Calendar.DAY_OF_YEAR..." + cal.get(Calendar.DAY_OF_YEAR));

		//월의 몇번째 주인지구함
		System.out.println("Calendar.WEEK_OF_MONTH..." + cal.get(Calendar.WEEK_OF_MONTH));

		//년도를 구함
		System.out.println("Calendar.YEAR...." + cal.get(Calendar.YEAR));

		//월 구함, 1월이 0임, 2월:1, 3월:2.....
		System.out.println("Calendar.MONTH...." + cal.get(Calendar.MONTH));


		/******************************** 날짜정보를 세팅 ********************************/




		/******************************** 응용 ********************************/

		// 오늘 년월일
		System.out.println("오늘의 날짜 : " + cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DATE) + " " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.MINUTE));
	}
	

}
