import java.util.ArrayList;
import java.util.Scanner;

public class Category {
    int category_ID;
    String category_name;
    ArrayList<ProductID> product_id;
    ArrayList<Productprice> product_price;
    ArrayList<Productdesc> product_desc;
    ArrayList<ProductQuantity> product_quan;
    ArrayList<ProductDiscount> product_disc;

    Category(int id, String name) {
        this.category_ID = id;
        this.category_name = name;
        this.product_id = new ArrayList<>();
        this.product_desc = new ArrayList<>();
        this.product_price = new ArrayList<>();
        this.product_quan= new ArrayList<>();
        this.product_disc= new ArrayList<>();
    }

    Category() {
        
    }
    
    public void AddDetails(ArrayList<Category> list_category) {
        Scanner input = new Scanner(System.in);
        System.out.println("Add a product");


        System.out.println("Enter Product ID");
        Double pid = input.nextDouble();
        ProductID Pid = new ProductID(pid);
        product_id.add(Pid);


        System.out.println("Enter Product Price");
        Double pprice = input.nextDouble();
        Productprice price = new Productprice(pprice);
        product_price.add(price);


        System.out.println("Enter Product quantity");
        int quantity= input.nextInt();
        ProductQuantity quan= new ProductQuantity(quantity);
        product_quan.add(quan);


        System.out.println("Enter Product desc");
        String description = "";
        String pdesc = input.next();
        if (pdesc.compareTo(".") != 0) {
            description += pdesc + "\n";
        }
        while (pdesc.compareTo(".") != 0) {
            pdesc = input.next();
            if (pdesc.compareTo(".") != 0) {
                description += pdesc + "\n";
            }
        }

        Productdesc Pdes = new Productdesc(description);
        product_desc.add(Pdes);

        ProductDiscount Pd = new ProductDiscount(0.01,0.01,0.01);
        product_disc.add(Pd);

    }

    public void addProduct(ArrayList<Category> list_category, int index) {
        Scanner input = new Scanner(System.in);

        System.out.println("Add a product");


        System.out.println("Enter Product ID");
        Double pid = input.nextDouble();
        ProductID Pid = new ProductID(pid);
        list_category.get(index).product_id.add(Pid);


        System.out.println("Enter Product Price");
        Double pprice = input.nextDouble();
        Productprice price = new Productprice(pprice);
        list_category.get(index).product_price.add(price);


        System.out.println("Enter Product quantity");
        int quantity= input.nextInt();
        ProductQuantity quan= new ProductQuantity(quantity);
        list_category.get(index).product_quan.add(quan);


        System.out.println("Enter Product desc");
        String description = "";
        String pdesc = input.next();
        if (pdesc.compareTo(".") != 0) {
            description += pdesc + "\n";
        }
        while (pdesc.compareTo(".") != 0) {
            pdesc = input.next();
            if (pdesc.compareTo(".") != 0) {
                description += pdesc + "\n";
            }
        }
        Productdesc Pdes = new Productdesc(description);
        list_category.get(index).product_desc.add(Pdes);


        ProductDiscount Pd = new ProductDiscount(0.01,0.01,0.01);
        list_category.get(index).product_disc.add(Pd);

    }

    public void addDiscount(ArrayList<Category> list_category,int indexc,int indexp){
        Scanner input = new Scanner(System.in);

        System.out.println("Add Product Disount for Elite Prime and normal users");

        Double pde = input.nextDouble();
        Double pdp= input.nextDouble();
        Double pdn= input.nextDouble();
        
        product_disc.get(indexp).setDiscount(pde,pdp,pdn);

        // for(int i=0;i<list_category.get(0).product_disc.size();i++){
        //     System.out.println(list_category.get(0).product_disc.get(i).getEdiscount());
        //     System.out.println(list_category.get(0).product_disc.get(i).getPdiscount());
        //     System.out.println(list_category.get(0).product_disc.get(i).getNdiscount());
        //     System.out.println();
        // }
    }

    
    public Double getPrice(int indexp2){    
        return(product_price.get(indexp2).getPrice());
    }

    
    public Double getID(int p){
        return(product_id.get(p).getID());
    }


}
