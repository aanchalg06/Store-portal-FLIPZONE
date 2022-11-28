
import java.util.ArrayList;

public class Customer extends Flipzone{
    String name;
    String password;
    Double amount;
    String status;
    ArrayList<Customercart> cart;
    ArrayList<Coupons> coupons;
    ArrayList<CustomerDealCart> dealcart;
    

    public Customer(String nm, String pass){
        this.name=nm;
        this.password=pass;
        this.status= "Normal";
        this.amount= 1000.0;
        this.cart= new ArrayList<>();
        this.coupons= new ArrayList<>();
        this.dealcart= new ArrayList<>();
    }

    Customer(){
        
    }
    
    
    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    
    public Double getAmount(){
        return this.amount;
    }

    public String getStatus(){
        return this.status;
    }

    public Double check_balance(){
        return this.amount;
    }

    public void setStatus(String st){
        this.status= st;


    }

    public void add_amount(Double amount){
        this.amount = this.amount + amount;
    }

    public void sub_amount(Double amount){
        this.amount= this.amount - amount;
    }

    public void addCart(Double pd, int qu, Double p){
        Customercart cc = new Customercart(pd,qu,p);
        cart.add(cc);
    }

    public void addDealCart(Double p1,Double p2,Double cp){
        CustomerDealCart cdc = new CustomerDealCart(p1,p2,cp);
        dealcart.add(cdc);
    }

    public void addCoupon(Double coupondisc){
        Coupons cou= new Coupons(coupondisc);
        coupons.add(cou);
    }

    public void viewcart(ArrayList<Customer> list_customer,int index){

        if(list_customer.get(index).cart.size()==0){
            System.out.println("Carty is empty right now ......Add items in here :)");
        }

        else{
        for(int i=0;i<list_customer.get(index).cart.size();i++){
            System.out.println("Item "+(i+1));
            System.out.println("Product Quantity is: "+list_customer.get(index).cart.get(i).getQuan());
            System.out.println("Product ID is "+list_customer.get(index).cart.get(i).getPid());
            // System.out.println("Product price is "+list_customer.get(index).prod.get(i).getPrice());
            System.out.println();
            
        }
    }
    }

    public void emptycart(ArrayList<Customer> list_customer,int index){
        // for(int i=0;i<list_customer.get(index).cart.size();i++){
        //     list_customer.get(index).cart.remove(i);            
        // }
        for(int i=0;i<list_customer.get(index).cart.size();i++){
            list_customer.get(index).cart.remove(i);
        }
        
        System.out.println("Cart Emptied succesfully");
    }

    public void viewdealcart(ArrayList<Customer> list_customer,int index){

        if(list_customer.get(index).dealcart.size() == 0){
            System.out.println("No deals added yet");
        }

        else{
        for(int i=0;i<list_customer.get(index).dealcart.size();i++){
            System.out.println("Item "+(i+1));
            System.out.println("Product Price is: "+list_customer.get(index).dealcart.get(i).getPrice());
            System.out.println("Product ID1 is "+list_customer.get(index).dealcart.get(i).getp1());
            System.out.println("Product ID2 is "+list_customer.get(index).dealcart.get(i).getp2());
            System.out.println();
            
        }
    }
    }

