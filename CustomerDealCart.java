public class CustomerDealCart implements productpid,price{
    Double combinedprice;
    Double proone;
    Double protwo;

    CustomerDealCart(){

    }

    CustomerDealCart(Double p1,Double p2,Double cp){
        this.proone=p1;
        this.protwo=p2;
        this.combinedprice=cp;
    }

    @Override
    public Double getp1(){
        return this.proone;
    }

    @Override
    public Double getp2(){
        return this.protwo;
    }
    
    @Override
    public Double getPrice(){
        return this.combinedprice;
    }
    
}
