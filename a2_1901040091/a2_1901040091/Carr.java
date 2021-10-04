package a2_1901040091;

public class Carr {
    private String name; 
    private int speed;
    private double regularPrice;
    private String color;

    public Carr (String name, int speed, double regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
        this.name = name;
    }

    public double getSalePrice() {
        if(color.equals("black")) {
            return regularPrice * 1.5;
        } else {
            return regularPrice * 1.2;
        }
    }

    public static void main(String[] args) {
        Carr fordMondeo = new Carr("Ford Mondeo", 80, 5000, "red");
        System.out.println("Name: " + fordMondeo.name 
                           +"\n"+"Speed: " + fordMondeo.speed
                           +"\n"+"RegularPrice: " + fordMondeo.regularPrice
                           +"\n"+"SalePrice: "+fordMondeo.getSalePrice());
        System.out.println("\n");
        Carr toyotaCamry = new Carr("Ford Mondeo", 80, 5000, "red");
        System.out.println("Name: " + toyotaCamry.name 
                           +"\n"+"Speed: " + toyotaCamry.speed
                           +"\n"+"RegularPrice: " + toyotaCamry.regularPrice
                           +"\n"+"SalePrice: "+toyotaCamry.getSalePrice());                 
    }
}