    public void viewcoupons(ArrayList<Customer> list_customer,int index){

        if(list_customer.get(index).coupons.size()==0){
            System.out.println("No coupons available at this moment......Shop from our store to get amazing coupons");
        }

        else{
        for(int i=0;i<list_customer.get(index).coupons.size();i++){
            System.out.println("Coupon "+(i+1));
            System.out.println("Coupon discount percent is: "+list_customer.get(index).coupons.get(i).getCoupon());
            System.out.println();
        }
    }
    }
    int test=0;
    public void checkout(ArrayList<Customer> list_customer,int index,ArrayList<Double> cprodiscount){
        

        if(list_customer.get(index).cart.size() == 0){
            System.out.println("Without deal cart is empty");
            System.out.println();
            test+=1;
    }

        else{
            for(int i=0;i<list_customer.get(index).cart.size();i++){
                list_customer.get(index).cart.get(i).setdisc(cprodiscount.get(i));
            }
        }

        Double sum_total_cart= 0.0;

        if(list_customer.get(index).cart.size() != 0){

        for(int i=0;i<list_customer.get(index).cart.size();i++){

            sum_total_cart += ((list_customer.get(index).cart.get(i).getPrice())* (list_customer.get(index).cart.get(i).getQuan()));
            // System.out.println(sum_total_cart +"stc");

        }
        // System.out.println(sum_total_cart + " is raw cart sum");
    }

        Double sum_total_deal= 0.0;

        if(list_customer.get(index).dealcart.size() == 0){
            System.out.println("Deal cart is empty");
            System.out.println();
            test+=1;     
        }
        else{
            for(int i=0;i<list_customer.get(index).dealcart.size();i++){
                sum_total_deal += (list_customer.get(index).dealcart.get(i).getPrice());
            }
            // System.out.println(sum_total_deal+" is raw deal sum");
        }

        if(test==2){
            System.out.println("Complete cart is empty");
            System.out.println();
            return;
        }
        Double delivery=0.0;

        if(list_customer.get(index).getStatus().equals("Elite")){
            // System.out.println("hello");
            
            delivery= 100.0;
            System.out.println("delivery Charges " + delivery);
        }

        else if(list_customer.get(index).getStatus().equals("Prime")){
            delivery= 100.0 + ((0.02)*(sum_total_cart + sum_total_deal));
            System.out.println("delivery Charges " + delivery);
        }

        else if(list_customer.get(index).getStatus().equals("Normal")){
            delivery= 100.0 + ((0.05)*(sum_total_cart + sum_total_deal));
            // System.out.println(delivery+"d");
            System.out.println("delivery Charges " + delivery);
        }


        Double sum_total_cartdisc= 0.0;
        if(list_customer.get(index).cart.size() != 0){

        for(int i=0;i<list_customer.get(index).cart.size();i++){
            sum_total_cartdisc += (((list_customer.get(index).cart.get(i).getPrice())* (list_customer.get(index).cart.get(i).getQuan()))*(1- (cprodiscount.get(i)/100)));
            // System.out.println(sum_total_cartdisc+"stcd");
        }
        // System.out.println(sum_total_cartdisc+" is sum disc cart");
            }

        Double sum_total_dealdisc=0.0;

        if(list_customer.get(index).getStatus().equals("Elite")){
            sum_total_dealdisc = (sum_total_deal);
            // System.out.println("Elite sum deal disc "+ sum_total_dealdisc);
        }

        else if(list_customer.get(index).getStatus().equals("Prime")){
            sum_total_dealdisc = (sum_total_deal);
            // System.out.println("prime sum deal disc "+ sum_total_dealdisc);
        }

        else if(list_customer.get(index).getStatus().equals("Normal")){
            sum_total_dealdisc = sum_total_deal;
            // System.out.println("normal sum deal disc "+ sum_total_dealdisc);
        }

        Double sum_total= 0.0;
        Double pay_total=0.0;

        if(list_customer.get(index).getStatus().equals("Elite")){
            sum_total= (sum_total_cart+sum_total_deal);
            // System.out.println("raw total sum elite: "+sum_total);
            if(sum_total>5000){
                System.out.println("Congrats you have recieved three coupons of value 5% 10% 15%");

                list_customer.get(index).addCoupon(15.0);
                list_customer.get(index).addCoupon(10.0);
                list_customer.get(index).addCoupon(5.0);

            }

            pay_total= (sum_total_cartdisc+sum_total_dealdisc+delivery);
            // System.out.println("Total sum to pay elite"+pay_total);
        }

        else if(list_customer.get(index).getStatus().equals("Prime")){
            sum_total= (sum_total_cart+sum_total_deal);
            // System.out.println("raw total sum Prime: "+sum_total);
            if(sum_total>5000){
                System.out.println("Congrats you have recieved two coupons of value 15% 10%");

                list_customer.get(index).addCoupon(10.0);
                list_customer.get(index).addCoupon(15.0);
            }
            pay_total= (sum_total_cartdisc+sum_total_dealdisc+delivery);
            // System.out.println("Total sum to pay prime "+pay_total);
        }

        else if(list_customer.get(index).getStatus().equals("Normal")){
            pay_total= (sum_total_cartdisc+sum_total_dealdisc+delivery);
            // System.out.println("raw total sum normal: "+sum_total);
            // System.out.println("Total sum to pay normal"+pay_total);
            // System.out.println(pay_total+"pt");
        }

        if(pay_total.equals(0.0)){
            System.out.println("Some error occured as paytotal was zero");
            return;
        }
        if(pay_total> list_customer.get(index).getAmount()){
            System.out.println("Insufficient balance in account");
            return;
        }
        int t=0;

        if(list_customer.get(index).cart.size()!=0){
        for(int k=0;k<list_customer.get(index).cart.size();k++){
            for(int i=0;i<list_category.size();i++){
                for(int j=0;j<list_category.get(i).product_id.size();j++){
                    if(list_customer.get(index).cart.get(k).getPid().equals(list_category.get(i).product_id.get(j).getID())){
                        if(list_customer.get(index).cart.get(k).getQuan() > list_category.get(i).product_quan.get(j).getQuan()){
                            t=1;
                            System.out.println("Insufficient Stock available for "+ list_customer.get(index).cart.get(k).getPid()+ " Product ID hence can't add to cart");
                            list_customer.get(index).cart.remove(k);
                            System.out.println("Sorry for the inconvience but that product has been removed from the cart");
                        }
                    }
            }
        }
    }
}

    if(list_customer.get(index).dealcart.size()!=0)
    {
    for(int k=0;k<list_customer.get(index).dealcart.size();k++)
    {
        for(int i=0;i<list_category.size();i++)
        {
            for(int j=0;j<list_category.get(i).product_id.size();j++)
            {
                for(int m=0;m<list_category.get(i).product_id.size();m++)
                {

                if((list_customer.get(index).dealcart.get(k).getp1().equals(list_category.get(i).product_id.get(j).getID())) && (list_customer.get(index).dealcart.get(k).getp2().equals(list_category.get(i).product_id.get(m).getID())))
                {
                    if((list_category.get(i).product_id.get(m).getID() <=0) && (list_category.get(i).product_id.get(j).getID()<=0)){
                        t=2;
                            System.out.println("Insufficient Stock available for deal added hence can't add to cart");
                            list_customer.get(index).dealcart.remove(k);
                            System.out.println("Sorry for the inconvience but that deal has been removed from the cart");
                    }
                }
            }
            
        }
    }
}
    }

        if(t==1 || t==2){
            System.out.println("Some issue with cart occured hence try again");
            return;
            }

        else if(t==0)
        {
            if(list_customer.get(index).cart.size()!=0){

            for(int k=0;k<list_customer.get(index).cart.size();k++){

                for(int i=0;i<list_category.size();i++){

                    for(int j=0;j<list_category.get(i).product_id.size();j++){

                        if(list_customer.get(index).cart.get(k).getPid().equals(list_category.get(i).product_id.get(j).getID())){

                            if(list_customer.get(index).cart.get(k).getQuan() <= list_category.get(i).product_quan.get(j).getQuan()){
                    
                                list_category.get(i).product_quan.get(j).setQuan(list_customer.get(index).cart.get(k).getQuan());
                            }
                        }
                }
            }
        }
    }

    if(list_customer.get(index).dealcart.size()!=0){

        for(int k=0;k<list_customer.get(index).dealcart.size();k++)
    {
        for(int i=0;i<list_category.size();i++)
        {
            for(int j=0;j<list_category.get(i).product_id.size();j++)
            {
                for(int m=0;m<list_category.get(i).product_id.size();m++)
                {

                if((list_customer.get(index).dealcart.get(k).getp1().equals(list_category.get(i).product_id.get(j).getID())) && (list_customer.get(index).dealcart.get(k).getp2().equals(list_category.get(i).product_id.get(m).getID())))
                {
                    if((list_category.get(i).product_id.get(m).getID() >0) && (list_category.get(i).product_id.get(j).getID()>0)){
                        list_category.get(i).product_quan.get(j).setQuan(1);
                        list_category.get(i).product_quan.get(m).setQuan(1);

                    }
                }
            }
            
        }
    }
}
}
            
        }

        if(list_customer.get(index).getStatus().equals("Elite")){
            int randomnumber= (int) (Math.random() * (9-1)) + 1;

            //free elite surprise
            if(randomnumber == 6){
                System.out.println();
                System.out.println("Congrats being such an valuable member to our compnay you have won a free surprise from FLIPZONE");

                System.out.println("You get a free product hair dryer worth rupees 2000");
                System.out.println();
            }
        }

        // public int getRandomNumber(int min, int max) {
        //     return (int) ((Math.random() * (max - min)) + min);
        // }

            list_customer.get(index).sub_amount(pay_total);
            System.out.println();
            System.out.println("Order palced successfully");
            System.out.println();
            System.out.println("Payable amount: "+pay_total);
            System.out.println();
            System.out.println("Remaining balance is: "+ list_customer.get(index).getAmount());
            System.out.println();

            if(list_customer.get(index).getStatus().equals("Elite")){
                System.out.println("Your order will be delivered in 1-2 days....For any query contact helpline number 180002020");
            }
            else if(list_customer.get(index).getStatus().equals("Prime")){
                System.out.println("Your order will be delivered in 3-6 days....For any query contact helpline number 180002020");
            }
            else if(list_customer.get(index).getStatus().equals("Normal")){
                System.out.println("Your order will be delivered in 7-10 days....For any query contact helpline number 180002020");
            }
            System.out.println();
            System.out.println("Thank you for your visit");

            for(int i=0;i<list_customer.get(index).cart.size();i++){
                list_customer.get(index).cart.remove(i);
            }
            return;
        


    }
  


}
