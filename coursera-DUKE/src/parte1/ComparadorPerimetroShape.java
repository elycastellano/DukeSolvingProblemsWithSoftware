package parte1;

import java.util.Comparator;

import edu.duke.Shape;

public class ComparadorPerimetroShape implements Comparator<Shape> {

	
	@Override
	public int compare(Shape s1, Shape s2) {

		if ( s1.getPerimeter() > s2.getPerimeter() )  {
			return -1;
		}
		if (s1.getPerimeter() < s2.getPerimeter()) {
			return +1;
		}
		
		return 0;
	}

}
