package edu.duke;

import java.util.ArrayList;
import java.util.Collections;

import edu.duke.FileResource;

/**
 * The <code>Shape</code> class represents a collection of <code>Point</code>s
 * that can easily model a polygonal shape. Points can be added in order via
 * code or given using a file, one point per line separated by a comma. The
 * points can then be accessed in the order they were added one at a time, using
 * the method <code>getPoints</code>.
 * 
 * <P>
 * Example usage:
 * 
 * <PRE>
 * Point a = new Point(3, 4);
 * Point b = new Point(2, 5);
 * Shape s = new Shape();
 * s.addPoint(a);
 * s.addPoint(b);
 * s.addPoint(new Point(1, 1));
 * for (Point p : s.getPoints()) {
 * 	System.out.println(p);
 * }
 * </PRE>
 * 
 * <P>
 * A <code>Shape</code> can also be created using file in the following format:
 * 
 * <PRE>
 * 3, 4
 * 2, 5
 * 1, 1
 * </PRE>
 *
 * <P>
 * Example file usage:
 * 
 * <PRE>
 * FileResource fr = new FileResource();
 * Shape s = new Shape(fr);
 * for (Point p : s.getPoints()) {
 * 	System.out.println(p);
 * }
 * </PRE>
 * 
 * <P>
 * This software is licensed with an Apache 2 license, see
 * http://www.apache.org/licenses/LICENSE-2.0 for details.
 * 
 * @author Duke Coursera Team
 */
@SuppressWarnings("unused")
public class ShapeElyTentativa1 {
	private ArrayList<Point> points;

	/**
	 * Create an empty <code>Shape</code> object, one with no points.
	 */
	public ShapeElyTentativa1() {
		points = new ArrayList<Point>();
	}

	/**
	 * Create a <code>Shape</code> object from a file with x,y coordinates of
	 * points, in order, one pair of x,y per line.
	 * 
	 * Each x,y are comma-separated, e.g.,
	 * 
	 * <pre>
	 *   3,4
	 *  -2,5
	 * </pre>
	 * 
	 * whitespace on line is skipped.
	 * 
	 * @param file is the FileResource accessible and bound to a file with one pair
	 *             of points per line
	 */
	public ShapeElyTentativa1(FileResource file) {
		this();
		for (String line : file.lines()) {
			int commaloc = line.indexOf(",");
			int x = Integer.parseInt(line.substring(0, commaloc).trim());
			int y = Integer.parseInt(line.substring(commaloc + 1).trim());
			addPoint(new Point(x, y));
		}
	}

	/**
	 * Add a point to this shape/polygon.
	 * 
	 * The order in which points are added defines the order in which points are
	 * accessed.
	 * 
	 * @param p is the Point added to this shape
	 */
	public void addPoint(Point p) {
		points.add(p);
	}

	/**
	 * Return the last point added to this shape/polygon
	 * 
	 * @return the last Point added
	 */
	public Point getLastPoint() {
		return points.get(points.size() - 1);
	}

	/**
	 * Allow access to this shape one point at a time.
	 * 
	 * @return an Iterable that allows access to points
	 */
	public Iterable<Point> getPoints() {
		return points;
	}

	/**
	 * Return Quantity of points
	 * 
	 * @author anon
	 * 
	 * @return int
	 */
	public int getNumPoints() {
		return points.size();
	}

	/**
	 * 
	 * 
	 */
	public double getPerimeter() {
		double totalPerim = 0.0;
		Point prevPt = getLastPoint();
		for (Point currPt : this.getPoints()) {
			double currDist = prevPt.distance(currPt);
			totalPerim += currDist;
			prevPt = currPt;
		}
		return totalPerim;

	}

	public double getAverageLength() {
		return this.getPerimeter() / this.getNumPoints();
	}

	public double getLargestSide() {

		double Largest = 0.0;

		ArrayList<Double> dist = new ArrayList<Double>();

		Point prevPt = getLastPoint();
		for (Point currPt : this.getPoints()) {
			double currDist = prevPt.distance(currPt);
			dist.add(currDist);
		}

		// VERIFICAR
		int tamanho = dist.size();
		double ultimoComPrimeiro = Math.max(dist.get(0), tamanho); // <---

		for (int i = 0; i < tamanho - 1; i++) {
			Largest = Math.max(dist.get(i), dist.get(i + 1));
		}
		Largest = Math.max(ultimoComPrimeiro, Largest);

		return Largest;

	}

	
	public double getLargestX () {
		
		// cria a referencia
		double Largest = 0.0;
		
		// cria o array
		ArrayList<Double> distX = new ArrayList<Double>();
		
		// pega o ultimo ponto em X
		Point lastPoint = this.getLastPoint();
		double prevAxisX = lastPoint.getX();
		
		//pega os pontos totais    
		for (Point currPt : this.getPoints()) {
			//double currDist = prevPt.distance(currPt);
			double axisX = currPt.getX();
			distX.add(axisX);
		}
		
		// pega o tamanho da amostra
		int tamanho = distX.size();
		double ultimoValor = distX.get(tamanho - 1); 
		
		
		
		// compara o ultimo valor da amostra com o primeiro
		double ultimoComPrimeiro = Math.max(distX.get(0), ultimoValor);

		for (int i = 0; i < tamanho - 1; i++) {
			Largest = Math.max(distX.get(i), distX.get(i + 1));
		}
		Largest = Math.max(ultimoComPrimeiro, Largest);

		
		// 1) criar referencias para o resultado final e criar o Array que segurara os valores de X
		// 2) pegar o valor X do ultimo ponto - tal valor sera comparado com o resultado do array
		// 3) coloca todos os X no array
		// 4) compara os valores do array
		// 5) compara o ultimo valor com o do resultado do array
		// 6) retorna o resultado
		
		
		
		
		
		return Largest;
	}
	
	
	
	
}
