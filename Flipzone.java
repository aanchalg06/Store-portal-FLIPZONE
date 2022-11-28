//Assumption only unique category id are given
//Assumption right username password is being used by customer

import java.util.ArrayList;
import java.util.Scanner;

public class Flipzone {
    public static ArrayList<Category> list_category = new ArrayList<>();

    public static ArrayList<Customer> list_customer = new ArrayList<>();

    public static ArrayList<GiveawayDeal> giveaway_deal = new ArrayList<>();

    static String username = "aanchal21224";
    static int password = 2021224;

    static Scanner input = new Scanner(System.in);

    public static void enterAsAdmin() {
        System.out.println("Please choose anyone of the following actions: ");
        System.out.println(
                "1. Add category" + "\n" + "2. Delete Category" + "\n" + "3. Add Product" + "\n" + "4. Delete Product"
                        + "\n" + "5. Set Discount on Product" + "\n" + "6. Add giveaway deal" + "\n" + "7.Back" + "\n");

    }

    public static void enterAsCustomer() {
        System.out.println("1. Sign up" + "\n" + "2. Log in" + "\n" + "3. Back");

    }

    public static void customerLogin() {

        System.out.println("1. Browse products" + "\n" + "2. Browse deals" + "\n" + "3. Add a product to cart" + "\n"
                + "4. Add products in deal to cart" + "\n" + "5. View coupons" + "\n" + "6. Check account balance"
                + "\n" + "7. View cart" + "\n" + "8.Empty cart" + "\n" + "9. Checkout cart" + "\n"
                + "10. Upgrade customer status" + "\n" + "11. Add amount to wallet" + "\n" + "12.Back");

    }

