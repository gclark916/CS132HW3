class Hurr{
    public static void main(String[] useless)
    {
        B a;
        boolean res;
        a = new A();
        res = a.method1();
        a = new B();
        res = a.method1();
        a = new A();
        res = a.method1();
    }
}

class A
{
    public boolean method1()
    { 
        System.out.println(1); 
        return true;
    }
}

class B extends A
{
    public boolean method1()
    { 
        System.out.println(2); 
        return true;
    }
}