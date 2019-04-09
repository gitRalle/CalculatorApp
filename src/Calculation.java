import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculation {
    private Object result;

    public Calculation(String expression) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("JavaScript");

        try {
            this.result = scriptEngine.eval(expression);

        } catch (ScriptException se) {
            se.printStackTrace();
        }

    }

    private void roundOffExpression(Object result) {

    }


    public Object getResult() {
        return result;
    }
}
