package parte1;

import java.util.ArrayList;
import java.util.Collections;

import edu.duke.Point;
import edu.duke.Shape;

public class TesteELY {

	public static void main(String[] args) {

//		-4, -3
//		4, -2
//		12, 2
//		6, 5
//		-3, 3
//		-8, 1
//		
		
		
		// inicializacao com pontos especificos
		Point a = new Point(-3, 3);
		Point b = new Point(4, -2);
		Point c = new Point(120, -2);
		Point d = new Point(6, 5);
		Point e = new Point(-3, 3);
		Point ff = new Point(-8, 1);
		Shape s = new Shape();
		s.addPoint(a);
		s.addPoint(b);
		s.addPoint(c);
		s.addPoint(d);
		s.addPoint(e);
		s.addPoint(ff);
		// s.addPoint(new Point(1, 1));
		for (Point p : s.getPoints()) {
			System.out.println(p);
		}

		System.out.println();
		
		
//		-3,3
//		-4,-3
//		4,-2
//		6,5
		
		
		// inicializacao com pontos especificos shape 2
		Point a1 = new Point(20, 20);
		Point b1 = new Point(0, 20);
		Point c1 = new Point(0, -20);
		Point d1 = new Point(20, -20);
		Shape s1 = new Shape();
		s1.addPoint(a1);
		s1.addPoint(b1);
		s1.addPoint(c1);
		s1.addPoint(d1);
		// s.addPoint(new Point(1, 1));
		for (Point p : s1.getPoints()) {
			System.out.println(p);
		}

		System.out.println();
//		
//		/**
//		 * inicializando o comparador
//		 */
//		// criando uma array com os shapes desenhados acima
//		ArrayList<Shape> listaShapes = new ArrayList<Shape>();
//		listaShapes.add(s1);
//		listaShapes.add(s);
//		
//		ComparadorPerimetro compara = new ComparadorPerimetro();
//		
//		System.out.println(listaShapes.indexOf(s1) + " index of s1 antes do sort");
//		// teste que queremos fazer usando a interface externa Comparator
//		listaShapes.sort(compara);
//		
//		// tentar imprimir o resultado
//		// acho que dara o erro de comparable
//		System.out.println(listaShapes.indexOf(s1) + " index of s1 apos sort");
//		
//		
//		System.out.println();
//		
//		/**
//		 * questao de pastas e shapes em arquivos separados
//		 */
//		
//		ArrayList<Shape> listaShapeFromArquivos = new ArrayList<Shape>();
//		DirectoryResource dr = new DirectoryResource();
//		for (File f : dr.selectedFiles()) {
//			FileResource fr = new FileResource(f);
//			Shape shape = new Shape(fr);
//			listaShapeFromArquivos.add(shape);
//		}
//		ComparadorPerimetro comparaPerimetroDeArquivos = new ComparadorPerimetro();
//		listaShapeFromArquivos.sort(comparaPerimetroDeArquivos);
		
		
	//	double resultado6 =  listaShapeFromArquivos.get(0).getPerimeter();
		
		
// ----------------------------------------------------------------------------------------
// 04/04/20
		// testando array com valores de distancia dos pontos
		ArrayList<Double> distancia = s.getDistancePoints();
		System.out.println(distancia);
		Collections.sort(distancia);
		System.out.println(distancia);
		System.out.println();
		ArrayList<Double> distancia2 = s.getOrderDistancePoints();
		System.out.println(distancia2);
		System.out.println("------------");
		
		Shape shaps1 = new Shape();
		shaps1.addValueX(50);
		shaps1.addValueX(200);
		
		System.out.println(shaps1.getListX());
		System.out.println(s.getListX());
		
// 04/04/20
// ----------------------------------------------------------------------------------------
		
		
		
		
		
		/**
		 * Varios testes da parte 1 do exercicio
		 */
		// teste 1 quantidade de pontos, metodo que adicionei no Shape.java
		System.out.println(s.getNumPoints() + " quantidade");
		
		// teste de metodo perimetro dentro da Classe Shape.java
		System.out.println(s.getPerimeter() + " perimetro");

		// teste de media de perimetro
		System.out.println(s.getAverageLength() + " media dos perimetros");

		// maior valor dentro da Array
		System.out.println(s.getLargestSide() + " maior");
//
//		// maior valor do Axis X dentro da Array
//		System.out.println(s.getLargestX() + " maior X");
//		
//		// de todos os arquivos na pasta parte1.datatest qual o maior perimetro
//		System.out.println(resultado6 + " maior perimetro dos arquivos");

	}

}
