import java.util.ArrayList;
import java.util.List;

public class Main {

    static private List<Product> products;
    static private List<Product> bucket;
    static private int sum = 0;

    public static void main(String[] args)
    {
	    Product potato = new Product("111111111",10,"Potato");
	    Product tomato = new Product("111111112",12,"Tomato");
	    Product cola = new Product("111111113",14,"Cola");

        products = new ArrayList<>();
        bucket = new ArrayList<>();
        products.add(potato);
        products.add(tomato);
        products.add(cola);
        scan("");
        scan("111111111");
        scan("1111");
        scan("111111113");
        scan("exit");
        scan("111111112");
        scan("exit");

    }

    public static void scan(String input)
    {
        int len = bucket.size();
        if(input.isEmpty())
        {
            outputLCDScreen("Invalid bar-code");
            return;
        }
        if(input.equals("exit"))
        {
            printer();
            bucket.clear();
            outputLCDScreen(String.valueOf(sum));
            sum = 0;
            return;
        }
        for (Product p:
             products)
        {
            if(p.getCode().equals(input))
            {
                bucket.add(p);
                sum+=p.getPrice();
                outputLCDScreen(p.toString());
            }
        }
        if(bucket.size() == len)
        {
            outputLCDScreen("Product not found");
        }
    }

    private static void outputLCDScreen(String input)
    {
        System.out.println("LCD SCREEN: "+input);
    }

    private static void printer()
    {
        System.out.println("\nPRINTER: \n"+bucket+"\nIN TOTAL: "+sum+" PLN\n");
    }

}
