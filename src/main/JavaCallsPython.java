package main;

import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

interface PyFunction {

	public PyObject __call__(PyString pyString, PyString pyString2);
}

public class JavaCallsPython {

	public static void main(String[] args) {
		PythonInterpreter interpreter = new PythonInterpreter();
		try {

			interpreter.execfile("pythonFiles\\hello.py");

			interpreter.execfile("pythonFiles\\test.py");
			PyFunction function = (PyFunction) interpreter.get("my_test", PyFunction.class);
			PyObject pyobject = function.__call__(new PyString("huzhiwei"), new PyString("25"));
			System.out.println("anwser = " + pyobject.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
