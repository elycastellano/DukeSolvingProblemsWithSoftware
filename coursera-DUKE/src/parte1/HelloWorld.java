package parte1;

import edu.duke.*;

public class HelloWorld {
	public void runHello () {
		FileResource res = new FileResource("parte1/hello_unicode.txt");
		for (String line : res.lines()) {
			System.out.println(line);
		}
	}
}