    public static void main(String[] args) {
        System.out.println("Welcome to FLIPZONE");

        boolean t = true;

        while (t) {
            System.out.println("1. Enter as Admin " + "\n" + "2. Explore the Product Catalog" + "\n"
                    + "3. Show Available Deals" + "\n" + "4. Enter as customer" + "\n" + "5. Exit the application"
                    + "\n");

            int echoice = input.nextInt();
            Category cons = new Category();
            Customer cust = new Customer();
            switch (echoice) {
                case 1:
                    System.out.println("welcome in admin mode");

                    System.out.println("Hello Dear admin :)");

                    System.out.print("Enter the username: ");
                    String name = input.next();

                    System.out.print("Enter the password:");
                    int rno = input.nextInt();

                    while (name != username && rno != password) {

                        System.out.println("Wrong username or password");

                        System.out.print("Enter the username: ");
                        name = input.next();

                        System.out.print("Enter the password:");
                        rno = input.nextInt();

                    }

                    System.out.println("Welcome " + username);

                    int onechoice = 0;

                    while (onechoice != 7) {

                        enterAsAdmin();

                        onechoice = input.nextInt();

                        switch (onechoice) {
                            case 1:
                                // add category

                                System.out.println("Enter category id: ");
                                int catid = input.nextInt();
                                System.out.println("Enter category name");
                                String catname = input.next();
                                Category obj = new Category(catid, catname);
                                list_category.add(obj);

                                obj.AddDetails(list_category);
                                cons = obj;

                                break;

                            case 2:
                                // delete category
                                System.out.println("Enter Category id");
                                int cid = input.nextInt();

                                int index = 0;
                                for (int i = 0; i < list_category.size(); i++) {
                                    if (cid == list_category.get(i).category_ID) {
                                        index = i;
                                        break;
                                    }
                                }

                                list_category.remove(index);
                                // System.out.println(list_category.get(0).category_ID);
                                break;

                            case 3:
                                // add product
                                System.out.println("Enter category id");
                                cid = input.nextInt();

                                index = 0;

                                for (int i = 0; i < list_category.size(); i++) {
                                    if (cid == list_category.get(i).category_ID) {
                                        index = i;
                                        break;
                                    }
                                }

                                // Category cons= new Category();
                                cons.addProduct(list_category, index);

                                break;

                            case 4:
                                // delete product
                                System.out.println("enter category id");
                                cid = input.nextInt();

                                int indexc = 0;

                                for (int i = 0; i < list_category.size(); i++) {
                                    if (cid == list_category.get(i).category_ID) {
                                        indexc = i;
                                        break;
                                    }
                                }

                                System.out.println("Enter product Id");
                                Double prodid = input.nextDouble();

                                int indexp = 0;

                                for (int i = 0; i < list_category.get(indexc).product_id.size(); i++) {
                                    if (prodid == list_category.get(indexc).product_id.get(i).getID()) {
                                        indexp = i;
                                        break;
                                    }
                                }

                                list_category.get(indexc).product_id.remove(indexp);

                                list_category.get(indexc).product_desc.remove(indexp);

                                list_category.get(indexc).product_price.remove(indexp);

                                list_category.get(indexc).product_quan.remove(indexp);

                                list_category.get(indexc).product_disc.remove(indexp);

                                break;

                            case 5:
                                // set discount on product
                                System.out.println("Enter product id");

                                indexc = 0;
                                indexp = 0;

                                prodid = input.nextDouble();

                                for (int i = 0; i < list_category.size(); i++) {
                                    for (int j = 0; j < list_category.get(i).product_id.size(); j++) {
                                        if (list_category.get(i).product_id.get(j).getID() == prodid) {
                                            indexc = i;
                                            indexp = j;
                                            break;
                                        }
                                    }
                                }

                                // Category const=new Category();
                                cons.addDiscount(list_category, indexc, indexp);
                                System.out.println("Discount added");
                                break;

                            case 6:
                                // add giveaway deal
                                System.out.println("Enter product Id 1");
                                Double p1 = input.nextDouble();

                                System.out.println("Enter product id 2");
                                Double p2 = input.nextDouble();

                                System.out.println("Enter combined price (must be less than total price");
                                System.out.println("Elite");
                                Double cpe = input.nextDouble();
                                System.out.println("Prime");
                                Double cpp = input.nextDouble();
                                System.out.println("Normal");
                                Double cpn = input.nextDouble();

                                int indexc1 = -1;
                                int indexc2 = -1;
                                int indexp1 = -1;
                                int indexp2 = -1;
                                // System.out.println("1");

                                for (int i = 0; i < list_category.size(); i++) {
                                    // System.out.println(i+"i");
                                    for (int j = 0; j < list_category.get(i).product_id.size(); j++) {
                                        // System.out.println(j+"j");

                                        if (p1.equals(list_category.get(i).getID(j))) {
                                            indexp1 = j;
                                            indexc1 = i;
                                            // System.out.println("ok");
                                        }

                                        else if (p2.equals(list_category.get(i).getID(j))) {
                                            // System.out.println("ok2");
                                            indexc2 = i;
                                            indexp2 = j;
                                        }
                                    }
                                }
                                // System.out.println("end");

                                // System.out.println(list_category.get(indexc1).getPrice(indexp1));

                                if (indexp1 != -1 && indexp2 != -1 && indexc1 != -1 && indexc2 != -1) {

                                    if ((list_category.get(indexc1).getPrice(indexp1)+ list_category.get(indexc2).getPrice(indexp2) > cpe)&& (list_category.get(indexc1).getPrice(indexp1)+ list_category.get(indexc2).getPrice(indexp2) > cpn)&& (list_category.get(indexc1).getPrice(indexp1)+ list_category.get(indexc2).getPrice(indexp2) > cpp)) {

                                        GiveawayDeal give = new GiveawayDeal(p1, p2, cpe, cpp, cpn);
                                        giveaway_deal.add(give);

                                        // System.out.println(giveaway_deal.get(0).combinedpriceforElite);
                                    }

                                    else {
                                        System.out.println("Prices can not be set according to giveaway deals");

                                    }
                                }

                                else {
                                    System.out.println("Product id is not present in product list");
                                }

                                break;

                            default:
                                break;

                        }
                    }
                    break;

                case 2:
                    System.out.println("Viewing product catalouge");

                    System.out.println();

                    for (int i = 0; i < list_category.size(); i++) {
                        for (int j = 0; j < list_category.get(i).product_id.size(); j++) {

                            System.out.println("Category Id is " + list_category.get(i).category_ID);

                            System.out.println("Product ID: " + list_category.get(i).product_id.get(j).getID());
                            System.out.println(
                                    "Product Description: " + list_category.get(i).product_desc.get(j).getDesc());
                            System.out
                                    .println("Product Price: " + list_category.get(i).product_price.get(j).getPrice());
                            System.out
                                    .println("Product Quantity: " + list_category.get(i).product_quan.get(j).getQuan());
                            System.out.println();

                        }
                    }
                    System.out.println("Thank you for viewing product catalogue");

                    break;

                case 3:
                    System.out.println("showing available deals");

                    for (int i = 0; i < giveaway_deal.size(); i++) {
                        System.out.println("Deal " + (i + 1));
                        System.out.println();

                        System.out.println("Product id 1: " + giveaway_deal.get(i).getp1());
                        System.out.println("Product id 2: " + giveaway_deal.get(i).getp2());
                        System.out.println("Elite price: " + giveaway_deal.get(i).getelite());
                        System.out.println("Prime price: " + giveaway_deal.get(i).getprime());
                        System.out.println("Normal price: " + giveaway_deal.get(i).getnormal());
                        System.out.println();
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("welcome in customer mode");

                    int cchoice = 0;

                    while (cchoice != 3) {
                        System.out.println();

                        enterAsCustomer();

                        cchoice = input.nextInt();

                        switch (cchoice) {
                            case 1:
                                // sign up

                                System.out.println("Enter name: ");
                                String cusname = input.next();

                                System.out.println("Enter password: ");
                                String cuspass = input.next();

                                Customer object = new Customer(cusname, cuspass);
                                list_customer.add(object);

                                // object.AddDetails(list_customer);
                                cust = object;

                                break;

                            case 2:
                                // login

                                System.out.println("Enter name: ");
                                cusname = input.next();

                                System.out.println("Enter password: ");
                                cuspass = input.next();

                                int index = -1;

                                for (int i = 0; i < list_customer.size(); i++) {
                                    if (cusname.equals(list_customer.get(i).getName())) {
                                        index = i;
                                    }
                                }

                                // System.out.println(index);

                                int clchoice = 0;
                                
                                while (clchoice != 12) {
                                    customerLogin();

                                    clchoice = input.nextInt();

                                    switch (clchoice) {
                                        case 1:
                                            // browse products

                                            System.out.println();
                                            System.out.println("Enter product id you like to browse");
                                            Double p = input.nextDouble();

                                            for (int i = 0; i < list_category.size(); i++) {
                                                for (int j = 0; j < list_category.get(i).product_id.size(); j++) {
                                                    if (p.equals(list_category.get(i).product_id.get(j).getID())) {
                                                        System.out.println(
                                                                "Category Id is " + list_category.get(i).category_ID);
                                                        System.out.println("Product ID: "
                                                                + list_category.get(i).product_id.get(j).getID());
                                                        System.out.println("Product Description: "
                                                                + list_category.get(i).product_desc.get(j).getDesc());
                                                        System.out.println("Product Price: "
                                                                + list_category.get(i).product_price.get(j).getPrice());
                                                        System.out.println("Product Quantity: "
                                                                + list_category.get(i).product_quan.get(j).getQuan());
                                                        System.out.println();
                                                    }

                                                }
                                            }
                                            System.out.println("Thank you for viewing product catalogue");

                                            break;

                                        case 2:
                                            // browse deals
                                            System.out.println("showing available deals");

                                            for (int i = 0; i < giveaway_deal.size(); i++) {
                                                System.out.println("Deal " + (i + 1));
                                                System.out.println();

                                                System.out.println("Product id 1: " + giveaway_deal.get(i).getp1());
                                                System.out.println("Product id 2: " + giveaway_deal.get(i).getp2());
                                                System.out.println("Elite price: " + giveaway_deal.get(i).getelite());
                                                System.out.println("Prime price: " + giveaway_deal.get(i).getprime());
                                                System.out.println("Normal price: " + giveaway_deal.get(i).getnormal());
                                                System.out.println();
                                                System.out.println();
                                            }

                                            break;

                                        case 3:
                                            // add a product to cart

                                            System.out.println("NOTE: products are non deal");
                                            System.out.println();

                                            System.out.println("Enter product id: ");

                                            Double pd = input.nextDouble();

                                            System.out.println("Enter product quantity you want to add: ");

                                            int qu = input.nextInt();
                                            int c = -1;
                                            int pop = -1;

                                            for (int i = 0; i < list_category.size(); i++) {
                                                for (int j = 0; j < list_category.get(i).product_id.size(); j++) {
                                                    if (pd.equals(list_category.get(i).product_id.get(j).getID())) {
                                                        c = i;
                                                        pop = j;
                                                    }
                                                }
                                            }

                                            if (c == -1 || pop == -1) {
                                                System.out.println("No such id exists");
                                                break;
                                            }

                                            else {
                                                if (qu <= (list_category.get(c).product_quan.get(pop).getQuan())) {
                                                    Double prprice= list_category.get(c).product_price.get(pop).getPrice();
                                                    list_customer.get(index).addCart(pd, qu,prprice);

                                                }

                                                else {
                                                    System.out.println("Quantity insufficient");
                                                }
                                            }

                                            // cust.viewcart(list_customer, index);

                                            break;

                                        case 4:
                                            // add products in deal to cart

                                            System.out.println(
                                                    "Note: Assuming that a deal is being accessed only once per purchase");

                                            System.out.println("showing available deals");

                                            for (int i = 0; i < giveaway_deal.size(); i++) {

                                                System.out.println("Deal " + (i + 1));
                                                System.out.println();

                                                System.out.println("Product id 1: " + giveaway_deal.get(i).getp1());
                                                System.out.println("Product id 2: " + giveaway_deal.get(i).getp2());
                                                if ((list_customer.get(index).getStatus()).equals("Elite")) {
                                                    System.out
                                                            .println("Elite price: " + giveaway_deal.get(i).getelite());
                                                }

                                                else if ((list_customer.get(index).getStatus()).equals("Prime")) {
                                                    System.out
                                                            .println("Prime price: " + giveaway_deal.get(i).getprime());
                                                }

                                                else if ((list_customer.get(index).getStatus()).equals("Normal")) {
                                                    System.out.println(
                                                            "Normal price: " + giveaway_deal.get(i).getnormal());
                                                }
                                                System.out.println();
                                                System.out.println();
                                            }


                                            System.out.println("Please enter the Product ID 1");
                                            Double p1 = input.nextDouble();
                                            System.out.println("Please enter the Product ID 2");
                                            Double p2 = input.nextDouble();

                                            int ind1 = -1;
                                            int ind2=-1;

                                            for (int i = 0; i < giveaway_deal.size(); i++) {
                                                if ((giveaway_deal.get(i).getp1()).equals(p1)) {
                                                    ind1 = i;
                                                }
                                                if((giveaway_deal.get(i).getp2()).equals(p2)){
                                                    ind2=1;
                                                }
                                            }
                                            if (ind1 != -1 && ind2!=-1) {

                                                Double cp = 0.0;
                                                if ((list_customer.get(index).getStatus()).equals("Elite")) {
                                                    cp = giveaway_deal.get(ind1).getelite();
                                                }

                                                else if ((list_customer.get(index).getStatus()).equals("Prime")) {
                                                    cp = giveaway_deal.get(ind1).getprime();
                                                }

                                                else if ((list_customer.get(index).getStatus()).equals("Normal")) {
                                                    cp = giveaway_deal.get(ind1).getnormal();
                                                }

                                                list_customer.get(index).addDealCart(p1, p2, cp);

                                            }

                                            else {
                                                System.out.println("Wrong product id given");
                                            }
                                            break;

                                        case 5:
                                            // view coupons
                                            cust.viewcoupons(list_customer, index);
                                            break;

                                        case 6:
                                            // check account balance
                                            System.out.println("Here is your account balance:");
                                            System.out.println(list_customer.get(index).getAmount());
                                            break;

                                        case 7:
                                            // view cart
                                            System.out.println("Viewing your cart Dear Customer");
                                            cust.viewcart(list_customer, index);

                                            System.out.println("Viewing your deal cart Dear Customer");
                                            cust.viewdealcart(list_customer, index);

                                            break;

                                        case 8:
                                            // empty cart
                                            System.out.println("Emptying cart in process.....");
                                            cust.emptycart(list_customer, index);
                                            break;

                                        case 9:
                                            // checkout cart

                                            System.out.println("Proceeding to checkout. Details:");

                                            cust.viewcart(list_customer, index);
                                            cust.viewdealcart(list_customer, index);

                                            Double status_discount = 0.0;
                                            Double coupon_discount = 0.0;

                                            if (list_customer.get(index).getStatus().equals( "Elite")) {
                                                status_discount = 10.0;
                                            }
                                            else if (list_customer.get(index).getStatus().equals("Prime")) {
                                                status_discount = 5.0;
                                            } 
                                            else if (list_customer.get(index).getStatus().equals("Normal")) {
                                                status_discount = 0.0;
                                            }

                                            if(list_customer.get(index).coupons.size() >0){

                                            for (int i = 0; i < list_customer.get(index).coupons.size(); i++) {
                                            if (list_customer.get(index).coupons.get(i).getCoupon() > coupon_discount) {
                                                    coupon_discount = list_customer.get(index).coupons.get(i).getCoupon();
                                                }
                                            }
                                        }

                                        // System.out.println("coupon disc: "+coupon_discount);
                                        
                                        // System.out.println("status disc: "+status_discount);
                                        

                                        ArrayList<Double> cprodiscount= new ArrayList<>(list_customer.get(index).cart.size());
                                            
                                            // now I have status discount and coupon discount

                                            for(int i=0;i<list_customer.get(index).cart.size();i++)
                                            {
                                                for(int j=0;j<list_category.size();j++){

                                                    for(int k=0;k<list_category.get(j).product_id.size();k++){

                                                        if((list_category.get(j).product_id.get(k).getID()).equals(list_customer.get(index).cart.get(i).getPid())) {

                                                            if(list_customer.get(index).getStatus().equals("Elite")){

                                                            if((list_category.get(j).product_disc.get(k).getelite()).equals(0.01)){

                                                                cprodiscount.add(0.0);
                                                                // System.out.println("if elite cprodiscount");
                                                                // for(int m=0;m<cprodiscount.size();m++){
                                                                //     System.out.println(cprodiscount.get(m));
                                                                // }
                                                            }

                                                            else{
                                                                cprodiscount.add((list_category.get(j).product_disc.get(k).getelite()));
                                                                // System.out.println("else elite cprodiscount");
                                                                // for(int m=0;m<cprodiscount.size();m++){
                                                                //     System.out.println(cprodiscount.get(m));
                                                                // }
                                                            }
                                                            
                                                            }

                                                            else if(list_customer.get(index).getStatus().equals("Prime")){

                                                                if((list_category.get(j).product_disc.get(k).getprime()).equals(0.01)){
    
                                                                    cprodiscount.add(0.0);
                                                                //     System.out.println("if prime cprodiscount");
                                                                // for(int m=0;m<cprodiscount.size();m++){
                                                                //     System.out.println(cprodiscount.get(m));
                                                                // }
                                                                
                                                                }
    
                                                                else{
                                                                    cprodiscount.add((list_category.get(j).product_disc.get(k).getprime()));
                                                                //     System.out.println("else prime cprodiscount");
                                                                //     for(int m=0;m<cprodiscount.size();m++){
                                                                //     System.out.println(cprodiscount.get(m));
                                                                // }
                                                                }
                                                            }

                                                            else if(list_customer.get(index).getStatus().equals("Normal")){

                                                                if((list_category.get(j).product_disc.get(k).getnormal()).equals(0.01)){
                                                                    cprodiscount.add(0.0);

                                                                //     System.out.println("if normal cprodiscount");
                                                                // for(int m=0;m<cprodiscount.size();m++){
                                                                //     System.out.println(cprodiscount.get(m));
                                                                // }
    
                                                                }
    
                                                                else{
                                                                    cprodiscount.add((list_category.get(j).product_disc.get(k).getnormal()));
                                                                //     System.out.println("else normal cprodiscount");
                                                                //     for(int m=0;m<cprodiscount.size();m++){
                                                                //     System.out.println(cprodiscount.get(m));
                                                                    
                                                                // }
                                                            }
                                                        }                                                          
                                                            
                                                        }
                                                    }
                                                }
                                            }

                                            
                                            for(int i=0;i<list_customer.get(index).cart.size();i++){
                                                Double max=0.0;
                                                // System.out.println(i+" ");
                                                if(cprodiscount.get(i) > status_discount){
                                                    max= cprodiscount.get(i);
                                                    // System.out.println("disc admin "+ max);
                                                    // System.out.println("disc admin "+ cprodiscount.get(i));
                                                }

                                                else{
                                                    max=status_discount;
                                                    // System.out.println("status dis "+max);
                                                    // System.out.println("status dis "+status_discount);
                                                }

                                                if(max<coupon_discount){
                                                    max=coupon_discount;
                                                    // System.out.println("coup disc "+max);
                                                    // System.out.println("coup disc "+ coupon_discount);
                                                }
                                                
                                                cprodiscount.set(i,max);

                                            //     for(int m=0;m<cprodiscount.size();m++){
                                            //         System.out.println(cprodiscount.get(m) +" index "+ i +" with "+max);
                                            // }
                                        }
                                            // System.out.println("Outside for loop");

                                            // System.out.println(list_customer.get(index).cart.size());
                                            // System.out.println(cprodiscount.size());

                                            // for(int i=0;i<list_customer.get(index).cart.size();i++){
                                                
                                            //     System.out.println(cprodiscount.get(i) + " "+ (i+1));
                                                
                                            // }
                                            
                                            cust.checkout(list_customer,index,cprodiscount);
                                            break;
                                        

                                        case 10:
                                            // upgrade customer status

                                            System.out.println(
                                                    "Enter status to be updated(Elite :300,Prime : 200,Normal: 0)");

                                            String st = input.next();

                                            if (list_customer.get(index).getStatus().equals("Normal")) {
                                                if (st.equals("Elite")) {
                                                    if (list_customer.get(index).getAmount() < 300) {
                                                        System.out.println("Insufficient balance Can't update");
                                                    }

                                                    else {
                                                        System.out.println("Congrats now you are an elite member");
                                                        list_customer.get(index).sub_amount(300.0);
                                                        list_customer.get(index).setStatus(st);

                                                    }

                                                }

                                                else if (st.equals("Prime")) {
                                                    if (list_customer.get(index).getAmount() < 200) {
                                                        System.out.println("Insufficient balance Can't update");
                                                    }

                                                    else {
                                                        System.out.println("Congrats now you are an prime member");
                                                        list_customer.get(index).sub_amount(200.0);
                                                        list_customer.get(index).setStatus(st);
                                                        // System.out.println(list_customer.get(index).getStatus());
                                                        // System.out.println(list_customer.get(index).getAmount());
                                                    }

                                                }

                                                else {
                                                    System.out.println("Some wrong input entered");
                                                }
                                            }

                                            else if (list_customer.get(index).getStatus().equals("Prime")) {
                                                if (st.equals("Elite")) {
                                                    if (list_customer.get(index).getAmount() < 100) {
                                                        System.out.println("Insufficient balance Can't update");
                                                    }

                                                    else {
                                                        System.out.println("Congrats now you are an Elite member");
                                                        list_customer.get(index).sub_amount(300.0);
                                                        list_customer.get(index).setStatus(st);

                                                    }

                                                } else {
                                                    System.out.println("Some wrong input entered");
                                                }

                                            }

                                            else {
                                                System.out.println("NO Updation available");
                                            }

                                            break;

                                        case 11:
                                            // add amount to wallet

                                            System.out.println("Enter amount to be added: ");
                                            Double amount = input.nextDouble();
                                            list_customer.get(index).add_amount(amount);

                                            break;

                                        default:
                                            break;

                                    }
                                    
                                }

                                break;
                        }
                    }
                    break;
            
            
                case 5:
                    System.out.println("Thank you for visiting FLIPZONE");

                    t = false;

                    System.exit(0);
                    }

            }
        }
    }
