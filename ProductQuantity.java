public class ProductQuantity implements quan {
    int quantity;

    ProductQuantity(int quantity){
        this.quantity=quantity;
    }
    
    @Override
    public int getQuan(){
        return this.quantity;
    }
    
    public void setQuan(int q){
        this.quantity=this.quantity-q;
    }
}
