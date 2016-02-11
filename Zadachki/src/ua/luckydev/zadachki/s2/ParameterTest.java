package ua.luckydev.zadachki.s2;

public class ParameterTest
{
    private static class A
    {
        private String a;

        public A(String a)
        {
            this.a = a;
        }

        public void setA(String a)
        {
            this.a = a;
        }

        @Override
        public String toString()
        {
            return "A [a=" + a + "]";
        }
    }

    private static class B
    {
        private A a;

        public B(A a)
        {
            this.a = a;
        }

        public void setA(A a)
        {
            this.a = a;
        }

        public A getA()
        {
            return a;
        }

        @Override
        public String toString()
        {
            return "B [a=" + a + "]";
        }

    }

    private static void change(B b)
    {
        b = new B(new A("3"));
        b.getA().setA("4");
    }

    public static void main(String[] args)
    {
        A a = new A("1");
        System.out.println(a); //??? A a 1
        B b = new B(a);
        System.out.println(b); //??? B a 1
        a.setA("2");
        System.out.println(a); //??? A a 2
        System.out.println(b); //??? B a 2
        change(b);
        System.out.println(b); //??? B a 2
        System.out.println(b.getA()); //??? A a 2
    }

}
