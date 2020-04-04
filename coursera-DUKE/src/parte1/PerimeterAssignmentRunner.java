package parte1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;

public class PerimeterAssignmentRunner {
	public double getPerimeter(Shape s) {
		// 1
		return s.getPerimeter();
	}

	public int getNumPoints(Shape s) {
		// 2
		return s.getNumPoints();
	}

	public double getAverageLength(Shape s) {
		// 3
		return s.getAverageLength();
	}

	public double getLargestSide(Shape s) {
		// 4
		return s.getLargestSide();
	}

	public double getLargestX(Shape s) {
		//5
		return s.getLargestX();
	}

	// ----------------------------------------------------
//	public double getLargestY(Shape s) {
//		//5
//		return s.getLargestY();
//	}
	// ----------------------------------------------------
	
	public double getLargestPerimeterMultipleFiles() {
		ArrayList<Shape> listaShapeFromArquivos = new ArrayList<Shape>();
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			Shape shape = new Shape(fr);
			listaShapeFromArquivos.add(shape);
		}

		ComparadorPerimetroShape compara = new ComparadorPerimetroShape();
		listaShapeFromArquivos.sort(compara);

		return listaShapeFromArquivos.get(0).getPerimeter();
	}

	public String getFileWithLargestPerimeter() {
		// now
		ArrayList<Shape> listaShapeFromArquivos = new ArrayList<Shape>();
		ArrayList<File> listaFileFromArquivos = new ArrayList<File>();
		Map<Shape, File> mapShapeFile = new HashMap<Shape, File>();
		
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			Shape shape = new Shape(fr);
			listaShapeFromArquivos.add(shape);
			listaFileFromArquivos.add(f);
			mapShapeFile.put(shape, f);
		}
		
		ComparadorPerimetroShape compara = new ComparadorPerimetroShape();
		listaShapeFromArquivos.sort(compara);
		
		
		File temp = mapShapeFile.get(listaShapeFromArquivos.get(0));
		return temp.getName();
	}

	/// coursera-DUKE/src/parte1/dadatest/datatest1.txt

	public void testPerimeter() {
		FileResource fr = new FileResource(
				"/home/anon/eclipse-workspace/coursera-DUKE/src/parte1/dadatest/datatest4.txt");
		Shape s = new Shape(fr);

		double length = getPerimeter(s);
		System.out.println("perimeter = " + length);

		int quantity = getNumPoints(s);
		System.out.println("Quantity = " + quantity);

		double average = getAverageLength(s);
		System.out.println("Average = " + average);

		double LargestSide = getLargestSide(s);
		System.out.println("LargestSide = " + LargestSide);
		
		double getLargestX = getLargestX(s);
		System.out.println("LargestAxisX = " + getLargestX);
//		System.out.println("LargestAxisY = " + getLargestY);
		
//		printFileNames();
		//System.out.println(getLargestPerimeterMultipleFiles());
		//testPerimeterMultipleFiles();
		
		
		//System.out.println(getFileWithLargestPerimeter());
		
		testFileWithLargestPerimeter();
		
	}

	public void testPerimeterMultipleFiles() {
//		ArrayList<Shape> listaShapeFromArquivos = new ArrayList<Shape>();
//		DirectoryResource dr = new DirectoryResource();
//		for (File f : dr.selectedFiles()) {
//			FileResource fr = new FileResource(f);
//			Shape shape = new Shape(fr);
//			listaShapeFromArquivos.add(shape);
//		}
//
//		ComparadorPerimetroShape compara = new ComparadorPerimetroShape();
//		listaShapeFromArquivos.sort(compara);
//
//		System.out.println(listaShapeFromArquivos.get(0).getPerimeter());
		System.out.println(getLargestPerimeterMultipleFiles() + " major Perimeter in selected Files");
	}

	public void testFileWithLargestPerimeter() {
		System.out.println(getFileWithLargestPerimeter() + " this is the file with major Perimeter");
	}

	// This method creates a triangle that you can use to test your other methods
	public void triangle() {
		Shape triangle = new Shape();
		triangle.addPoint(new Point(0, 0));
		triangle.addPoint(new Point(6, 0));
		triangle.addPoint(new Point(3, 6));
		for (Point p : triangle.getPoints()) {
			System.out.println(p);
		}
		double peri = getPerimeter(triangle);
		System.out.println("perimeter = " + peri);
	}

	// This method prints names of all files in a chosen folder that you can use to
	// test your other methods
	public void printFileNames() {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			System.out.println(f);
		}
	}

	public static void main(String[] args) {
		PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
		pr.testPerimeter();
	}
}
