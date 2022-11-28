public class GiveawayDeal implements productpid, information{
    Double productone;
    Double producttwo;
    Double combinedpriceforElite;
    Double combinedpriceforPrime;
    Double combinedpriceforNormal;


    public GiveawayDeal(Double p1,Double p2, Double cpe,Double cpp, Double cpn ){
        this.combinedpriceforElite=cpe;
        this.combinedpriceforPrime=cpp;
        this.combinedpriceforNormal=cpn;
        this.productone=p1;
        this.producttwo=p2;
    }

    public GiveawayDeal(){

    }

    @Override
    public Double getp1(){
        return this.productone;
    }

    @Override
    public Double getp2(){
        return this.producttwo;
    }

    @Override
    public Double getelite(){
        return this.combinedpriceforElite;
    }

    @Override
    public Double getprime(){
        return this.combinedpriceforPrime;
    }

    @Override
    public Double getnormal(){
        return this.combinedpriceforNormal;
    }


}
