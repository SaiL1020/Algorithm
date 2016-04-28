import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class SimilarUserDetection {
	
	public String haveSimilar(String[] handles) {
		for (int i = 0; i < handles.length; i++) {
			for (int j = 0; j < handles[i].length(); j++) {
				handles[i] = handles[i].replace("0", "O");
				handles[i] = handles[i].replace("1", "I");
				handles[i] = handles[i].replace("l", "I");
			}
		}

		for (int i = 0; i < handles.length; i++) {
			for (int j = i + 1; j < handles.length; j++) {
				if (handles[i].equals(handles[j]))
					return "Similar handles found";
			}
		}
		return "Similar handles not found";
	}
}
