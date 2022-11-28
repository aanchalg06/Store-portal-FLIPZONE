

public class ProductDiscount implements information{
    Double eliteDiscount;
    Double primeDiscount;
    Double normalDiscount;

    ProductDiscount(Double e,Double p,Double n){
        this.eliteDiscount=e;
        this.primeDiscount=p;
        this.normalDiscount=n;

    }

    @Override
    public Double getelite(){
        return this.eliteDiscount;
    }

    @Override
    public Double getprime(){
        return this.primeDiscount;
    }

    @Override
    public Double getnormal(){
        return this.normalDiscount;
    }

    
    public void setDiscount(Double e, Double p,Double n){
        this.eliteDiscount=e;
        this.primeDiscount=p;
        this.normalDiscount=n;
    }
}
