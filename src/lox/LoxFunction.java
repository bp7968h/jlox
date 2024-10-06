package lox;

import java.util.List;

public class LoxFunction implements LoxCallable {
    private final Stmt.Function declaration;
    private final Environment closure;

    LoxFunction(Stmt.Function declaration, Environment closure) {
        this.declaration = declaration;
        this.closure = closure;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        // create new environment
        // Environment environment = new Environment(interpreter.globals);
        Environment environment = new Environment(closure);

        // walk the parameter and argument lists in lockstep
        for (int i = 0; i < declaration.params.size(); i++) {
            // create a new variable with the parameter’s name and binds it to the
            // argument’s value.
            environment.define(declaration.params.get(i).lexeme, arguments.get(i));
        }

        // execute the body of the function in new function-local environment
        try {
            interpreter.executeBlock(declaration.body, environment);
        } catch (Return returnValue) {
            return returnValue.value;
        }

        // discards that function-local environment and restores the previous one that
        // was active back at the callsite

        return null;
    }

    @Override
    public int arity() {
        return declaration.params.size();
    }

    @Override
    public String toString() {
        return "<fn " + declaration.name.lexeme + ">";
    }

}
