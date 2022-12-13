package month;

public class Months {
	
   
public int getDays(int month) {
	
	
	if (month==2) {
		   return (28);
    } else if (month==9 || month==4 || month==6 || month==11) {
           return (30);
    } else {
          return (31);
    }

}
}
