package com.Dandelion.DesignPattern.Interpretor;

import java.util.HashMap;
import java.util.Map;

public class TestInterpret {
    private static Expression ex;
    private static Context con;

    public static void main(String[] args) {
        con = new Context();
        Variable a = new Variable();
        Variable b = new Variable();
        Constant c = new Constant(2);
        con.addValue(a, 5);
        con.addValue(b, 8);
        ex = new Division(new Multiply(a, b), new Add(new Subtract(a, b), c));
        System.out.println("结果为：" + ex.interpret(con));
    }
}

class Context {
    private Map valueMap = new HashMap<>();

    void addValue(Variable x, int y) {
        Integer yi = y;
        valueMap.put(x, yi);
    }

    int LookupValue(Variable x) {
        int i = (Integer) valueMap.get(x);
        return i;
    }
}

abstract class Expression {
    public abstract int interpret(Context con);
}

class Constant extends Expression {
    private int i;

    public Constant(int i) {
        this.i = i;
    }

    @Override
    public int interpret(Context con) {
        return i;
    }
}

class Variable extends Expression {
    @Override
    public int interpret(Context con) {
        return con.LookupValue(this);
    }
}

class Add extends Expression {
    private Expression left, right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context con) {
        return left.interpret(con) + right.interpret(con);
    }
}

class Subtract extends Expression {
    private Expression left, right;

    public Subtract(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context con) {
        return left.interpret(con) - right.interpret(con);
    }
}

class Multiply extends Expression {
    private Expression left, right;

    public Multiply(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context con) {
        return left.interpret(con) * right.interpret(con);
    }
}

class Division extends Expression {
    private Expression left, right;

    public Division(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context con) {
        try {
            return left.interpret(con) / right.interpret(con);
        } catch (Exception e) {
            System.out.println("被除数是0");
            e.printStackTrace();
            return -111;
        }
    }
}