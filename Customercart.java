public class Customercart extends CustomerDealCart implements quan{
    Double product_id;
    int quantity;
    Double product_disc;
    Double product_price;

    public Customercart(Double pd,int qu,Double p){
        this.product_id= pd;
        this.quantity=qu;
        this.product_disc=0.0;
        this.product_price=p;
    }

    public Customercart(){

    }
    @Override
    public int getQuan(){
        return this.quantity;
    }
    
    public Double getPid(){
        return this.product_id;
    }

    public Double getDisc(){
        return this.product_disc;
    }

    public Double getPrice(){
        return this.product_price;
    }

    public void setdisc(Double disc){
        this.product_disc=disc;
    }
}
