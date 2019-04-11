import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculation {
    private String result;

    public Calculation(String expression) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("JavaScript");
        Object obj = null;

        try {
            obj = scriptEngine.eval(expression);

        } catch (ScriptException se) {
            se.printStackTrace();
        }
        this.result = String.valueOf(obj);

    }

    private boolean hasFloatingPoint(Object obj) {
        char[] arr = String.valueOf(obj).toCharArray();
        boolean hasFloatingPoint = false;

        // Go through char[] and looks for decimal point
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '.' || arr[i] == ',') {
                hasFloatingPoint = true;
                break;
            }
        }

        return hasFloatingPoint;
    }

    public String getResult() {
        return result;
    }
}
